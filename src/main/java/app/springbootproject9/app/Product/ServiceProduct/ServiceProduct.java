package app.springbootproject9.app.Product.ServiceProduct;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.springbootproject9.app.Product.Pojo.Product;
import app.springbootproject9.app.Product.RepositoryProduct.RepoProduct;

@Service
public class ServiceProduct {

    @Autowired
    private RepoProduct repoProduct;

    public List<Product> findAllProduct() {
        return repoProduct.findAll();
    }

    public Optional<Product> findByIdProduct(Integer id) {
        return repoProduct.findById(id);
    }

    public void saveProduct(Product Product) {
        repoProduct.save(Product);
    }

    public void deleteProduct(Product Product) {
        repoProduct.delete(Product);
    }
}
