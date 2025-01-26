resource "random_id" "suffix" {
  byte_length = 4
}

# create s3 bucket
resource "aws_s3_bucket" "prod_media" {
  bucket        = "${var.prod_media_bucket}-${random_id.suffix.hex}"
  force_destroy = true
}

# configure 
resource "aws_s3_bucket_website_configuration" "blog" {
  bucket = aws_s3_bucket.prod_media.id

  index_document {
    suffix = "index.html"
  }

  error_document {
    key = "index.html"
  }
}

# # (old) apply bucket policy for public access
# resource "aws_s3_bucket_policy" "this" {
#   bucket = aws_s3_bucket.bucket.id

#   policy = jsonencode({
#     "Version" : "2008-10-17",
#     "Statement" : [
#       {
#         "Sid" : "PublicReadGetObject",
#         "Effect" : "Allow",
#         "Principal" : "*",
#         "Action" : "s3:GetObject",
#         "Resource" : "arn:aws:s3:::${var.prod_media_bucket}-${random_id.suffix.hex}/*"
#       }
#     ]
#   })
# }

# add cors policy
resource "aws_s3_bucket_cors_configuration" "prod_media" {
  bucket = aws_s3_bucket.prod_media.id  

  cors_rule {
    allowed_headers = ["*"]
    allowed_methods = ["GET", "HEAD"]
    allowed_origins = ["*"]
    expose_headers  = ["ETag"]
    max_age_seconds = 3000
  }  
}

resource "aws_s3_bucket_public_access_block" "example" {
  bucket = aws_s3_bucket.prod_media.id

  block_public_acls       = false
  block_public_policy     = false
  ignore_public_acls      = false
  restrict_public_buckets = false
}

resource "aws_s3_bucket_ownership_controls" "s3_bucket_acl_ownership" {
  bucket = aws_s3_bucket.prod_media.id
  rule {
    object_ownership = "BucketOwnerPreferred"
  }
  depends_on = [aws_s3_bucket_public_access_block.example]
}

# set bucket policy for public access
resource "aws_s3_bucket_policy" "prod_media_bucket" {
    bucket = aws_s3_bucket.prod_media.id
    policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Principal = "*"
        Action = [
          "s3:*",
        ]
        Effect = "Allow"
        Resource = [
          "arn:aws:s3:::${var.prod_media_bucket}-${random_id.suffix.hex}",
          "arn:aws:s3:::${var.prod_media_bucket}-${random_id.suffix.hex}/*"
        ]
      },
      {
        Sid = "PublicReadGetObject"
        Principal = "*"
        Action = [
          "s3:GetObject",
        ]
        Effect   = "Allow"
        Resource = [
          "arn:aws:s3:::${var.prod_media_bucket}-${random_id.suffix.hex}",
          "arn:aws:s3:::${var.prod_media_bucket}-${random_id.suffix.hex}/*"
        ]
      },
    ]
  })
  
  depends_on = [aws_s3_bucket_public_access_block.example]
}

resource "aws_s3_bucket_acl" "prod_media" {
    bucket = aws_s3_bucket.prod_media.id
    acl    = "public-read"
    depends_on = [aws_s3_bucket_ownership_controls.s3_bucket_acl_ownership]
}

# more public access config
resource "aws_s3_bucket_public_access_block" "public_access_block" {
  bucket                  = aws_s3_bucket.prod_media.id
  block_public_acls       = false
  block_public_policy     = false
  ignore_public_acls      = false
  restrict_public_buckets = false
}

locals {
  content_type_map = {
    "js"   = "application/json"
    "html" = "text/html"
    "css"  = "text/css"
    "svg"  = "image/svg+xml"
    "png"  = "image/png"
  }
}

# upload files
resource "aws_s3_object" "upload_object" {
  for_each = fileset("../guitar-site/dist/guitar-site/browser", "**")
  bucket   = aws_s3_bucket.prod_media.id
  key      = each.value
  source   = "../guitar-site/dist/guitar-site/browser/${each.value}"

  content_type = lookup(
    local.content_type_map,
  split(".", "../guitar-site/dist/guitar-site/browser/${each.value}")[1], "text/html")
}

# output the bucket name into the state file
output "bucket_name" {
  value       = aws_s3_bucket.prod_media.bucket
  description = "New bucket name"
}