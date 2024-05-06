The Controller-Service-Repository pattern is prevalent in a lot of Spring Boot applications. 
One of the big reasons I like this pattern is that it does a great job of a separation of concerns: 
The Controller layer, at the top of this picture, 
is solely responsible for exposing the functionality so that it can be consumed by external entities 
(including, perhaps, a UI component). 
The Repository layer, at the bottom of this picture, is responsible for storing and retrieving some set of data. 
The Service layer is where all the business logic should go. If the business logic requires fetching/saving data, it wires in a Repository.
If someone wants to access this business logic, they go through a Controller to get there.

based on https://tom-collings.medium.com/controller-service-repository-16e29a4684e5