package fr.miage.syp.chellengesgroupe9.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.syp.chellengesgroupe9.modele.entities.dto.ChallengeDuJourDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RabbitEventsListener {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitEventsListener.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String GET_CHALLENGE_QUEUE = "challenges.get_challenge_jour";
    private final RabbitTemplate rabbitTemplate;
    private final FacadeChallengeHistorique facadeChallengeHistorique;


    public RabbitEventsListener(RabbitTemplate rabbitTemplate, FacadeChallengeHistorique facadeChallengeHistorique) {
        this.rabbitTemplate = rabbitTemplate;
        this.facadeChallengeHistorique = facadeChallengeHistorique;
    }

    @RabbitListener(queues = GET_CHALLENGE_QUEUE)
    public ChallengeDuJourDTO getChallengeJour(Instant dateDuJour) {
        try {
            ChallengeDuJourDTO challengeDuJourDTO = this.facadeChallengeHistorique.getChallengeDuJour();
            return challengeDuJourDTO;
        }catch (Exception e){
            return null;
        }
    }
}
