package com.pragma.api.image.application.dtos;

import lombok.*;

@Data
public class ImageDto {
    private String idType;
    private Long idNumber;
    private String imageB64;
}
