package br.com.serratec.project.repository;

import br.com.serratec.project.model.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Long> {

}
