package algebra.spring_practice.article;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl {
    private final JdbcTemplate jdbcTemplate;

    public List<Article> fetchAll(){
        return jdbcTemplate.query("SELECT a.id, a.name, a.description, a.price, a.category_id, c.name AS categoryName, c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.category_id = c.id", new ArticleRowMapper());
    }

    public Optional<Article> findById(int id){
        String query = "SELECT a.id, a.name, a.description, a.price, a.category_id, c.name AS categoryName, c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.category_id = c.id WHERE a.id = ?";

        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, new ArticleRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Article createArticle(Article article){
        String query = "INSERT INTO Article (name,description,price,category_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId());
        return article;
    }

    public Article updateArticle(Article article){
        String query = "UPDATE Article SET name = ?, description = ?, price = ?, category_id = ? WHERE id = ?";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId(),article.getId());
        return article;
    }

    public void deleteById(int id) {
       String query = "DELETE FROM Article WHERE id = ?";
       jdbcTemplate.update(query,id);
    }
}

