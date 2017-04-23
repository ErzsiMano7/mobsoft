package mobsoft.bme.hu.mobsoft.ui.create;

import mobsoft.bme.hu.mobsoft.model.Animal;
import mobsoft.bme.hu.mobsoft.ui.Presenter;

import static mobsoft.bme.hu.mobsoft.repository.MemoryRepository.animals;

/**
 * Created by erzsi on 2017.04.09..
 */

public class CreatePresenter extends Presenter<CreateScreen> {

    public void createAnimal(String species, String classAnimal, String appearance, String habitat, String living, String reproduction) {
        Animal animal = new Animal(species, classAnimal, appearance, habitat, living, reproduction);

        animals.add(animal);

        screen.navigateToList();
    }

}