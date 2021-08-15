resource "docker_image" "demo-api" {
  name = "bolof2000/demo:0.1.0-SNAPSHOT"
}

resource "docker_container" "demo" {
  image = docker_image.demo-api.name
  name = "demo-api"
  ports {
    external = 9393
    internal = 9393
  }
}

output "url" {
  value = "http://localhost:${docker_container.demo.ports[0].external}/actuator/health"
}