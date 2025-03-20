package fr.miage.syp.chellengesgroupe9.services;

import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDuJourDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitEventsSender {

    private final RabbitTemplate rabbitTemplate;
    private final String NEW_CHALLENGE_QUEUE = "challenges.nouveau_challenge_jour";

    public RabbitEventsSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendChallengeDuJour(ChallengeDuJourDTO challengeDuJourDTO) {
        this.rabbitTemplate.convertAndSend(NEW_CHALLENGE_QUEUE, challengeDuJourDTO);
    }

 }
