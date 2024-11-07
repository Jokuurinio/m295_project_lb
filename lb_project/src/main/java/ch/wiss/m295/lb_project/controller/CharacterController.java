package ch.wiss.m295.lb_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Iterable<Character>> getAllCharacters() {
        Iterable<Character> character = null;
		character = characterRepository.findAll();
		return ResponseEntity.ok(character);
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
                Character savedCharacter = characterRepository.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        return characterRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character characterDetails) {
        return characterRepository.findById(id)
            .map(character -> {
                character.setName(characterDetails.getName());
                character.setItemLevel(characterDetails.getItemLevel());
                character.setCharacterClass(characterDetails.getCharacterClass());
                character.setRaid(characterDetails.getRaid());
                character.setDungeon(characterDetails.getDungeon());
                character.setGuardian(characterDetails.getGuardian());
                characterRepository.save(character);
                return ResponseEntity.ok(character);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterRepository.deleteById(id);
    }
}