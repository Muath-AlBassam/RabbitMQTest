# RabbitMQTest

The Server & Error Handling configuration is in the application.properties

Other Configurations are in the **RabbitMQConfig.java**

# Server Details
  - Server IP 
    - spring.rabbitmq.host=
  - RabbitMQ Port
    - spring.rabbitmq.port=

# Credintials
  - Username
    - spring.rabbitmq.username=
  - Password
    - spring.rabbitmq.password=

# Error Handling
  - Time Between Retries : 
    - spring.rabbitmq.listener.simple.retry.initial-interval 
    - spring.rabbitmq.listener.simple.retry.max-interval
  - Number of Retries
    - spring.rabbitmq.listener.simple.retry.max-attempt
    
