package com.projetosprbt.workshop.resources;

import com.projetosprbt.workshop.entities.User;
import com.projetosprbt.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Anotação indica que este é um recurso web, implementado por controlador REST.
@RestController
//da nome ao recurso.
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    //tipo especifico que retorna resposta para requisições web.
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    //(value) indica que a requisição virá acompanhada de um argumento na URL (id).
    @GetMapping(value = "/{id}")
    //para o spring entender que esse argumento é o da requisição acima, PathVariable.
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
