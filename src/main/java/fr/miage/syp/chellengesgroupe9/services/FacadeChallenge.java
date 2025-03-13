package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ModifierChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.exceptions.ChallengeDejaSortiException;
import fr.miage.syp.chellengesgroupe9.modele.exceptions.ChallengeInexistantException;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface FacadeChallenge {

    ChallengeDTO creerChallenge(CreerChallengeDTO creerChallengeDTO);
    ChallengeDTO modifierChallenge(ModifierChallengeDTO modifierChallengeDTO, UUID idChallenge) throws ChallengeInexistantException, ChallengeDejaSortiException;
    void supprimerChallenge(UUID idChallenge) throws ChallengeInexistantException;
    List<ChallengeDTO> consulterChallenges();


}
