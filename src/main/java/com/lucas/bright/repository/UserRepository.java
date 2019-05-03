package com.lucas.bright.repository;

import com.lucas.bright.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Connect directly with the database and is not necessary to do querys here
 *
 * @author Lucas Daniel
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    //This is a JPA functionality  using the atribute you can add any 'querys' without code
    Optional<User> findByName(String name);
    
}
