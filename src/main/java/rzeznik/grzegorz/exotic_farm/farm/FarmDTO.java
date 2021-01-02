package rzeznik.grzegorz.exotic_farm.farm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import rzeznik.grzegorz.exotic_farm.animal.Animal;
import rzeznik.grzegorz.exotic_farm.animal.AnimalDTO;
import rzeznik.grzegorz.exotic_farm.animal.spider.SpiderDTO;
import rzeznik.grzegorz.exotic_farm.user.User;
import rzeznik.grzegorz.exotic_farm.user.UserDTO;

import java.util.Set;

@Getter
@AllArgsConstructor
public class FarmDTO {

    private Integer id;
    private String name;
    private Set<UserDTO> admins;
    private Set<UserDTO> users;


    public FarmDTO(String name){
        this.name = name;
    }


}
