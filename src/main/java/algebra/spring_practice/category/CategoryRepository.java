package algebra.spring_practice.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Integer id);
    List<Category> fetchAll();
    Category update(Category category);
    Category create(Category category);
    void delete(int id);
}
