package com.upgrad.technical.api.controller;

import com.upgrad.technical.api.model.ImageUploadRequest;
import com.upgrad.technical.api.model.ImageUploadResponse;
import com.upgrad.technical.api.model.SignupUserRequest;
import com.upgrad.technical.api.model.SignupUserResponse;
import com.upgrad.technical.service.business.ImageUploadService;
import com.upgrad.technical.service.business.SignupBusinessService;
import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.entity.UserEntity;
import com.upgrad.technical.service.exception.UploadFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ImageUploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    @RequestMapping(method = RequestMethod.POST, path = "/imageupload", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ImageUploadResponse> imageupload(final ImageUploadRequest imageUploadRequest, @RequestHeader("authorization") final String authorization) throws UploadFailedException, UnsupportedEncodingException {
        final ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(imageUploadRequest.getImage());
        imageEntity.setName(imageUploadRequest.getName());
        imageEntity.setDescription(imageUploadRequest.getDescription());
        imageEntity.setUuid(UUID.randomUUID().toString());
        imageEntity.setNo_of_likes(0);
        imageEntity.setCreated_at(ZonedDateTime.now());
        imageEntity.setStatus("REGISTERED");


        final ImageEntity createdimageEntity = imageUploadService.upload(imageEntity, authorization);
        ImageUploadResponse imageUploadResponse = new ImageUploadResponse().id(createdimageEntity.getUuid()).status("IMAGE SUCCESSFULLY REGISTERED");
        return new ResponseEntity<ImageUploadResponse>(imageUploadResponse,HttpStatus.CREATED);
    }

}
