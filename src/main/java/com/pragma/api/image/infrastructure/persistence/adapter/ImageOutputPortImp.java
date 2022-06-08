package com.pragma.api.image.infrastructure.persistence.adapter;

import com.pragma.api.image.domain.model.Image;
import com.pragma.api.image.domain.ports.IImageOutputPort;
import com.pragma.api.image.infrastructure.entity.ImageEntity;
import com.pragma.api.image.infrastructure.mapper.ImageEntityMapper;
import com.pragma.api.image.infrastructure.persistence.dao.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ImageOutputPortImp implements IImageOutputPort {

    private final ImageRepository imageRepository;
    private final ImageEntityMapper imageEntityMapper;

    @Override
    public List<Image> findAll() {
        return imageEntityMapper.toModels(imageRepository.findAll());
    }

    @Override
    public Optional<Image> findFirstByIdTypeAndIdNumber(String idType, Long idNumber) {
        Optional<ImageEntity> optionalImageEntity = imageRepository.findFirstByIdTypeAndIdNumber(idType,idNumber);
        return optionalImageEntity.map(imageEntityMapper::toModel);
    }

    @Override
    public void deleteByImageId(Long imageId) {
        imageRepository.deleteImageById(imageId);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(imageEntityMapper.toEntity(image));
    }

    @Override
    public Optional<Image> findImageByIdTypeAndIdNumber(String idType, Long idNumber) {
        return Optional.empty();
    }

    @Override
    public void deleteImageByIdTypeAndIdNumber(String idType, Long idNumber) {

    }
}
