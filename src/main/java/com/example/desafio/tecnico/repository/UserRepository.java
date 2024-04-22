package com.example.desafio.tecnico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.desafio.tecnico.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
