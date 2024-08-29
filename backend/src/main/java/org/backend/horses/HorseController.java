package org.backend.horses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/horses")

public class HorseController {
    private final HorseService horseService;

    @GetMapping
    public List<Horse> getAllHorses() {
        return horseService.findAllHorses();
    }
}
