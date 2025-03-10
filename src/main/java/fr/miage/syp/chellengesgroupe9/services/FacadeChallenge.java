package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;

import java.time.Instant;
import java.util.UUID;

public interface FacadeChallenge {

    Challenge creerChallenge(CreerChallengeDTO creerChallengeDTO);
    Challenge modifierChallenge(UUID idChallenge, String titreChallenge, String descriptionChallenge);
    Challenge supprimerChallenge(UUID idChallenge);
    Challenge consulterChallenge(UUID idChallenge, String titreChallenge, String descriptionChallenge);
    // envoit du challenge à heure fixe

}
