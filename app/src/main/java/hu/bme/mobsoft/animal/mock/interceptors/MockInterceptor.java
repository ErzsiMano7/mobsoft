package hu.bme.mobsoft.animal.mock.interceptors;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import hu.bme.mobsoft.animal.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.mobsoft.animal.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by erzsi on 2017.04.24..
 */

public class MockInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();


        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "animals")) {
            return AnimalMock.process(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "user")) {
            return UserMock.process(request);
        }
        return makeResponse(request, headers, 404, "Unknown");

    }
}
