package models.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
//@JsonIgnoreProperties(ignoreUnknown=true)
public class CreateUserRequest {
//    @JsonProperty()
    private String email;
//    @JsonProperty()
    private String name;
//    @JsonProperty()
    private String phone;
//    @JsonProperty()
    private String userName;
//    @JsonProperty()
    private String website;
}
