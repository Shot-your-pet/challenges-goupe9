package fr.miage.syp.chellengesgroupe9.modele.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChallenge;

    @Column(unique = true)
    private String titreChallenge;

    @Column(unique = true)
    private String descriptionChallenge;

    private LocalDateTime dateDebutChallenge;
    private LocalDateTime dateFinChallenge;

    public long getIdChallenge() {
        return idChallenge;
    }

    public void setIdChallenge(long idChallenge) {
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
}
