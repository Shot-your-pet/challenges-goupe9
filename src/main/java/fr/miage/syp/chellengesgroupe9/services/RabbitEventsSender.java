//package fr.miage.syp.cheorg.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

//@Service
public class RabbitEventsSender {

//    private final RabbitTemplate rabbitTemplate;
//
//    public RabbitEventsSender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public record Message<T>(UUID idDemande, UUID idReponse, T contenu) implements Serializable {}
//    public record MessageNewChallenge(UUID idChallenge, String titreChallenge, String descriptionChallenge) implements Serializable {}
//
//
//    public <T> void send(UUID idDemande, UUID idReponse, T contenu){
//        Message message = new Message(idDemande, idReponse, contenu);
//        this.rabbitTemplate.convertAndSend("exchange", "routingkey", message);
//    }
//
//    public void sendUpdateChallengeEvent(UUID idChallenge ,String titreChallenge, String descriptionChallenge) {
//        MessageNewChallenge message = new MessageNewChallenge(idChallenge,titreChallenge,descriptionChallenge);
//        this.rabbitTemplate.convertAndSend("challenge.creer_challenge", message);
//    }

 }
