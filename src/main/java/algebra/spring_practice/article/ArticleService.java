package algebra.spring_practice.article;

import algebra.spring_practice.article.dto.CreateArticleDto;
import algebra.spring_practice.article.dto.UpdateArticleDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> fetchAll();
    Optional<Article> findById(int id);
    Article createArticle(CreateArticleDto createArticleDto);
    Article updateArticle(int id, UpdateArticleDto updateDto);
    void deleteById(int id);
}
