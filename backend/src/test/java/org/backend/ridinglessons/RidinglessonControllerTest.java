package org.backend.ridinglessons;

import org.backend.ridinglesson.Ridinglesson;
import org.backend.ridinglesson.RidinglessonRepo;
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
import static org.backend.ridinglesson.RidinglessonStatus.TO_CREATE;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oidcLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        //Given
        Ridinglesson newLesson = new Ridinglesson("2", "ina", "dressage", "lui", "2.3.23",
                "15:00", TO_CREATE);
        ridinglessonRepo.save(newLesson);
        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/api/ridinglessons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                             {"id": "2",
                                              "ridingintructor": "ina",
                                              "ridingtype": "dressage",
                                              "horse": "lui",
                                              "date": "2.3.23",
                                              "time": "15:00",
                                               "status": "TO_CREATE"
                                                 
                                                  
                                             }
                                            """)
        );
        //Then
        List<Ridinglesson> allRidinglessons = ridinglessonRepo.findAll();
        Assertions.assertTrue(allRidinglessons.contains(new Ridinglesson(allRidinglessons.get(0).id(), "ina",
                "dressage", "lui", "2.3.23",
                "15:00", TO_CREATE)
                )
        );
    }
    @Test
    void deletebyid() throws Exception {
        //Given
        ridinglessonRepo.save(new Ridinglesson("2", "ina", "dressage", "lui", "2.3.23",
                "15:00", TO_CREATE));
        //When
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/ridinglessons/2")
                        .with(oidcLogin().userInfoToken(token -> token.claim("login", "github-username"))))
                //Then
                .andExpect(status().isOk());





    }

    @Test
    @DirtiesContext

    void getRidinglessonById() throws Exception {
        //GIVEN
        Ridinglesson newLesson = new Ridinglesson("3", "ina", "dressage", "lui", "2.3.23",
                "15:00", TO_CREATE);
        ridinglessonRepo.save(newLesson);
        //WHEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ridinglessons/3"))
                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                         "id": "3",
                         "ridinginstructor": "ina",
                         "ridingtype": "dressage",
                         "horse": "lui",
                         "date": "2.3.23",
                         "time": "15:00",
                         "status": "TO_CREATE"
     
                        }
                          """));

    }

    @DirtiesContext
    @Test
    void updateLesson_Test_When_IdMatches() throws Exception {
        // GIVEN
        ridinglessonRepo.save(new Ridinglesson("1", "dani", "dressage", "lui",
                "2.3.23", "15:00", TO_CREATE));

        // WHEN
        mockMvc.perform(put("/api/ridinglessons/1")
                        .contentType("application/json")
                        .content("""
                                {
                                    "id": "1",
                                   "ridinginstructor": "dani",
                                   "ridingtype": "jumping",
                                   "horse": "lui",
                                   "date": "2.3.23",
                                   "time": "15:00",
                                   "status": "TO_CREATE"
                                }
                                """))
                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        { "id": "1",
                                   "ridinginstructor": "dani",
                                   "ridingtype": "jumping",
                                   "horse": "lui",
                                   "date": "2.3.23",
                                   "time": "15:00",
                                   "status": "TO_CREATE"
                        }
                        """));
    }

}
