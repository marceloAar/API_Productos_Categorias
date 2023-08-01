package cl.mar.api_productos_categoria.controllers.dto;

import java.util.List;

import cl.mar.api_productos_categoria.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoriaDTO {
	
	private Long id;
    private String nombre;
    private List<Producto> productos;

}
