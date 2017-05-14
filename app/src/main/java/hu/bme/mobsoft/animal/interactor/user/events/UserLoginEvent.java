package hu.bme.mobsoft.animal.interactor.user.events;

import java.util.List;

import hu.bme.mobsoft.animal.model.Animal;

/**
 * Created by erzsi on 2017.05.14..
 */

public class UserLoginEvent {
    private int code;
    private String userHash;
    private Throwable throwable;

    public UserLoginEvent(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
