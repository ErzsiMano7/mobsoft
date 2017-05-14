package hu.bme.mobsoft.animal.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mobsoft.animal.R;
import hu.bme.mobsoft.animal.model.Animal;

/**
 * Created by erzsi on 2017.05.14..
 */

public class AnimalAdapter extends BaseAdapter {
    private List<Animal> animalList;
    private Context context;

    public AnimalAdapter(Context context) {
        animalList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Animal getItem(int position) {
        return animalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Animal animal = (Animal) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false);
        }
        // Lookup view for data population
        TextView tvSpecies = (TextView) convertView.findViewById(R.id.tvAnimalItem);
        // Populate the data into the template view using the data object
        tvSpecies.setText(animal.getSpecies());
        // Return the completed view to render on screen
        return convertView;
    }

    public void setItems(List<Animal> animals)
    {
        animalList.clear();
        animalList.addAll(animals);
    }
}

