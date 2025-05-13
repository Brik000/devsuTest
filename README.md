# Sistema de Microservicios Bancarios

## Requisitos

- Java 17 o superior  
- Maven 3.8 o superior  
- Docker  
- Docker Compose  

---

## Ejecución paso a paso

```
1. Compilar cada microservicio

cd customer-service
mvn clean install

cd ../account-service
mvn clean install

2. Levantar la solución completa con Docker

docker-compose up --build

3. Cargar datos de prueba en la base de datos

docker exec -i mysql-customer mysql -uroot -proot customerdb < sql/loadData.sql

4. Apagar todo y eliminar volúmenes

docker-compose down -v
