package algebra.spring_practice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl {
    private final JdbcTemplate jdbcTemplate;

    public List<Product> fetchAll(){

    }

}
