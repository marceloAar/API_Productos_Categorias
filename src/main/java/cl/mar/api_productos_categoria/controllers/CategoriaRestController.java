package cl.mar.api_productos_categoria.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mar.api_productos_categoria.controllers.dto.CategoriaDTO;
import cl.mar.api_productos_categoria.models.Categoria;
import cl.mar.api_productos_categoria.services.ICategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/buscar/{id}")
    private ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Categoria> categoriaOpcional = categoriaService.findById(id);

        if (categoriaOpcional.isPresent()) {
            Categoria categoria = categoriaOpcional.get();
            CategoriaDTO categoriaDTO = CategoriaDTO.builder()
                    .id(categoria.getId())
                    .nombre(categoria.getNombre())
                    .productos(categoria.getProductos())                    
                    .build();
            return ResponseEntity.ok(categoriaDTO);
        }

        return ResponseEntity.badRequest().build();        
    }
	
	
	 @GetMapping("/listar")
	    private ResponseEntity<?> listarCategorias() {
	        List<CategoriaDTO> listaCategorias = categoriaService.findAll()
	                .stream()
	                .map(categoria -> CategoriaDTO.builder()
	                        .id(categoria.getId())
	                        .nombre(categoria.getNombre())
	                        .productos(categoria.getProductos())
	                        .build())
	                .toList();
	        return ResponseEntity.ok(listaCategorias);
	 }	
	 
	 
	 @PostMapping("/crear")
	    public ResponseEntity<?> crear(@RequestBody CategoriaDTO categoriaDTO) throws URISyntaxException {

	        if (categoriaDTO.getNombre().isBlank() || categoriaDTO.getProductos() == null) {
	            return ResponseEntity.badRequest().build();
	        }

	        Categoria categoria = Categoria.builder()
	                                 .id(categoriaDTO.getId())
	                                 .nombre(categoriaDTO.getNombre())
	                                 .productos(categoriaDTO.getProductos())
	                                 .build();

	        categoriaService.save(categoria);
	        return ResponseEntity.created(new URI("/api/categorias/crear")).build();
	    }	 
	 
	 
		@PutMapping("/modificar/{id}")
		public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {

			Optional<Categoria> categoriaOptional = categoriaService.findById(id);

			if (categoriaOptional.isPresent()) {
				Categoria categoria = categoriaOptional.get();

				categoria.setNombre(categoriaDTO.getNombre());
				categoria.setProductos(categoriaDTO.getProductos());
				
				categoriaService.save(categoria);
			}
			return ResponseEntity.notFound().build();
		}
		
		
		@DeleteMapping("/eliminar/{id}")
		public ResponseEntity<?> eliminar(@PathVariable Long id) {

			if (id != null) {
				categoriaService.deleteById(id);
				return ResponseEntity.noContent().build();
			}

			return ResponseEntity.badRequest().body("El producto no se encuentra");
		}
	 
	 

}
