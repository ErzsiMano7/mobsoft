package mobsoft.bme.hu.mobsoft.interactor.animals;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.bme.hu.mobsoft.MobSoftApplication;
import mobsoft.bme.hu.mobsoft.interactor.animals.events.GetAnimalsEvent;
import mobsoft.bme.hu.mobsoft.interactor.animals.events.RemoveAnimalEvent;
import mobsoft.bme.hu.mobsoft.interactor.animals.events.SaveAnimalEvent;
import mobsoft.bme.hu.mobsoft.model.Animal;
import mobsoft.bme.hu.mobsoft.repository.Repository;

/**
 * Created by erzsi on 2017.04.10..
 */

public class AnimalsInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    public AnimalsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getAnimals() {
        GetAnimalsEvent event = new GetAnimalsEvent();
        try {
            List<Animal> animals = repository.getAnimals();
            event.setAnimals(animals);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveAnimals(Animal animals) {

        SaveAnimalEvent event = new SaveAnimalEvent();
        event.setAnimal(animals);
        try {
            repository.saveAnimal(animals);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateAnimals(List<Animal> todo) {
        try {
            repository.updateAnimals(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAnimals(Animal animals) {
        RemoveAnimalEvent event = new RemoveAnimalEvent();
        event.setAnimals(animals);
        try {
            repository.removeAnimal(animals);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
