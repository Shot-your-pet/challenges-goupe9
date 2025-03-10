package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FacadeChallengeImpl implements FacadeChallenge {

    private final ChallengeRepository challengeRepository;

    public FacadeChallengeImpl(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public Challenge creerChallenge(String titreChallenge, String descriptionChallenge) {
        Challenge challenge = new Challenge();
        //challenge.setIdChallenge(UUID.randomUUID());
        challenge.setTitreChallenge(titreChallenge);
        challenge.setDescriptionChallenge(descriptionChallenge);
        challenge = challengeRepository.save(challenge);
        return challenge;
    }

    @Override
    public Challenge modifierChallenge(String titreChallenge, String descriptionChallenge) {
        return null;
    }

    @Override
    public Challenge supprimerChallenge(String titreChallenge, String descriptionChallenge) {
        return null;
    }

    @Override
    public Challenge consulterChallenge(String titreChallenge, String descriptionChallenge) {
        return null;
    }

    // envoit du challenge à heure fixe
}
