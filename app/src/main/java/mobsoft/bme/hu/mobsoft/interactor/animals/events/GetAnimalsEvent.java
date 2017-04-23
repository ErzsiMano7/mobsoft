package mobsoft.bme.hu.mobsoft.interactor.animals.events;

import java.util.List;

import mobsoft.bme.hu.mobsoft.model.Animal;

/**
 * Created by erzsi on 2017.04.23..
 */

public class GetAnimalsEvent {

    private int code;
    private List<Animal> animals;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetAnimalsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

//</editor-fold>
}
