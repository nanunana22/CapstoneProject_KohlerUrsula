package org.backend.Ridinglesson;

import lombok.RequiredArgsConstructor;
import org.backend.horses.Horse;
import org.backend.horses.HorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
