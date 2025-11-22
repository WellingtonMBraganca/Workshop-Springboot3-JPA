package com.projetosprbt.workshop.config;

import com.projetosprbt.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Anotação que associa uma instancia de user repository
    //fazendo automanticamnte uma injeção de dependencia.
    @Autowired
    private UserRepository userRepository;


}
