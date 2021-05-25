package com.upgrad.technical.service.business;


import com.upgrad.technical.service.dao.ImageDao;
import com.upgrad.technical.service.dao.UserDao;
import com.upgrad.technical.service.entity.ImageEntity;
import com.upgrad.technical.service.entity.UserAuthTokenEntity;
import com.upgrad.technical.service.exception.ImageNotFoundException;
import com.upgrad.technical.service.exception.UnauthorizedException;
import com.upgrad.technical.service.exception.UserNotSignedInException;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

@Service
public class AdminService {

    @Autowired
    private ImageDao imageDao;

    public ImageEntity getImage(final String imageUuid, final String authorization) throws ImageNotFoundException, UnauthorizedException, UserNotSignedInException {

        UserAuthTokenEntity userAuthTokenEntity = imageDao.getUserAuthToken(authorization);

        if(userAuthTokenEntity==null){
            throw new UserNotSignedInException("USR-001","You are not signed in, firstly sign in to fetch the details of the Image");
        }

        String role = userAuthTokenEntity.getUser().getRole();

        if(!role.equals("Admin")){
            throw new UnauthorizedException("ATH-001","UNAUTHORIZED Access, The user is not an Admin");
        }

        ImageEntity imageHost = imageDao.getImage(imageUuid);

        if(imageHost == null){
            throw new ImageNotFoundException("IMG-001","Image with Uuid not found");
        }
        return imageHost;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ImageEntity updateImage(final ImageEntity imageEntity, final String authorization) throws ImageNotFoundException, UnauthorizedException, UserNotSignedInException {
        UserAuthTokenEntity userAuthTokenEntity = imageDao.getUserAuthToken(authorization);

        if(userAuthTokenEntity == null){
            throw new UserNotSignedInException("USR-001", "You are not signed in, firstly sign in  to fetch the details of the Image");
        }

        String role = userAuthTokenEntity.getUser().getRole();

        if(!role.equals("Admin")){
            throw new UnauthorizedException("ATH-001","UNAUTHORIZED Access, The user is not an Admin");
        }

        ImageEntity UpdateImage = imageDao.getImageById(imageEntity.getId());

        if(UpdateImage ==null){
            throw new ImageNotFoundException("IMG-002","Image with Id not found");
        }


        UpdateImage.setImage(imageEntity.getImage());
        UpdateImage.setName(imageEntity.getName());
        UpdateImage.setDescription(imageEntity.getDescription());
        UpdateImage.setStatus(imageEntity.getStatus());
        imageDao.updateImage(UpdateImage);
        return  UpdateImage;

    }
}
