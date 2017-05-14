package hu.bme.mobsoft.animal.api;

import hu.bme.mobsoft.animal.model.dto.UserHashDto;
import hu.bme.mobsoft.animal.model.dto.UserObjectDto;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserApi {
  
  /**
   * 
   * Login the user!
   * @param user 
   * @return Call<UserHashDto>
   */
  
  @POST("user")
  Call<UserHashDto> userPost(
          @Body UserObjectDto user
  );

  
}
