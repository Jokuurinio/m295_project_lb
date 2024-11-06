package ch.wiss.m295.lb_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.wiss.m295.lb_project.model.GuardianRepository;
import ch.wiss.m295.lb_project.model.Guardian;

@RestController
@RequestMapping(path = "/guardians")
public class GuardianController {

    @Autowired
    private GuardianRepository guardianRepository;

    @GetMapping
    public List<Guardian> getAllGuardians() {
        return (List<Guardian>) guardianRepository.findAll();
    }

    @PostMapping
    public Guardian createGuardian(@RequestBody Guardian guardian) {
        return guardianRepository.save(guardian);
    }

    @GetMapping("/{id}")
    public Guardian getGuardianById(@PathVariable Long id) {
        return guardianRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Guardian updateGuardian(@PathVariable Long id, @RequestBody Guardian guardianDetails) {
        Guardian guardian = guardianRepository.findById(id).orElse(null);
        if (guardian != null) {
            guardian.setName(guardianDetails.getName());
            guardian.setItemLevel(guardianDetails.getItemLevel());
            return guardianRepository.save(guardian);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteGuardian(@PathVariable Long id) {
        guardianRepository.deleteById(id);
    }
}
