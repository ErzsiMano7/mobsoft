package mobsoft.bme.hu.mobsoft.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobsoft.bme.hu.mobsoft.model.Animal;

/**
 * Created by erzsi on 2017.04.10..
 */

public class MemoryRepository implements Repository {

    public static Map<Long, Animal> animalMap;
    public static long nextId = -1;

    @Override
    public void open(Context context) {
        animalMap = new HashMap<>();
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
    public void saveAnimal(Animal animal) {
        animalMap.put(getNextId(), animal);
    }

    @Override
    public void updateAnimals(List<Animal> animals) {
        for (Animal an : animals)
        {
            animalMap.put(an.getId(), an);
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        animalMap.remove(animal.getId());
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

    public long getNextId()
    {
        return nextId++;
    }
}
