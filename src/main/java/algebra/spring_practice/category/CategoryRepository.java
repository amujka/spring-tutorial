package algebra.spring_practice.category;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public Optional<Category> findById(Integer id){
        String query = "SELECT * FROM Category WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query,new CategoryRowMapper(), id));
    }
}
