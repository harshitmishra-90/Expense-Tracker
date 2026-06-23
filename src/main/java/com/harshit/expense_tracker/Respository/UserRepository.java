package com.harshit.expense_tracker.Respository;

import com.harshit.expense_tracker.Model.User;
import com.harshit.expense_tracker.dto.LoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    Optional<User> findByUsernameOrEmail(
            String username,
            String  email
    );
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
