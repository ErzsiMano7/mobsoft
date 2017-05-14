package hu.bme.mobsoft.animal.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.mobsoft.animal.ui.create.CreatePresenter;
import hu.bme.mobsoft.animal.ui.detail.DetailPresenter;
import hu.bme.mobsoft.animal.ui.list.ListPresenter;
import hu.bme.mobsoft.animal.ui.login.LoginPresenter;
import hu.bme.mobsoft.animal.ui.main.MainPresenter;


/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public ListPresenter provideListPresenter() {
        return new ListPresenter();
    }

    @Provides
    @Singleton
    public DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }

    @Provides
    @Singleton
    public CreatePresenter provideCreatePresenter() {
        return new CreatePresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}