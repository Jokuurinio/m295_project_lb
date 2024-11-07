package ch.wiss.m295.lb_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ch.wiss.m295.lb_project.model.Raid;

public class RaidTest {

    @Test
    public void testSetRaidName(){

        // ARRANGE
        String name = "test";
        Raid r = new Raid();

        // ACT
        r.setName(name);

        // ASSERT
        assertEquals(name, r.getName());
    }
}
