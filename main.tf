provider "google" {
  region  = "europe-west1"
  zone    = "europe-west1-a"
  project = "radoslaws-playground"
  credentials = file("key.json")
}

resource "google_spanner_instance" "main" {
  config       = "regional-europe-west1"
  name = "flywaydemo"
  display_name = "flywaydemo"
}

resource "google_spanner_database" "database" {
  instance = google_spanner_instance.main.name
  name     = "example-db"
  ddl = [
  ]
}