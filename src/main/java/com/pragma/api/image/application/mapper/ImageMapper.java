package com.pragma.api.image.application.mapper;

import com.pragma.api.image.application.dtos.ImageDto;
import com.pragma.api.image.domain.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    Image toModel(ImageDto dto);

    ImageDto toDto(Image model);

    List<ImageDto> toDtos(List<Image> models);

}
