package org.backend.horses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HorseServiceTest {
    HorseRepository horseRepository = mock(HorseRepository.class);
    HorseService horseService = new HorseService(horseRepository);

    @Test
    void findAllHorses(){
        //Given
        Horse horse1 = new Horse("1", "Lui");
        Horse horse2 = new Horse("2", "Quini");
        List<Horse> horse = List.of(horse1, horse2);

        when(horseRepository.findAll()).thenReturn(horse);
        //When
        List<Horse> actual = horseService.findAllHorses();
        //Then
        verify(horseRepository).findAll();
        assertEquals(horse, actual);
    }
}
