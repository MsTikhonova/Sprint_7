package ru.yandex.practicum.courier;

import ru.yandex.practicum.config.Config;

import static io.restassured.RestAssured.given;

public class CourierClient extends BaseClient {
    private final String ROOT = "/courier";
    private final String LOGIN = ROOT + "/login";
    private final String DELETE = ROOT + "/{courierId}";

    public boolean create(Courier courier) {
        return getSpec()
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");

    }

    public String createConflict(Courier courier) {
        return getSpec()
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(409)
                .extract()
                .path("message");

    }

    public String createBadRequest(Courier courier) {
        return getSpec()
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");

    }

    public int login(CourierCredentials creds){
        return getSpec()
                .body(creds)
                .when()
                .post(LOGIN)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }
    public String loginBadRequest(CourierCredentials creds){
        return getSpec()
                .body(creds)
                .when()
                .post(LOGIN)
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");
    }

    public void delete(int courierId){
        getSpec()
                .pathParam("courierId", courierId)
                .when().delete(DELETE)
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
