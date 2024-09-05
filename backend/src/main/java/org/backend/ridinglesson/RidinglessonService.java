package org.backend.ridinglesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class RidinglessonService {
    private final RidinglessonRepo ridinglessonRepo;

    public List<Ridinglesson> findAllLessons() {
        return ridinglessonRepo.findAll();
    }
    public Ridinglesson findRidinglessonById(String id) {
        return ridinglessonRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ridinglesson with id: " + id + " not found!"));
    }

    public Ridinglesson save(RidinglessonDTO newRidinglesson){
        Ridinglesson ridinglesson = new Ridinglesson(null,
                newRidinglesson.ridinginstructor(), newRidinglesson.ridingtype(), newRidinglesson.horse(), newRidinglesson.date(),
                newRidinglesson.time(), newRidinglesson.status());
        return ridinglessonRepo.save(ridinglesson);
    }
}
