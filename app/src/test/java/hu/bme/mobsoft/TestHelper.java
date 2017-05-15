package hu.bme.mobsoft;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

import hu.bme.mobsoft.animal.MobSoftApplication;
import hu.bme.mobsoft.animal.MobSoftApplicationComponent;

/**
 * Created by erzsi on 2017.05.15..
 */

public class TestHelper {
    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        MobSoftApplication application = (MobSoftApplication) RuntimeEnvironment.application;
        MobSoftApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}
