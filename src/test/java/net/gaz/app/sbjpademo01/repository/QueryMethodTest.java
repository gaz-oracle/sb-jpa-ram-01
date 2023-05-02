package net.gaz.app.sbjpademo01.repository;

import jdk.swing.interop.SwingInterOpUtils;
import net.gaz.app.sbjpademo01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryMethodTest {

    /** vamos a inyectar la interface ProductRepository aquí*/
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product 3");
        System.out.println(product.getId());
        System.out.println(product.getPrice());
        //System.out.println(product.getDescription());
        System.out.println(product.getLastUpdate());
    }

}
