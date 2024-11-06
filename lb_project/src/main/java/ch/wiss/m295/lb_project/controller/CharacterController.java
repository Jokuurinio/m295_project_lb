package ch.wiss.m295.lb_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.wiss.m295.lb_project.model.CharacterRepository;
import ch.wiss.m295.lb_project.model.Character;

@RestController
@RequestMapping(path ="/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public List<Character> getAllCharacters() {
        return (List<Character>) characterRepository.findAll();
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody Character characterDetails) {
        Character character = characterRepository.findById(id).orElse(null);
        if (character != null) {
            character.setName(characterDetails.getName());
            character.setItemLevel(characterDetails.getItemLevel());
            character.setCharacterClass(characterDetails.getCharacterClass());
            character.setRaid(characterDetails.getRaid());
            character.setDungeon(characterDetails.getDungeon());
            character.setGuardian(characterDetails.getGuardian());
            return characterRepository.save(character);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }
}