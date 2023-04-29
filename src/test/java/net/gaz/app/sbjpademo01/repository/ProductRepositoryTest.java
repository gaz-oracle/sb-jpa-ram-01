package net.gaz.app.sbjpademo01.repository;

import net.gaz.app.sbjpademo01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;

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
        Product saveObjetc = productRepository.save(product); // save -> insert

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
        productRepository.save(product); //save -> Update
        /** EntityManager merge() method */

    }
    @Test
    void findByIdMethod(){
        /**
         * - Recuperar una entidad de la tabla de base de datos utilizando el método buscar por ID.
         * - por método ID es básicamente de la interfaz del repositorio crud y encontrar por método ID devuelve opcional(Retrieve a single
         *   entity by id from the databases)
         * - Como el nombre lo sugiere es encontrar por el método ID nos permite obtener o recuperar una entidad basado en el ID proporcionado
         *   de la tabla de la base de datos
         */

        Long id = 4L;
        Product product = productRepository.findById(id).get(); // ->findById
        Product printObjetc = productRepository.save(product);
        System.out.println(printObjetc.toString());
    }

    @Test
    void saveAllMethod(){
/** CREATE MULTIPLES PRODUCTS*/
        Product product1 = new Product();
        product1.setName("product 100");
        product1.setDescription("product 100 description");
        product1.setSku("900MORE");
        product1.setPrice(new BigDecimal(100));
        product1.setActive(true);
        product1.setImageUrl("product 100.png");

        Product product2 = new Product();
        product2.setName("product 200");
        product2.setDescription("product 200 description");
        product2.setSku("800YXZ");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product 200.png");

        Product product3 = new Product();
        product3.setName("product 300");
        product3.setDescription("product 300 description");
        product3.setSku("700BDC");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("product 300.png");

        productRepository.saveAll(List.of(product1,product2,product3)); // -> saveAll - Insert MAsivo
    }

    @Test
    void findAllMethod(){  // find all
        List<Product> products = productRepository.findAll();

        products.forEach((p) ->{
            System.out.println(p.getName());
        });

        products.forEach((p) ->{
            System.out.println(p.getId());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1l;
        productRepository.deleteById(id);
    }

    @Test
    void deleteEntityMethod(){
        //find an entity by id:
        Long id =7l;
        Product product = productRepository.findById(id).get();

        //Delete(entity)
        productRepository.delete(product);
    }
    /**
     * para usar un método de eliminación para eliminar una entidad en particular de la tabla de la
     * base de datos, primero necesitamos recuperar esa entidad en particular de la tabla de base de
     * datos mediante ID.
     *
     * deleteByIdMethod() vs delete() : mejor perfomace deleteByIdMethod(), genera menos query para
     * su ejecucion
     * https://www.baeldung.com/spring-data-jpa-delete
     *
     */

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();
    }

    /** OTHER WAY **/
    @Test
    void deleteAllMethod2(){
        /** DELETE ITERABLE VARIUOS IS LILE DELETE ONLY PRODUCTSO AT SAME TIME */
        Product product1 = productRepository.findById(8l).get();
        Product product2 = productRepository.findById(9l).get();
        productRepository.deleteAll(List.of(product1,product2));
    }

    @Test
    void countMethod() {
        Long count = productRepository.count();
        //long count = productRepository.count();
        System.out.println("******** ROWS IN TBL_PRODUCTS ********: " +count);
        /**
         *
         long una primitiva, que debe tener un valor. Simple.

         Long un objeto , entonces:

         puede ser null(que significa lo que quieras, pero "desconocido" es una interpretación común)
         se puede pasar a un método que acepta un Object, Number, Longo longparámetro (el último gracias al desempaquetado automático)
         se puede utilizar como un tipo de parámetro genérico, es decir List<Long>está bien, pero List<long> está no bien
         se puede serializar/deserializar a través del mecanismo de serialización de Java

         Utilice siempre lo más sencillo que funcione, así que si necesita alguna de las características de Long, usar Longde lo contrario usar long. La sobrecarga de un Longes sorprendentemente pequeño, pero está ahí
         */

    }

    @Test
    void existByIdMethod(){

        Long id = 179876544663L;
        boolean result =  productRepository.existsById(id);
        System.out.println(result);
        if (result){
            System.out.println("SI existe el id: " + id);
        }else {
            System.out.println("NO existe el id: " + id);
        }



    }


}
