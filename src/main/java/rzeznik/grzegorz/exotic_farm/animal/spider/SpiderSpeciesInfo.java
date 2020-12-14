package rzeznik.grzegorz.exotic_farm.animal.spider;

import lombok.NoArgsConstructor;
import rzeznik.grzegorz.exotic_farm.animal.Country;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class SpiderSpeciesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String genus;
    private String species;
    private String commonName;
    private String preferredTemperature;
    private String preferredHumidity;
    private boolean hasUrticatingHair;
    private Country country;
    @OneToMany(mappedBy = "spiderSpeciesInfo")
    List<Spider> spiders = new ArrayList<>();

    public SpiderSpeciesInfo(String genus, String species, String commonName, String preferredTemperature, String preferredHumidity, boolean hasUrticatingHair, Country country) {
        this.genus = genus;
        this.species = species;
        this.commonName = commonName;
        this.preferredTemperature = preferredTemperature;
        this.preferredHumidity = preferredHumidity;
        this.hasUrticatingHair = hasUrticatingHair;
        this.country = country;
    }


}
