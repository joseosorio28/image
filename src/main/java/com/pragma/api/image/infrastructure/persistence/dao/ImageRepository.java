package com.pragma.api.image.infrastructure.persistence.dao;

import com.pragma.api.image.infrastructure.entity.ImageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends MongoRepository<ImageEntity, String> {

    Optional<ImageEntity> findByIdTypeAndIdNumber(String idType, Long idNumber);

    List<ImageEntity> findAll();

    void deleteImageByIdTypeAndIdNumber(String idType, Long idNumber);

    Optional<ImageEntity> findFirstByIdTypeAndIdNumber(String idType, Long idNumber);

    void deleteImageById(Long imageId);
}