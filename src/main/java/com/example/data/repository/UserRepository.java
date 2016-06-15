package com.example.data.repository;

import com.example.data.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.id = :id")
    User findById(@Param("id") Long id);
}
