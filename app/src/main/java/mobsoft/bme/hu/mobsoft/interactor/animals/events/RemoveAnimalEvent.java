package mobsoft.bme.hu.mobsoft.interactor.animals.events;

import mobsoft.bme.hu.mobsoft.model.Animal;

/**
 * Created by erzsi on 2017.04.23..
 */

public class RemoveAnimalEvent {
    private int code;
    private Animal animals;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public RemoveAnimalEvent() {
    }

    public RemoveAnimalEvent(int code, Animal animals, Throwable throwable) {
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

    public Animal getAnimals() {
        return animals;
    }

    public void setAnimals(Animal animals) {
        this.animals = animals;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
