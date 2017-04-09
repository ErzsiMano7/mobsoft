package mobsoft.bme.hu.mobsoft.ui.login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import mobsoft.bme.hu.mobsoft.MobSoftApplication;
import mobsoft.bme.hu.mobsoft.R;
import mobsoft.bme.hu.mobsoft.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    protected LoginPresenter loginPresenter;

    private TextInputLayout layoutUsername;
    private TextInputEditText etUsername;
    private TextInputLayout layoutPassword;
    private TextInputEditText etPassword;
    private Button btnLogin;

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
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.attachScreen(this);
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
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
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