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
    public List<RidinglessonDTO> getAllLessons() {
        List<Ridinglesson> ridinglessons = ridinglessonService.findAllLessons();
        return ridinglessons.stream()
                .map(ridinglesson -> new RidinglessonDTO(ridinglesson.ridinginstructor(), ridinglesson.ridingtype(), ridinglesson.horse(),
                        ridinglesson.date(), ridinglesson.time(), ridinglesson.status()))
                .toList();
    }

    @GetMapping("id")
    public Ridinglesson getRidinglessonById(@PathVariable String id) {
        return ridinglessonService.findRidinglessonById(id);
    }

    @PostMapping
    public RidinglessonDTO postRidinglesson(@RequestBody RidinglessonDTO newRidinglesson) {
        Ridinglesson saved = ridinglessonService.save(newRidinglesson);
        return new RidinglessonDTO(saved.ridinginstructor(), saved.ridingtype(),
                saved.horse(), saved.date(), saved.time(), saved.status());
    }
}
