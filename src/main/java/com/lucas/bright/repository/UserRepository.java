package com.lucas.bright.repository;

import com.lucas.bright.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas Daniel
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
    
}
