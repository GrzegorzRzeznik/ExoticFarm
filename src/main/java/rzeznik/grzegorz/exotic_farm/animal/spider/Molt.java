package rzeznik.grzegorz.exotic_farm.animal.spider;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Molt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDate date;
    @ManyToOne
    private Spider spider;

    public Molt(LocalDate date, Spider spider){
        this.date = date;
        this.spider = spider;
    }

}
