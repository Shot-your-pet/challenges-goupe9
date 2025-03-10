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

    private Instant dateDebutChallenge;
    private Instant dateFinChallenge;

    public Challenge() {
    }

    public Challenge(UUID idChallenge, String titreChallenge, String descriptionChallenge, Instant dateDebutChallenge, Instant dateFinChallenge) {
        this.idChallenge = idChallenge;
        this.titreChallenge = titreChallenge;
        this.descriptionChallenge = descriptionChallenge;
        this.dateDebutChallenge = dateDebutChallenge;
        this.dateFinChallenge = dateFinChallenge;
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

    public Instant getDateDebutChallenge() {return dateDebutChallenge;}
    public void setDateDebutChallenge(Instant dateDebutChallenge) { this.dateDebutChallenge = dateDebutChallenge; }
    public Instant getDateFinChallenge() {return dateFinChallenge;}
    public void setDateFinChallenge(Instant dateFinChallenge) { this.dateFinChallenge = dateFinChallenge; }
}
