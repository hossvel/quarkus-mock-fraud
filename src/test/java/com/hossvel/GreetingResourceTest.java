package com.hossvel;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
class GreetingResourceTest {

    @InjectMock
    GreetingService greetingService;

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/greet")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }



    @Test
    public void testGreetWithMock() {
        when(greetingService.greet("Alice")).thenReturn("¡Hola, Alice!");

        given()
                .when().get("/greet/Alice")
                .then()
                .statusCode(200)
                .body(org.hamcrest.Matchers.equalTo("¡Hola, Alice!"));
    }

}