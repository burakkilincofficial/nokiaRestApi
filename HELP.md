# Getting Started

The swagger can be used directly for tests.

`http://localhost:9005/swagger-ui.html#/user-account-controller`

The any user account can be created firstly,

`curl -X POST "http://localhost:9005/v1/user-account" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"address\": \"string\", \"country\": \"string\", \"department\": \"string\", \"email\": \"string\", \"id\": 1, \"name\": \"string\", \"phone\": \"1212121212\"}"`

The tests can be run anytime.

`mvn clean install`

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

