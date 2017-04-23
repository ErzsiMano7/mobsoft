package mobsoft.bme.hu.mobsoft;

import android.app.Application;

import javax.inject.Inject;

import mobsoft.bme.hu.mobsoft.repository.Repository;
import mobsoft.bme.hu.mobsoft.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MobSoftApplication extends Application {

	@Inject
	Repository repository;

    public static MobSoftApplicationComponent injector;

	@Override
	public void onCreate() {
		super.onCreate();

		injector =
				DaggerMobSoftApplicationComponent.builder().
						uIModule(
								new UIModule(this)
						).build();

		injector.inject(this);
		repository.open(getApplicationContext());

	}
}
