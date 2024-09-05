package org.backend.ridinglessons;

import lombok.RequiredArgsConstructor;
import org.backend.horses.HorseRepository;
import org.backend.ridinglesson.Ridinglesson;
import org.backend.ridinglesson.RidinglessonRepo;
import org.backend.ridinglesson.RidinglessonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Set;

import static org.backend.ridinglesson.RidinglessonStatus.TO_CREATE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class RidinglessonControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    RidinglessonRepo ridinglessonRepo;
    @DirtiesContext
    @Test
    void getAllRidinglessons() throws Exception {
        //Given
        //When
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ridinglessons"))
                //Then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                            []
                        """));
    }



    @Test
    @DirtiesContext
    void postRidinglesson() throws Exception {
        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/api/ridinglessons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                             {
                                                  "ridinginstructor": "Dani",
                                                  "ridingtype": "Dressage",
                                                  "horse": "Lui",
                                                  "Date": "23.05.2025",
                                                  "Time": "15:00",
                                                  "status": "TO_CREATE"
                                             }
                                            """)
        );
        //Then
        List<Ridinglesson> allRidinglessons = ridinglessonRepo.findAll();
        Assertions.assertTrue(allRidinglessons.contains(new Ridinglesson(allRidinglessons.get(0).id(), "Dani",
                "Dressage", "Lui", "23.05.2025",
                "15:00", TO_CREATE)
                )
        );
    }
}
