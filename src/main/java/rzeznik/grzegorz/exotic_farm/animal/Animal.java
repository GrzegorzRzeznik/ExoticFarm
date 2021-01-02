package rzeznik.grzegorz.exotic_farm.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rzeznik.grzegorz.exotic_farm.animal.spider.Status;
import rzeznik.grzegorz.exotic_farm.care.Care;
import rzeznik.grzegorz.exotic_farm.farm.Farm;
import rzeznik.grzegorz.exotic_farm.farm.FarmDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Integer id;
    protected LocalDate acquisitionDate;
    protected String name;
    @ManyToOne(fetch = FetchType.LAZY)
    protected Farm farm;
    @OneToMany(mappedBy = "animal")
    protected List<Care> careList = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    protected Sex sex;
    @Enumerated(EnumType.STRING)
    protected Status status;
    @Enumerated(EnumType.STRING)
    protected Temperament temperament;

    public Animal(LocalDate acquisitionDate, String name, Farm farm, Sex sex, Status status, Temperament temperament) {
        this.acquisitionDate = acquisitionDate;
        this.name = name;
        this.farm = farm;
        this.sex = sex;
        this.status = status;
        this.temperament = temperament;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void addCare(Care care) {
        this.careList.add(care);
    }

    public AnimalDTO toDTO() {
        return new AnimalDTO(id, acquisitionDate, name, farm.toDTO(), sex, status, temperament);
    }

    public static Animal applyDTO(AnimalDTO animalDTO) {
        return new Animal(animalDTO.getAcquisitionDate(),
                animalDTO.getName(),
                Farm.applyDTO(animalDTO.getFarmDTO()),
                animalDTO.getSex(),
                animalDTO.getStatus(),
                animalDTO.getTemperament());
    }

}
