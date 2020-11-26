package rzeznik.grzegorz.exotic_farm.animal.spider;

import rzeznik.grzegorz.exotic_farm.animal.Animal;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Spider extends Animal {

    @OneToOne
    private SpiderInfo spiderInfo;
    private VenomPotency venomPotency;
    @OneToMany
    private List<Molt> molts;
    private Type type;
}
