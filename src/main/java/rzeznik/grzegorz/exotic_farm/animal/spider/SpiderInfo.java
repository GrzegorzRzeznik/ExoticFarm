package rzeznik.grzegorz.exotic_farm.animal.spider;

import rzeznik.grzegorz.exotic_farm.animal.Country;

import javax.persistence.*;
import java.util.List;

@Entity
public class SpiderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @OneToMany
    private List<Spider> spiders;
    private String genus;
    private String species;
    private String commonName;
    private Integer preferredTemperature;
    private Integer preferredHumidity;
    private boolean hasUrticatingHair;
    private Country country;
}
