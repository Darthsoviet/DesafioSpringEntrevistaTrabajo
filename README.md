# DesafioSpring

 
para levantar la base de dattos, ejecute el script db/init.sql con mysql

la conexion de JDBC requiere de 3 variable de entorno 

* DB_USER el usuario de la base de datos
* DB_PASSWORD contraseña de la base de datos
* DB_HOST el servidor de la base de datos, puede ser localhost

---
en la secion releases viene ya un jar todo preparado para la ejecucion solo basta con ejecutar el jar, la aplicacion funciona en el puerto 8080

si no encuentra el jar lo puede generar usted mismo, posicionandose en el directorio de backend y ejecutando el comando mvn package, esto generara un archivo jar dentro de la carpeta /backend/target
