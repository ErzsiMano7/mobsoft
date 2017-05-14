package hu.bme.mobsoft.animal.mock;

import hu.bme.mobsoft.animal.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by erzsi on 2017.04.23..
 */

public class MockHttpServer {
    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
