package org.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RidinglessonRepository extends MongoRepository<Horses, String> {
}
