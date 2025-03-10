package algebra.spring_practice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UpdateDto {
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
    private LocalDateTime createdAt;
}
