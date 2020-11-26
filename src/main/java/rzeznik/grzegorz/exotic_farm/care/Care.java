package rzeznik.grzegorz.exotic_farm.care;

import rzeznik.grzegorz.exotic_farm.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Care {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @OneToOne
    private User user;
    private LocalDate date;
    private CareType type;
}
