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
import static org.springframework.test.util.AssertionErrors.assertNotNull;

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

    @Test
    void testUpdateRidinglesson_Success(){
        //Given
        String id = "4";

        Ridinglesson existingRidinglesson = new Ridinglesson(id, "Ina", "Dressage", "Asmano",
                "2.10.24", "12:00",TO_BOOK);
        RidinglessonDTO ridinglessonDTO = new RidinglessonDTO("Lena", "Dressage", "Asmano",
                "2.10.24", "12:00", TO_BOOK);
        Ridinglesson updateRidinglesson = new Ridinglesson("1", "Lena", "Dressage", "Asmano",
                "2.10.24", "12:00",TO_BOOK);

        //When
        when(ridinglessonRepo.findById(id)).thenReturn(Optional.of(existingRidinglesson));
        when(ridinglessonRepo.save(updateRidinglesson)).thenReturn(updateRidinglesson);

        Ridinglesson result = ridinglessonService.updateLesson(ridinglessonDTO, id);
        //Then
        //assertNotNull(result);
        assertEquals(ridinglessonDTO, result);
        verify(ridinglessonRepo).findById(id);
        verify(ridinglessonRepo).save(updateRidinglesson);
    }






}
