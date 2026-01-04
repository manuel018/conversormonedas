# Conversor de Monedas 💱

Este proyecto es una aplicación de consola en **Java** que permite convertir entre diferentes monedas utilizando un servicio externo (`ApiService`).  
El programa ofrece un menú interactivo para realizar conversiones rápidas desde **USD** a monedas específicas, o seleccionar libremente las monedas de origen y destino.

 > 📌 **Este proyecto forma parte de un desafío (challenge) de Alura Latam**, dentro de su programa de formación en desarrollo backend con Java. 
---

## 🚀 Características

- Conversión de **USD** a:
  - Peso Argentino (ARS)
  - Sol Peruano (PEN)
  - Peso Mexicano (MXN)
  - Real Brasileño (BRL)
- Conversión personalizada entre cualquier par de monedas disponibles.
- Manejo de errores comunes:
  - Entrada inválida (valores no numéricos).
  - Excepciones generales durante la ejecución.
- Menú interactivo en consola.

---

## 📂 Estructura del Proyecto

- `Conversormonedas.java`: Clase principal que contiene el menú y la lógica de interacción con el usuario.
- `ApiService.java`: Clase encargada de realizar las consultas de tipo cambio.
- `ApiResponse.java`: Clase encargada de mapear la respuesta de la API ExchangeRate-API.

---


