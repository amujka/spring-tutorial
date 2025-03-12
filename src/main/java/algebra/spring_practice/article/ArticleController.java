package algebra.spring_practice.article;

import algebra.spring_practice.article.dto.CreateArticleDto;
import algebra.spring_practice.article.dto.UpdateArticleDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
//
//    @GetMapping
//    public ResponseEntity<List<Article>> fetchAll(){
//        List<Article> articles = articleService.fetchAll();
//        return ResponseEntity.status(200).body(articles);
//    }

    @GetMapping
    public ResponseEntity<List<Article>> findAllByPriceBetweenAndCategory(@RequestParam(required = false) BigDecimal minPrice,@RequestParam(required = false) BigDecimal maxPrice,@RequestParam(required = false) Integer categoryId){
        List<Article> articles;
        if (minPrice != null && maxPrice != null && categoryId != null) {
            articles = articleService.findAllByPriceBetweenAndCategory(minPrice, maxPrice, categoryId);
        } else {
            articles = articleService.fetchAll();
        }
        return ResponseEntity.status(200).body(articles);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Article>> findByNameOrDescriptionIgnoreCase(@RequestParam String query){
        List<Article> articles = articleService.findByNameOrDescriptionIgnoreCase(query);
        return ResponseEntity.status(200).body(articles);
    }

    @GetMapping("/top-expensive")
    public ResponseEntity<Article> findByNameOrDescriptionIgnoreCase(){
        Optional<Article> article = articleService.findTopByOrderByPriceDesc();
        if (article.isEmpty()) return ResponseEntity.status(404).build();
        return ResponseEntity.status(200).body(article.get());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Integer id){
        Optional<Article> article = articleService.findById(id);

        if (article.isEmpty()) return ResponseEntity.status(404).build();

        return ResponseEntity.status(200).body(article.get());
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody CreateArticleDto createArticleDto){
        Article article = articleService.createArticle(createArticleDto);
        return  ResponseEntity.status(200).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> update (@Valid @RequestBody UpdateArticleDto dto, @PathVariable Integer id){
        Article article = articleService.updateArticle(id, dto);
        return ResponseEntity.status(200).body(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        Optional<Article> article = articleService.findById(id);
        if (article.isEmpty()) return ResponseEntity.status(404).build();

        articleService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}

