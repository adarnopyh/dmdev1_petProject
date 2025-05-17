package now.qty.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {
    String username;
    String password;
    String email;
    String role;
}
