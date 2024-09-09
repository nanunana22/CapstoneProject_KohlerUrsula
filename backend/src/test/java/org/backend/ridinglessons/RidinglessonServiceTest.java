package org.backend.ridinglessons;

import org.backend.ridinglesson.*;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.backend.ridinglesson.RidinglessonStatus.TO_BOOK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RidinglessonServiceTest {
    RidinglessonRepo ridinglessonRepo = mock(RidinglessonRepo.class);
    RidinglessonService ridinglessonService = new RidinglessonService(ridinglessonRepo);

    @Test
    void findAllLessons(){
        //Given
        Ridinglesson ridinglesson1 = new Ridinglesson("1", "Kenzie", "Libertydressage", "Lui", "02.03.2024","15:00", RidinglessonStatus.TO_CREATE);
        Ridinglesson ridinglesson2 = new Ridinglesson("2", "Jessy", "Dressage", "Dalera", "03.03.2024","15:00", RidinglessonStatus.TO_CREATE);
        List<Ridinglesson> ridinglesson = List.of(ridinglesson1, ridinglesson2);

        when(ridinglessonRepo.findAll()).thenReturn(ridinglesson);
        //When
        List<Ridinglesson> actual = ridinglessonService.findAllLessons();
        //Then
        verify(ridinglessonRepo).findAll();
        assertEquals(ridinglesson, actual);
    }

    @Test
    void addNewRidingLesson(){
        //Given
        RidinglessonDTO ridinglessonDTO = new RidinglessonDTO( "ina", "dressage",
                "rivien", "02.03.2024","15:00", TO_BOOK);
        Ridinglesson ridinglesson = new Ridinglesson(null, "ina", "dressage",
                "rivien", "02.03.2024","15:00", TO_BOOK);
        when(ridinglessonRepo.save(ridinglesson)).thenReturn(ridinglesson);
        //When
        Ridinglesson actual = ridinglessonService.save(ridinglessonDTO);
        //Then

        verify(ridinglessonRepo).save(ridinglesson);
        assertEquals(ridinglesson, actual);
    }

    @Test
    void deleteRidinglesson_Test() {
        doNothing().when(ridinglessonRepo).deleteById("2");
        ridinglessonService.deleteById("2");
        verify(ridinglessonRepo).deleteById("2");
    }

    @Test
    void getRidinglessonById() {
        //GIVEN
        String id = "4";
        Ridinglesson ridinglesson = new Ridinglesson("4", "ina", "dressage",
                "rivien", "02.03.2024","15:00", TO_BOOK);
        when(ridinglessonRepo.findById(id)).thenReturn(Optional.of(ridinglesson));
        //WHEN
        Ridinglesson actual = ridinglessonService.findRidinglessonById(id);
        //THEN
        verify(ridinglessonRepo).findById(id);
        assertEquals(ridinglesson, actual);
    }



}
