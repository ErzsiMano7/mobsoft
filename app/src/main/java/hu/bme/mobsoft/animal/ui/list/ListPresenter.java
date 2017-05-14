package hu.bme.mobsoft.animal.ui.list;

import android.util.Log;


import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.mobsoft.animal.interactor.animals.AnimalsInteractor;
import hu.bme.mobsoft.animal.interactor.animals.events.GetAnimalsEvent;
import hu.bme.mobsoft.animal.model.Animal;
import hu.bme.mobsoft.animal.ui.Presenter;

import static hu.bme.mobsoft.animal.MobSoftApplication.injector;

/**
 * Created by erzsi on 2017.04.09..
 */

public class ListPresenter extends Presenter<ListScreen> {
    @Inject
    AnimalsInteractor animalsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(ListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);

    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getAnimals() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                animalsInteractor.getAnimals();
            }
        });
    }

    public void onEventMainThread(GetAnimalsEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading animals", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showAnimalList(event.getAnimals());
            }
        }
    }

    public void createAnimal(Animal animal) {
        animalsInteractor.saveAnimal(animal);
        getAnimals();
    }
}
