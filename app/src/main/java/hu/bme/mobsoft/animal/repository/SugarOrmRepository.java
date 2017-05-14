package hu.bme.mobsoft.animal.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mobsoft.animal.model.Animal;

import static hu.bme.mobsoft.animal.repository.MemoryRepository.animalMap;

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
    public long saveAnimal(Animal animal) {
        SugarRecord.saveInTx(animal);
        return animal.getId();
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
    public void removeAnimal(long id) {
        SugarRecord.delete(id);
    }

    @Override
    public boolean isInDB(Animal animal) {
        return SugarRecord.findById(Animal.class, animal.getId()) != null;
    }

    @Override
    public void clearAllAnimals() {
        SugarRecord.deleteAll(Animal.class);
    }
}
