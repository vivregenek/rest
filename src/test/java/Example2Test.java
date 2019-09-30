import controllers.UserController;
import core.DataHelper;
import models.requests.CreateUserRequest;
import models.responses.UsersResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Example2Test {

    @Test
    void create_user_test() {
        // create user
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .name("000")
                .userName(DataHelper.getGeneratedName())
                .email("1@m.ru")
                .phone("012345")
                .website("www.ru")
                .build();
        int createUserResponse = UserController.createUser(createUserRequest);

        // check service answer
        assertThat(createUserResponse).isEqualTo(createUserResponse);

        // check that user was added
        UsersResponse[] usersResponses = UserController.getUsers();
        UsersResponse tmp = new UsersResponse();
        tmp.setId(createUserResponse);
        tmp.setName(createUserRequest.getName());
        tmp.setUserName(createUserRequest.getUserName());
        tmp.setEmail(createUserRequest.getEmail());
        tmp.setPhone(createUserRequest.getPhone());
        tmp.setWebsite(createUserRequest.getWebsite());
        assertThat(Arrays.stream(usersResponses).filter(usersResponse -> usersResponse.getId() == createUserResponse).count()).isEqualTo(1);
    }
}
