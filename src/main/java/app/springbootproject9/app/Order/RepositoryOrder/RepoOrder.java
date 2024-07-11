package app.springbootproject9.app.Order.RepositoryOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.springbootproject9.app.Order.Pojo.Order;

@Repository
public interface RepoOrder extends JpaRepository<Order, Integer> {

}
