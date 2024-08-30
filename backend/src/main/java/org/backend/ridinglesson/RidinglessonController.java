package org.backend.ridinglesson;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ridinglessons")

public class RidinglessonController {
    private final RidinglessonService ridinglessonService;

    @GetMapping
    public List<Ridinglesson> getAllLessons() {
        return ridinglessonService.findAllLessons();
    }

    @GetMapping("id")
    public Ridinglesson getRidinglessonById(@PathVariable String id) {
        return ridinglessonService.findRidinglessonById(id);
    }
}
