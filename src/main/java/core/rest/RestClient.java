package core.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class RestClient {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    public RestClient() {
        this.requestSpecification = RequestSpecificationFactory.getJsonRequestSpecification();
        this.responseSpecification = ResponseSpecificationFactory.getResponseSpecification();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    public RestClient(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
        this.responseSpecification = ResponseSpecificationFactory.getResponseSpecification();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    /**
     * Send request
     * @param method   Method: GET, POST, DELETE. etc
     * @param endpoint String: service endpoint
     * @return
     */
    public Response sendRequest(Method method, String endpoint, int status) {
        return given().log().ifValidationFails().spec(requestSpecification).request(method, endpoint).then().log().ifError().statusCode(status).extract().response();
    }

    /**
     * Send request with custom RequestSpecification
     * @param method Method: GET, POST, DELETE. etc
     * @param endpoint String: service endpoint
     * @param requestSpecification RequestSpecification: for custom request, for example headers, parameters, body etc
     * @return
     */
    public Response sendRequest(Method method, String endpoint, RequestSpecification requestSpecification, int status) {
        return given().log().ifValidationFails().spec(requestSpecification).request(method, endpoint).then().log().ifError().statusCode(status).extract().response();
    }

    /**
     * Send request with custom ResponseSpecification
     * @param method Method: GET, POST, DELETE. etc
     * @param endpoint String: service endpoint
     * @param responseSpecification ResponseSpecification: for custom response, for example
     * @return
     */
    public Response sendRequest(Method method, String endpoint, ResponseSpecification responseSpecification) {
        return given().log().ifValidationFails().request(method, endpoint).then().spec(responseSpecification).log().ifError().extract().response();
    }

    /**
     * Send request with custom ResponseSpecification
     * @param method Method: GET, POST, DELETE. etc
     * @param endpoint String: service endpoint
     * @param requestSpecification RequestSpecification: for custom request, for example headers, parameters, body etc
     * @param responseSpecification ResponseSpecification: for custom response, for example
     * @return
     */
    public Response sendRequest(Method method, String endpoint, RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        return given().log().ifValidationFails().spec(requestSpecification).request(method, endpoint).then().log().ifError().spec(responseSpecification).extract().response();
    }
}
