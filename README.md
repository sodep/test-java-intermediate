Ejercicio para evaluación de candidatos para Developers Java - Nivel Intermedio
===============================================================

Requisitos
----------

* Recomendado [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* Algun servidor compatible con Java EE. Reocmendado [Jboss Wildfly 10.1.0](http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.zip). O bien un Tomcat en su última versión.
* IDE favorito
* Git

Descripción de la Evaluación
----------------------------
Se proveen dos ejercicios de distinta dificultad. Leer antentamente lo que se pide en cada ejercicio y empezar por el que sea más sencillo.


Ejercicio 1 - Manejador de tareas
---------------------------------

Esta aplicación es para un manejador de tareas. 

La intención de la aplicación es la de proveer un CRUD de tareas que son manejadas desde una base de datos relacional. 


### Tareas de Backend

Agregar un servicio REST para consultar, agregar, actualizar y borrar tareas. El servicio debe responder a las siguientes URLs:

*   `api/tasks` - lista todas las tareas con sus asignados
*   `api/tasks/<id>` - obtiene detalles de una tarea identificada por su *id*
*   `api/tasks/<id>` - actualiza una tarea existente con el *id*

**Requerimientos de tecnología**: 

*  Los servicios REST pueden ser implementados usando [JAX-RS](https://jax-rs-spec.java.net/) o anotaciones de Spring Boot.

*  Las tareas deben ser modificadas y consultadas a partir de tablas en base de datos. Para el acceso a base de datos se puede usar repositorios de Spring Boot o bien alguna otra tecnología estándar JEE.   

**Requerimientos funcionales**:

*   El servicio que permite actualizar una tarea debe también permitir asignar la tarea a una persona.

*   No se debe de poder asignar a una persona más de 5 tareas (para evitarle la fatiga :-)). La aplicación debe lanzar un error en caso de que se quiera asignar más de 5 tareas a una persona. 

*   El servicio que permite listar tareas también se debe de poder mostrar sus asignados. Es decir, debe haber una relación entre tareas y asignados y el servicio de listado debe reflejar esto.     


### Tareas de Test Unitarios

Escribir un test unitario que verifique el siguiente **requerimiento funcional** mencionado arriba:

>> No se debe de poder asignar a una persona más de 5 tareas (para evitarle la fatiga :-)). La aplicación debe
lanzar un error en caso de que se quiera asignar más de 5 tareas a una persona. 

### Guías generales

Las URLs para los servicios REST deben tener el verbo HTTP apropiado para cada operación.

Los servicios deben aceptar y responder en formato JSON. Diseñar el esquema JSON que se crea apropiado dado la estructura de datos proporcionada.
 

Ejercicio 2 - Ejercicio de query a base de datos con JDBC
---------------------------------------------------------

Conectarse a una base de datos por JDBC, hacer una consulta mediante un PreparedStatement e imprimir en consola los resultados de la consulta.

El sistema debe modelar y comportarse según las siguientes especificaciones:

1. Debe permitir ingresar por parámetros de aplicación o por consola el nombre de la columna y el valor a consultar de la columna

2. Debe ejecutar un query de acuerdo a los datos ingresados en el ítem 1 e impirmir en consola el resultado del query. Los parámetros deben ser usados para armar el query de la siguiente forma:

   `select * from potluck where nombreColumnaParam = valorParam`

    Donde nombreColumnaParam y valorParam son los parámetro del ítem 1.

3. Se debe utilizar un PreparedStatement para setear el valor usado como filtro del query. No vale concatenar todo en un string.

Se provee en este repositorio un script [potlucktable.sql](src/main/resources/db/migration/potlucktable.sql) para la creación de la tabla sobre la que se debe hacer este ejercicio. El script es compatible con PostgreSQL.
    

Criterios de evaluación
-----------------------

1.  Correctitud de la solución

    Naturalmente, el proyecto entregado debe ser funncional y compilar. 
    También se va a evaluar *como* la solución presentada resuelve cada problema.
    
2.  Conocmiento de la plataforma Java

    ¿Tu código demuestra conocimiento de las capacidades de la plataforma Java o JavaEE y sus recursos?
    ¿Se supo qué librerias o anotaciones usar para cada caso?

3.  Coding style

    ¿Es bueno tu estilo de código? ¿Encaja con el código base proporcionado?
    ¿Es idiomático de tal forma en que va a ser fácilmente entendido por cualquier Java developer?
    ¿Está adecuadamente (pero no en exceso) documentado?
    
4.  Entendimiento de la especificación

    Se debería poder completar las tareas pedidas solamente leyendo la especificación en este repositorio.
    Las soluciones a las tareas deben ser de acuerdo a lo pedido en este README.
    
5.  Facilidad en probar la solución
    
    ¿Se provee todo lo necesario para ejecutar la solución entregada? Ya sea drivers, documentación adicional de pasos para deploy o ejecución, etc.


Pasos iniciales
---------------

### Empezando a trabajar

Para empezar crear un fork de este repositorio para implementar los ejercicios.

Adjuntar cualquier documentación al proyecto en forma de archivos con extensión `.md`.

Se recomienda ir haciendo commits a medida que se avanza con la solución. Agrupando estos commits si corresponde hacerlo.


### Contruyendo el proyecto

El proyecto incluye un pom.xml que permite construir un paquete jar utilizando [Maven](http://maven.apache.org). Simplemente corriendo `mvn package` descargará todas las dependencias necesarias y construirá un paquete jar estándar.


### Manejando la base de datos

Se provee en la carpeta `src/main/resources/db/migration` scripts de creación de tablas para los ejercicios.


Enviando tu código para evaluación
------------------------------------

Luego al finalizar enviar un email con el link al fork a la persona que te envió este test.

¡Buena suerte! 🎉
