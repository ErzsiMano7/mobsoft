package hu.bme.mobsoft.animal.interactor.animals.events;

import hu.bme.mobsoft.animal.model.Animal;

/**
 * Created by erzsi on 2017.04.23..
 */

public class SaveAnimalEvent {

    private int code;
    private Animal animals;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public SaveAnimalEvent() {
    }

    public SaveAnimalEvent(int code, Animal animals, Throwable throwable) {
        this.code = code;
        this.animals = animals;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Animal getAnimal() {
        return animals;
    }

    public void setAnimal(Animal animal) {
        this.animals = animal;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    //</editor-fold>
}
