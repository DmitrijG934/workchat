package nn.dgordeev.workchat.repository;

import nn.dgordeev.workchat.domain.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UUID, ChatUser> {
}
