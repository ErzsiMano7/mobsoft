package mobsoft.bme.hu.mobsoft.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import javax.inject.Inject;

import mobsoft.bme.hu.mobsoft.MobSoftApplication;
import mobsoft.bme.hu.mobsoft.R;
import mobsoft.bme.hu.mobsoft.ui.create.CreateActivity;
import mobsoft.bme.hu.mobsoft.ui.detail.DetailActivity;

/**
 * Created by erzsi on 2017.04.09..
 */

public class ListActivity extends AppCompatActivity implements ListScreen {
    @Inject
    protected ListPresenter listPresenter;

    protected FloatingActionButton floatingActionButton;

    protected ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MobSoftApplication.injector.inject(this);

        listView = (ListView) findViewById(R.id.listView);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.btnCreate);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, CreateActivity.class);
                startActivityForResult(intent, RESULT_OK);
            }
        });
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
    public void navigateToDetailScreen() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
