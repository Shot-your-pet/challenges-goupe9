package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;

public interface FacadeChallenge {

    Challenge creerChallenge(String titreChallenge, String descriptionChallenge);
    Challenge modifierChallenge(String titreChallenge, String descriptionChallenge);
    Challenge supprimerChallenge(String titreChallenge, String descriptionChallenge);
    Challenge consulterChallenge(String titreChallenge, String descriptionChallenge);
    // envoit du challenge à heure fixe

}
