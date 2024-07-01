package service;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import model.Product;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class ProductServiceImp implements ProductService{

    @Inject
    ProductRepository productRepository;
    @Override
    public List<Product> findall() {
        return productRepository.findall();
    }

    @Override
    public Product getByName(String name){
        return productRepository.getByName(name);
    }

    @Override
    public Product updata(Long id, Product product) {
        return productRepository.updata(id, product);
    }

    @Override
    public boolean delete(Long id) {
        return productRepository.delete(id);
    }

    @Override
    public Product add(Product product) {
        productRepository.add(product);
        return product;
    }
}
