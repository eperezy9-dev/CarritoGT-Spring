ANÁLISIS DE LA APLICACIÓN CARRITOGT

1. Introducción

El proyecto CarritoGT parte de una aplicación web desarrollada en PHP 7, utilizando programación orientada a objetos y una arquitectura MVC propia, sin frameworks como Laravel, Symfony o CodeIgniter.

El propósito de este análisis es comprender la estructura del sistema original, identificar sus componentes, estudiar el funcionamiento del catálogo y del carrito de compras, y establecer una base para migrar la aplicación a una API REST desarrollada con Java y Spring Boot.

2. Tecnologías utilizadas

* PHP 7 para la lógica del servidor.
* Programación orientada a objetos.
* Arquitectura MVC.
* Twig para la generación de vistas HTML.
* PDO para la conexión con MySQL/MariaDB.
* Apache como servidor web.
* MySQL/MariaDB como sistema de gestión de base de datos.
* Git para el control de versiones.

3. Arquitectura de la aplicación

La aplicación utiliza una arquitectura Modelo-Vista-Controlador (MVC).

Modelo

Los modelos gestionan el acceso a los datos y las operaciones relacionadas con los productos y el carrito.

Clases identificadas:

* App/Models/ProductoModel.php
* App/Models/ShoppingCartModel.php
* Core/Model.php

Vista

Las vistas utilizan Twig para presentar el catálogo y el carrito de compras.

Archivos identificados:

* App/Views/Home/index.html
* App/Views/ShoppingCart/index.html
* App/Views/base.html

Controlador

Los controladores reciben las solicitudes y coordinan la ejecución de las operaciones.

Clases identificadas:

* App/Controllers/Home.php
* App/Controllers/ShoppingCart.php
* Core/Controller.php

Enrutamiento

El archivo public/index.php constituye el punto de entrada de la aplicación y utiliza el enrutador propio del proyecto.

Archivo identificado:

* Core/Router.php

4. Base de datos

La base de datos utilizada se denomina cc y contiene dos tablas principales.

Tabla producto

Almacena la información del catálogo:

* idProducto: identificador del producto.
* nombre: nombre del producto.
* codigo: código del producto.
* imagen: ruta de la imagen.
* precio: precio unitario.

Tabla shopping_cart

Almacena los productos agregados al carrito:

* idShoppingCart: identificador del registro.
* idProducto: referencia al producto.
* codUsuario: código asociado al usuario.
* cantidad: cantidad de unidades solicitadas.

La tabla shopping_cart tiene una clave foránea que relaciona idProducto con producto.idProducto.

5. Funcionalidades identificadas

1. Consultar el catálogo de productos.
2. Agregar productos al carrito.
3. Consultar los productos del carrito.
4. Eliminar un producto del carrito.
5. Vaciar el carrito de un usuario.

El modelo del carrito también calcula el subtotal de cada producto multiplicando su precio por la cantidad solicitada.

6. Flujo general de funcionamiento

El flujo general de la aplicación es:

Navegador → Punto de entrada y enrutador → Controlador → Modelo → Base de datos → Vista HTML.

El navegador solicita una página o envía un formulario. El enrutador identifica la acción correspondiente, el controlador coordina la operación y los modelos consultan o modifican la base de datos. Finalmente, la vista presenta los resultados al usuario.

7. Conclusión

El análisis permite comprender las responsabilidades de los componentes de la aplicación original y establecer una referencia para su migración.

La nueva implementación en Java y Spring Boot debe conservar las funcionalidades principales del catálogo y del carrito, separando las responsabilidades en las capas Controller, Service, Repository y Entity. También permitirá mejorar la validación de datos, el manejo de errores y la seguridad de las consultas a la base de datos.
