package com.PfaGroup5.ZLearning.repository;

import com.PfaGroup5.ZLearning.model.Certif;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CertifRepo extends MongoRepository<Certif,String> {
    @Query("{'name': ?0}")
    Optional<Certif> findByName(String name);

}
