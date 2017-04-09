package mobsoft.bme.hu.mobsoft.ui.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import mobsoft.bme.hu.mobsoft.MobSoftApplication;
import mobsoft.bme.hu.mobsoft.R;
import mobsoft.bme.hu.mobsoft.model.Animal;

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
        tvLiving.setText(animal.getReproduction());
    }
}
