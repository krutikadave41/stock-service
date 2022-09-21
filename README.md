# stock-service
This service consumes the order details from the Kafka broker and inserts into MySQL database.

## Steps to use this service:
- Clone this repository
- Run maven clean build install
- Run Kafka broker at localhost 9092
- Use the order-service to send data to the Kafka broker with the help of a REST Endpoint
- Now run this stock service as a Spring Boot application and check if the data is getting stored in the MySQL database. 
