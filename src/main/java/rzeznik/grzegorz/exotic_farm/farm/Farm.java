package rzeznik.grzegorz.exotic_farm.farm;

import rzeznik.grzegorz.exotic_farm.animal.Animal;
import rzeznik.grzegorz.exotic_farm.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToMany
    private Set<User> users;
    @OneToMany
    private Set<Animal> animals;
}
