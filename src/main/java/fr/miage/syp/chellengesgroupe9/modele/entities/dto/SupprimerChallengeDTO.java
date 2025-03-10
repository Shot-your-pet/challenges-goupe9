package fr.miage.syp.chellengesgroupe9.modele.entities.dto;

import java.time.Instant;

public record SupprimerChallengeDTO(long idChallenge,
                                    String titreChallenge,
                                    String descriptionChallenge,
                                    Instant dateDebutChallenge,
                                    Instant dateFinChallenge) {
}
