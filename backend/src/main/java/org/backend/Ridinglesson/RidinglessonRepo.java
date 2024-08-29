package org.backend.Ridinglesson;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RidinglessonRepo extends MongoRepository<Ridinglesson, String> {
}
