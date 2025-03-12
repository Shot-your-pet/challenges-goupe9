package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class FacadeChallengeImpl implements FacadeChallenge {

    private final ChallengeRepository challengeRepository;

    public FacadeChallengeImpl(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public Challenge creerChallenge(CreerChallengeDTO creerChallengeDTO) {
        Challenge challenge = new Challenge(
                creerChallengeDTO.idChallenge(),
                creerChallengeDTO.titreChallenge(),
                creerChallengeDTO.descriptionChallenge()
        );

        challenge = challengeRepository.save(challenge);
        return challenge;
    }
    
    @Override
    public Challenge modifierChallenge(UUID idChallenge, String titreChallenge, String descriptionChallenge) {
        Optional<Challenge> optionalChallenge = challengeRepository.findById(idChallenge);

        if (optionalChallenge.isPresent()) {
            Challenge challenge = optionalChallenge.get();
            challenge.setTitreChallenge(titreChallenge);
            challenge.setDescriptionChallenge(descriptionChallenge);
            return challengeRepository.save(challenge);
        } else {
            throw new EntityNotFoundException("Challenge avec l'ID " + idChallenge + " non trouvé.");
        }
    }
    
    @Override
    public Challenge supprimerChallenge(UUID idChallenge) {
        return null;
    }

    @Override
    public Challenge consulterChallenge(UUID idChallenge, String titreChallenge, String descriptionChallenge) {
        return null;
    }

    // envoit du challenge à heure fixe
}
