package repository;

import jakarta.ejb.Singleton;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Singleton
public class ProductMemoryRepository implements ProductRepository{

    List<Product> products=new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    @Override
    public Product add(Product product)  {
        product.setId(idCounter.incrementAndGet());
        products.add(product);
        return product;
    }

    @Override
    public List<Product> findall()  {
        return products;
    }

    @Override
    public Product getByName(String name)  {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product updata(Long id, Product product)   {

        products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    return existingProduct;
                });
        return product;
    }

    @Override
    public boolean delete(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
