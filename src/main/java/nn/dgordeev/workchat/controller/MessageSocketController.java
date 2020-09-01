package nn.dgordeev.workchat.controller;

import lombok.extern.slf4j.Slf4j;
import nn.dgordeev.workchat.domain.ChatUser;
import nn.dgordeev.workchat.domain.Message;
import nn.dgordeev.workchat.repository.UserRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class MessageSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    private final UserRepository userRepository;

    public MessageSocketController(SimpMessagingTemplate messagingTemplate, UserRepository userRepository) {
        this.messagingTemplate = messagingTemplate;
        this.userRepository = userRepository;
    }

    @MessageMapping("/chat/{to}")
    public void handleMessage(@DestinationVariable ChatUser user, Message message) {
      log.info("Handling incoming message from user {}", user.getLogin());
      if (userRepository.findById(user.getId()).isPresent()) {
          message.setCreatedAt(LocalDateTime.now());
          message.setUser(user);
          messagingTemplate.convertAndSend("/topic/messages-topic/" + user.getLogin(), message);
      }
    }
}
