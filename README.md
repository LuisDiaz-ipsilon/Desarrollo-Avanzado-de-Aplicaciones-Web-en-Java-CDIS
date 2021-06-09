Spring Boot y Java Persistence Api (JPA) :seedling:

En este ejemplo ya contamos con el uso de JPA (Java Persistence Api) podras encontrar muchas de las anotaciones correspondientes para la persisitencia de datos, al igual que con los otros ejemplos se añadio comentarios sobre los metodos y clases con la explicacion de su uso en la aplicacion. 

Continuamos apoyandonos del etiquetado en HTML de thymeleaf para que nuestras vistas sean mas faciles de implementar. 

Por esta ocaciones utilizamos la base de datos H2, podras encontrar los valores utilizados en el archivo application.properties y algunas intrucciones de ejemplo en el archivo import.sql, recomiedo ampliamente repasar la [estructura del lenguaje SQL](https://dev.mysql.com/doc/refman/8.0/en/language-structure.html) para este ejemplo y asi puedas crear tu aplicacion de manera correcta.

En este ejemplo al crear la aplicacion en el Spring Tools Suite, agrege las siguientes dependencias:

- Spring Boot DevTools
- Spring Data JPA(Hibernate)
- H2 Database(primeros pasos)
- MySQL(Lo actualizaremos despues de hacer la prueba con H2)
- Thymeleaf
- Spring Web