package api.tests.createUser;

import api.controllers.UserController;
import api.models.requests.RegisterUserRequest;
import core.DataHelper;
import core.JsonSchemaValidation;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class RegisterUsersTest {
    RegisterUserRequest registerUserRequest;
    String id;

    @AfterEach
    public void after() {
        UserController.delete(id, 200);
    }

    @Test
    void register_user_test() {
        // create user
        registerUserRequest = RegisterUserRequest
                .builder()
                .userName(DataHelper.getGeneratedName())
                .email("1@m.ru")
                .firstName("first")
                .lastName("last")
                .password("12345")
                .build();
        Response createUserResponse = UserController.registerUser(registerUserRequest, 200);

        // check response
        JsonSchemaValidation.validateBody(createUserResponse, "register-user-schema.json");
        id = createUserResponse.jsonPath().get("id");

        // check that user was added
//        GetCustomerResponse usersResponses = UserController.getCustomer(id,200, GetCustomerResponse.class);
//        GetCustomerResponse createdUser = new GetCustomerResponse();
    }
}
