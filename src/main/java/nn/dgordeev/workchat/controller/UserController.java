package nn.dgordeev.workchat.controller;

import lombok.extern.slf4j.Slf4j;
import nn.dgordeev.workchat.domain.ChatUser;
import nn.dgordeev.workchat.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/registration")
    public ResponseEntity<Void> handleRegistration(ChatUser chatUser) {
        this.repository.save(chatUser);
        return ResponseEntity.ok().build();
    }
}
