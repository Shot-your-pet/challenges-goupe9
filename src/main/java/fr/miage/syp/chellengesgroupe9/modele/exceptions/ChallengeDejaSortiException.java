package fr.miage.syp.chellengesgroupe9.modele.exceptions;

import java.util.UUID;

public class ChallengeDejaSortiException extends Throwable {
    public ChallengeDejaSortiException(UUID idChallenge) {
        super("Le challenge a été utilisé, il est donc impossible de le modifier !");
    }
}
