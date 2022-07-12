package com.matheussilvestre.storage_manager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheussilvestre.storage_manager.domain.Storage;

@Repository
public interface StorageRepository extends MongoRepository<Storage, String>{

}
