package com.pragma.api.image.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private String id;
    private String imageB64;
    private String idType;
    private Long idNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (!imageB64.equals(image.imageB64)) return false;
        if (!idType.equals(image.idType)) return false;
        return idNumber.equals(image.idNumber);
    }

    @Override
    public int hashCode() {
        int result = imageB64.hashCode();
        result = 31 * result + idType.hashCode();
        result = 31 * result + idNumber.hashCode();
        return result;
    }
}
