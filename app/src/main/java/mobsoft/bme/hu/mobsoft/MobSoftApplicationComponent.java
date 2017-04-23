package mobsoft.bme.hu.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.bme.hu.mobsoft.interactor.InteractorModule;
import mobsoft.bme.hu.mobsoft.interactor.animals.AnimalsInteractor;
import mobsoft.bme.hu.mobsoft.repository.Repository;
import mobsoft.bme.hu.mobsoft.repository.RepositoryModule;
import mobsoft.bme.hu.mobsoft.ui.UIModule;
import mobsoft.bme.hu.mobsoft.ui.create.CreateActivity;
import mobsoft.bme.hu.mobsoft.ui.detail.DetailActivity;
import mobsoft.bme.hu.mobsoft.ui.list.ListActivity;
import mobsoft.bme.hu.mobsoft.ui.login.LoginActivity;
import mobsoft.bme.hu.mobsoft.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(ListActivity listActivity);

    void inject(DetailActivity detailActivity);

    void inject(CreateActivity createActivity);

    void inject(AnimalsInteractor animalsInteractor);

    void inject(MobSoftApplication mobSoftApplication);
}
