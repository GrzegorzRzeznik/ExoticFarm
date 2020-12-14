package rzeznik.grzegorz.exotic_farm.farm;

import lombok.Getter;
import rzeznik.grzegorz.exotic_farm.animal.Animal;
import rzeznik.grzegorz.exotic_farm.animal.AnimalDTO;
import rzeznik.grzegorz.exotic_farm.animal.spider.SpiderDTO;
import rzeznik.grzegorz.exotic_farm.user.User;
import rzeznik.grzegorz.exotic_farm.user.UserDTO;

import java.util.Set;

@Getter
public class FarmDTO {

    private Integer id;
    private String name;
    private Set<UserDTO> admins;
    private Set<SpiderDTO> spiders;
    private Set<UserDTO> users;


    public FarmDTO(String name){
        this.name = name;
    }
    public FarmDTO(String name, Set<UserDTO> admins, Set<UserDTO> users) {
        this.name = name;
        this.admins = admins;
        this.users = users;
    }

    public FarmDTO(Integer id, String name, Set<UserDTO> users, Set<UserDTO> admins, Set<SpiderDTO> spiders) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.admins = admins;
        this.spiders = spiders;
    }



}
