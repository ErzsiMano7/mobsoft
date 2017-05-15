package hu.bme.mobsoft.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.mobsoft.animal.repository.MemoryRepository;
import hu.bme.mobsoft.animal.repository.Repository;

/**
 * Created by erzsi on 2017.05.15..
 */
@Module
public class TestRepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
