package mobsoft.bme.hu.mobsoft.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import mobsoft.bme.hu.mobsoft.model.Animal;

import static mobsoft.bme.hu.mobsoft.repository.MemoryRepository.animals;

/**
 * Created by erzsi on 2017.04.10..
 */

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Animal> getAnimals() {
        return SugarRecord.listAll(Animal.class);
    }

    @Override
    public void saveAnimal(Animal animal) {
        SugarRecord.saveInTx(animal);
    }

    @Override
    public void updateAnimals(List<Animal> animals) {
        List<Animal> animalsList = getAnimals();
        List<Animal> toUpdate = new ArrayList<>(animalsList.size());
        for (Animal animal : animalsList) {
            for (Animal a : animals) {
                if (a.getId().equals(animal.getId())) {
                    toUpdate.add(a);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
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
