package algebra.spring_practice.article;

import algebra.spring_practice.category.Category;
import algebra.spring_practice.category.CategoryRepository;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public ArticleService (ArticleRepository articleRepository,CategoryRepository categoryRepository){
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Article> fetchAll(){
        return articleRepository.fetchAll();
    }

    public Article findById(int id){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()){
            throw new InternalException("Article not found");
        }
        return article.get();
    }

    public Article createArticle(CreateArticleDto createArticleDto){
        Optional<Category> category = categoryRepository.findById(createArticleDto.getCategoryId());
        if (category.isEmpty()) throw new InternalException("Category not found");

        Article article = new Article(createArticleDto.getName(),createArticleDto.getDescription(),createArticleDto.getPrice(),category.get());
        return articleRepository.createArticle(article);
    }

    public Article updateArticle(int id, UpdateArticleDto updateDto){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()) throw new InternalException("Article not found");

        Optional<Category> category = categoryRepository.findById(updateDto.getCategoryId());
        if (category.isEmpty()) throw new InternalException("Category not found");

        Article updatedArticle = article.get();
        updatedArticle.setName(updatedArticle.getName());
        updatedArticle.setDescription(updateDto.getDescription());
        updatedArticle.setPrice(updateDto.getPrice());
        updatedArticle.setCategory(category.get());

        return articleRepository.updateArticle(updatedArticle);

    }
}