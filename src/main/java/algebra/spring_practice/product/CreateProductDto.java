package algebra.spring_practice.product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProductDto {
    @NotBlank (message = "Article name cannot be")
    private String name;
}
