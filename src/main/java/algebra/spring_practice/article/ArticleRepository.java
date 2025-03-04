package algebra.spring_practice.article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    List<Article> fetchAll();
    Optional<Article> findById(int id);
    Article createArticle(Article article);
    Article updateArticle(Article article);
    void deleteById(int id);
}
