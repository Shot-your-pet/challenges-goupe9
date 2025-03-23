package fr.miage.syp.chellengesgroupe9.modele.entities.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public record ChallengeDuJourDTO(
        UUID id,
        ChallengeDTO challenge,
        Instant dateDebut,
        Instant dateFin
) implements Serializable {
}
