package cl.mar.api_productos_categoria.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mar.api_productos_categoria.models.Categoria;
import cl.mar.api_productos_categoria.persistence.ICategoriaDAO;
import cl.mar.api_productos_categoria.services.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() {		
		return categoriaDAO.findAll();
	}

	@Override
	public Optional<Categoria> findById(Long id) {		
		return categoriaDAO.findById(id);
	}

	@Override
	public void save(Categoria categoria) {
		categoriaDAO.save(categoria);		
	}

	@Override
	public void deleteById(Long id) {
		categoriaDAO.deleteById(id);
	}
	
	
	

}
