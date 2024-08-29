package org.backend.ridinglesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RidinglessonService {
    private final RidinglessonRepo ridinglessonRepo;

    public List<Ridinglesson> findAllLessons() {
        return ridinglessonRepo.findAll();
    }
}
