package fr.miage.syp.chellengesgroupe9.modele.entities.dto;

import java.time.Instant;
import java.util.UUID;

public record CreerChallengeDTO(
        String titreChallenge,
        String descriptionChallenge
) {
}
