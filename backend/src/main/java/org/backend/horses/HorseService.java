package org.backend.horses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HorseService {
    private final HorseRepository horseRepository;

    public List<Horse> findAllHorses(){
        return horseRepository.findAll();
    }
}
