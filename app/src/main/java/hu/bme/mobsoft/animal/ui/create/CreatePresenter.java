package hu.bme.mobsoft.animal.ui.create;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.mobsoft.animal.interactor.animals.AnimalsInteractor;
import hu.bme.mobsoft.animal.interactor.animals.events.SaveAnimalEvent;
import hu.bme.mobsoft.animal.model.Animal;
import hu.bme.mobsoft.animal.ui.Presenter;

import static hu.bme.mobsoft.animal.MobSoftApplication.injector;

/**
 * Created by erzsi on 2017.04.09..
 */

public class CreatePresenter extends Presenter<CreateScreen> {
    @Inject
    AnimalsInteractor animalsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    public CreatePresenter(){
    }

    public void createAnimal(String species, String classAnimal, String appearance, String habitat, String living, String reproduction, String image) {
        final Animal animal = new Animal(species, classAnimal, appearance, habitat, living, reproduction, image);
        saveAnimal(animal);
        screen.navigateToList();
    }

    @Override
    public void attachScreen(CreateScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void saveAnimal(final Animal animal) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                animalsInteractor.saveAnimal(animal);
            }
        });
    }

    public void onEventMainThread(SaveAnimalEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error creating new animal", event.getThrowable());
        } else {
            if (screen != null) {
                    screen.showMessage(event.getAnimal().getSpecies());
            }
        }
    }
}