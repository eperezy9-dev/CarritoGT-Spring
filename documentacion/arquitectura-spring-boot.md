ARQUITECTURA DE LA API REST CARRITOGT

1. Introducción

La nueva implementación de CarritoGT migra la lógica de la aplicación original, desarrollada en PHP 7, a una API REST utilizando Java 21 y Spring Boot.

El objetivo es separar las responsabilidades del sistema en capas, facilitar el mantenimiento del código y permitir que los recursos del catálogo y del carrito se gestionen mediante solicitudes HTTP.

2. Tecnologías utilizadas

* Java 21.
* Spring Boot.
* Maven para la gestión de dependencias y construcción del proyecto.
* Spring Data JPA para el acceso a datos.
* Hibernate como proveedor de persistencia.
* MySQL/MariaDB como sistema de gestión de base de datos.
* Git y GitHub para el control de versiones.

3. Arquitectura por capas

Controller

Recibe las solicitudes HTTP, define los endpoints de la API y devuelve las respuestas al cliente.

Clases identificadas:

* ProductoController.java
* ShoppingCartController.java

Service

Contiene la lógica de negocio y coordina las operaciones que se realizan sobre los productos y el carrito.

Clases identificadas:

* ProductoService.java
* ShoppingCartService.java

Repository

Gestiona las operaciones de persistencia mediante Spring Data JPA y permite consultar, guardar, actualizar y eliminar registros.

En esta capa se encuentran las interfaces de repositorio correspondientes a productos y elementos del carrito.

Entity

Representa las entidades que se relacionan con las tablas de la base de datos.

Las entidades del sistema corresponden a los productos y a los elementos del carrito de compras.

4. Base de datos

La API utiliza la base de datos cc, configurada en el archivo application.properties.

La conexión se establece mediante JDBC y las operaciones de persistencia se gestionan utilizando JPA e Hibernate.

5. Endpoints verificados

Durante las pruebas se verificaron las siguientes operaciones:

* Consultar la lista de productos.
* Consultar los productos del carrito.
* Crear elementos del carrito.
* Actualizar elementos del carrito.
* Eliminar elementos del carrito.

Las respuestas HTTP y los datos JSON se utilizaron para comprobar el funcionamiento de las operaciones.

6. Flujo de funcionamiento

Cliente HTTP → Controller → Service → Repository → Base de datos.

La solicitud llega al controlador, pasa al servicio para ejecutar la lógica de negocio y utiliza el repositorio para acceder a la base de datos. Finalmente, la API devuelve una respuesta HTTP con los datos correspondientes o el estado de la operación.

7. Conclusión

La arquitectura por capas permite separar las responsabilidades de la API REST y facilita las pruebas, el mantenimiento y la evolución de CarritoGT.

La migración busca conservar las funcionalidades esenciales del sistema original, utilizando Java y Spring Boot para ofrecer servicios REST que puedan ser consumidos por un navegador, una aplicación web u otro cliente HTTP.