package algebra.spring_practice.article;

import algebra.spring_practice.article.dto.CreateArticleDto;
import algebra.spring_practice.article.dto.UpdateArticleDto;

import java.util.List;

public interface ArticleService {
    List<Article> fetchAll();
    Article findById(int id);
    Article createArticle(CreateArticleDto createArticleDto);
    Article updateArticle(int id, UpdateArticleDto updateDto);
}
