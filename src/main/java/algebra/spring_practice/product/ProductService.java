package algebra.spring_practice.product;

import algebra.spring_practice.product.dto.CreateDto;
import algebra.spring_practice.product.dto.UpdateDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> fetchAll();
    Optional<Product> findById(long id);
    Product createProduct(CreateDto createProductDto);
    Product updateProduct(int id, UpdateDto updateDto);
    void deleteById(long id);
}
