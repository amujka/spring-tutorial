package algebra.spring_practice.category;

import algebra.spring_practice.category.dto.CreateDto;
import algebra.spring_practice.category.dto.UpdateDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> fetchAll();
    Optional<Category> fetchById(int id);
    Category create(CreateDto createDto);
    Category update(int id, UpdateDto updateDto);
    void delete(int id);
}
