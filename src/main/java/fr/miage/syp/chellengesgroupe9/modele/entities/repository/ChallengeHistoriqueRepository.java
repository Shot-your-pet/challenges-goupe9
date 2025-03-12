package fr.miage.syp.chellengesgroupe9.modele.entities.repository;

import fr.miage.syp.chellengesgroupe9.modele.entities.ChallengeHistorique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChallengeHistoriqueRepository extends JpaRepository<ChallengeHistorique, UUID> {
    @Query("SELECT ch FROM ChallengeHistorique ch ORDER BY ch.dateTirage DESC")
    List<ChallengeHistorique> findLast5Tirages();
}
