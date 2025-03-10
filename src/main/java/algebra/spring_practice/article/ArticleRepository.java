package algebra.spring_practice.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("SELECT a FROM Article a WHERE a.price BETWEEN :minPrice AND :maxPrice AND a.category.id = :categoryId")
    List<Article> findAllByPriceBetweenAndCategory(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice, @Param("categoryId") Integer categoryId);

    @Query("SELECT a FROM Article a WHERE a.name LIKE %:query% OR a.description LIKE %:query%")
    List<Article> findByNameContainingOrDescriptionContaining(@Param("query") String query);


}
