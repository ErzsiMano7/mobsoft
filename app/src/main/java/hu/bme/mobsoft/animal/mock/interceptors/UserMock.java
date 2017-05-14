package hu.bme.mobsoft.animal.mock.interceptors;

import android.net.Uri;

import hu.bme.mobsoft.animal.model.dto.UserHashDto;
import hu.bme.mobsoft.animal.network.NetworkConfig;
import hu.bme.mobsoft.animal.repository.MemoryRepository;
import hu.bme.mobsoft.animal.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.mobsoft.animal.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by erzsi on 2017.05.14..
 */

public class UserMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if(uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "user") && request.method().equals("POST"))
        {
            UserHashDto userHashDto = new UserHashDto();
            userHashDto.setHashcode("TESTADMIN");
            responseString = GsonHelper.getGson().toJson(userHashDto);
            responseCode = 200;
        }
        else {
            responseString = "ERROR";
            responseCode = 404;
        }
        return makeResponse(request, headers, responseCode, responseString);
    }
}
