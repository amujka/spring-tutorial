package algebra.spring_practice.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public Product createProduct(CreateProductDto dto){
        return new Product(1,dto.getName());
    }

    public void updateProduct(UpdateProductDto dto, int id){
        Product product = new Product(id, "old name");
        product.setName(dto.getName());
    }

    public Product findProductById(int id){
        return new Product(id, "some product from db");
    }

    public List<Product> getAllProducts(){
        return List.of(new Product(1,"TV"),new Product(2,"Monitor"),new Product(3,"Phone"));
    }

    public void deleteProduct(int id){
        System.out.println("delete product by id: " + id);
    }
}
