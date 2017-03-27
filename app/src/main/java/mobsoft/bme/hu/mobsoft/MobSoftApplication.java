package mobsoft.bme.hu.mobsoft;

import android.app.Application;
import mobsoft.bme.hu.mobsoft.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MobSoftApplication extends Application {
    public static MobSoftApplicationComponent injector;

	@Override
	public void onCreate() {
		super.onCreate();

		injector =
				DaggerMobSoftApplicationComponent.builder().
						uIModule(
								new UIModule(this)
						).build();
	}
}
