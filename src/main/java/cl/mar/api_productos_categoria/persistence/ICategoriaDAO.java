package cl.mar.api_productos_categoria.persistence;

import java.util.List;
import java.util.Optional;

import cl.mar.api_productos_categoria.models.Categoria;

public interface ICategoriaDAO {

	 List<Categoria> findAll();

	 Optional<Categoria> findById(Long id);	   

	 void save(Categoria categoria);
    
	 void deleteById(Long id);	
}
