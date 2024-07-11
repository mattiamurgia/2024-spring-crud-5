package app.springbootproject9.app.Product.RepositoryProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.springbootproject9.app.Product.Pojo.Product;

@Repository
public interface RepoProduct extends JpaRepository<Product, Integer> {

}
