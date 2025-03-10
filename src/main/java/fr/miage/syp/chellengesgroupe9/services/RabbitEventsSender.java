package fr.miage.syp.chellengesgroupe9.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Service
public class RabbitEventsSender {

    private final RabbitTemplate rabbitTemplate;

    public RabbitEventsSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public record Message<T>(UUID idDemande, UUID idReponse, T data) implements Serializable {}
    public record MessageNewChallenge(Long idChallenge, String titreChallenge, String descriptionChallenge, Instant dateDebutChallenge, Instant dateFinChallenge) implements Serializable {}


    public <T> void send(UUID idDemande, UUID idReponse, T data){
        Message message = new Message(idDemande, idReponse, data);
        this.rabbitTemplate.convertAndSend("exchange", "routingkey", message);
    }

    public void sendUpdateChallengeEvent(Long idChallenge ,String titreChallenge, String descriptionChallenge, Instant dateDebutChallenge, Instant dateFinChallenge) {
        MessageNewChallenge message = new MessageNewChallenge(idChallenge,titreChallenge,descriptionChallenge,dateDebutChallenge,dateFinChallenge);
        this.rabbitTemplate.convertAndSend("challenge.creer_challenge", message);
    }
 }
