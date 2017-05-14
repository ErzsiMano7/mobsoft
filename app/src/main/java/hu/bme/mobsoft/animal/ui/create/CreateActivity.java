package hu.bme.mobsoft.animal.ui.create;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.R;
import hu.bme.mobsoft.animal.ui.list.ListActivity;

/**
 * Created by erzsi on 2017.04.09..
 */

public class CreateActivity extends AppCompatActivity implements CreateScreen {
    private static final int REQUEST_IMAGE_CODE = 200;
    @Inject
    protected CreatePresenter createPresenter;

    protected Button saveButton;
    protected Button imageButton;

    protected TextInputEditText etSpecies;
    protected TextInputEditText etClass;
    protected TextInputEditText etAppearance;
    protected TextInputEditText etHabitat;
    protected TextInputEditText etLiving;
    protected TextInputEditText etReproduction;
    protected TextView tvImage;


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
        tvImage = (TextView) findViewById(R.id.tilImage);

        imageButton = (Button) findViewById(R.id.btnImage);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivityForResult(intent, REQUEST_IMAGE_CODE);
            }
        });

        saveButton = (Button) findViewById(R.id.btnSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPresenter.createAnimal(etSpecies.getText().toString(), etClass.getText().toString(),
                        etAppearance.getText().toString(), etHabitat.getText().toString(), etLiving.getText().toString(),
                        etReproduction.getText().toString(), tvImage.getText().toString());
            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CODE && resultCode == RESULT_OK) {
            Uri uri = data.getData();

            String[] projection = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(projection[0]);
            String picturePath = cursor.getString(columnIndex); // returns null
            cursor.close();

            tvImage.setText(picturePath);
        }
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

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
