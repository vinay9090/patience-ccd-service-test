
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;


public class PatientCcdServiceTest {

    public RequestSpecification REQUEST;

    public PatientCcdServiceTest() {
        REQUEST = RestAssured.given().contentType(ContentType.JSON);
    }

    @Test
    void testccd() {
        RestAssured
                .given()
                .headers("nc-oidc-idtoken-claims", "eyJraWQiOiJcL2VwNkE3VUVRUSsrbk4ycnVRenhUUUdtYzJQTXlCMk83azhOMnVyNCt1TT0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI4YTZjOWIxNC1jNjEzLTQxOTctYjJkYi1iYzdkMzcyNjZhOGUiLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9lenloNXdya1AiLCJjb2duaXRvOnVzZXJuYW1lIjoiNDE3ZjRiMDYtZTgxNy00MTM5LWFlOWQtNDA1MzVhNzM5OWVjIiwicHJlZmVycmVkX3VzZXJuYW1lIjoidGVzdCthbGljZS5uZXdtYW5AbmF2aWdhdGluZ2NhbmNlci5jb20iLCJnaXZlbl9uYW1lIjoiQWxpY2UiLCJjdXN0b206cGF0aWVudElkcyI6IjYxNTNiMzk1LTc0OTItNTkxOS05Y2E4LTY5MWY1Y2YyZGMyZSIsImN1c3RvbTp1c2VySWQiOiItMyIsImN1c3RvbTpjbGluaWNJZCI6IjEiLCJvcmlnaW5fanRpIjoiM2UxNmM0Y2UtMTJhNS00YjlhLTk5MDUtNjczNGJkY2NlZDAzIiwiYXVkIjoiM2JtN3NtM2ZiMzE4dGcxOW5zcXJ2bGtqNGoiLCJldmVudF9pZCI6IjIwZjFjZDBkLThhZWUtNGM3MS05YmEyLTZhYTM2MTA1ZGIwOCIsInRva2VuX3VzZSI6ImlkIiwiY3VzdG9tOmNsaW5pY1BhdGllbnRMaW5rSWQiOiIyMDAxIiwiYXV0aF90aW1lIjoxNjQ0NTM3NDA0LCJleHAiOjE2NDQ1Mzc3MDQsImlhdCI6MTY0NDUzNzQwNCwiZmFtaWx5X25hbWUiOiJOZXdtYW4iLCJjdXN0b206Y2xpbmljTmFtZSI6IlNlYXR0bGUgT25jb2xvZ3kiLCJqdGkiOiJjMTczODJhNS1kZWNhLTQ5OGItOThkMi03MWRkMThmOTk1YjMiLCJlbWFpbCI6InRlc3QrYWxpY2UubmV3bWFuQG5hdmlnYXRpbmdjYW5jZXIuY29tIn0.XvdSxaaRD7MtJ89JCWfYP-yl97-zy-sfaSZPhTa_URHz4H-5pyI5Hm45nRiaye8lR9Ac4IwqIORUlhszqDZ47Ny1G4Zgum9BYHUgxSOL6n_CfsxYOW7bBd4hNAC8QHTpqWJqWl0u6SwzzVPVwmhxsmgXqdOP9kjz3EvwyPbaZ2A7NY6IlK3lT3DXsJARDAUI4kl8eghfcczB4Sct5FTSXsfS6rdqdJi4WlUqfGhkoKRbOiTmZXXnhe3hlS2kfhAuYNmEzT5mL0nL9BQoo5bqfqBV-A9UsJpdtgTeq3oa0-a4LICy-6KK_LZNPueviWj4C-uX0zvjlVB92u83lPlmKQ")
                .log()
                .headers()
                .get("http://localhost:8080/fhir/patient/6153b395-7492-5919-9ca8-691f5cf2dc2e/ccd")
                .then()
                .and()
                .body("ClinicalDocument.title", equalTo("Alice, Newman Patient Record CCD"))
                .and()
                .body("ClinicalDocument.effectiveTime.@value", equalTo("20220618"));
    }

}
