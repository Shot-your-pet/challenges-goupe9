package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.ChallengeHistorique;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.CreerChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ModifierChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeHistoriqueRepository;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeRepository;
import fr.miage.syp.chellengesgroupe9.modele.exceptions.ChallengeDejaSortiException;
import fr.miage.syp.chellengesgroupe9.modele.exceptions.ChallengeInexistantException;
import fr.miage.syp.chellengesgroupe9.modele.mappers.ChallengeMappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public ChallengeDTO creerChallenge(CreerChallengeDTO creerChallengeDTO) {
        Challenge challenge = new Challenge(
                creerChallengeDTO.titre(),
                creerChallengeDTO.description()
        );

        challenge = challengeRepository.save(challenge);
        return ChallengeMappers.challengeToDTO(challenge);
    }
    
    @Override
    public ChallengeDTO modifierChallenge(ModifierChallengeDTO modifierChallengeDTO, UUID idChallenge) throws ChallengeInexistantException, ChallengeDejaSortiException {
        Challenge challenge = challengeRepository.findById(idChallenge).orElseThrow(() -> new ChallengeInexistantException(idChallenge));
        List<ChallengeHistorique> listeChallengesHistoriques = challengeHistoriqueRepository.findByChallenge(challenge);

        if (!listeChallengesHistoriques.isEmpty()){
            throw new ChallengeDejaSortiException(idChallenge);
        }

        challenge.setTitreChallenge(modifierChallengeDTO.titre());
        challenge.setDescriptionChallenge(modifierChallengeDTO.description());
        return ChallengeMappers.challengeToDTO(challengeRepository.save(challenge));
    }
    
    @Override
    public void supprimerChallenge(UUID idChallenge) throws ChallengeInexistantException {
        Challenge challenge = challengeRepository.findById(idChallenge).orElseThrow(() -> new ChallengeInexistantException(idChallenge));
        List<ChallengeHistorique> challengesHistoriques = this.challengeHistoriqueRepository.findByChallenge(challenge);
        if (challengesHistoriques.isEmpty()){
            challengeRepository.delete(challenge);
        }
        else {
            challenge.setDateSuppressionChallenge();
            challengeRepository.save(challenge);
        }

    }

    @Override
    public List<ChallengeDTO> consulterChallenges() {
        List<Challenge> challenges = challengeRepository.findAll();
        List<ChallengeDTO> dtos = new ArrayList<>();

        for (Challenge challenge : challenges) {
            dtos.add(ChallengeMappers.challengeToDTO(challenge));
        }

        return dtos;
    }



}
