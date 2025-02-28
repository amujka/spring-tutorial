package algebra.spring_practice.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateDto {
    private String name;

    private String description;
}
