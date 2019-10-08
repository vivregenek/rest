package api.createUser;

import api.controllers.UserController;
import api.models.requests.CreateUserRequest;
import api.models.responses.errors.InvalidCreateUserResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserNegativeTest {

    @Test
    void create_user_negative_test() {
        // create user
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .name("000")
                .email("1@m.ru")
                .phone("012345")
                .website("www.ru")
                .build();
        InvalidCreateUserResponse createUserResponse = UserController.createUser(createUserRequest, 400, InvalidCreateUserResponse.class);

        InvalidCreateUserResponse expectedError = new InvalidCreateUserResponse();
        expectedError.setException("InvalidUserDataException");
        expectedError.setMessage("Incorrect user. Please validate if all mandatory data is filled.");

        // check service answer
        assertThat(createUserResponse).isEqualTo(expectedError);
    }
}
