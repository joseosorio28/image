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

@RequestMapping("/default")
public interface IImageController {

    @GetMapping("/images")
    ResponseEntity<List<ImageDto>> listAllImages();

    @GetMapping("image")
    ResponseEntity<ImageDto> getImage(
            @RequestParam(name = "idType") String idType,
            @RequestParam(name = "idNumber") Long idNumber);

    @PostMapping
    ResponseEntity<ImageDto> registerImage(@Valid @RequestBody ImageDto image);

    @PutMapping
    ResponseEntity<ImageDto> updateImage(@Valid @RequestBody ImageDto image);

    @DeleteMapping("image")
    ResponseEntity<String> deleteImage(
            @RequestParam(name = "idType") String idType,
            @RequestParam(name = "idNumber") Long idNumber);
}
