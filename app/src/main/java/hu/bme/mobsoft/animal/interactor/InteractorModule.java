package hu.bme.mobsoft.animal.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.mobsoft.animal.interactor.animals.AnimalsInteractor;
import hu.bme.mobsoft.animal.interactor.user.UserInteractor;

/**
 * Created by erzsi on 2017.04.10..
 */
@Module
public class InteractorModule {

    @Provides
    public AnimalsInteractor provideAnimals() {
        return new AnimalsInteractor();
    }

    @Provides
    public UserInteractor provideUser() {
        return new UserInteractor();
    }
}
