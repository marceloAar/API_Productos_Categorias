package cl.mar.api_productos_categoria.persistence;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import cl.mar.api_productos_categoria.models.Producto;

public interface IProductoDAO {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    List<Producto> findByPrecioInRange(BigDecimal minPrecio, BigDecimal maxPrecio);

    void save(Producto producto);

    void deleteById(Long id);
}
