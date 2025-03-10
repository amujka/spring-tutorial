package algebra.spring_practice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CreateDto {

    private String name;
    private Double yearPublished;
    private List<Integer> grades;
}
