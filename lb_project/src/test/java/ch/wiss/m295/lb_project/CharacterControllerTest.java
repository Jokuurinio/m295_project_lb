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

import ch.wiss.m295.lb_project.controller.CharacterController;
import ch.wiss.m295.lb_project.model.Character;
import ch.wiss.m295.lb_project.model.CharacterRepository;
import ch.wiss.m295.lb_project.model.DungeonRepository;
import ch.wiss.m295.lb_project.model.GuardianRepository;
import ch.wiss.m295.lb_project.model.RaidRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CharacterController.class)  // Test explizit auf CharacterController beschränken
@AutoConfigureMockMvc
public class CharacterControllerTest {

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

    // Testet, ob ein neu erstellter Character korrekt übergeben wird
    @Test
    public void testCorrectPostRequest_ReturnsCreated() throws Exception {

        // JSON-Daten vorbereiten
        JSONObject json = new JSONObject();
        json.put("name", "Assassin");
        json.put("itemLevel", 1680);
        json.put("characterClass", "SoulEater");

        // Mock für characterRepository.save() konfigurieren
        Character mockCharacter = new Character();
        mockCharacter.setName("Assassin");
        mockCharacter.setItemLevel(1680);
        mockCharacter.setCharacterClass("SoulEater");

        when(characterRepository.save(any(Character.class))).thenReturn(mockCharacter);

        // POST-Anfrage ausführen und Status überprüfen
        mockMvc.perform(post("/characters")  // korrigierter Pfad
                .content(json.toString())
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    } 
    
    
    // Leerer POST Request bringt einen Fehler
    @Test
  public void testeLeereCategoryPostParameter_400erError() throws Exception{

    mockMvc.perform(post("/characters"))
      .andExpect(status().is5xxServerError());
  }

}
