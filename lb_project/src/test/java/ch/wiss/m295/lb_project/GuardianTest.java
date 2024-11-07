package ch.wiss.m295.lb_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch.wiss.m295.lb_project.model.Guardian;

public class GuardianTest {

        public void testSetGuardianName(){

        // ARRANGE
        String name = "test";
        Guardian g = new Guardian();

        // ACT
        g.setName(name);

        // ASSERT
        assertEquals(name, g.getName());
    }
    
}
