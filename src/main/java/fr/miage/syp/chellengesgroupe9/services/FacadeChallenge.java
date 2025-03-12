package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface FacadeChallenge {

    Challenge creerChallenge(CreerChallengeDTO creerChallengeDTO);
    Challenge modifierChallenge(UUID idChallenge, String titreChallenge, String descriptionChallenge);
    void supprimerChallenge(UUID idChallenge);
    List<Challenge> consulterChallenges(UUID idChallenge, String titreChallenge, String descriptionChallenge);
    Challenge envoitChallengeHeureFixe(UUID idChallenge);

}
