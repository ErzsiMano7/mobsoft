package mobsoft.bme.hu.mobsoft.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import mobsoft.bme.hu.mobsoft.ui.create.CreatePresenter;
import mobsoft.bme.hu.mobsoft.ui.detail.DetailPresenter;
import mobsoft.bme.hu.mobsoft.ui.list.ListPresenter;
import mobsoft.bme.hu.mobsoft.ui.login.LoginPresenter;
import mobsoft.bme.hu.mobsoft.ui.main.MainPresenter;


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
}