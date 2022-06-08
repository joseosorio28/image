package com.pragma.api.image.domain.ports;

import com.pragma.api.image.domain.model.Image;

import java.util.List;

public interface IImageInputPort {
    List<Image> getImages();
    Image searchImage(String idType, Long idNumber);
    void addImage(Image image);
    void updateImage(Image image);
    void deleteImage(String idType, Long idNumber);
}
