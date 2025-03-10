package fr.miage.syp.chellengesgroupe9.modele.entities.repository;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {
    Optional<Challenge> findByTitreChallenge(String titreChallenge);
}
