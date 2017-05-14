package hu.bme.mobsoft.animal.ui.login;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.interactor.user.UserInteractor;
import hu.bme.mobsoft.animal.interactor.user.events.UserLoginEvent;
import hu.bme.mobsoft.animal.model.dto.UserHashDto;
import hu.bme.mobsoft.animal.model.dto.UserObjectDto;
import hu.bme.mobsoft.animal.ui.Presenter;
import hu.bme.mobsoft.animal.ui.list.ListScreen;
import retrofit2.Call;
import retrofit2.Response;

import static hu.bme.mobsoft.animal.MobSoftApplication.injector;

/**
 * Created by erzsi on 2017.04.08..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    UserInteractor userInteractor;
    @Inject
    Executor executor;
    @Inject
    EventBus bus;

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void login(String username, String password) {
        if (screen != null) {
            if (username.isEmpty()) {
                screen.showUsernameError();
                return;
            }
            if (password.isEmpty()) {
                screen.showPasswordError();
                return;
            }

            final UserObjectDto usr = new UserObjectDto();
            usr.setUsername(username);
            usr.setPassword(password);

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    userInteractor.login(usr);
                }
            });
        }
    }

    public void onEventMainThread(UserLoginEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showLoginFailed();
            }
            Log.e("Networking", "Could not log in", event.getThrowable());
        } else {
            MobSoftApplication.saveUserHash(event.getUserHash());
            if(screen != null){
                screen.onLoginSuccess();
            }
        }
    }

}
