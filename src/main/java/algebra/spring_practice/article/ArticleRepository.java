package algebra.spring_practice.article;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {
    private final JdbcTemplate jdbcTemplate;


    public List<Article> fetchAll(){
        return jdbcTemplate.query("SELECT a.id, a.name, a.description, a.price, a.categoryId, c.name AS categoryName, c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.categoryId = c.id", new ArticleRowMapper());
    }

    public Optional<Article> findById(int id){
        String query = "SELECT a.id, a.name, a.description, a.price, a.categoryId, c.name AS categoryName, c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.categoryId = c.id WHERE a.id = ?";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, new ArticleRowMapper(),parameters));
    }

    public Article createArticle(Article article){
        String query = "INSERT INTO Article (name,description,price,categoryId) VALUES(?,?,?,?)";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId());
        return article;
    }

    public Article updateArticle(Article article){
        String query = "UPDATE Article SET name = ?, description = ?, price = ?, categoryId = ? WHERE id = ?";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId(),article.getId());
        return article;
    }

}

