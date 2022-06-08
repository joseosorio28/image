package com.pragma.api.image.infrastructure.mapper;

import com.pragma.api.image.domain.model.Image;
import com.pragma.api.image.infrastructure.entity.ImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface ImageEntityMapper {

    ImageEntityMapper INSTANCE = Mappers.getMapper(ImageEntityMapper.class);
    Image toModel(ImageEntity imageEntity);
    ImageEntity toEntity(Image image);
    List<ImageEntity> toEntities(List<Image> images);
    List<Image> toModels(List<ImageEntity> imageEntities);

}
