package rzeznik.grzegorz.exotic_farm.farm;

import rzeznik.grzegorz.exotic_farm.animal.spider.Spider;
import rzeznik.grzegorz.exotic_farm.animal.spider.SpiderDTO;
import rzeznik.grzegorz.exotic_farm.user.User;
import rzeznik.grzegorz.exotic_farm.user.UserDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @OneToMany
    @JoinTable(name = "Farm_users")
    private Set<User> users = new HashSet<>();
    @OneToMany
    @JoinTable(name = "Farm_admins")
    private Set<User> admins = new HashSet<>();
    @OneToMany(mappedBy = "farm")
    private Set<Spider> spiders = new HashSet<>();

    public Farm() {
    }

    public Farm(String name, Set<User> admins) {
        this.name = name;
        this.admins = admins;
    }

    public static Farm applyDTO(FarmDTO dto) {
        Set<User> admins = new HashSet<>();
        if (dto.getAdmins() != null) {
            admins = dto.getAdmins().stream()
                    .map(u -> User.applyDTO(u, u.getPasswordHash()))
                    .collect(Collectors.toSet());
        }
        return new Farm(dto.getName(), admins);
    }

    public FarmDTO toDTO() {
        Set<UserDTO> usersDTOs = users.stream().map(User::toDTO).collect(Collectors.toSet());
        Set<UserDTO> adminsDTOs = admins.stream().map(User::toDTO).collect(Collectors.toSet());
        Set<SpiderDTO> spiderDTOs = spiders.stream().map(Spider::toDTO).collect(Collectors.toSet());
        return new FarmDTO(this.id, this.name, usersDTOs, adminsDTOs, spiderDTOs);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addAdmin(User admin) {
        this.admins.add(admin);
    }

    public void addSpider(Spider spider) {
        spider.setFarm(this);
        this.spiders.add(spider);
    }
}
