package createUser;

import controllers.UserController;
import core.DataHelper;
import models.requests.CreateUserRequest;
import models.responses.UsersResponse;
import models.responses.errors.InvalidCreateUserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUsersTest {
    CreateUserRequest createUserRequest;
    @AfterEach
    public void after() {
        UserController.delete(createUserRequest.getUserName(), 204);
        System.out.println("after");
    }

    @Test
    void create_user_test() {
        // create user
        createUserRequest = CreateUserRequest
                .builder()
                .name("000")
                .userName(DataHelper.getGeneratedName())
                .email("1@m.ru")
                .phone("012345")
                .website("www.ru")
                .build();
        int createUserResponse = UserController.createUser(createUserRequest, 200, Integer.class);

        // check service answer
        assertThat(createUserResponse).isEqualTo(createUserResponse);

        // check that user was added
        UsersResponse[] usersResponses = UserController.getUsers(200, UsersResponse[].class);
        UsersResponse createdUser = new UsersResponse();
        createdUser.setId(createUserResponse);
        createdUser.setName(createUserRequest.getName());
        createdUser.setUserName(createUserRequest.getUserName());
        createdUser.setEmail(createUserRequest.getEmail());
        createdUser.setPhone(createUserRequest.getPhone());
        createdUser.setWebsite(createUserRequest.getWebsite());
        assertThat(usersResponses).filteredOn("id", createUserResponse).containsOnly(createdUser);
    }
}
