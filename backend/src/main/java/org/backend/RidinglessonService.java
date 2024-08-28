package org.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RidinglessonService {
    private final RidinglessonRepository ridinglessonRepository;

    public List<Horses> findAllHorses(){
        return ridinglessonRepository.findAll();
    }
}
