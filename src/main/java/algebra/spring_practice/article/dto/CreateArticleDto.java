package algebra.spring_practice.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateArticleDto {
    private String name;

    private String description;

    private BigDecimal price;

    private Integer categoryId;
}
