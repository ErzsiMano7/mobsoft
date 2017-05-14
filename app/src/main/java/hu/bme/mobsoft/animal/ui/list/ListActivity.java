package hu.bme.mobsoft.animal.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.R;
import hu.bme.mobsoft.animal.model.Animal;
import hu.bme.mobsoft.animal.ui.create.CreateActivity;
import hu.bme.mobsoft.animal.ui.detail.DetailActivity;
import hu.bme.mobsoft.animal.utils.GsonHelper;

/**
 * Created by erzsi on 2017.04.09..
 */

public class ListActivity extends AppCompatActivity implements ListScreen {
    public static final String EXTRA_CREATED_ANIMAL = "created_animal";

    private static final int REQUEST_CREATE_ANIMAL = 200;
    public static final String EXTRA_ANIMAL = "extra_animal";
    @Inject
    protected ListPresenter listPresenter;

    protected FloatingActionButton floatingActionButton;

    protected ListView listView;

    protected AnimalAdapter animalAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MobSoftApplication.injector.inject(this);

        listView = (ListView) findViewById(R.id.listView);

        animalAdapter = new AnimalAdapter(this);

        listView.setAdapter(animalAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                navigateToDetailScreen(animalAdapter.getItem(position));
            }
        });

        floatingActionButton = (FloatingActionButton) findViewById(R.id.btnCreate);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, CreateActivity.class);
                startActivityForResult(intent, REQUEST_CREATE_ANIMAL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CREATE_ANIMAL && resultCode == RESULT_OK){
            listPresenter.createAnimal(GsonHelper.getGson().fromJson(data.getStringExtra(EXTRA_CREATED_ANIMAL), Animal.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        listPresenter.attachScreen(this);
    }

    @Override
    protected void onPause() {
        listPresenter.detachScreen();
        super.onPause();
    }

    @Override
    public void navigateToDetailScreen(Animal animal) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_ANIMAL, GsonHelper.getGson().toJson(animal));
        startActivity(intent);
    }

    @Override
    public void showAnimalList(List<Animal> animals) {
        animalAdapter.setItems(animals);
        animalAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
