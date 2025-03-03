package algebra.spring_practice.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDto {
    private String name;

    private String description;
}
