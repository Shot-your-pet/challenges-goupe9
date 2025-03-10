package fr.miage.syp.chellengesgroupe9.controleur;

import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;
import fr.miage.syp.chellengesgroupe9.services.FacadeChallenge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challenges")

public class Controleur {

    private final FacadeChallenge facadeChallenge;

    public Controleur(FacadeChallenge facadeChallenge) {
        this.facadeChallenge = facadeChallenge;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getChallengeById(@PathVariable("id") int id) {
        return ResponseEntity.ok("Challenge " + id);
    }

    @PostMapping("/creationChallenge")
    public ResponseEntity<String> createChallenge(@RequestBody CreerChallengeDTO creerChallengeDTO) {
        this.facadeChallenge.creerChallenge(creerChallengeDTO);
        return ResponseEntity.ok().build();
    }


}
