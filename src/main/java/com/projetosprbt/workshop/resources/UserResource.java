package com.projetosprbt.workshop.resources;

import com.projetosprbt.workshop.entities.User;
import com.projetosprbt.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //inserir posting;...
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        //Forma padrao de gerar endereço do novo recurso inserido e apresentar e codigo 201
        //que representa um recurso inserido com um caminho específico.
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
