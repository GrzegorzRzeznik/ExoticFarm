package rzeznik.grzegorz.exotic_farm.animal.spider;

import rzeznik.grzegorz.exotic_farm.animal.AnimalDTO;
import rzeznik.grzegorz.exotic_farm.animal.Sex;

import java.time.LocalDate;

public class SpiderDTO extends AnimalDTO {


    public SpiderDTO(Integer id, LocalDate acquisitionDate, String name, Sex sex) {
        super(id, acquisitionDate, name, sex);
    }

    public SpiderDTO(LocalDate acquisitionDate, String name, Sex sex) {
        super(acquisitionDate, name, sex);
    }
}
