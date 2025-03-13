package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;

import java.util.UUID;

public interface FacadeChallengeHistorique {
    Challenge genererChallengeDuJour();
    void updateNbPublicationChallenge(int nbPublicationChallenge, UUID idChallenge);
}
