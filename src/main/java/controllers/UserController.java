package controllers;

import core.RestClient;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.requests.CreateUserRequest;
import models.responses.UsersResponse;

public class UserController {

    static final String basePath  = "/api";
    static RestClient restClient;
    static {
        restClient = new RestClient(basePath);
    }

    @Step("Get list users")
    public static <T> T getUsers(int status, Class<T> cls) {
        Response response = restClient.sendRequest(Method.GET,"/users", status);
        T t  = response.body().as(cls);
        Allure.addAttachment("body", response.prettyPrint());
        return t;
    }

    @Step("Create user")
    public static <T> T createUser(CreateUserRequest createUserRequest, int status, Class<T> cls) {
        RequestSpecification requestSpecification = new RequestSpecBuilder().setBody(createUserRequest).build();
        Response response = restClient.sendRequest(Method.POST,"/user", requestSpecification, status);
        T t = response.body().as(cls);
        Allure.addAttachment("body", response.prettyPrint());
        return t;
    }

    @Step("Delete user")
    public static void delete(String userName, int status) {
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(status).build();
        Response tmp = restClient.sendRequest(Method.DELETE,"/user/" + userName , responseSpecification);
    }
}