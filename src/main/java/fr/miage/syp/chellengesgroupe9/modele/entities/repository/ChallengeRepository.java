package fr.miage.syp.chellengesgroupe9.modele.entities.repository;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {
    Optional<Challenge> findRandomChallenge();
    Optional<Challenge> deleteChallengeByIdChallenge(UUID idChallenge);

    @Query("SELECT c FROM Challenge c WHERE " +
            "(c.idChallenge = :idChallenge OR :idChallenge IS NULL) AND " +
            "(c.titreChallenge LIKE %:titreChallenge% OR :titreChallenge IS NULL) AND " +
            "(c.descriptionChallenge LIKE %:descriptionChallenge% OR :descriptionChallenge IS NULL)")
    List<Challenge> consulterChallenges(UUID idChallenge, String titreChallenge, String descriptionChallenge);
}
