package hu.bme.mobsoft.animal.api;

import java.util.List;

import hu.bme.mobsoft.animal.model.dto.AnimalDto;
import hu.bme.mobsoft.animal.model.dto.AnimalIdDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AnimalApi {
  
  /**
   * 
   * Gets a list of `Animal` objects.
   * @return Call<List<AnimalDto>>
   */
  
  @GET("animals")
  Call<List<AnimalDto>> getAnimals();
    

  
  /**
   * 
   * Add a new animal to the list.
   * @param accessHash Only admin has the right to do this method
   * @param animal Pet object that needs to be added to the store
   * @return Call<AnimalIdDto>
   */
  
  @POST("animals")
  Call<AnimalIdDto> addAnimal(
          @Header("AccessHash") String accessHash, @Body AnimalDto animal
  );

  
  /**
   * 
   * Find an animal based on id.
   * @param id id of an animal to return
   * @return Call<Animal>
   */
  
  @GET("animals/{id}")
  Call<AnimalDto> getAnimalById(
          @Path("id") Long id
  );

  
  /**
   * 
   * Update an animal.
   * @param accessHash Only admin has the right to do this method
   * @param animal Animal object that needs to be added to the store
   * @param id id of an animal to update
   * @return Call<AnimalIdDto>
   */
  
  @PUT("animals/{id}")
  Call<AnimalIdDto> updateAnimal(
          @Header("AccessHash") String accessHash, @Body AnimalDto animal, @Path("id") Long id
  );

  
  /**
   * 
   * Delete an animal based on id.
   * @param id id of animal to delete
   * @return Call<Void>
   */
  
  @DELETE("animals/{id}")
  Call<Void> deleteAnimal(
          @Path("id") Long id
  );

  
}
