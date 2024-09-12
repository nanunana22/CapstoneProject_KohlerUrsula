package org.backend.ridinglesson;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@With
@RequiredArgsConstructor
@Service
public class RidinglessonService {
    private final RidinglessonRepo ridinglessonRepo;

    public void deleteById(String id) {
        ridinglessonRepo.deleteById(id);
    }

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
        List<Ridinglesson> counthorses = ridinglessonRepo.findAll();
        int counter = 0;
                for (Ridinglesson element: counthorses){
                    if (element.horse().equals(ridinglesson.horse()) && element.date().equals(ridinglesson.date())){
                        counter = counter + 1;
                        if (counter == 2){
                            throw new IllegalArgumentException("booking is not possible as the horse has reached the maximum daily contigent");
                        }
                    }
                }
        return ridinglessonRepo.save(ridinglesson);
    }

    public Ridinglesson updateLesson(RidinglessonDTO update, String id){
        Ridinglesson ridinglesson = ridinglessonRepo.findById(id).orElseThrow(() -> new NoSuchElementException
                ("No Ridinglesson with id: " + id + " found!"))
                .withRidinginstructor(update.ridinginstructor())
                .withRidingtype(update.ridingtype())
                .withHorse(update.horse())
                .withDate(update.date())
                .withTime(update.time())
                .withStatus(update.status());
        return ridinglessonRepo.save(ridinglesson);
    }
}
