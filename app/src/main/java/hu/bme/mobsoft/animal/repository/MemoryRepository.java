package hu.bme.mobsoft.animal.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.bme.mobsoft.animal.model.Animal;

/**
 * Created by erzsi on 2017.04.10..
 */

public class MemoryRepository implements Repository {

    public static Map<Long, Animal> animalMap = new HashMap<>();
    public static long nextId = -1;

    @Override
    public void open(Context context) {
    }

    @Override
    public void close() {
    }

    @Override
    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        for(long i : animalMap.keySet())
        {
            animals.add(animalMap.get(i));
        }
        return animals;
    }

    @Override
    public long saveAnimal(Animal animal) {
        long id = getNextId();
        animalMap.put(id, animal);
        return id;
    }

    @Override
    public void updateAnimals(List<Animal> animals) {
        for (Animal an : animals)
        {
            animalMap.put(an.getId(), an);
        }
    }

    @Override
    public void removeAnimal(long id) {
        animalMap.remove(id);
    }

    @Override
    public boolean isInDB(Animal animal) {
        for(long i : animalMap.keySet())
        {
            if(animalMap.get(i).equals(animal))
                return true;
        }
        return false;
    }

    @Override
    public void clearAllAnimals() {
        animalMap.clear();
    }

    public long getNextId()
    {
        return nextId++;
    }
}
