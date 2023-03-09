package com.ratatouille.Ratatouille23.user;

import com.ratatouille.Ratatouille23.order.Order;
import lombok.NonNull;
import org.apache.el.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByEmail(String email);
    Optional<List<User>> findAllByFirstNameContainingIgnoreCase(String firstName);
    Optional<List<User>> findAllByLastNameContainingIgnoreCase(String firstName);
    Optional<List<User>> findAllByEmailContainingIgnoreCase(String email);

    default Optional<List<User>> searchUsers(String firstName, String lastName, String email, Role role) {
        return Optional.of(findAll(UserSpecification.searchUsers(firstName, lastName, email, role)));
    };

}
