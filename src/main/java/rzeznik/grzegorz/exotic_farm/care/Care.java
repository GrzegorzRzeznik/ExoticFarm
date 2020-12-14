package rzeznik.grzegorz.exotic_farm.care;

import lombok.NoArgsConstructor;
import lombok.Setter;
import rzeznik.grzegorz.exotic_farm.animal.Animal;
import rzeznik.grzegorz.exotic_farm.animal.AnimalDTO;
import rzeznik.grzegorz.exotic_farm.user.User;
import rzeznik.grzegorz.exotic_farm.user.UserDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@NoArgsConstructor
public class Care {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Animal animal;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private CareType type;

    public Care(User user, Animal animal, LocalDate date, CareType type){
        this.user = user;
        this.animal = animal;
        this.date = date;
        this.type = type;
    }

    public CareDTO toDTO(){
        UserDTO userDTO = user.toDTO();
        AnimalDTO animalDTO = animal.toDTO();
        return new CareDTO(id, userDTO, animalDTO, type);
    }

    public static Care applyDTO(CareDTO careDTO){
        return new Care(User.applyDTO(careDTO.getUser(), careDTO.getUser().getPasswordHash()),
                Animal.applyDTO(careDTO.getAnimal()),
                careDTO.getAnimal().getAcquisitionDate(),
                careDTO.getType());
    }
}
