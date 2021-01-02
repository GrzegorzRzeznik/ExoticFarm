package rzeznik.grzegorz.exotic_farm.animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import rzeznik.grzegorz.exotic_farm.animal.spider.Status;
import rzeznik.grzegorz.exotic_farm.farm.FarmDTO;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AnimalDTO {

    private Integer id;
    private LocalDate acquisitionDate;
    private String name;
    private FarmDTO farmDTO;
    private Sex sex;
    private Status status;
    private Temperament temperament;

    public AnimalDTO(LocalDate acquisitionDate, String name, FarmDTO farmDTO, Sex sex, Status status, Temperament temperament) {
        this.acquisitionDate = acquisitionDate;
        this.name = name;
        this.farmDTO = farmDTO;
        this.sex = sex;
        this.status = status;
        this.temperament = temperament;
    }

}
