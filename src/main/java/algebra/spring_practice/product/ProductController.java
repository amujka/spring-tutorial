package algebra.spring_practice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.findProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductDto dto){
        return productService.createProduct(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody UpdateProductDto dto, @PathVariable int id){
        productService.updateProduct(dto, id);
    }

}
