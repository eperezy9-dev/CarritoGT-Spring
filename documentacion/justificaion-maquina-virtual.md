Justificación de los recursos de la máquina virtual

Para desarrollar el proyecto CarritoGT se utilizó Oracle VirtualBox como hipervisor de tipo 2 sobre Windows, con una máquina virtual GNU/Linux Lubuntu.

Se asignaron 5,536 MB de memoria RAM para permitir la ejecución simultánea del sistema operativo y las herramientas necesarias para el proyecto, entre ellas Apache, PHP, MariaDB, Git, Java y Spring Boot.

Se configuraron 2 procesadores virtuales para distribuir el procesamiento de los servicios web, la base de datos y el entorno de desarrollo. Además, se asignaron 128 MB de memoria de video para la interfaz gráfica de Lubuntu.

El almacenamiento se configuró mediante un disco virtual VDI de expansión dinámica, con un límite de 60.93 GB y un tamaño actual de 35.23 GB. Este formato permite que el archivo de disco crezca conforme se necesita espacio, hasta alcanzar el límite establecido.

La red se configuró en modo NAT, lo que permite que la máquina virtual utilice la conexión de red del equipo anfitrión para acceder a Internet. Esta configuración resulta apropiada para instalar herramientas, actualizar el sistema y desarrollar la aplicación localmente.

La asignación de estos recursos permite disponer de un entorno virtualizado para ejecutar y probar la aplicación original en PHP y la solución migrada a Java con Spring Boot y MariaDB.

Recurso Valor observado
Hipervisor Oracle VirtualBox
Sistema invitado GNU/Linux Lubuntu
Memoria RAM 5,536 MB
Procesadores virtuales 2 CPU
Memoria de video 128 MB
Disco virtual máximo 60.93 GB
Tamaño actual del disco 35.23 GB
Red NAT