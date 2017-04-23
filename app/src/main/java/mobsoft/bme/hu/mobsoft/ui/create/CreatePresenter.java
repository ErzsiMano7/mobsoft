package mobsoft.bme.hu.mobsoft.ui.create;

import javax.inject.Inject;

import mobsoft.bme.hu.mobsoft.MobSoftApplication;
import mobsoft.bme.hu.mobsoft.MobSoftApplicationComponent;
import mobsoft.bme.hu.mobsoft.model.Animal;
import mobsoft.bme.hu.mobsoft.repository.Repository;
import mobsoft.bme.hu.mobsoft.ui.Presenter;


/**
 * Created by erzsi on 2017.04.09..
 */

public class CreatePresenter extends Presenter<CreateScreen> {

    @Inject
    Repository repository;

    public CreatePresenter(){
        MobSoftApplication.injector.inject(this);
    }

    public void createAnimal(String species, String classAnimal, String appearance, String habitat, String living, String reproduction) {
        Animal animal = new Animal(species, classAnimal, appearance, habitat, living, reproduction);

        repository.saveAnimal(animal);

        screen.navigateToList();
    }

}