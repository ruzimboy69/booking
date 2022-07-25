package com.example.booking.repository;

import com.example.booking.entity.User;
import com.example.booking.interfaces.Searchable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends Searchable<User,Integer>,JpaRepository<User,Integer> {
    @Override
    List<User> findAll();

    @Override
    User findByid(Integer integer);

    Optional<User> findByUsername(String username);
    boolean existsByUsernameAndPassword(String username,String password);
}
