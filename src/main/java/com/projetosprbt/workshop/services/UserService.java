package com.projetosprbt.workshop.services;

import com.projetosprbt.workshop.entities.User;
import com.projetosprbt.workshop.repositories.UserRepository;
import com.projetosprbt.workshop.services.exceptions.DatabaseException;
import com.projetosprbt.workshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        //orElseThrow tenta dar o get, mas caso não consiga, retorna excessao.
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e ){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        //getReferenceById faz com que esse objeto seja monitorado pelo JPA,
        // para que possamos trabalhar com ele e posteriormente fazer alguma opeção com BD...
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName( obj.getName());
        entity.setEmail( obj.getEmail());
        entity.setPhone( obj.getPhone());
    }
}
