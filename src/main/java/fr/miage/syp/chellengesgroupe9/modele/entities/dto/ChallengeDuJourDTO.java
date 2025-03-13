package fr.miage.syp.chellengesgroupe9.modele.entities.dto;

import java.time.Instant;

public record ChallengeDuJourDTO(
        ChallengeDTO challengeDTO,
        Instant DateDebutChallenge,
        Instant DateFinChallenge
) {
}
