package controllers;

import core.RestClient;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import models.requests.CreateUserRequest;
import models.responses.CreateUserResponse;
import models.responses.UsersResponse;

public class UserController {

    static final String basePath  = "/api";
    static RestClient restClient;
    static {
        restClient = new RestClient(basePath);
    }

    @Step("Get list users")
    public static UsersResponse[] getUsers() {
        return restClient.sendRequest(Method.GET,"/users", UsersResponse[].class);
    }

    @Step("Get list users")
    public static Integer createUser(CreateUserRequest createUserRequest) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBody(createUserRequest)
                .build();
        return restClient.sendRequest(Method.POST,"/user", Integer.class, requestSpecification);
    }
}