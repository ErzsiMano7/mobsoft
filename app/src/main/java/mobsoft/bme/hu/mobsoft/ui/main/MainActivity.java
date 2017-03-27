package mobsoft.bme.hu.mobsoft.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import mobsoft.bme.hu.mobsoft.MobSoftApplication;
import mobsoft.bme.hu.mobsoft.R;

public class MainActivity extends AppCompatActivity implements MainScreen {

	@Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }
	
 @Override
    protected void onStart() {
        super.onStart();
       mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
