package de.ait.task.repositories;

import de.ait.task.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    Page<User> findAllByRole(User.Role role, Pageable pageable);

    Page<User> findAllByState(User.State state, Pageable pageable);

    Optional<User> findByEmail(String email);
}
