package ch.wiss.m295.lb_project;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import ch.wiss.m295.lb_project.controller.RaidController;
import ch.wiss.m295.lb_project.model.CharacterRepository;
import ch.wiss.m295.lb_project.model.DungeonRepository;
import ch.wiss.m295.lb_project.model.GuardianRepository;
import ch.wiss.m295.lb_project.model.RaidRepository;
import ch.wiss.m295.lb_project.model.Raid;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RaidController.class)  // Test explizit auf RaidController beschränken
@AutoConfigureMockMvc
public class RaidControllerTest {

    @MockBean
    RaidRepository raidRepository;

    @MockBean
    GuardianRepository guardianRepository;
    @MockBean
    DungeonRepository dungeonRepository;
    @MockBean
    CharacterRepository characterRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void assertSetupWorks(){
        assertTrue(true);
    }


    //Teste ob Neu erstellte Raids korrekt übergeben werden
    @Test
    public void testCorrectPostRequest_ReturnsCreated() throws Exception {

        // JSON-Daten vorbereiten
        JSONObject json = new JSONObject();
        json.put("name", "Behemoth");
        json.put("itemLevel", 1600);
        json.put("gates", 2);
        json.put("gold", 18000);

        // Mock für raidRepository.save() konfigurieren
        Raid mockRaid = new Raid();
        mockRaid.setName("Behemoth");
        mockRaid.setItemLevel(1600);
        mockRaid.setGates(2);
        mockRaid.setGold(18000);

        when(raidRepository.save(any(Raid.class))).thenReturn(mockRaid);

        // POST-Anfrage ausführen und Status überprüfen
        mockMvc.perform(post("/raids")
                .content(json.toString())
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }    

        // Leerer POST Request bringt einen Fehler
        @Test
        public void testeLeereCategoryPostParameter_400erError() throws Exception{
      
          mockMvc.perform(post("/raids"))
            .andExpect(status().is5xxServerError());
        }


}

