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
 * ImageDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-05-25T16:29:14.407+05:30")

public class ImageDetailsResponse   {
  @JsonProperty("image")
  private String image = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("status")
  private String status = null;

  public ImageDetailsResponse image(String image) {
    this.image = image;
    return this;
  }

  /**
   * This is image in Base64 format
   * @return image
  **/
  @ApiModelProperty(required = true, value = "This is image in Base64 format")
  @NotNull


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ImageDetailsResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the user in a standard UUID format
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the user in a standard UUID format")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ImageDetailsResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the image
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the image")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ImageDetailsResponse description(String description) {
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

  public ImageDetailsResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * REGISTERED
   * @return status
  **/
  @ApiModelProperty(required = true, value = "REGISTERED")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageDetailsResponse imageDetailsResponse = (ImageDetailsResponse) o;
    return Objects.equals(this.image, imageDetailsResponse.image) &&
        Objects.equals(this.id, imageDetailsResponse.id) &&
        Objects.equals(this.name, imageDetailsResponse.name) &&
        Objects.equals(this.description, imageDetailsResponse.description) &&
        Objects.equals(this.status, imageDetailsResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(image, id, name, description, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageDetailsResponse {\n");
    
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

