package mobsoft.bme.hu.mobsoft.interactor;

import dagger.Module;
import dagger.Provides;
import mobsoft.bme.hu.mobsoft.interactor.animals.AnimalsInteractor;

/**
 * Created by erzsi on 2017.04.10..
 */
@Module
public class InteractorModule {

    @Provides
    public AnimalsInteractor provideAnimals() {
        return new AnimalsInteractor();
    }
}
