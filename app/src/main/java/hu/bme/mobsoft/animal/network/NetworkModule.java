package hu.bme.mobsoft.animal.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.mobsoft.animal.api.AnimalApi;
import hu.bme.mobsoft.animal.api.UserApi;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import hu.bme.mobsoft.animal.utils.GsonHelper;

/**
 * Created by erzsi on 2017.04.24..
 */
@Module
public class NetworkModule {
    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public AnimalApi provideAnimalApi(Retrofit retrofit) {
        return retrofit.create(AnimalApi.class);
    }

    @Provides
    @Singleton
    public UserApi provideUserApi(Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }
}
