package com.projetosprbt.workshop.services;

import com.projetosprbt.workshop.entities.User;
import com.projetosprbt.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
Para utilizarmos a injeção de dependencia do spring (Autowired), Precisamos registrar a classe como
um componente do spring, para isso utilizamos a anotação @component, @repository ou @Service...
Todos para a mesma finalidade, entretanto a escolha deve ser feita para que o codigo seja semantico.
Como por exemplo, UserService, que recebera @Service.
*/
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        //Metodo findById retorna um optional, então, devemos receber em uma variavel optional...
        Optional<User> obj = repository.findById(id);
        //.get do optional, retorna o valor contido no objeto obj.
        return obj.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }
}
