package net.gaz.app.sbjpademo01.repository;

import net.gaz.app.sbjpademo01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodTest {

    /**
     * vamos a inyectar la interface ProductRepository aquí
     */
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 3");
        System.out.println(product.getId());
        System.out.println(product.getPrice());
        System.out.println(product.getDescription());
        System.out.println(product.getLastUpdate());
    }

    @Test
    void findById() {
        /**
         * Simplemente podemos llamar aquí un método get
         * Este método get()<- , básicamente devuelve un nombre de entidad en nuestro caso, entidad de producto,
         * ya que si no tenemos que implentar  Optional<Product> como en la emplentaccion de la interface
         * y no nos vas dejar invocar la propiedades de la entidad en cuestion.
         */
        Product product = productRepository.findById(16L).get(); // <-
        System.out.println(product.getName());
        System.out.println(product.getSku());
        System.out.println(product.getDescription());
        System.out.println(product.getPrice());
        System.out.println(product.getId());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> productList = productRepository.findByNameOrDescription("product 300", "product 100 description");
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getPrice());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> productList = productRepository.findByNameAndDescription("product 100", "product 100 description");
        productList.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getPrice());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 200");
        System.out.println(product.getId());
        System.out.println(product.getPrice());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    /**
     * @Test void findDistinctByNameNotInMethod(){
     * Product productList = productRepository.findDistinctByName("product 200");
     * productList.forEach(product -> {
     * System.out.println(product.getId());
     * System.out.println(product.getPrice());
     * System.out.println(product.getName());
     * System.out.println(product.getDescription());
     * });
     * }
     */


    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(BigDecimal.valueOf(100));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getPrice());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(220L); /** BEST BigDecimal BECUASE VALUES DECIMALS */
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getPrice());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products = productRepository.findByNameContaining("product 300");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getPrice());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });
    }
}
