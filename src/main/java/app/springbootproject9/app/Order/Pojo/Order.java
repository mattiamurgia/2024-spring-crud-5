package app.springbootproject9.app.Order.Pojo;

import java.util.List;

import app.springbootproject9.app.Customer.Pojo.Customer;
import app.springbootproject9.app.FullPrice.FullPrice;
import app.springbootproject9.app.Product.Pojo.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements FullPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    private List<Product> products;

    public Order() {
    }

    public Order(Customer customer, List<Product> products) {
        setCustomer(customer);
        setProducts(products);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public Integer getFullPrice(boolean includeVat) {
        if (getProducts() == null)
            return 0;

        Integer total = 0;
        for (Product p : getProducts()) {
            total += p.getFullPrice(includeVat);
        }
        return total;
    }

    @Override
    public String toString() {

        return "Order: " + getCustomer() + "NProduct: " + getProducts();
    }
}
