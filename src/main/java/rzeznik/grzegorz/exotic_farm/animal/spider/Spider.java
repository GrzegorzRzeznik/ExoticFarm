package rzeznik.grzegorz.exotic_farm.animal.spider;

import rzeznik.grzegorz.exotic_farm.animal.Animal;

import java.time.LocalDate;
import java.util.List;

public class Spider extends Animal {

    private SpiderInfo spiderInfo;
    private VenomPotency venomPotency;
    private List<LocalDate> molts;
    private Type type;
}
