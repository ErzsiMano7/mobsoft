package hu.bme.mobsoft;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.mobsoft.animal.ui.create.CreatePresenter;
import hu.bme.mobsoft.animal.ui.detail.DetailPresenter;
import hu.bme.mobsoft.animal.ui.list.ListPresenter;
import hu.bme.mobsoft.animal.ui.login.LoginPresenter;
import hu.bme.mobsoft.animal.ui.UIModule;
import hu.bme.mobsoft.utils.UiExecutor;

/**
 * Created by erzsi on 2017.05.15..
 */

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }

    @Provides
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }

    @Provides
    public CreatePresenter provideCreatePresenter() {
        return UIModule.provideCreatePresenter();
    }

    @Provides
    public DetailPresenter provideDetailPresenter() {
        return UIModule.provideDetailPresenter();
    }

    @Provides
    public ListPresenter provideListPresenter() {
        return UIModule.provideListPresenter();
    }


    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }

}
