# Test *Lati*

## Dependencies

* **spring-boot-starter**
* **spring-boot-starter-data-jpa**
* **spring-boot-starter-jdbc**
* **postgresql**
* **h2**
* **spring-boot-devtools**
* **validation-api**
* **springfox-swagger2**
* **springfox-swagger-ui**

* **Script database schema.sql->** _Location in folder /database/schema.sql_

## Controllers APIREST

* **api-rest-catalogos-controller ->** _Includes a method get all for each of the tables created in the postgresql database._

* **api-rest-controller ->** _Includes the three services defined in the pdf file: account discharge, credit application, payment notification, with their respective object definitions for requests._

## Steps to run project

* **Open terminal**
* **Clone the repository**
* **Create image Docker ldoc-laticash/database:latest**
  * **enter command ->** _cd database_
  * **enter command ->** _docker build -t ldoc-laticash/database:latest ._
* **Create imagen Docker ldoc-laticash/apirest:latest**
  * **move to root repository**
  * **enter command ->** _cd apirest_
  * **enter command ->** _mvn clean package_
  * **enter command ->** _docker build -t ldoc-laticash/apirest:latest ._
* **Run Containers Docker**
  * **move to root repository**
  * **enter command ->** _docker-compose up_
* **Try ApiRest**
  * **open your browser** http://localhost:8080/swagger-ui.html#/_
  * **select the controller**
  * **execute the desired request**

---
**Luis Daniel Olmos Cordero** (ldanielolmos@gmail.com).
