package hu.bme.mobsoft.animal.ui.list;

import java.util.List;

import hu.bme.mobsoft.animal.model.Animal;

/**
 * Created by erzsi on 2017.04.09..
 */

public interface ListScreen {
    void navigateToDetailScreen(Animal animal);

    void showAnimalList(List<Animal> animals);

    void showMessage(String text);
}
