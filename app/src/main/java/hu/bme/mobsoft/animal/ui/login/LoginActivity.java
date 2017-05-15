package hu.bme.mobsoft.animal.ui.login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.R;
import hu.bme.mobsoft.animal.ui.list.ListActivity;

import static android.R.attr.name;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    protected LoginPresenter loginPresenter;

    private TextInputLayout layoutUsername;
    private TextInputEditText etUsername;
    private TextInputLayout layoutPassword;
    private TextInputEditText etPassword;
    private Button btnLogin;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MobSoftApplication.injector.inject(this);

        layoutUsername = (TextInputLayout) findViewById(R.id.tilUsername);
        etUsername = (TextInputEditText) findViewById(R.id.etUsername);
        layoutPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        etPassword = (TextInputEditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutPassword.setErrorEnabled(false);
                layoutUsername.setErrorEnabled(false);
                loginPresenter.login(etUsername.getText().toString(), etPassword.getText().toString());

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Share")
                        .build());
            }
        });

        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.attachScreen(this);

        Log.i("Message", "Setting screen name: " + name);
        mTracker.setScreenName("Image~" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onPause() {
        loginPresenter.detachScreen();
        super.onPause();
    }

    @Override
    public void showLoginFailed() {

    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(this, ListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }


    @Override
    public void showPasswordError() {
        layoutPassword.setError("Empty or invalid password!");
    }

    @Override
    public void showUsernameError() {
        layoutUsername.setError("Empty or invalid username!");
    }
}
