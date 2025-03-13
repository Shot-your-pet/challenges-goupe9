package fr.miage.syp.chellengesgroupe9.modele.mappers;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDTO;

public class ChallengeMappers {
    public static ChallengeDTO challengeToDTO(Challenge challenge) {
        return new ChallengeDTO(challenge.getTitreChallenge(), challenge.getDescriptionChallenge());
    }
}
