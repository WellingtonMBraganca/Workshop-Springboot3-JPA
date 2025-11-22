package com.projetosprbt.workshop.resources;

import com.projetosprbt.workshop.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Anotação indica que este é um recurso web, implementado por controlador REST.
@RestController
//da nome ao recurso.
@RequestMapping(value = "/users")
public class UserResource {

    //tipo especifico que retorna resposta para requisições web.
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u =new User(1L, "Godofredo", "godofs@arromba.com", "9988776655", "123456");
        return ResponseEntity.ok().body(u);
    };
}
