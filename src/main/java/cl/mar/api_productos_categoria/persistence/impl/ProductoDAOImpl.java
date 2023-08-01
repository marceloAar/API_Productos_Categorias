package cl.mar.api_productos_categoria.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.mar.api_productos_categoria.models.Producto;
import cl.mar.api_productos_categoria.persistence.IProductoDAO;
import cl.mar.api_productos_categoria.repositories.ProductoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoDAOImpl implements IProductoDAO {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

  
    @Override
    public void save(Producto product) {
        productoRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

	@Override
	public List<Producto> findByPrecioInRange(BigDecimal minPrecio, BigDecimal maxPrecio) {		
		return productoRepository.findProductoByPrecioInRange(minPrecio, maxPrecio);
	}
	
}
