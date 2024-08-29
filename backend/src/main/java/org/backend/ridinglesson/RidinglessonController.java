package org.backend.ridinglesson;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
