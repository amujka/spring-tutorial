package algebra.spring_practice.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> fetchAll(){
        List<Category> categories = categoryService.fetchAll();
        return ResponseEntity.status(200).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> fetchById(@PathVariable int id){
        Optional<Category> category = categoryService.fetchById(id);
        if (category.isEmpty()) return ResponseEntity.status(404).build();

        return ResponseEntity.status(200).body(category.get());
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CreateDto createDto){
        Category category = categoryService.create(createDto);
        return ResponseEntity.status(201).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable int id, @RequestBody UpdateDto updateDto){
        Category category = categoryService.update(id,updateDto);
        return ResponseEntity.status(200).body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable int id){
        categoryService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
