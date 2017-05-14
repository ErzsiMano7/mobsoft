package hu.bme.mobsoft.animal.model;

import android.support.v7.app.AppCompatActivity;

import com.orm.dsl.Table;

import hu.bme.mobsoft.animal.model.dto.AnimalDto;

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
    private String image;

    public Animal() {}

    public Animal(String species, String classAnimal, String appearance, String habitat, String living, String reproduction, String image) {
        this.species = species;
        this.classAnimal = classAnimal;
        this.appearance = appearance;
        this.habitat = habitat;
        this.living = living;
        this.reproduction = reproduction;
        this.image = image;
    }

    public Animal(AnimalDto animalDto)
    {
        species = animalDto.getSpecies();
        classAnimal = animalDto.getAnimalClass();
        appearance = animalDto.getAppearance();
        habitat = animalDto.getHabitat();
        living = animalDto.getLiving();
        reproduction = animalDto.getReproduction();
        image = animalDto.getImage();
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

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Animal)){
            return false;
        }

        Animal other = (Animal) obj;
        return this.species.equals(other.species);
    }
}
