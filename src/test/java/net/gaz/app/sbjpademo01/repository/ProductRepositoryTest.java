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
        product.setName("product 3");
        product.setDescription("product 3 description");
        product.setSku("555GAZ");
        product.setPrice(new BigDecimal(555));
        product.setActive(true);
        product.setImageUrl("product555.png");

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
    @Test
    void findByIdMethd(){
        /**
         * - Recuperar una entidad de la tabla de base de datos utilizando el método buscar por ID.
         * - por método ID es básicamente de la interfaz del repositorio crud y encontrar por método ID devuelve opcional(Retrieve a single
         *   entity by id from the databases)
         * - Como el nombre lo sugiere es encontrar por el método ID nos permite obtener o recuperar una entidad basado en el ID proporcionado
         *   de la tabla de la base de datos
         */

        Long id = 4L;
        Product product = productRepository.findById(id).get();
        Product printObjetc = productRepository.save(product);
        System.out.println(printObjetc.toString());
    }

}
