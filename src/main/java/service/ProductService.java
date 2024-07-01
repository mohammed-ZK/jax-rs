package service;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product add(Product product)  ;
    public List<Product> findall() ;
    public Product getByName(String name) ;
    public Product updata(Long id,Product product) ;
    public boolean delete(Long id);
}
