package app.springbootproject9.app.Order.ServiceOrder;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.springbootproject9.app.Order.Pojo.Order;
import app.springbootproject9.app.Order.RepositoryOrder.RepoOrder;
import app.springbootproject9.app.Product.Pojo.Product;
import app.springbootproject9.app.Product.RepositoryProduct.RepoProduct;
import jakarta.transaction.Transactional;

@Service
public class ServiceOrder {

    @Autowired
    private RepoOrder repoOrder;

    @Autowired
    private RepoProduct repoProduct;

    @Transactional
    public List<Order> findAllOrder() {

        List<Order> orders = repoOrder.findAll();

        for (Order o : orders) {
            Hibernate.initialize(o.getProducts());
        }
        return orders;
    }
    public Optional<Order> findByIdOrder(Integer id) {
        return repoOrder.findById(id);
    }

    @Transactional
    public void saveOrder(Order order) {
        System.out.println(" \n<----- START ESECUZIONE");
        for (Product p : order.getProducts()) {
            if (p.getId() == null) {
                repoProduct.save(p);
            }
        }
        repoOrder.save(order);
        System.out.println("-----> FINE ESECUZIONE\n");
    }

    public void deleteOrder(Order Order) {
        repoOrder.delete(Order);
    }

}
