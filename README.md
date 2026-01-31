🛒 Proyecto Supermercado – Backend

Backend de un sistema de supermercado con compras virtuales, desarrollado con Spring Boot, que gestiona usuarios, productos, stock, pedidos y reposiciones, aplicando buenas prácticas de arquitectura y lógica de negocio.

El proyecto simula el funcionamiento real de un supermercado / e-commerce, con control de stock, manejo de pedidos y separación clara de responsabilidades, pensado como proyecto demostrativo para portfolio y CV.

🚀 Tecnologías utilizadas

Java 21

Spring Boot

Spring Web

Spring Data JPA

Hibernate / JPA

H2 Database (entorno de desarrollo)

Maven

Lombok

🧩 Arquitectura

El proyecto sigue una arquitectura en capas:

Controller → Manejo de requests HTTP

Service → Lógica de negocio

Repository → Acceso a datos (JPA)

DTOs → Comunicación con el frontend

Entities → Modelo de dominio

Se prioriza un diseño limpio, desacoplado y fácil de extender.

👥 Roles del sistema (conceptuales)

El sistema está diseñado para soportar distintos roles de usuario:

CLIENTE

Realizar compras virtuales

Crear pedidos

REPONEDOR

Ejecutar reposiciones de productos

ENCARGADO_DEPOSITO

Gestionar stock y reposiciones

GERENTE

Supervisar pedidos y stock

ADMIN

Administración general del sistema

⚠️ Actualmente los roles están modelados a nivel de dominio.
La seguridad y control de acceso se implementarán en futuras versiones.

🛍️ Funcionalidades principales
Usuarios

Creación de usuarios

Email único

Asociación a un rol del sistema

Productos

Alta, baja y modificación de productos

Gestión de precios

Stock

Control de:

Stock total

Stock reservado

Stock disponible

Detección de stock crítico

Pedidos

Creación de pedidos con múltiples productos

Detalle de pedido por producto y cantidad

Cálculo de totales desde backend

Manejo de estados del pedido

Operaciones transaccionales (@Transactional)

Reposición

Registro de reposiciones

Detalle de reposición por producto y cantidad

Asociación de usuarios responsables

🧠 Conceptos aplicados

Backend como fuente de verdad

Separación de responsabilidades

Lógica de negocio centralizada en services

Uso de DTOs para evitar exponer entidades

Manejo de transacciones

Modelado correcto de relaciones (1-N, N-1)

🧪 Base de datos

H2 en memoria para desarrollo

Consola H2 habilitada

Preparado para migración a base de datos relacional real

▶️ Cómo ejecutar el proyecto

Clonar el repositorio:

git clone https://github.com/sonandi8053/Supermercado.git


Abrir el proyecto en tu IDE (IntelliJ recomendado)

Ejecutar la aplicación:

mvn spring-boot:run


Acceder a:

API: http://localhost:8080

H2 Console: http://localhost:8080/h2-console

📌 Próximas mejoras

🔐 Integración de Spring Security

Autenticación y autorización por roles

Protección de endpoints

Login con email y contraseña

Hash de contraseñas con BCrypt

🐳 Dockerización del proyecto

Dockerfile para el backend

Ejecución en contenedores

Preparación para despliegue

🧪 Tests

Tests unitarios de services

Tests de integración

🗄️ Base de datos real

Migración a MySQL o PostgreSQL

📊 Reportes

Métricas de pedidos

Productos más vendidos

Stock y reposiciones

📘 Documentación

Swagger / OpenAPI para la API REST

✍️ Autor

Proyecto desarrollado con fines educativos y profesionales, enfocado en reforzar conocimientos de backend con Spring Boot, diseño de sistemas y buenas prácticas de desarrollo.