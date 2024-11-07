package ch.wiss.m295.lb_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch.wiss.m295.lb_project.model.Dungeon;

public class DungeonTest {

        public void testSetRaidName(){

        // ARRANGE
        String name = "test";
        Dungeon d = new Dungeon();

        // ACT
        d.setName(name);

        // ASSERT
        assertEquals(name, d.getName());
    }
    
}
