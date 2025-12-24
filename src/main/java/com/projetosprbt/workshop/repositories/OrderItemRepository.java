package com.projetosprbt.workshop.repositories;

import com.projetosprbt.workshop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Aqui não se faz necessário registroda classe (@Repository), pois a classe ja herda
de JpaRepository que é um componente do spring já registrado..
*/
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    //não ha necessidade de implementação de interface, uma vez que ja existe uma implementação
    //no JPA repository.
}
