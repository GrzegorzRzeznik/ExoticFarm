package rzeznik.grzegorz.exotic_farm.animal.spider;

import rzeznik.grzegorz.exotic_farm.animal.Country;

public class SpeciesInfoFromFileDTO {
    private String genus;
    private String species;
    private String commonName;
    private String preferredTemperature;
    private String preferredHumidity;
    private boolean hasUrticatingHair;
    private Country country;

    public SpeciesInfoFromFileDTO(String genus,
                                  String species,
                                  String commonName,
                                  String  preferredTemperature,
                                  String preferredHumidity,
                                  boolean hasUrticatingHair,
                                  Country country) {
        this.genus = genus;
        this.species = species;
        this.commonName = commonName;
        this.preferredTemperature = preferredTemperature;
        this.preferredHumidity = preferredHumidity;
        this.hasUrticatingHair = hasUrticatingHair;
        this.country = country;
    }

    public static SpeciesInfoFromFileDTO applyFromText(String info){
        String[] data = info.split(",");
        return new SpeciesInfoFromFileDTO(
                data[0],
                data[1],
                data[2],
                data[3],
                data[4],
                Boolean.parseBoolean(data[5]),
                Country.valueOf(data[6]));
    }

    @Override
    public String toString() {
        return "SpeciesInfoFromFileDTO{" +
                "genus='" + genus + '\'' +
                ", species='" + species + '\'' +
                ", commonName='" + commonName + '\'' +
                ", preferredTemperature=" + preferredTemperature +
                ", preferredHumidity=" + preferredHumidity +
                ", hasUrticatingHair=" + hasUrticatingHair +
                ", country=" + country +
                '}';
    }
}
