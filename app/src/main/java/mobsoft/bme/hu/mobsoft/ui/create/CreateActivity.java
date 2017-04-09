package mobsoft.bme.hu.mobsoft.ui.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import mobsoft.bme.hu.mobsoft.MobSoftApplication;
import mobsoft.bme.hu.mobsoft.R;
import mobsoft.bme.hu.mobsoft.ui.list.ListActivity;

/**
 * Created by erzsi on 2017.04.09..
 */

public class CreateActivity extends AppCompatActivity implements CreateScreen {
    @Inject
    protected CreatePresenter createPresenter;

    protected Button saveButton;

    protected TextInputEditText etSpecies;
    protected TextInputEditText etClass;
    protected TextInputEditText etAppearance;
    protected TextInputEditText etHabitat;
    protected TextInputEditText etLiving;
    protected TextInputEditText etReproduction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etSpecies = (TextInputEditText) findViewById(R.id.etSpecies);
        etClass = (TextInputEditText) findViewById(R.id.etClass);
        etAppearance = (TextInputEditText) findViewById(R.id.etAppearance);
        etHabitat = (TextInputEditText) findViewById(R.id.etHabitat);
        etLiving = (TextInputEditText) findViewById(R.id.etLiving);
        etReproduction = (TextInputEditText) findViewById(R.id.etReproduction);

        saveButton = (Button) findViewById(R.id.btnSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPresenter.createAnimal(etSpecies.getText().toString(), etClass.getText().toString(), etAppearance.getText().toString(), etHabitat.getText().toString(), etLiving.getText().toString(), etReproduction.getText().toString());
            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createPresenter.attachScreen(this);
    }

    @Override
    protected void onPause() {
        createPresenter.detachScreen();
        super.onPause();
    }

    @Override
    public void navigateToList() {
        Intent intent = new Intent(this, ListActivity.class);
        setResult(RESULT_OK, intent);
        finish();
    }
}
