package mobsoft.bme.hu.mobsoft.ui.create;

import java.util.List;

import mobsoft.bme.hu.mobsoft.model.Animal;
import mobsoft.bme.hu.mobsoft.ui.Presenter;

/**
 * Created by erzsi on 2017.04.09..
 */

public class CreatePresenter extends Presenter<CreateScreen> {
    protected List<Animal> animalList;

    public void createAnimal(String species, String classAnimal, String appearance, String habitat, String living, String reproduction) {
        Animal animal = new Animal(species, classAnimal, appearance, habitat, living, reproduction);

        animalList.add(animal);

        screen.navigateToList();
    }

}