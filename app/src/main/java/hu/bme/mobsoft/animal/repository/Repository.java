package hu.bme.mobsoft.animal.repository;

import android.content.Context;

import java.util.List;

import hu.bme.mobsoft.animal.model.Animal;

/**
 * Created by erzsi on 2017.04.10..
 */

public interface Repository {
    void open(Context context);

    void close();

    List<Animal> getAnimals();

    long saveAnimal(Animal animal);

    void updateAnimals(List<Animal> animals);

    void removeAnimal(long id);

    boolean isInDB(Animal animal);

    void clearAllAnimals();
}
