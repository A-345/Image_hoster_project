package com.upgrad.technical.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ImageUploadRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-05-25T16:29:14.267+05:30")

public class ImageUploadRequest   {
  @JsonProperty("image")
  private String image = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  public ImageUploadRequest image(String image) {
    this.image = image;
    return this;
  }

  /**
   * The pic in Base64 format
   * @return image
  **/
  @ApiModelProperty(required = true, value = "The pic in Base64 format")
  @NotNull


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ImageUploadRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the image
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the image")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ImageUploadRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the image
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description of the image")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageUploadRequest imageUploadRequest = (ImageUploadRequest) o;
    return Objects.equals(this.image, imageUploadRequest.image) &&
        Objects.equals(this.name, imageUploadRequest.name) &&
        Objects.equals(this.description, imageUploadRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(image, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageUploadRequest {\n");
    
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

