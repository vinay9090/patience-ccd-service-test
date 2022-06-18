import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class VitalSignTest {
    public RequestSpecification REQUEST;

    public VitalSignTest() {
        REQUEST = RestAssured.given().contentType(ContentType.JSON);
    }

    @Test
    void testVitalSign() {
        RestAssured
                .given()
                .headers("Authorization", "Bearer Fp3rpjfy64Okb/nFsuA3Ew==Ui8rtJmnps8oYUbzCjJ8N0FQVH0+WGhcrVWW+LIpUJoE8/Hm3a7tSFK3+/Q8a4vxl1+Z9CVk/LcAWJkdigwKZZnOajExTcaAhezWTqMFKykeXvozWXcuNpRQXaLCjerU0dgwKBS72GKDG7edZz2+HuCRI3SwpRGCNjaLf1lO4cgNqn8Ox2JAvQ/9lnK+NWcTs9AzH9KJpugAd1dCFkD+4OwMtNzHs4hG8+v6NlQCsiBK+84AaH9JOyLgb4AmtflUKJuHjxKzefemzvtzrN/+pvmf1OBcT2vagJfQ4PLdOWKHPgZ8vuPBv8ILIVyIdVJc55UiNqKyfcLQmnAsO6+qPZJi8DoV+6ZNx0Y/ywdQW3yf8vZgUcUgzJmb+q7lZ5WaYpsa472xJQuNlgvHOuZ5wOD1Di4Bmj66LTdvaEvki43S8RP9fOCzK0jEy1gAX8c+")
                .queryParam("category", "vital-signs")
                .queryParam("subject", "6153b395-7492-5919-9ca8-691f5cf2dc2e")
                .when().get("http://localhost:8080/fhir/Observation")
                .then()
                .log()
                .body();
    }
}
