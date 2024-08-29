package org.backend.ridinglessons;

import org.backend.ridinglesson.Ridinglesson;
import org.backend.ridinglesson.RidinglessonRepo;
import org.backend.ridinglesson.RidinglessonService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RidinglessonServiceTest {
    RidinglessonRepo ridinglessonRepo = mock(RidinglessonRepo.class);
    RidinglessonService ridinglessonService = new RidinglessonService(ridinglessonRepo);

    @Test
    void findAllLessons(){
        //Given
        Ridinglesson ridinglesson1 = new Ridinglesson("1", "Kenzie", "Libertydressage", "Lui", "02.03.2024","15:00");
        Ridinglesson ridinglesson2 = new Ridinglesson("2", "Jessy", "Dressage", "Dalera", "03.03.2024","15:00");
        List<Ridinglesson> ridinglesson = List.of(ridinglesson1, ridinglesson2);

        when(ridinglessonRepo.findAll()).thenReturn(ridinglesson);
        //When
        List<Ridinglesson> actual = ridinglessonService.findAllLessons();
        //Then
        verify(ridinglessonRepo).findAll();
        assertEquals(ridinglesson, actual);
    }
}
