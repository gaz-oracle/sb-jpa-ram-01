package net.gaz.app.sbjpademo01.repository;

import net.gaz.app.sbjpademo01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //1º
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("200ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //2º
        Product saveObjetc = productRepository.save(product);

        //3º
        System.out.println(saveObjetc.getId());
        System.out.println(saveObjetc.toString());


    }

}
/**
 * 1º Se requiere crear un objeto de Product
 * 2º Se guardara ese objeto Product
 * 3º Mostrar la informaccion del producto.
 */