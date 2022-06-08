package com.pragma.api.image.domain.ports;

import com.pragma.api.image.domain.model.Image;

import java.util.List;
import java.util.Optional;

public interface IImageOutputPort {

    List<Image> findAll();
    Optional<Image> findFirstByIdTypeAndIdNumber(String idType, Long idNumber);
    void deleteByImageId(Long imageId);

    void save(Image image);

    Optional<Image> findImageByIdTypeAndIdNumber(String idType, Long idNumber);

    void deleteImageByIdTypeAndIdNumber(String idType, Long idNumber);
}
