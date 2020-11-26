package rzeznik.grzegorz.exotic_farm.user;

import lombok.Data;
import rzeznik.grzegorz.exotic_farm.farm.Farm;

import java.util.Set;
@Data
public class UserRegistrationDTO {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Farm> farms;


}
