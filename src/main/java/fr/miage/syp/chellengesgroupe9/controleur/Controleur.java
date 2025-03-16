package fr.miage.syp.chellengesgroupe9.controleur;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.ChallengeHistorique;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDuJourDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ModifierChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.exceptions.ChallengeDejaSortiException;
import fr.miage.syp.chellengesgroupe9.modele.exceptions.ChallengeInexistantException;
import fr.miage.syp.chellengesgroupe9.services.FacadeChallenge;
import fr.miage.syp.chellengesgroupe9.services.FacadeChallengeHistorique;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/challenges")

public class Controleur {
    public record ReponseAPI<T>(int code, String message, T contenu) {
    }

    private final FacadeChallenge facadeChallenge;
    private final FacadeChallengeHistorique facadeChallengeHistorique;

    public Controleur(FacadeChallenge facadeChallenge, FacadeChallengeHistorique facadeChallengeHistorique) {
        this.facadeChallenge = facadeChallenge;
        this.facadeChallengeHistorique = facadeChallengeHistorique;
    }

    @GetMapping("")
    public ResponseEntity<ReponseAPI<List<ChallengeDTO>>> getChallengeById() {
        List<ChallengeDTO> listeChallenges = this.facadeChallenge.consulterChallenges();
        return ResponseEntity.ok(new ReponseAPI<>(200, "challenges récupérés", listeChallenges));
    }

    @GetMapping("/today")
    public ResponseEntity<ReponseAPI<ChallengeDuJourDTO>> getChallengeDuJour() {
        ChallengeDuJourDTO challengeDuJour = this.facadeChallengeHistorique.getChallengeDuJour();
        return ResponseEntity.ok(new ReponseAPI<>(200, "challenge du jour récupéré", challengeDuJour));
    }

    @PostMapping("")
    public ResponseEntity<ReponseAPI<ChallengeDTO>> createChallenge(@RequestBody CreerChallengeDTO creerChallengeDTO) throws URISyntaxException {
        ChallengeDTO challengeDTOcree = this.facadeChallenge.creerChallenge(creerChallengeDTO);
        return ResponseEntity.created(new URI("cacahuete")).body(new ReponseAPI<>(201, "bravo c'est crée", challengeDTOcree));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReponseAPI<Void>> deleteChallenge(@PathVariable("id") UUID id) throws ChallengeInexistantException {
        this.facadeChallenge.supprimerChallenge(id);
        return ResponseEntity.ok(new ReponseAPI<>(200, "challenge supprimé", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReponseAPI<ChallengeDTO>> updateChallenge(@PathVariable("id") UUID id, @RequestBody ModifierChallengeDTO modifierChallengeDTO) throws ChallengeInexistantException, ChallengeDejaSortiException {
        ChallengeDTO challengeDTOmodifie = this.facadeChallenge.modifierChallenge(modifierChallengeDTO, id);
        return ResponseEntity.ok(new ReponseAPI<>(200, "challenge modifié", challengeDTOmodifie));
    }

    @PostMapping("/historique")
    public ResponseEntity<ReponseAPI<ChallengeDuJourDTO>> challengeEnregistreHistorique() throws URISyntaxException {
        ChallengeDuJourDTO challengeHistorique = this.facadeChallengeHistorique.genererChallengeDuJour();
        return ResponseEntity.created(new URI("cacahuete")).body(new ReponseAPI<>(201, "bravo c'est dans l'historique", challengeHistorique));
    }

    //TODO: mettre des belles URI + GET d'un seul challenge --> challenge du jour + regarder son nbre de publis associées
}
