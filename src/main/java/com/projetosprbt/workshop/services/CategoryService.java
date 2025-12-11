package com.projetosprbt.workshop.services;

import com.projetosprbt.workshop.entities.Category;
import com.projetosprbt.workshop.repositories.CategoryRepository;
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
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        //Metodo findById retorna um optional, então, devemos receber em uma variavel optional...
        Optional<Category> obj = repository.findById(id);
        //.get do optional, retorna o valor contido no objeto obj.
        return obj.get();
    }
}
