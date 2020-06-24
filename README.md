# DesafioSpring

 
para levantar la base de dattos, ejecute el script db/init.sql con mysql esto genera un esquema llamada challenge y una tabla llamada transaction ya con datos dentro que contiene usuarios con el id 1,2,3,4,20,123

la conexion de JDBC requiere de 3 variable de entorno 

* DB_USER el usuario de la base de datos
* DB_PASSWORD contraseña de la base de datos
* DB_HOST el servidor de la base de datos, puede ser localhost


## una alternativa es modificar el archivo application.properties backend\src\main\resources\application.properties remplazando ${} por los valores anteriores

---
en la secion releases viene ya un jar todo preparado para la ejecucion, solo basta con ejecutar el jar, la aplicacion funciona en el puerto 8080

si no encuentra el jar lo puede generar usted mismo, posicionandose en el directorio de backend y ejecutando el comando mvn package, esto generara un archivo jar dentro de la carpeta /backend/target
