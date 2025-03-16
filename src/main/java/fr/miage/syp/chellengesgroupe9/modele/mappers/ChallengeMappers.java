package fr.miage.syp.chellengesgroupe9.modele.mappers;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.ChallengeHistorique;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDuJourDTO;

public class ChallengeMappers {
    public static ChallengeDTO challengeToDTO(Challenge challenge) {
        return new ChallengeDTO(challenge.getTitreChallenge(), challenge.getDescriptionChallenge());
    }

    public static ChallengeDuJourDTO dtoToChallengeDuJourDTO(ChallengeHistorique challengeHistorique) {
        return new ChallengeDuJourDTO(challengeToDTO(challengeHistorique.getChallenge()), challengeHistorique.getDateDebutChallengeHistorique(), challengeHistorique.getDateFinChallengeHistorique());
    }
}
