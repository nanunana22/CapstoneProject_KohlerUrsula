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
        List<Ridinglesson> ridinglessons = ridinglessonService.findAllLessons();
        return ridinglessons;
    }

    @GetMapping("/{id}")
    public Ridinglesson getRidinglessonById(@PathVariable String id) {
        return ridinglessonService.findRidinglessonById(id);
    }

    @PostMapping
    public Ridinglesson postRidinglesson(@RequestBody RidinglessonDTO newRidinglesson) {
        Ridinglesson saved = ridinglessonService.save(newRidinglesson);
        return saved;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        ridinglessonService.deleteById(id);
    }

    @PutMapping(path = { "{id}"})
    public Ridinglesson update(@PathVariable String id, @RequestBody RidinglessonDTO ridinglessonDTO) {
        return ridinglessonService.updateLesson(ridinglessonDTO, id);
    }
}
