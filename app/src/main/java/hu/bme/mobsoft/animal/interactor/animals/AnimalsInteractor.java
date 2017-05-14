package hu.bme.mobsoft.animal.interactor.animals;

import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.api.AnimalApi;
import hu.bme.mobsoft.animal.interactor.animals.events.GetAnimalsEvent;
import hu.bme.mobsoft.animal.interactor.animals.events.RemoveAnimalEvent;
import hu.bme.mobsoft.animal.interactor.animals.events.SaveAnimalEvent;
import hu.bme.mobsoft.animal.model.Animal;
import hu.bme.mobsoft.animal.model.dto.AnimalDto;
import hu.bme.mobsoft.animal.model.dto.AnimalIdDto;
import hu.bme.mobsoft.animal.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by erzsi on 2017.04.10..
 */

public class AnimalsInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    AnimalApi animalApi;

    public AnimalsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getAnimals() {
        GetAnimalsEvent event = new GetAnimalsEvent();
        try {
            Call<List<AnimalDto>> call = animalApi.getAnimals();
            Response<List<AnimalDto>> result = call.execute();

            if (result.isSuccess()) {
                //repository.clearAllAnimals();
                for (AnimalDto anim : result.body()) {
                    Animal animal = new Animal(anim.getSpecies(), anim.getAnimalClass(),
                            anim.getAppearance(), anim.getHabitat(), anim.getLiving(),
                            anim.getReproduction(), anim.getImage());
                    repository.saveAnimal(animal);
                }
            }

            event.setAnimals(repository.getAnimals());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveAnimal(Animal animal) {

        SaveAnimalEvent event = new SaveAnimalEvent();
        event.setAnimal(animal);
        try {
            AnimalDto anim = new AnimalDto();
            anim.setSpecies(animal.getSpecies());
            anim.setAnimalClass(animal.getClassAnimal());
            anim.setAppearance(animal.getAppearance());
            anim.setHabitat(animal.getHabitat());
            anim.setLiving(animal.getLiving());
            anim.setReproduction(animal.getReproduction());
            anim.setImage(animal.getImage());

            Call<AnimalIdDto> call = animalApi.addAnimal(MobSoftApplication.getUserHash(), anim);
            Response<AnimalIdDto> response = call.execute();

            if (!response.isSuccess()) {
                event.setCode(response.code());
                event.setThrowable(new SyncFailedException("Could not get animal list from servers"));
                bus.post(event);
            } else {
                getAnimals();
            }
//            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateAnimal(List<Animal> animals) {
        try {
            repository.updateAnimals(animals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAnimal(Animal animal) {
        RemoveAnimalEvent event = new RemoveAnimalEvent();
        event.setAnimals(animal);
        try {
            repository.removeAnimal(animal.getId());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
