package algebra.spring_practice.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product>findByName(String name);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
    List<Product>findByIsAvailableTrue();
    List<Product>findByDescriptionContainingIgnoreCase(String word);

    @Query("SELECT p FROM Product p WHERE p.is_available = false")
    List<Product> findByIsAvailableFalse();

    @Query("SELECT p FROM Product p WHERE p.price NOT BETWEEN :min AND :max")
    List<Product> findByPriceNotBetween(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findBySpecificName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:expression%")
    List<Product> findByNameContaining(@Param("expression") String expression);

    @Query("SELECT p FROM Product p WHERE p.name NOT LIKE %:phrase%")
    List<Product> findByNameNotContaining(@Param("phrase") String phrase);

    @Query("SELECT p FROM Product p WHERE p.description IS NULL")
    List<Product> findByDescriptionIsNull();
}
