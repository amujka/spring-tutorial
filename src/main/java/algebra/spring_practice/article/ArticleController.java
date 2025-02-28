package algebra.spring_practice.article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> fetchAll(){
        List<Article> articles = articleService.fetchAll();
        return ResponseEntity.status(200).body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Integer id){
        Article article = articleService.findById(id);
        return ResponseEntity.status(200).body(article);
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

}

