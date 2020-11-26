package rzeznik.grzegorz.exotic_farm.animal.spider;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Molt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDate date;
    @ManyToOne
    private Spider spider;
}
