package api.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class RegisterUserRequest {
    @JsonProperty()
    private String email;
    @JsonProperty()
    private String firstName;
    @JsonProperty()
    private String lastName;
    @JsonProperty()
    private String password;
    @JsonProperty()
    private String userName;
}
