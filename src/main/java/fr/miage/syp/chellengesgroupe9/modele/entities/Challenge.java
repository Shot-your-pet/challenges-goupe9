package fr.miage.syp.chellengesgroupe9.modele.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Challenge {

    @Id
    @UuidGenerator
    private UUID idChallenge;

    @Column(unique = true)
    private String titreChallenge;

    @Column(unique = true)
    private String descriptionChallenge;

    private Instant dateSuppressionChallenge;

    public Challenge() {
    }

    public Challenge(String titreChallenge, String descriptionChallenge) {
        this.titreChallenge = titreChallenge;
        this.descriptionChallenge = descriptionChallenge;
        this.dateSuppressionChallenge = null;

    }

    public UUID getIdChallenge() {
        return idChallenge;
    }

    public void setIdChallenge(UUID idChallenge) {
        this.idChallenge = idChallenge;
    }

    public String getTitreChallenge() {
        return titreChallenge;
    }

    public void setTitreChallenge(String titreChallenge) {
        this.titreChallenge = titreChallenge;
    }

    public String getDescriptionChallenge() {
        return descriptionChallenge;
    }

    public void setDescriptionChallenge(String descriptionChallenge) {
        this.descriptionChallenge = descriptionChallenge;
    }

    public Instant getDateSuppressionChallenge() {
        return dateSuppressionChallenge;
    }

    public void setDateSuppressionChallenge() {
        this.dateSuppressionChallenge = Instant.now();
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "idChallenge=" + idChallenge +
                ", titreChallenge='" + titreChallenge + '\'' +
                ", descriptionChallenge='" + descriptionChallenge + '\'' +
                ", dateSuppressionChallenge=" + dateSuppressionChallenge +
                '}';
    }

}
