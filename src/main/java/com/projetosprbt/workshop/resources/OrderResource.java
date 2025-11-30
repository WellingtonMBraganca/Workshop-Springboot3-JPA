package com.projetosprbt.workshop.resources;

import com.projetosprbt.workshop.entities.Order;
import com.projetosprbt.workshop.services.OrderService;
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
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    //tipo especifico que retorna resposta para requisições web.
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    //(value) indica que a requisição virá acompanhada de um argumento na URL (id).
    @GetMapping(value = "/{id}")
    //para o spring entender que esse argumento é o da requisição acima, PathVariable.
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
