    package com.ctf_kg.ctf_kg.repositories;

    import com.ctf_kg.ctf_kg.entities.Product;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.util.List;


    @Repository
    public interface ProductRepository extends JpaRepository<Product, Long> {
        @Query("SELECT p.typeofProduct, COUNT(p) AS count FROM Product p GROUP BY p.typeofProduct ORDER BY COUNT(p) DESC")
        List<Object[]> findTopTypeOfProducts();

        @Query("SELECT p FROM Product p WHERE p.number = :number OR p.organizationName = :organizationName OR p.nameOfProduct = :nameOfProduct")
        List<Product> searchByMultipleFields(@Param("number") String number, @Param("organizationName") String organizationName, @Param("nameOfProduct") String nameOfProduct);

        @Query("SELECT p.organizationName, COUNT(p) AS purchaseCount FROM Product p GROUP BY p.organizationName ORDER BY purchaseCount DESC")
        List<Object[]> countProductsByOrganization();
    }
