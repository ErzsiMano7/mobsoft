package hu.bme.mobsoft.animal.mock.interceptors;

import android.net.Uri;

import java.io.IOException;

import hu.bme.mobsoft.animal.model.Animal;
import hu.bme.mobsoft.animal.model.dto.AnimalDto;
import hu.bme.mobsoft.animal.model.dto.AnimalIdDto;
import hu.bme.mobsoft.animal.network.NetworkConfig;
import hu.bme.mobsoft.animal.repository.MemoryRepository;
import hu.bme.mobsoft.animal.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

import static hu.bme.mobsoft.animal.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by erzsi on 2017.05.14..
 */

public class AnimalMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "animals") && request.method().equals("GET")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            responseString = GsonHelper.getGson().toJson(memoryRepository.getAnimals());
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "animals") && request.method().equals("POST")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            Animal animal = new Animal(GsonHelper.getGson().fromJson(bodyToString(request), AnimalDto.class));
            long id = memoryRepository.saveAnimal(animal);
            AnimalIdDto animalIdDto = new AnimalIdDto();
            animalIdDto.setId(id);
            responseString = GsonHelper.getGson().toJson(animalIdDto);
            responseCode = 200;
        /*} else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "animals/{id}") && request.method().equals("PUT")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            List<AnimalDto> animalDtoList = new ArrayList<>();

            long id = memoryRepository.updateAnimal(GsonHelper.getGson().fromJson(request.body().toString(), List<Animal>.class));
            AnimalIdDto animalIdDto = new AnimalIdDto();
            animalIdDto.setId(id);
            responseString = GsonHelper.getGson().toJson(animalIdDto);
            responseCode = 200;*/
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "animals/") && request.method().equals("DELETE")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            long id = Long.parseLong(uri.getPath().substring(uri.getPath().lastIndexOf("/")));
            memoryRepository.removeAnimal(id);
            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 404;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }

    public static String bodyToString(final Request request) {

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "";
        }
    }

}
