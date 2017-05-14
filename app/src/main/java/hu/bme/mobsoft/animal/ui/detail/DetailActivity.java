package hu.bme.mobsoft.animal.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.R;
import hu.bme.mobsoft.animal.model.Animal;
import hu.bme.mobsoft.animal.ui.list.ListActivity;
import hu.bme.mobsoft.animal.utils.GsonHelper;

/**
 * Created by erzsi on 2017.04.09..
 */

public class DetailActivity extends AppCompatActivity implements DetailScreen {

    @Inject
    protected DetailPresenter detailPresenter;

    protected TextView tvClass;
    protected TextView tvAppearance;
    protected TextView tvHabitat;
    protected TextView tvLiving;
    protected TextView tvReproduction;
    protected ImageView ivAnimal;
    private Animal animal;

    public static final String ANIMAL = "ANIMAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MobSoftApplication.injector.inject(this);

        tvClass = (TextView) findViewById(R.id.tvClass);
        tvAppearance = (TextView) findViewById(R.id.tvAppearance);
        tvHabitat = (TextView) findViewById(R.id.tvHabitat);
        tvLiving = (TextView) findViewById(R.id.tvLiving);
        tvReproduction = (TextView) findViewById(R.id.tvReproduction);
        ivAnimal = (ImageView) findViewById(R.id.ivDetailsBackground);

        animal = GsonHelper.getGson().fromJson(getIntent().getStringExtra(ListActivity.EXTRA_ANIMAL), Animal.class);

        setTitle(animal.getSpecies());
        showAnimal(animal);
    }

    @Override
    protected void onResume() {
        super.onResume();
        detailPresenter.attachScreen(this);
    }

    @Override
    protected void onPause() {
        detailPresenter.detachScreen();
        super.onPause();
    }

    @Override
    public void showAnimal(Animal animal) {
        tvClass.setText(animal.getClassAnimal());
        tvAppearance.setText(animal.getAppearance());
        tvHabitat.setText(animal.getHabitat());
        tvLiving.setText(animal.getLiving());
        tvReproduction.setText(animal.getReproduction());
        Glide.with(this).load(animal.getImage()).centerCrop().into(ivAnimal);
    }
}
