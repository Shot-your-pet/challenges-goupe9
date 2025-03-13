package fr.miage.syp.chellengesgroupe9.modele.exceptions;

import java.util.UUID;

public class ChallengeInexistantException extends Exception {
    public ChallengeInexistantException(UUID idChallenge) {
        super("Challenge inexistant ! " + idChallenge);
    }
}
