package cl.mar.api_productos_categoria.services;

import java.util.List;
import java.util.Optional;

import cl.mar.api_productos_categoria.models.Categoria;

public interface ICategoriaService {
	
	List<Categoria> findAll();

    Optional<Categoria> findById(Long id);;

    void save(Categoria categoria);

    void deleteById(Long id);	

}
