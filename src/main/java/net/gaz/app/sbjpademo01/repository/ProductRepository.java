package net.gaz.app.sbjpademo01.repository;

import net.gaz.app.sbjpademo01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Este va a ser nuestro método de consulta para encontrar o recuperar un producto por nombre.
     * Este método de consulta básicamente devuelve el nombre de UN producto
     * utilizando su nombre como criterio de búsqueda, Si el producto no se encuntra, este metodo retona un NULL
     * <p>
     * ---> only one field retrive findByName&findById  <----
     */

    public Product findByName(String name);

    /**
     * un método de consulta para encontrar o recuperar un producto por ID
     * Simplemente pasaremos el producto como un tipo de OPTIONAL
     * y simplemente creamos un método de consulta que busque por ID y
     * luego simplemente pase ID como un argumento de método.
     * Este metodo retorna un Empty Optional,si el priducto no es encontrado.
     */

    Optional<Product> findById(Long id);

    /**
     * Hibernate:
     * select
     * p1_0.id,
     * p1_0.active,
     * p1_0.date_created,
     * p1_0.description,
     * p1_0.image_url,
     * p1_0.last_update,
     * p1_0.name,
     * p1_0.price,
     * p1_0.stock_keeping_unit
     * from
     * tbl_products p1_0
     * where
     * p1_0.id=?
     * <p>
     * ==
     * <p>
     * Optional<Product> findById(Long id)
     */
    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    /** - Así que estos dos campos son de la entidad del producto: Name , Description.
     *  - Siempre que escriba un método de consulta, asegúrese de usar campos de entidad tengan Maysucula en la primera letra
     *  - Returns the found list of product entries whose tiltle or description is given as method paramenter
     *    (Devuelve la lista encontrada de entradas de productos cuyo título O descripción se proporciona como parámetro de método)
     *  - If not product entries is founf, this methos returns an empty list
     *             findByNameOrDescription
     *   (Devuelve la lista encontrada de entradas de productos cuyo título Y descripción se proporciona como parámetro de método)
     *      *  - If not product entries is founf, this methos returns an empty list
     *             findByNameAndDescription
     **/

    /**
     * METHOD FIND DISTINCTY
     * - Return the distinct product entry whose name is given as a method parameter
     * - If no product entry is found, this method returns null
     * (Este método devuelve una entrada de producto distinta cuyo nombre se proporciona como parámetro de método, como
     * criterio de búsqueda)
     */
    Product findDistinctByName(String name);

    List<Product> findDistinctByNameNotIn(List<String> names);

    /**
     * Return the products whose price is greater thangiven price as method parameter
     * Return the products whose price is Less thangiven price as method parameter
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(Long price);

    /**
     * Return the filtered the product recors that march the given text
     *
     * @param name
     * @return
     */
    List<Product> findByNameContaining(String name);

    /**
     * Return Product  based on SQL like condition
     *
     * @param name
     * @return
     */
    List<Product> findByNameLike(String name);

    /**
     * Returns a products whose price between start price and end price.
     *
     * @param starPrice
     * @param endPrice
     * @return
     */
    List<Product> findByPriceBetween(BigDecimal starPrice, BigDecimal endPrice);

    /**
     * Returns a products whose DataCreated between startDate and endDate.
     *
     * @param starDate
     * @param endDate
     * @return
     */
    List<Product> findByDateCreatedBetween(LocalDateTime starDate, LocalDateTime endDate);

}


/**
 * 1. No tenemos que escribir una clase de implemantaccion para implementar esta Interfaz.
 * 2. La Interfaz JpaRepository obtiene todos los metodos para realizar operaciones CRUD en la entidad JPA del producto.
 * 3. También podemos eliminar public porque todos los métodos que definimos en la interfaz son por defecto públicos.
 * 4. find es básicamente una palabra clave de sujeto y distinct es básicamente una palabra clave de predicado.
 */

