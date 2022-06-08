package com.pragma.api.image.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Document(collection = "images")
public class ImageEntity {

    @Id
    private String id;

    @ToString.Include
    @Field(name = "imageB64")
    private String imageB64;

    @ToString.Include
    @Field(name = "idType")
    private String idType;

    @ToString.Include
    @Field(name = "idNumber")
    private Long idNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageEntity image = (ImageEntity) o;

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
