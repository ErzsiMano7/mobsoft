package hu.bme.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.mobsoft.animal.MobSoftApplicationComponent;
import hu.bme.mobsoft.animal.interactor.InteractorModule;
import hu.bme.mobsoft.animal.mock.MockNetworkModule;
import hu.bme.mobsoft.repository.TestRepositoryModule;

/**
 * Created by erzsi on 2017.05.15..
 */

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
