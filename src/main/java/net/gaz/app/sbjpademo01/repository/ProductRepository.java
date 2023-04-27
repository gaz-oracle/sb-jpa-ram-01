package net.gaz.app.sbjpademo01.repository;

import net.gaz.app.sbjpademo01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}


/**
 * 1. No tenemos que escribir una clase de implemantaccion para implementar esta Interfaz.
 * 2. La Interfaz JpaRepository obtiene todos los metodos para realizar operaciones CRUD en la entidad JPA del producto
 */