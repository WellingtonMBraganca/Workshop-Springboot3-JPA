package com.projetosprbt.workshop.repositories;

import com.projetosprbt.workshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    //não ha necessidade de implementação de interface, uma vez que ja existe uma implementação
    //no JPA repository.
}
