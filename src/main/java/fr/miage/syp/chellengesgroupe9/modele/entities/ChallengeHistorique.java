package fr.miage.syp.chellengesgroupe9.modele.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
public class ChallengeHistorique {

    @Id
    @UuidGenerator
    private UUID idChallengeHistorique;

    @ManyToOne
    private Challenge challenge;

    private Instant dateDebutChallengeHistorique;
    private Instant dateFinChallengeHistorique;
    private Instant dateTirage;

    private int nbPublicationChallenge;


    public UUID getIdChallengeHistorique() {
        return idChallengeHistorique;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Instant getDateDebutChallengeHistorique() {
        return dateDebutChallengeHistorique;
    }

    public void setDateDebutChallengeHistorique(Instant dateDebutChallengeHistorique) {
        this.dateDebutChallengeHistorique = dateDebutChallengeHistorique;
    }

    public Instant getDateFinChallengeHistorique() {
        return dateFinChallengeHistorique;
    }

    public void setDateFinChallengeHistorique(Instant dateFinChallengeHistorique) {
        this.dateFinChallengeHistorique = dateFinChallengeHistorique;
    }

    public Instant getDateTirage() {
        return dateTirage;
    }

    public void setDateTirage(Instant dateTirage) {
        this.dateTirage = dateTirage;
    }

    public int getNbPublicationChallenge() {
        return nbPublicationChallenge;
    }

    public void setNbPublicationChallenge(int nbPublicationChallenge) {
        this.nbPublicationChallenge = nbPublicationChallenge;
    }
}
