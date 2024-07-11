package app.springbootproject9.app.Customer.RepositoryCustomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.springbootproject9.app.Customer.Pojo.Customer;

@Repository
public interface RepoCustomer extends JpaRepository<Customer, Integer> {

}
