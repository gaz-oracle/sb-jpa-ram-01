package net.gaz.app.sbjpademo01.repository;

import net.gaz.app.sbjpademo01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;



@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    /**
     * 1º Se requiere crear un objeto de Product
     * 2º Se guardara ese objeto Product
     * 3º Mostrar la informaccion del producto.
     */
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

    @Test
    void updateUsingMethod(){
        //1º Find or retrive an entity by id from database.
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        /**llame al método Get para obtener un objeto de producto de la clase opcional*/

        //2º Actualizar: recuperar la entidad y actualizar la informaccion:
        product.setName("Update product 1 - 12:33");
        product.setDescription("Producto Actualizado recientemente");

        //3º Guardar la entidad actualizada en la tabla de las base de Datos.
        productRepository.save(product);
        /** EntityManager merge() method */

    }

}
