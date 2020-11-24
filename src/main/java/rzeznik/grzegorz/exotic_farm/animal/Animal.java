package rzeznik.grzegorz.exotic_farm.animal;

import rzeznik.grzegorz.exotic_farm.animal.spider.Status;
import rzeznik.grzegorz.exotic_farm.care.Care;

import java.time.LocalDate;
import java.util.List;

public abstract class Animal {

    private LocalDate received;
    private String name;
    private List<Care> care;
    private Sex sex;
    private Status status;


}
