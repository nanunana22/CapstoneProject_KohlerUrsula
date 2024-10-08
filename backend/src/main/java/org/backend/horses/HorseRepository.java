package org.backend.horses;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepository extends MongoRepository<Horse, String> {
}
