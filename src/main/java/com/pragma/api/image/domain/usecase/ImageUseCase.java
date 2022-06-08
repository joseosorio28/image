package com.pragma.api.image.domain.usecase;

import com.pragma.api.image.domain.model.Image;
import com.pragma.api.image.domain.ports.IImageInputPort;
import com.pragma.api.image.domain.ports.IImageOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ImageUseCase implements IImageInputPort{

    private final IImageOutputPort imageOutputPort;

    @Override
    public List<Image> getImages() {
        return this.imageOutputPort.findAll();
    }

    @Override
    public Image searchImage(String idType,Long idNumber) {
        return imageOutputPort.findFirstByIdTypeAndIdNumber(idType,idNumber)
                .orElseThrow(()->new IllegalStateException("Client image not present in DB"));
    }

    @Override
    public void addImage(Image image) {
        Optional<Image> imageByClientId = imageOutputPort.findImageByIdTypeAndIdNumber(image.getIdType(),image.getIdNumber());

        if (imageByClientId.isPresent()) {
            throw new IllegalStateException("Client image already in DB");
        }
        imageOutputPort.save(image);
    }

    @Override
    public void updateImage(Image image) {
        imageOutputPort.save(image);
    }

    @Override
    public void deleteImage(String idType,Long idNumber) {
        Optional<Image> imageByClientId = imageOutputPort.findImageByIdTypeAndIdNumber(idType,idNumber);
        imageByClientId.ifPresent(image -> imageOutputPort.deleteImageByIdTypeAndIdNumber(idType,idNumber));
    }
}
