package models.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateUserRequest {
    @JsonProperty()
    private String email;
    @JsonProperty()
    private String name;
    @JsonProperty()
    private String phone;
    @JsonProperty()
    private String userName;
    @JsonProperty()
    private String website;
}
