package algebra.spring_practice.category;

import algebra.spring_practice.category.dto.CreateDto;
import algebra.spring_practice.category.dto.UpdateDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAll(){
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> fetchById(int id){
        return categoryRepository.findById(id);
    }

    @Override
    public Category create(CreateDto createDto){
        Category category = new Category(createDto.getName(),createDto.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public Category update(int id, UpdateDto updateDto){
        Optional<Category>category = categoryRepository.findById(id);
        if (category.isEmpty()) throw new InternalException("No category found");

        Category updatedCategory = category.get();
        updatedCategory.setName(updateDto.getName());
        updatedCategory.setDescription(updateDto.getDescription());

        return categoryRepository.save(updatedCategory);
    }

    @Override
    public void delete(int id){
        categoryRepository.deleteById(id);
    }
}
