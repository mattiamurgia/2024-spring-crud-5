package app.springbootproject9.app.Product.Pojo;

import java.util.List;

import app.springbootproject9.app.FullPrice.FullPrice;
import app.springbootproject9.app.Order.Pojo.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product implements FullPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String nameProduct;

    @Column(length = 64, nullable = false)
    private Integer price;

    @Column(length = 64, nullable = false)
    private Integer vat; // (iva percentuale)

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product() {
    }

    public Product(String nameProduct, Integer price, Integer vat) {
        setNameProduct(nameProduct);
        setPrice(price);
        setVat(vat);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Integer getFullPrice(boolean withVat) {
        if (withVat) {
            return getPrice() + (getPrice() * getVat() / 100);
        } else {
            return getPrice();
        }
    }

    @Override
    public String toString() {
        return "Product: " + getNameProduct() + " " + getPrice() + " - " + getVat() + " ID: " + getId();
    }

}
