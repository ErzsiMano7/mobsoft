package hu.bme.mobsoft.animal.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class UserHashDto {
  
  @SerializedName("hashcode")
  private String hashcode = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getHashcode() {
    return hashcode;
  }
  public void setHashcode(String hashcode) {
    this.hashcode = hashcode;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserHashDto userHashDto = (UserHashDto) o;
    return Objects.equals(hashcode, userHashDto.hashcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashcode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserHashDto {\n");
    
    sb.append("    hashcode: ").append(toIndentedString(hashcode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
