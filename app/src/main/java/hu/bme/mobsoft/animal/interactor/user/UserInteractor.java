package hu.bme.mobsoft.animal.interactor.user;

import java.io.IOException;
import java.security.InvalidParameterException;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.MobSoftApplicationComponent;
import hu.bme.mobsoft.animal.api.UserApi;
import hu.bme.mobsoft.animal.interactor.user.events.UserLoginEvent;
import hu.bme.mobsoft.animal.model.dto.UserHashDto;
import hu.bme.mobsoft.animal.model.dto.UserObjectDto;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by erzsi on 2017.05.14..
 */

public class UserInteractor {
    @Inject
    EventBus bus;
    @Inject
    UserApi userApi;

    public UserInteractor()
    {
        MobSoftApplication.injector.inject(this);
    }

    public void login(UserObjectDto usr) {

        UserLoginEvent event = new UserLoginEvent();
        try {
            Call<UserHashDto> call = userApi.userPost(usr);
            Response<UserHashDto> response = call.execute();

            if(!response.isSuccess()){
                event.setCode(response.code());
                event.setThrowable(new InvalidParameterException("Login failed"));
            }else{
                event.setCode(200);
                event.setUserHash(response.body().getHashcode());
            }

            bus.post(event);

        } catch (IOException e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
