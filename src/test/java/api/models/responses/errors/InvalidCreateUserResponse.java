package api.models.responses.errors;

import lombok.Data;

@Data
public class InvalidCreateUserResponse {
    String exception;
    String message;
}
