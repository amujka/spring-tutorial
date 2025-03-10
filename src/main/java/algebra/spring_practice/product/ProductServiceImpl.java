package algebra.spring_practice.product;

import algebra.spring_practice.product.dto.CreateDto;
import algebra.spring_practice.product.dto.UpdateDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> fetchAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(CreateDto createProductDto) {
        Product product = new Product(createProductDto.getName(),createProductDto.getDescription(),createProductDto.getPrice(),createProductDto.isAvailable(),createProductDto.getCreatedAt());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, UpdateDto updateDto) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new InternalException("Product not found");
        }

        productRepository.delete(product.get());

    }
}
