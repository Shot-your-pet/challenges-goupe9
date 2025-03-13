package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.ChallengeHistorique;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeHistoriqueRepository;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class FacadeChallengeHistoriqueImpl implements FacadeChallengeHistorique{

    private final ChallengeRepository challengeRepository;
    private final ChallengeHistoriqueRepository challengeHistoriqueRepository;
    private final Random random;

    public FacadeChallengeHistoriqueImpl(ChallengeRepository challengeRepository, ChallengeHistoriqueRepository challengeHistoriqueRepository) {
        this.challengeRepository = challengeRepository;
        this.challengeHistoriqueRepository = challengeHistoriqueRepository;
        this.random = new Random();
    }

    @Scheduled(cron = "0 0 18 * * ?")
    @Override
    public Challenge genererChallengeDuJour() {
        List<Challenge> challenges = challengeRepository.findAll();
        boolean challengeTrouve = false;
        List<ChallengeHistorique> derniers5Tirages = challengeHistoriqueRepository.findLast5Tirages();
        Challenge challengeTire = null;

        while(!challengeTrouve) {
            int nbAleatoire = random.nextInt(0, challenges.size()-1);
            challengeTire = challenges.get(nbAleatoire);
            challengeTrouve = true;

            for (ChallengeHistorique unDesDerniers5Tirage : derniers5Tirages) {
                if(unDesDerniers5Tirage.getChallenge().equals(challengeTire)) {
                    challengeTrouve = false;
                    break;
                }
            }

        }
        return challengeTire;
    }

    @Override
    public void updateNbPublicationChallenge(int nbPublicationChallenge, UUID idChallenge) {

    }

}
