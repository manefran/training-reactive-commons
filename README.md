# Hacking Implementación Reactive Commons

Aplicación de ejemplo para implementación de la librería **reactive-commons** para java.

Ver reactive-commons repositorio en [GitHub](https://github.com/reactive-commons/reactive-commons-java).

## Requisitos

1. Java JDK 11
2. RabbitMQ instalado

## Funcionamiento

El ejemplo cubre el patrón **Event Notification - Domain Event** implementando el caso de uso del registro de una mascota.

1. Correr la aplicación MainAplication
2. Se expone un servicio REST que debe ser llamado por POST de la siguiente manera *http://localhost:8080/pet* enviando un body como el siguiente ejemplo `{ "name":"Pixell", "type": "Perro" }`
3. En la consola de la aplicación se mostrarán logs describiendo el envío y lectura de los eventos respectivos.

`Emitiendo evento de dominio: pet.created: Pet(id=d826ae71-1ef5-4e33-8bed-59fd4f965d42, name=Pixell, type=Perro)`

`Recibiendo evento de dominio: pet.created: Pet(id=d826ae71-1ef5-4e33-8bed-59fd4f965d42, name=Pixell, type=Perro)`
