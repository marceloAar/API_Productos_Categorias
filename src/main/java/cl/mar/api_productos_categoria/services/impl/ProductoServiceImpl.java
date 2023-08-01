package cl.mar.api_productos_categoria.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mar.api_productos_categoria.models.Producto;
import cl.mar.api_productos_categoria.persistence.IProductoDAO;
import cl.mar.api_productos_categoria.services.IProductoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDAO.findById(id);
    }

  
    @Override
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
    }

	@Override
	public List<Producto> findByPrecioInRange(BigDecimal minPrecio, BigDecimal maxPrecio) {		
		return productoDAO.findByPrecioInRange(minPrecio, maxPrecio);
	}
	
}
