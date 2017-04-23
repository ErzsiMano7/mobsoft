package mobsoft.bme.hu.mobsoft.model;

import com.orm.dsl.Table;

/**
 * Created by erzsi on 2017.04.09..
 */
@Table
public class Animal {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Animal)){
            return false;
        }

        Animal other = (Animal) obj;
        return this.species.equals(other.species);
    }
}
