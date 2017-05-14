package hu.bme.mobsoft.animal;

/**
 * Created by erzsi on 2017.05.14..
 */

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.mobsoft.animal.interactor.InteractorModule;
import hu.bme.mobsoft.animal.mock.MockNetworkModule;
import hu.bme.mobsoft.animal.repository.RepositoryModule;
import hu.bme.mobsoft.animal.ui.UIModule;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, MockNetworkModule.class})
public interface MockApplicationComponent extends MobSoftApplicationComponent {

}
