package rzeznik.grzegorz.exotic_farm.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {

    private Integer id;
    private String username;
    private String email;
    private String passwordHash;
    private String firstName;
    private String lastName;

    
}
