package rzeznik.grzegorz.exotic_farm.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AnimalDTO {

    private Integer id;
    private LocalDate acquisitionDate;
    private String name;
    private Sex sex;

    public AnimalDTO(LocalDate acquisitionDate, String name, Sex sex) {
        this.acquisitionDate = acquisitionDate;
        this.name = name;
        this.sex = sex;
    }
}
