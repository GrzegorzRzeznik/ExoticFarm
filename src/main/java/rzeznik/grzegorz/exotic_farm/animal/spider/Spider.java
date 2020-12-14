package rzeznik.grzegorz.exotic_farm.animal.spider;

import lombok.NoArgsConstructor;
import lombok.Setter;
import rzeznik.grzegorz.exotic_farm.animal.Animal;
import rzeznik.grzegorz.exotic_farm.animal.Sex;
import rzeznik.grzegorz.exotic_farm.animal.Temperament;
import rzeznik.grzegorz.exotic_farm.farm.Farm;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
public class Spider extends Animal {

    @ManyToOne
    private SpiderSpeciesInfo spiderSpeciesInfo;
    @Enumerated(EnumType.STRING)
    private VenomPotency venomPotency;
    @OneToMany(mappedBy = "spider")
    private List<Molt> molts = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Type type;


    public Spider(String name, Sex sex, Status status) {
        this.name = name;
        this.sex = sex;
        this.status = status;
    }

    public Spider(LocalDate date,
                  String name,
                  Sex sex,
                  Status status,
                  Temperament temperament,
                  Farm farm,
                  VenomPotency venomPotency,
                  Type type,
                  SpiderSpeciesInfo speciesInfo) {
        this.acquisitionDate = date;
        this.name = name;
        this.farm = farm;
        this.sex = sex;
        this.status = status;
        this.temperament = temperament;
        this.venomPotency = venomPotency;
        this.type = type;
        this.spiderSpeciesInfo = speciesInfo;
    }

    public void addMolt(Molt molt) {
        this.molts.add(molt);
    }

    public SpiderDTO toDTO(){
        return new SpiderDTO(id, acquisitionDate, name, sex);
    }
}
