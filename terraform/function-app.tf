resource "azurerm_resource_group" "main" {
  name     = var.resource_group_name
  location = "canadaeast"
}

resource "azurerm_storage_account" "main" {
  name                     = "guitarapistorageacc"
  resource_group_name      = azurerm_resource_group.main.name
  location                 = azurerm_resource_group.main.location
  account_tier             = "Standard"
  account_replication_type = "LRS"
}

resource "azurerm_service_plan" "main" {
  name                = "guitarpiserviceplan"
  resource_group_name = azurerm_resource_group.main.name
  location            = azurerm_resource_group.main.location
  os_type                    = "Linux"
  sku_name = "B1"
}

resource "azurerm_app_service" "main" {
  name                       = "guitarapifunctionapp2"
  resource_group_name        = azurerm_resource_group.main.name
  location                   = azurerm_resource_group.main.location

  app_service_plan_id = azurerm_service_plan.main.id

  app_settings = {
    "DOCKER_REGISTRY_SERVER_URL"      = "https://ghcr.io"
    "DOCKER_REGISTRY_SERVER_USERNAME" = var.GITHUB_USERNAME
    "DOCKER_REGISTRY_SERVER_PASSWORD" = var.GITHB_PAT
  }

  site_config {
    always_on = "true"
    linux_fx_version = "DOCKER|ghcr.io/${var.GITHUB_USERNAME}/${var.REPO_NAME}:${var.CONTAINER_IMAGE}"
  }
}
