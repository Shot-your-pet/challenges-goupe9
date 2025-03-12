package fr.miage.syp.chellengesgroupe9.modele.entities;

import java.time.Instant;
import java.util.UUID;

public class ChallengeHistorique {
    UUID idChallengeHistorique;
    Challenge challenge;
    Instant dateDebutChallengeHistorique;
    Instant dateFinChallengeHistorique;
    int nbPublicationChallenge;


}
