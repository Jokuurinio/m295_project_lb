package ch.wiss.m295.lb_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch.wiss.m295.lb_project.model.Character;

public class CharacterTest {

        public void testSetCharacterName(){

        // ARRANGE
        String name = "test";
        Character c = new Character();

        // ACT
        c.setName(name);

        // ASSERT
        assertEquals(name, c.getName());
    }
    
}
