package rzeznik.grzegorz.exotic_farm;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rzeznik.grzegorz.exotic_farm.animal.Country;
import rzeznik.grzegorz.exotic_farm.animal.Sex;
import rzeznik.grzegorz.exotic_farm.animal.Temperament;
import rzeznik.grzegorz.exotic_farm.animal.spider.*;
import rzeznik.grzegorz.exotic_farm.care.CareRepository;
import rzeznik.grzegorz.exotic_farm.farm.Farm;
import rzeznik.grzegorz.exotic_farm.farm.FarmRepository;
import rzeznik.grzegorz.exotic_farm.user.Role;
import rzeznik.grzegorz.exotic_farm.user.RoleRepository;
import rzeznik.grzegorz.exotic_farm.user.User;
import rzeznik.grzegorz.exotic_farm.user.UserRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Service
public class DataSeed implements InitializingBean {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FarmRepository farmRepository;
    @Autowired
    private SpiderRepository spiderRepository;
    @Autowired
    private CareRepository careRepository;
    @Autowired
    private SpiderSpeciesInfoRepository spiderSpeciesInfoRepository;
    @Autowired
    private MoltRepository moltRepository;

    @Override
    public void afterPropertiesSet(){
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(Role.ADMIN));
            roleRepository.save(new Role(Role.USER));
        }
        addUsers();
        addFarms();
        addSpiders();
    }


    private void addUsers(){
        if(userRepository.count()!=0){
            return;
        }
        final Role admin = roleRepository.findByRoleName(Role.ADMIN);
        final Role user = roleRepository.findByRoleName(Role.USER);
        User admin1 = new User("admin",
                "a@a.pl",
                passwordEncoder.encode("admin"),
                "Aaa",
                "Aaa" );
        admin1.addRole(admin);
        userRepository.save(admin1);
        User user1 = new User("user",
                "u@u.pl",
                passwordEncoder.encode("user"),
                "Uuu",
                "Uuu");
        user1.addRole(user);
        userRepository.save(user1);
    }

    public void addFarms(){
        if(farmRepository.count()!=0){
            return;
        }
        User user = userRepository.findByEMail("a@a.pl").orElse(null);
        Set<User> admins = new HashSet<>();
        admins.add(user);
        Farm farm = new Farm("AutoAddedFarm", admins);
        farmRepository.save(farm);
    }

    public void addSpiders(){
        if(spiderRepository.count() != 0){
            return;
        }
        Farm farm = farmRepository.findByName("AutoAddedFarm").orElse(null);
        SpiderSpeciesInfo speciesInfo = new SpiderSpeciesInfo("Brachypelma", "albopilosum", "Curly Hair", "28", "75", true, Country.MEXICO);
        spiderSpeciesInfoRepository.save(speciesInfo);

        Spider spider1 = new Spider(LocalDate.now(), "Kędzior", Sex.FEMALE,Status.OWNED,Temperament.DOCILE, farm, VenomPotency.LOW, Type.TERRESTRIAL, speciesInfo);
        Spider spider2 = new Spider(LocalDate.now(), "Gienka", Sex.FEMALE,Status.OWNED,Temperament.DOCILE, farm, VenomPotency.LOW, Type.TERRESTRIAL, speciesInfo);
        Spider spider3 = new Spider(LocalDate.now(), "Laska", Sex.FEMALE,Status.OWNED,Temperament.DOCILE, farm, VenomPotency.LOW, Type.TERRESTRIAL, speciesInfo);

        spiderRepository.save(spider1);
        spiderRepository.save(spider2);
        spiderRepository.save(spider3);

    }


}

