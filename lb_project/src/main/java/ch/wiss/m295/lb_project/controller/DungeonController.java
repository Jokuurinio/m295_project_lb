package ch.wiss.m295.lb_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.wiss.m295.lb_project.model.DungeonRepository;
import ch.wiss.m295.lb_project.model.Dungeon;

@RestController
@RequestMapping(path ="/dungeons")
public class DungeonController {

    @Autowired
    private DungeonRepository dungeonRepository;

    @GetMapping
    public List<Dungeon> getAllDungeons() {
        return (List<Dungeon>) dungeonRepository.findAll();
    }

    @PostMapping
    public Dungeon createDungeon(@RequestBody Dungeon dungeon) {
        return dungeonRepository.save(dungeon);
    }

    @GetMapping("/{id}")
    public Dungeon getDungeonById(@PathVariable Long id) {
        return dungeonRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Dungeon updateDungeon(@PathVariable Long id, @RequestBody Dungeon dungeonDetails) {
        Dungeon dungeon = dungeonRepository.findById(id).orElse(null);
        if (dungeon != null) {
            dungeon.setName(dungeonDetails.getName());
            dungeon.setItemLevel(dungeonDetails.getItemLevel());
            return dungeonRepository.save(dungeon);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDungeon(@PathVariable Long id) {
        dungeonRepository.deleteById(id);
    }
}
