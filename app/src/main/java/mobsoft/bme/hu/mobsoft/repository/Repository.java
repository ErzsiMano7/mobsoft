package mobsoft.bme.hu.mobsoft.repository;

import android.content.Context;

import java.util.List;

import mobsoft.bme.hu.mobsoft.model.Animal;

/**
 * Created by erzsi on 2017.04.10..
 */

public interface Repository {
    void open(Context context);

    void close();

    List<Animal> getAnimals();

    void saveAnimal(Animal animal);

    void updateAnimals(List<Animal> animals);

    void removeAnimal(Animal animal);

    boolean isInDB(Animal animal);
}
