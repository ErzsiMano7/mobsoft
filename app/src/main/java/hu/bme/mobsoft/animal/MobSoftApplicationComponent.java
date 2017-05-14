package hu.bme.mobsoft.animal;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.mobsoft.animal.interactor.InteractorModule;
import hu.bme.mobsoft.animal.interactor.animals.AnimalsInteractor;
import hu.bme.mobsoft.animal.interactor.user.UserInteractor;
import hu.bme.mobsoft.animal.network.NetworkModule;
import hu.bme.mobsoft.animal.repository.RepositoryModule;
import hu.bme.mobsoft.animal.ui.UIModule;
import hu.bme.mobsoft.animal.ui.create.CreateActivity;
import hu.bme.mobsoft.animal.ui.create.CreatePresenter;
import hu.bme.mobsoft.animal.ui.detail.DetailActivity;
import hu.bme.mobsoft.animal.ui.list.ListActivity;
import hu.bme.mobsoft.animal.ui.list.ListPresenter;
import hu.bme.mobsoft.animal.ui.login.LoginActivity;
import hu.bme.mobsoft.animal.ui.login.LoginPresenter;
import hu.bme.mobsoft.animal.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(ListActivity listActivity);

    void inject(DetailActivity detailActivity);

    void inject(CreateActivity createActivity);

    void inject(AnimalsInteractor animalsInteractor);

    void inject(UserInteractor userInteractor);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(CreatePresenter createPresenter);

    void inject(ListPresenter listPresenter);

    void inject(LoginPresenter loginPresenter);
}
