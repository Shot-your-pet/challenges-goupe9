package fr.miage.syp.chellengesgroupe9.modele.entities.dto;

import java.time.Instant;

public record ChallengeDuJourDTO(
        ChallengeDTO challenge,
        Instant dateDebut,
        Instant dateFin
) {
}
