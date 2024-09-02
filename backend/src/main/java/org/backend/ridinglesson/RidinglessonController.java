package org.backend.ridinglesson;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ridinglessons")

public class RidinglessonController {
    private final RidinglessonService ridinglessonService;
    private final RidinglessonRepo ridinglessonRepo;

    @GetMapping
    public List<Ridinglesson> getAllLessons() {
        return ridinglessonService.findAllLessons();
    }

    @GetMapping("id")
    public Ridinglesson getRidinglessonById(@PathVariable String id) {
        return ridinglessonService.findRidinglessonById(id);
    }

    @PostMapping
    public Ridinglesson postRidinglesson(@RequestBody NewRidinglesson newRidinglesson) {
        Ridinglesson ridinglesson = new Ridinglesson(UUID.randomUUID().toString(),
                newRidinglesson.ridinginstructor(), newRidinglesson.ridingtype(),
                newRidinglesson.horse(), newRidinglesson.Date(), newRidinglesson.Time());
        return ridinglessonRepo.save(ridinglesson);
    }
}
