package net.gaz.app.sbjpademo01.repository;

import net.gaz.app.sbjpademo01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
/**Este va a ser nuestro método de consulta para encontrar o recuperar un producto por nombre.
 * Este método de consulta básicamente devuelve el nombre de UN producto
 * utilizando su nombre como criterio de búsqueda, Si el producto no se encuntra, este metodo retona un NULL  */
    public Product findByName(String name);



}


/**
 * 1. No tenemos que escribir una clase de implemantaccion para implementar esta Interfaz.
 * 2. La Interfaz JpaRepository obtiene todos los metodos para realizar operaciones CRUD en la entidad JPA del producto
 */