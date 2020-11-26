package rzeznik.grzegorz.exotic_farm.animal;

import rzeznik.grzegorz.exotic_farm.animal.spider.Status;
import rzeznik.grzegorz.exotic_farm.care.Care;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDate acquisitionDate;
    private String name;
    @OneToMany
    private List<Care> care;
    private Sex sex;
    private Status status;


}
