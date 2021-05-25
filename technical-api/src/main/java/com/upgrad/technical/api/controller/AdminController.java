package com.upgrad.technical.api.controller;


import com.upgrad.technical.api.model.ImageDetailsResponse;
import com.upgrad.technical.api.model.UpdateImageRequest;
import com.upgrad.technical.api.model.UpdateImageResponse;
import com.upgrad.technical.service.business.AdminService;
import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.exception.ImageNotFoundException;
import com.upgrad.technical.service.exception.UnauthorizedException;
import com.upgrad.technical.service.exception.UserNotSignedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.GET, path = "/images/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ImageDetailsResponse> getImage(@PathVariable("id") final String imageUuid, @RequestHeader("authorization") final String authorization) throws ImageNotFoundException, UnauthorizedException, UserNotSignedInException {

        final ImageEntity imageEntity = adminService.getImage(imageUuid, authorization);

        ImageDetailsResponse imageDetailsResponse = new ImageDetailsResponse().image(imageEntity.getImage()).id((int) imageEntity.getId()).name(imageEntity.getName()).description(imageEntity.getDescription()).status(imageEntity.getStatus());
        return new ResponseEntity<ImageDetailsResponse>(imageDetailsResponse, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/images/update/{image_id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UpdateImageResponse> updateImage(final UpdateImageRequest updateImageRequest, @PathVariable("image_id") final long image_id, @RequestHeader("authorization") final String authorization) throws ImageNotFoundException, UnauthorizedException, UserNotSignedInException {
        ImageEntity imageEntity = new ImageEntity();

        imageEntity.setImage(updateImageRequest.getImage());
        imageEntity.setId(image_id);
        imageEntity.setName(updateImageRequest.getName());
        imageEntity.setStatus(updateImageRequest.getStatus());
        imageEntity.setDescription(updateImageRequest.getDescription());


        ImageEntity updatedimageEntity = adminService.updateImage(imageEntity, authorization);
        UpdateImageResponse updateImageResponse = new UpdateImageResponse().id((int) updatedimageEntity.getId()).status(updatedimageEntity.getStatus());
        return new ResponseEntity<UpdateImageResponse>(updateImageResponse, HttpStatus.OK);
    }

}
