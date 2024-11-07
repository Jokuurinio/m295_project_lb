package ch.wiss.m295.lb_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.wiss.m295.lb_project.model.RaidRepository;
import ch.wiss.m295.lb_project.model.Raid;

@RestController
@RequestMapping(path = "/raids")
public class RaidController {

    @Autowired
    private RaidRepository raidRepository;

    @GetMapping
    public List<Raid> getAllRaids() {
        return (List<Raid>) raidRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Raid> createRaid(@RequestBody Raid raid) {
        Raid savedRaid = raidRepository.save(raid);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRaid);
    }

    @GetMapping(path = "/{id}")
    public Raid getRaidById(@PathVariable Long id) {
        return raidRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public Raid updateRaid(@PathVariable Long id, @RequestBody Raid raidDetails) {
        Raid raid = raidRepository.findById(id).orElse(null);
        if (raid != null) {
            raid.setName(raidDetails.getName());
            raid.setItemLevel(raidDetails.getItemLevel());
            raid.setGates(raidDetails.getGates());
            raid.setGold(raidDetails.getGold());
            return raidRepository.save(raid);
        }
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteRaid(@PathVariable Long id) {
        raidRepository.deleteById(id);
    }
}
