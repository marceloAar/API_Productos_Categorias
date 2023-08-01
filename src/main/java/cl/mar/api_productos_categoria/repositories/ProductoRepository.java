package cl.mar.api_productos_categoria.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.mar.api_productos_categoria.models.Producto;

import java.math.BigDecimal;
import java.util.List;


public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN ?1 AND ?2")
    List<Producto> findProductoByPrecioInRange(BigDecimal minPrecio, BigDecimal maxPrecio);
    
}
