package algebra.spring_practice.category;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Category> findById(Integer id){
        String query = "SELECT * FROM Category WHERE id = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, new CategoryRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Category> fetchAll(){
        String query = "SELECT * FROM Category";
        return jdbcTemplate.query(query,new CategoryRowMapper());
    }

    @Override
    public Category update(Category category){
        String query = "UPDATE Category SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(query,category.getName(),category.getDescription(),category.getId());
        return  category;
    }

    @Override
    public Category create(Category category){
        String query="INSERT INTO Category(name, description) VALUES(?,?)";
        jdbcTemplate.update(query,category.getName(),category.getDescription());
        return category;
    }

    @Override
    public void delete(int id){
        String query="DELETE FROM Category WHERE id = ?";
        jdbcTemplate.update(query,id);
    }
}
