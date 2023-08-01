package cl.mar.api_productos_categoria.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.mar.api_productos_categoria.models.Categoria;
import cl.mar.api_productos_categoria.persistence.ICategoriaDAO;
import cl.mar.api_productos_categoria.repositories.CategoriaRepository;

@Component
public class CategoriaDAOImpl implements ICategoriaDAO{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findAll() {		
		return (List<Categoria>) categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);		
	}

	@Override
	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);		
	}

}
