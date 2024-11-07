package ch.wiss.m295.lb_project.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import ch.wiss.m295.lb_project.model.Raid;
import ch.wiss.m295.lb_project.model.Dungeon;
import ch.wiss.m295.lb_project.model.Guardian;
import ch.wiss.m295.lb_project.model.RaidRepository;
import ch.wiss.m295.lb_project.model.DungeonRepository;
import ch.wiss.m295.lb_project.model.GuardianRepository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RaidRepository raidRepository;

    @Autowired
    private DungeonRepository dungeonRepository;

    @Autowired
    private GuardianRepository guardianRepository;

    @Override
    public void run(String... args) throws Exception {
        // JSON-Datei laden
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("data.json").getInputStream();
        Map<String, List<Map<String, Object>>> data = mapper.readValue(inputStream, new TypeReference<>() {});

        // Raids importieren, wenn die Tabelle leer ist
        if (raidRepository.count() == 0) {
            List<Map<String, Object>> raids = data.get("raids");
            raids.forEach(raidData -> {
                Raid raid = mapper.convertValue(raidData, Raid.class);
                raidRepository.save(raid);
            });
        }

        // Dungeons importieren, wenn die Tabelle leer ist
        if (dungeonRepository.count() == 0) {
            List<Map<String, Object>> dungeons = data.get("dungeons");
            dungeons.forEach(dungeonData -> {
                Dungeon dungeon = mapper.convertValue(dungeonData, Dungeon.class);
                dungeonRepository.save(dungeon);
            });
        }

        // Guardians importieren, wenn die Tabelle leer ist
        if (guardianRepository.count() == 0) {
            List<Map<String, Object>> guardians = data.get("guardians");
            guardians.forEach(guardianData -> {
                Guardian guardian = mapper.convertValue(guardianData, Guardian.class);
                guardianRepository.save(guardian);
            });
        }

        System.out.println("Daten erfolgreich geladen, wenn Tabellen leer waren!");
    }
}

