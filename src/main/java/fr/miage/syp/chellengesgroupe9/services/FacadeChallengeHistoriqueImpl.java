package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.ChallengeHistorique;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDuJourDTO;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeHistoriqueRepository;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeRepository;
import fr.miage.syp.chellengesgroupe9.modele.mappers.ChallengeMappers;
import org.hibernate.bytecode.spi.ReflectionOptimizer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
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
    public ChallengeDuJourDTO genererChallengeDuJour() {
        List<Challenge> challenges = challengeRepository.findAll();
        boolean challengeTrouve = false;
        List<ChallengeHistorique> derniers5Tirages = challengeHistoriqueRepository.findLast5Tirages();
        Challenge challengeTire = null;

        if(challenges.isEmpty()) {
            return null;
        }

        while(!challengeTrouve) {
            int nbAleatoire = random.nextInt(0, Math.max(challenges.size() - 1, 1));
            System.out.println(nbAleatoire);
            System.out.println(derniers5Tirages);
            challengeTire = challenges.get(nbAleatoire);
            System.out.println("challenge tiré" + challengeTire);
            challengeTrouve = true;

            for (ChallengeHistorique unDesDerniers5Tirage : derniers5Tirages) {
                System.out.println(unDesDerniers5Tirage + " " + challengeTire);
                if(unDesDerniers5Tirage.getChallenge().equals(challengeTire)) {
                    challengeTrouve = false;
                    break;
                }
            }

        }
        LocalDate dateDuJour = LocalDate.now();
        LocalTime horaireDuJour = LocalTime.of(18, 0);
        LocalDateTime dateEtHoraireDuJour = LocalDateTime.of(dateDuJour, horaireDuJour);
        Instant dateDebut = dateEtHoraireDuJour.atZone(ZoneId.systemDefault()).toInstant();
        ChallengeHistorique challengeHistorique = new ChallengeHistorique(
                challengeTire, dateDebut, dateDebut.plus(24, ChronoUnit.HOURS), 0);
        challengeHistoriqueRepository.save(challengeHistorique);
        return ChallengeMappers.dtoToChallengeDuJourDTO(challengeHistorique);

        //TODO: verifier que dans les 5 derniers challenges il n'y a pas de challenges supprimés (à verifier avec la date de suppression)
        //TODO: revérifier le délir de 5 derniers car le challenge 2 qui est en dernière position de challenge est jamais pris

    }

    @Override
    public void updateNbPublicationChallenge(int nbPublicationChallenge, UUID idChallenge) {

    }

    @Override
    public ChallengeDuJourDTO getChallengeDuJour() {
        Instant instant = Instant.now();
        System.out.println(instant);
        List<ChallengeHistorique> challengeHistoriques = challengeHistoriqueRepository.findLastChallenge(instant);
        if (challengeHistoriques.isEmpty()) {
            return null;
        }
        else {
            return ChallengeMappers.dtoToChallengeDuJourDTO(challengeHistoriques.getFirst());
        }
    }

}
