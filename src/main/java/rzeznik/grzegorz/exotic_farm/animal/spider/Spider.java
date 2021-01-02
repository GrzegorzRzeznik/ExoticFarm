package rzeznik.grzegorz.exotic_farm.animal.spider;

import lombok.NoArgsConstructor;
import lombok.Setter;
import rzeznik.grzegorz.exotic_farm.animal.Animal;
import rzeznik.grzegorz.exotic_farm.animal.Sex;
import rzeznik.grzegorz.exotic_farm.animal.Temperament;
import rzeznik.grzegorz.exotic_farm.animal.spider.speciesInfo.SpiderSpeciesInfo;
import rzeznik.grzegorz.exotic_farm.farm.Farm;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
public class Spider extends Animal {

    @ManyToOne(fetch = FetchType.LAZY)
    private SpiderSpeciesInfo speciesInfo;
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

    public Spider(String name,
                  LocalDate date,
                  Sex sex,
                  Status status,
                  Temperament temperament,
                  SpiderSpeciesInfo speciesInfo,
                  Farm farm,
                  VenomPotency venomPotency,
                  Type type
                  ) {
        super(date, name, farm, sex, status, temperament);
        this.speciesInfo = speciesInfo;
        this.venomPotency = venomPotency;
        this.type = type;
        setFarm(farm);
    }

    public void addMolt(Molt molt) {
        this.molts.add(molt);
    }

    public SpiderDTO toDTO(){
        return new SpiderDTO(id, acquisitionDate, name, farm.toDTO(), sex, status, temperament, speciesInfo.toDTO(), venomPotency, type);
    }

    public static Spider applyDTO(SpiderDTO dto){
        return new Spider(dto.getName(),
                dto.getAcquisitionDate(),
                dto.getSex(),
                dto.getStatus(),
                dto.getTemperament(),
                SpiderSpeciesInfo.applyDTO(dto.getInfoDTO()),
                Farm.applyDTO(dto.getFarmDTO()),
                dto.getVenomPotency(),
                dto.getType());
    }


}
