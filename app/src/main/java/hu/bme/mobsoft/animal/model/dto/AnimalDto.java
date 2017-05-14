package hu.bme.mobsoft.animal.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by erzsi on 2017.04.24..
 */

public class AnimalDto {
    @SerializedName("species")
    private String species = null;

    @SerializedName("image")
    private String image = null;

    @SerializedName("classAnimal")
    private String classAnimal = null;

    @SerializedName("appearance")
    private String appearance = null;

    @SerializedName("living")
    private String living = null;

    @SerializedName("habitat")
    private String habitat = null;

    @SerializedName("reproduction")
    private String reproduction = null;



    /**
     **/
    @ApiModelProperty(required = true, value = "")
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getAnimalClass() { return classAnimal; }
    public void setAnimalClass(String classAnimal) {
        this.classAnimal = classAnimal;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getAppearance() {
        return appearance;
    }
    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getLiving() {
        return living;
    }
    public void setLiving(String living) {
        this.living = living;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getHabitat() {
        return habitat;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getReproduction() {
        return reproduction;
    }
    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnimalDto animal = (AnimalDto) o;
        return Objects.equals(species, animal.species) &&
                Objects.equals(image, animal.image) &&
                Objects.equals(classAnimal, animal.classAnimal) &&
                Objects.equals(appearance, animal.appearance) &&
                Objects.equals(living, animal.living) &&
                Objects.equals(habitat, animal.habitat) &&
                Objects.equals(reproduction, animal.reproduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, image, classAnimal, appearance, living, habitat, reproduction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Animal {\n");

        sb.append("    species: ").append(toIndentedString(species)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    classAnimal: ").append(toIndentedString(classAnimal)).append("\n");
        sb.append("    appearance: ").append(toIndentedString(appearance)).append("\n");
        sb.append("    living: ").append(toIndentedString(living)).append("\n");
        sb.append("    habitat: ").append(toIndentedString(habitat)).append("\n");
        sb.append("    reproduction: ").append(toIndentedString(reproduction)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
