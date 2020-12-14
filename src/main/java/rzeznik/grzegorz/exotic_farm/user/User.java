package rzeznik.grzegorz.exotic_farm.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import rzeznik.grzegorz.exotic_farm.care.Care;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
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
    @OneToMany(mappedBy = "user")
    private List<Care> careList;
    @ManyToMany
    @JoinTable(name = "Users_roles")
    private List<Role> roles;


    public User(String username, String email, String passwordHash, String firstName, String lastName){
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static User applyDTO(UserRegistrationDTO dto, String passwordHash) {
        User user = new User();
        user.username = dto.getUsername();
        user.email = dto.getEmail();
        user.passwordHash = passwordHash;
        user.firstName = dto.getFirstName();
        user.lastName = dto.getLastName();

        return user;
    }
    public static User applyDTO(UserDTO dto, String passwordHash) {
        User user = new User();
        user.username = dto.getUsername();
        user.email = dto.getEmail();
        user.passwordHash = passwordHash;
        user.firstName = dto.getFirstName();
        user.lastName = dto.getLastName();

        return user;
    }

    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList<>();
            roles.add(role);
        } else if (!roles.contains(role)) {
            roles.add(role);
        }
    }

    public UserDTO toDTO(){
        return new UserDTO(id, username, email, passwordHash, firstName, lastName);
    }
}
