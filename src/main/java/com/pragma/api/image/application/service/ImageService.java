package com.pragma.api.image.application.service;

import com.pragma.api.image.application.dtos.ImageDto;
import com.pragma.api.image.application.mapper.ImageMapper;
import com.pragma.api.image.domain.usecase.ImageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageUseCase imageUseCase;
    private final ImageMapper imageMapper;

    public List<ImageDto> getImages(){
        return imageMapper.toDtos(imageUseCase.getImages());
    }

    public ImageDto searchImage(String idType, Long idNumber){
        return imageMapper.toDto(imageUseCase.searchImage(idType,idNumber));
    }

    @Transactional
    public void addImage(ImageDto imageDto) {
        imageUseCase.addImage(imageMapper.toModel(imageDto));
    }

    @Transactional
    public void updateImage(ImageDto imageDto){
        imageUseCase.updateImage(imageMapper.toModel(imageDto));
    }

    @Transactional
    public void deleteImage(String idType, Long idNumber){
        imageUseCase.deleteImage(idType,idNumber);
    }

}
