package ma.enset.backend.repositories;

import ma.enset.backend.dtos.CustomerDTO;
import ma.enset.backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.name like :keyword")
    List<Customer> searchCustomers(@Param("keyword") String keyword);
}
