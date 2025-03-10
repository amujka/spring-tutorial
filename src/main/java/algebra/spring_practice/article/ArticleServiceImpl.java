package algebra.spring_practice.article;

import algebra.spring_practice.article.dto.CreateArticleDto;
import algebra.spring_practice.article.dto.UpdateArticleDto;
import algebra.spring_practice.category.Category;
import algebra.spring_practice.category.CategoryRepositoryImpl;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepositoryImpl categoryRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepositoryImpl categoryRepository){
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Article> fetchAll(){
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findByNameOrDescriptionIgnoreCase(String query) {
        return articleRepository.findByNameContainingOrDescriptionContaining(query);
    }

    @Override
    public List<Article> findAllByPriceBetweenAndCategory(BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId) {
        return articleRepository.findAllByPriceBetweenAndCategory(minPrice,maxPrice,categoryId);
    }

    @Override
    public Optional<Article> findById(int id){
        return articleRepository.findById(id);
    }

    @Override
    public Article createArticle(CreateArticleDto createArticleDto){
        Optional<Category> category = categoryRepository.findById(createArticleDto.getCategoryId());
        if (category.isEmpty()) throw new InternalException("Category not found");

        Article article = new Article(createArticleDto.getName(),createArticleDto.getDescription(),createArticleDto.getPrice(),category.get());
        return articleRepository.save(article);
    }

    @Override
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

        return articleRepository.save(updatedArticle);
    }

    @Override
    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }
}

