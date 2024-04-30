# Proyecto Examen Selección Empresa Base2

## 1.- Introducción 

El proyecto se basa en una plantilla de Spring boot y sirve para manejar una base de Estudiantes y gestionar la misma ya sea creando, consultando, modificando o eliminando registros de la misma.

## 2.- Contrucción 

### 2.1 - Herramientas
  * Java 17
  * Spring boot
  * Maven
  * MySQL
  * Intellij Idea
  * MySQL Workbench
  * Swagger
  * Postman

### 2.2 Pasos previos
  * Crear una carpeta local para descargar fuente del proyecto allí.
  * Clonar el proyecto desde GitHub de esta ruta: git clone https://github.com/yossealexandra/projectBase2-exam.git
  * Abrir el proyecto desde Intellij Idea.

### 2.3 Configuración de la Base de Datos
  * Descargar MySQL Workbench.
  * Crear una Base de Datos llamada MYDATABASE.
  * Crear una nueva conexión a esa base de datos usando los siguientes datos:
      1.- url: jdbc:mysql://localhost:3306/MYDATABASE
      2.- username: root
      3.- password=12345678
      4.- Agregar la variable serverTimezone = UTC
      5.- Hacer un test de dicha conexión.

## 3.- Pruebas
  * Hacer un run project a nivel de IDE.
  * Revisar documentación Swagger en http://localhost:8000/doc/swagger-ui/index.html#
  * Descargar Postman.
  * Remitirse a la documentación para hacer las pruebas pertinentes.

## 4.- Ejecución
  * Una vez cargado el proyecto en localhost ubicar el script (Script_Insert_Student.sql) en el directorio resources/scripts en MySql WorkBench.
  * Desde Postman ejecutar los servicios que deseen probarse según la API Rest documentada en Swagger.
