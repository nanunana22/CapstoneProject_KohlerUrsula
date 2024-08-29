package org.backend.ridinglessons;

import org.backend.horses.HorseRepository;
import org.backend.ridinglesson.RidinglessonRepo;
import org.backend.ridinglesson.RidinglessonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

}
