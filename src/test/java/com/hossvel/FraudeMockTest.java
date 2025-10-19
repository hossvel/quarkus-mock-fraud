package com.hossvel;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class FraudeMockTest {

    @InjectMock
    FraudService mockFraudService;

    @Test
    public void testvalidatefraudcheck() {
        TransferRequest request = new TransferRequest();
        request.fromAccount = "123";
        request.toAccount = "456";
        request.amount = 100.0;

        Mockito.when(mockFraudService.check(request)).thenReturn(false);

        var result = given().contentType(ContentType.JSON)
                .when().post("/fraud/check")
                .then()
                .statusCode(200);
        ;


    }
}
