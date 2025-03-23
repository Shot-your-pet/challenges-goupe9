package fr.miage.syp.chellengesgroupe9;

import fr.miage.syp.chellengesgroupe9.modele.entities.Challenge;
import fr.miage.syp.chellengesgroupe9.modele.entities.repository.ChallengeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private final ChallengeRepository challengeRepository;

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final List<Pair<String, String>> INITIAL_CHALLENGES = List.of(
            Pair.of("Challenge du déguisement", "Habillez votre animal dans un costume amusant et partagez la photo la plus créative"), Pair.of("Challenge de la sieste", "Capturez votre animal en train de dormir dans une position drôle ou mignonne"),
            Pair.of("Challenge de l'expression", "Prenez une photo de votre animal avec une expression faciale unique (surpris, heureux, curieux, etc.)"),
            Pair.of("Challenge de la nourriture", "Photographiez votre animal en train de manger son plat préféré ou une friandise"),
            Pair.of("Challenge de la nature", "Prenez une photo de votre animal en pleine exploration à l'extérieur, que ce soit dans un parc, un jardin ou en randonnée"),
            Pair.of("Challenge de la complicité", "Capturez un moment tendre entre votre animal et un membre de la famille ou un autre animal"),
            Pair.of("Challenge du saut", "Photographiez votre animal en train de sauter ou de jouer, capturant son énergie et sa joie"),
            Pair.of("Challenge de la pose", "Demandez à votre animal de prendre une pose spécifique (assis, couché, debout) et partagez la meilleure photo"),
            Pair.of("Challenge de la transformation", "Montrez une photo de votre animal lorsqu'il était un chiot ou un chaton, comparée à une photo actuelle"),
            Pair.of("Challenge de l'artiste", "Créez une œuvre d'art (dessin, peinture, collage) inspirée de votre animal et partagez-la avec une photo de votre compagnon à côté")
    );


    public DataLoader(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (challengeRepository.count() == 0) {
            logger.info("Creating initial challenges");
            this.challengeRepository.saveAll(INITIAL_CHALLENGES.stream().map((p) -> new Challenge(p.getFirst(), p.getSecond())).toList());
        }
    }
}
