package app.springbootproject9.app.Customer.ServiceCustomer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.springbootproject9.app.Customer.Pojo.Customer;
import app.springbootproject9.app.Customer.RepositoryCustomer.RepoCustomer;

@Service
public class ServiceCustomer {

    @Autowired
    private RepoCustomer repoCustomer;

    public List<Customer> findAllCustomer() {
        return repoCustomer.findAll();
    }

    public Optional<Customer> findByIdCustomer(Integer id) {
        return repoCustomer.findById(id);
    }

    public void saveCustomer(Customer Customer) {
        repoCustomer.save(Customer);
    }

    public void deleteCustomer(Customer Customer) {
        repoCustomer.delete(Customer);
    }
}
