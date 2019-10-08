package api.controllers;

import core.AllureAttachmentHelper;
import core.rest.RestClient;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import api.models.requests.RegisterUserRequest;

public class UserController {

    public static final String REGISTER_ENDPOINT = "/register";
    public static final String USERS_ENDPOINT = "/customers";

    static RestClient restClient;
    static String url;
    static {
        restClient = new RestClient();
        url = System.getProperty("host");
    }

    @Step("Get list users")
    public static <T> T getCustomer(String id, int status, Class<T> cls) {
        String customer = String.format("%s/%s", USERS_ENDPOINT, id);
        Response response = restClient.sendRequest(Method.GET, customer, status);
        AllureAttachmentHelper.logRestCall(url + customer, Method.GET.toString(), response.prettyPrint());
        return response.body().as(cls);
    }

    @Step("Register user")
    public static Response registerUser(RegisterUserRequest registerUserRequest, int status) {
        RequestSpecification requestSpecification = new RequestSpecBuilder().setBody(registerUserRequest).build();
        Response response = restClient.sendRequest(Method.POST, REGISTER_ENDPOINT, requestSpecification, status);
        AllureAttachmentHelper.logRestCall(url + REGISTER_ENDPOINT, Method.POST.toString(), registerUserRequest.toString(), response.prettyPrint());
        return response;
    }

    @Step("Delete user")
    public static void delete(String id, int status) {
        String url = String.format("%s/%s", USERS_ENDPOINT, id);
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(status).build();
        Response response = restClient.sendRequest(Method.DELETE, url, responseSpecification);
        AllureAttachmentHelper.logRestCall(url + url, Method.DELETE.toString(), response.prettyPrint());
    }
}