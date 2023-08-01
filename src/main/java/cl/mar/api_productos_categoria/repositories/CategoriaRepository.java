package cl.mar.api_productos_categoria.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.mar.api_productos_categoria.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>  {

}
