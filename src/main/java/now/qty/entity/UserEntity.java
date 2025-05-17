package now.qty.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class UserEntity {

private Integer id;
private String username;
private String password;
private String email;
private Role role;

}
