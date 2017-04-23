package mobsoft.bme.hu.mobsoft.model;

/**
 * Created by erzsi on 2017.04.09..
 */

public class Animal {
    private String species;
    private String classAnimal;
    private String appearance;
    private String habitat;
    private String living;
    private String reproduction;

    public Animal(String species, String classAnimal, String appearance, String habitat, String living, String reproduction) {

        this.species = species;
        this.classAnimal = classAnimal;
        this.appearance = appearance;
        this.habitat = habitat;
        this.living = living;
        this.reproduction = reproduction;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getClassAnimal() {
        return classAnimal;
    }

    public void setClassAnimal(String classAnimal) {
        this.classAnimal = classAnimal;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    public String getReproduction() {
        return reproduction;
    }

    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }
}
