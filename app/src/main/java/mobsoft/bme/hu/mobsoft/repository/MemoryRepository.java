package mobsoft.bme.hu.mobsoft.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import mobsoft.bme.hu.mobsoft.model.Animal;

/**
 * Created by erzsi on 2017.04.10..
 */

public class MemoryRepository implements Repository {

    public static List<Animal> animals;

    @Override
    public void open(Context context) {
        animals  = new ArrayList<>();
    }

    @Override
    public void close() {
    }

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void saveAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void updateAnimals(List<Animal> animals) {
        for (int i = 0; i < this.animals.size(); i++) {
            Animal animal = this.animals.get(i);
            for (Animal ani : animals) {
                if (ani.getId().equals(animal.getId())) {
                    this.animals.set(i, ani);
                }
            }
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public boolean isInDB(Animal animal) {
        return animals.contains(animal);
    }
}
