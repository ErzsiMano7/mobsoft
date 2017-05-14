package hu.bme.mobsoft.animal;

import android.content.SharedPreferences;

import com.orm.SugarApp;

import javax.inject.Inject;

import hu.bme.mobsoft.animal.repository.Repository;
import hu.bme.mobsoft.animal.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MobSoftApplication extends SugarApp {

	@Inject
	Repository repository;

    public static MobSoftApplicationComponent injector;

	private static SharedPreferences prefs;

	@Override
	public void onCreate() {
		super.onCreate();

        if(BuildConfig.DEBUG){
            injector =
                    DaggerMockApplicationComponent.builder().
                            uIModule(
                                    new UIModule(this)
                            ).build();
        }else{
            injector =
                    DaggerMobSoftApplicationComponent.builder().
                            uIModule(
                                    new UIModule(this)
                            ).build();
        }


		injector.inject(this);
		repository.open(getApplicationContext());

		prefs = getSharedPreferences("default", MODE_PRIVATE);

	}

	public static void saveUserHash(String hash){
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("hash", hash);
		editor.apply();
	}

	public static String getUserHash(){
		return prefs.getString("hash", "");
	}
}
