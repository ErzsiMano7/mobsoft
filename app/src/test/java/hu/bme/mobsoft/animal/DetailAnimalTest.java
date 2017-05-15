package hu.bme.mobsoft.animal;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mobsoft.animal.model.Animal;
import hu.bme.mobsoft.animal.repository.MemoryRepository;
import hu.bme.mobsoft.animal.ui.detail.DetailPresenter;
import hu.bme.mobsoft.animal.ui.detail.DetailScreen;
import hu.bme.mobsoft.animal.ui.login.LoginPresenter;
import hu.bme.mobsoft.animal.ui.login.LoginScreen;

import static hu.bme.mobsoft.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by erzsi on 2017.05.15..
 */

public class DetailAnimalTest {
    private final Animal animalTest = new Animal("Vörös róka", "emlős", "vörös bunda", "ragadozó", "Európa", "4-7 kölyök", "roka.jpg");
    private DetailPresenter detailPresenter;
    private LoginPresenter loginPresenter;

    @Before
    public void setUp()
    {
        setTestInjector();
        detailPresenter = new DetailPresenter();
        LoginScreen loginScreen = mock(LoginScreen.class);
        loginPresenter = new LoginPresenter();
        loginPresenter.attachScreen(loginScreen);
        loginPresenter.login("testuser", "testpw");
    }

    @After
    public void tearDown() {
        detailPresenter.detachScreen();
        loginPresenter.detachScreen();
    }

}

