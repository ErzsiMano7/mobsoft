package mobsoft.bme.hu.mobsoft.ui.login;

import mobsoft.bme.hu.mobsoft.ui.Presenter;

/**
 * Created by erzsi on 2017.04.08..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    public void login(String username, String password){
        if (screen != null) {
            if(username.isEmpty()){
                screen.showUsernameError();
                return;
            }
            if(password.isEmpty()){
                screen.showPasswordError();
                return;
            }
            screen.onLoginSuccess();
        }
    }

}
