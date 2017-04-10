package mobsoft.bme.hu.mobsoft.repository;

import android.content.Context;

import java.util.List;

import mobsoft.bme.hu.mobsoft.model.Animal;

/**
 * Created by erzsi on 2017.04.10..
 */

public class MemoryRepository implements Repository {
    @Override
    public void open(Context context) {

    }

    @Override
    public void close() {

    }

    @Override
    public List<Animal> getFavourites() {
        return null;
    }

    @Override
    public void saveFavourite(Animal animal) {

    }

    @Override
    public void updateFavourites(List<Animal> animals) {

    }

    @Override
    public void removeFavourite(Animal animal) {

    }

    @Override
    public boolean isInDB(Animal animal) {
        return false;
    }
}
