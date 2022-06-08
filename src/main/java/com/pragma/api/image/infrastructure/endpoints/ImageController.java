package com.pragma.api.image.infrastructure.endpoints;

import com.pragma.api.image.application.dtos.ImageDto;
import com.pragma.api.image.application.service.ImageService;
import com.pragma.api.image.domain.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1")
public class ImageController implements IImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public ResponseEntity<List<ImageDto>> listAllImages(){
        return new ResponseEntity<>(imageService.getImages(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ImageDto> getImage(
            @RequestParam(name = "idType") String idType,
            @RequestParam(name = "idNumber") Long idNumber){
        ImageDto imageDto = imageService.searchImage(idType,idNumber);
        return new ResponseEntity<>(imageDto, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<ImageDto> registerImage(@Valid @RequestBody ImageDto image) {
        imageService.addImage(image);
        return new ResponseEntity<>(image,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ImageDto> updateImage(@Valid @RequestBody ImageDto image) {
        imageService.updateImage(image);
        return new ResponseEntity<>(image,HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<String> deleteImage(
            @RequestParam(name = "idType") String idType,
            @RequestParam(name = "idNumber") Long idNumber){
        imageService.deleteImage(idType,idNumber);
        return new ResponseEntity<>("User image deleted",HttpStatus.ACCEPTED);
    }

}
