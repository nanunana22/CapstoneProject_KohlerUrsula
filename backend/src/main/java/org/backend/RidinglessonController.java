package org.backend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ridinglesson")

public class RidinglessonController {
    private final RidinglessonService ridinglessonService;

    @GetMapping
    public List<Horses> getAllHorses() {
        return ridinglessonService.findAllHorses();
    }
}
