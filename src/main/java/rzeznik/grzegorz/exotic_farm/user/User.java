package rzeznik.grzegorz.exotic_farm.user;

import rzeznik.grzegorz.exotic_farm.farm.Farm;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String username;
    private String email;
    private String passwordHash;
    private String firstName;
    private String lastName;
    @ManyToMany
    private Set<Farm> farms;

    public static User applyDTO(UserRegistrationDTO dto, String passwordHash) {
        User user = new User();
        user.username = dto.getUsername();
        user.email = dto.getEmail();
        user.passwordHash = passwordHash;
        user.firstName = dto.getFirstName();
        user.lastName = dto.getLastName();

        return user;
    }
}
