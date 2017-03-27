package mobsoft.bme.hu.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.bme.hu.mobsoft.ui.UIModule;
import mobsoft.bme.hu.mobsoft.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
	void inject(MainActivity mainActivity);

}
