terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "~>3.0.2"
    }
  }

  required_version = ">= 1.2.0"
}

provider "aws" {
  region = var.region
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "rg" {
  name     = var.resource_group_name
  location = "canadaeast"

  tags = {
    Environment = "HCP Terraform Getting Started"
    Team        = "DevOps"
  }
}