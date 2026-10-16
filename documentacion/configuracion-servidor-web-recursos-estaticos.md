Configuración del servidor web y recursos estáticos

La aplicación original CarritoGT se ejecuta mediante Apache dentro del entorno GNU/Linux virtualizado. La configuración del servidor permite acceder a la aplicación desde el navegador y dirigir las solicitudes al punto de entrada público.

Los recursos estáticos se organizan dentro del directorio público, incluyendo las hojas de estilo CSS, los archivos JavaScript y las imágenes de los productos. Mantener estas rutas correctamente configuradas permite que el navegador cargue los recursos necesarios para presentar el catálogo y las vistas de la aplicación.

La configuración definitiva del VirtualHost, el directorio raíz y las rutas de los recursos se documenta de acuerdo con los valores verificados en el entorno de ejecución.