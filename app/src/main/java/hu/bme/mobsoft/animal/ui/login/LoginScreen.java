package hu.bme.mobsoft.animal.ui.login;

/**
 * Created by erzsi on 2017.04.08..
 */

public interface LoginScreen {
    void showLoginFailed();

    void onLoginSuccess();

    void showPasswordError();

    void showUsernameError();
}
