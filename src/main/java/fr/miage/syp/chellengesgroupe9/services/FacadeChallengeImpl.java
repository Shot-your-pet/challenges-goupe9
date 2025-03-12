package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.ChallengeHistorique;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeHistoriqueRepository;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FacadeChallengeImpl implements FacadeChallenge {

    private final ChallengeRepository challengeRepository;
    private final ChallengeHistoriqueRepository challengeHistoriqueRepository;

    public FacadeChallengeImpl(ChallengeRepository challengeRepository, ChallengeHistoriqueRepository challengeHistoriqueRepository) {
        this.challengeRepository = challengeRepository;
        this.challengeHistoriqueRepository = challengeHistoriqueRepository;
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
    public void supprimerChallenge(UUID idChallenge) {
        if (!challengeRepository.existsById(idChallenge)) {
            throw new IllegalArgumentException("Challenge avec l'ID " + idChallenge + " n'existe pas");
        }
        challengeRepository.deleteById(idChallenge);
    }

    @Override
    public List<Challenge> consulterChallenges(UUID idChallenge, String titreChallenge, String descriptionChallenge) {
        return null;
    }

    public Challenge envoitChallengeHeureFixe(UUID idChallenge) {
        Optional<Challenge> challengeOpt = challengeRepository.findById(idChallenge);
        if (challengeOpt.isEmpty()) {
            throw new IllegalArgumentException("Challenge non trouvé");
        }
        Challenge challenge = challengeOpt.get();

        List<ChallengeHistorique> dernierTirages = challengeHistoriqueRepository.findLast5Tirages();
        while (dernierTirages.stream().anyMatch(h -> h.getChallenge().equals(challenge))) {
            challenge = findRandomChallenge();
            dernierTirages = challengeHistoriqueRepository.findLast5Tirages();
        }

        ChallengeHistorique historique = new ChallengeHistorique();
        historique.setChallenge(challenge);
        Instant dateDebut = Instant.now().plusSeconds(18 * 60 * 60);
        Instant dateFin = dateDebut.plusSeconds(24 * 60 * 60);
        historique.setDateDebutChallengeHistorique(dateDebut);
        historique.setDateFinChallengeHistorique(dateFin);
        historique.setDateTirage(Instant.now());

        challengeHistoriqueRepository.save(historique);

        return challenge;
    }

    public Challenge findRandomChallenge() {
        List<Challenge> challenges = challengeRepository.findAll();
        if (challenges.isEmpty()) {
            throw new IllegalStateException("Aucun challenge disponible");
        }
        int randomIndex = (int) (Math.random() * challenges.size());
        return challenges.get(randomIndex);
    }


}
