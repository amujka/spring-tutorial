package algebra.spring_practice.category;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> fetchAll(){
        return categoryRepository.fetchAll();
    }

    public Optional<Category> fetchById(int id){
        return categoryRepository.findById(id);
    }

    public Category create(CreateDto createDto){
        Category category = new Category(createDto.getName(),createDto.getDescription());
        return categoryRepository.create(category);
    }

    public Category update(int id, UpdateDto updateDto){
        Optional<Category>category = categoryRepository.findById(id);
        if (category.isEmpty()) throw new InternalException("No category found");

        Category updatedCategory = category.get();
        updatedCategory.setName(updateDto.getName());
        updatedCategory.setDescription(updateDto.getDescription());

        return categoryRepository.update(updatedCategory);
    }

    public void delete(int id){
        categoryRepository.delete(id);
    }
}
