package com.dorm.backend.shared.mappper.picture;

import com.dorm.backend.shared.data.entities.Picture;
import com.dorm.backend.profile.dto.ProfilePictureDTO;
import com.dorm.backend.shared.services.PictureService;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.Base64;

public class ProfilePictureDTOConverter implements Converter<ProfilePictureDTO, Picture> {

    @Override
    public Picture convert(MappingContext<ProfilePictureDTO, Picture> context) {
        Picture picture = new Picture();
        picture.setPictureName(context.getSource().getName());
        picture.setUrl(PictureService.produceHashPictureDirectoryFilename(context.getSource().getName()));
        picture.setPicture(Base64.getMimeDecoder().decode(context.getSource().getBase64String().split(";base64,")[1]));
        return picture;
    }
}
