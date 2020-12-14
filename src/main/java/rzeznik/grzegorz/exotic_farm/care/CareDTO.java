package rzeznik.grzegorz.exotic_farm.care;

import lombok.AllArgsConstructor;
import lombok.Getter;
import rzeznik.grzegorz.exotic_farm.animal.AnimalDTO;
import rzeznik.grzegorz.exotic_farm.user.UserDTO;
@AllArgsConstructor
@Getter
public class CareDTO {

    private Integer id;
    private UserDTO user;
    private AnimalDTO animal;
    private CareType type;

    public CareDTO(UserDTO user, AnimalDTO animal, String careType){
        this.user = user;
        this.animal = animal;
        this.type = CareType.valueOf(careType);
    }
}
