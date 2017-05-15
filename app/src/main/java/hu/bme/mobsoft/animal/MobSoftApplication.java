package hu.bme.mobsoft.animal;

import android.content.SharedPreferences;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarApp;

import io.fabric.sdk.android.Fabric;
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
	private Tracker mTracker;

	@Override
	public void onCreate() {
		super.onCreate();
		Fabric.with(this, new Crashlytics());

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

    public void setInjector(MobSoftApplicationComponent mobSoftApplicationComponent) {
        injector = mobSoftApplicationComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }


	synchronized public Tracker getDefaultTracker() {
		if (mTracker == null) {
			GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
			// To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
			mTracker = analytics.newTracker(R.xml.global_tracker);
		}
		return mTracker;
	}
}
