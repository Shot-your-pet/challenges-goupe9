package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDuJourDTO;

import java.util.UUID;

public interface FacadeChallengeHistorique {
    ChallengeDuJourDTO genererChallengeDuJour();
    void updateNbPublicationChallenge(int nbPublicationChallenge, UUID idChallenge);
    ChallengeDuJourDTO getChallengeDuJour();
}
