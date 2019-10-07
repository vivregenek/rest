package controllers;

import core.AllureAttachmentHelper;
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

public class UserController {

    public static final String USER_ENDPOINT = "/user";
    public static final String USERS_ENDPOINT = "/users";

    static final String basePath  = "/api";
    static RestClient restClient;
    static String url;
    static {
        restClient = new RestClient(basePath);
        url = System.getProperty("host") + basePath;
    }

//    @Step("Get list users")
    public static <T> T getUsers(int status, Class<T> cls) {
        Allure.step("Get list users");
        Response response = restClient.sendRequest(Method.GET, USERS_ENDPOINT, status);
        AllureAttachmentHelper.logRestCall(url + USERS_ENDPOINT, Method.GET.toString(), response.prettyPrint());
        return response.body().as(cls);
    }

//    @Step("Create user")
    public static <T> T createUser(CreateUserRequest createUserRequest, int status, Class<T> cls) {
        Allure.step("Create user");
        RequestSpecification requestSpecification = new RequestSpecBuilder().setBody(createUserRequest).build();
        Response response = restClient.sendRequest(Method.POST, USER_ENDPOINT, requestSpecification, status);
        AllureAttachmentHelper.logRestCall(url + USER_ENDPOINT, Method.POST.toString(), createUserRequest.toString(), response.prettyPrint());
        return response.body().as(cls);
    }

//    @Step("Delete user")
    public static void delete(String userName, int status) {
        Allure.step("Delete user");
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(status).build();
        Response response = restClient.sendRequest(Method.DELETE, String.format("%s/%s", USER_ENDPOINT, userName), responseSpecification);
        AllureAttachmentHelper.logRestCall(url + String.format("%s/%s", USER_ENDPOINT, userName), Method.DELETE.toString(), response.prettyPrint());
    }
}