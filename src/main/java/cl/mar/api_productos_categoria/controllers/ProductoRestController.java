package cl.mar.api_productos_categoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.mar.api_productos_categoria.controllers.dto.ProductoDTO;
import cl.mar.api_productos_categoria.models.Producto;
import cl.mar.api_productos_categoria.services.IProductoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/buscar/{id}")
    private ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Producto> productoOpcional = productoService.findById(id);

        if (productoOpcional.isPresent()) {
            Producto producto = productoOpcional.get();
            ProductoDTO productoDTO = ProductoDTO.builder()
                    .id(producto.getId())
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .categoria(producto.getCategoria())
                    .build();

            return ResponseEntity.ok(productoDTO);
        }

        return ResponseEntity.badRequest().build();        
    }


    @GetMapping("/listar")
    private ResponseEntity<?> listarProductos() {
        List<ProductoDTO> listaProductos = productoService.findAll()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .id(producto.getId())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecio())
                        .categoria(producto.getCategoria())
                        .build())
                .toList();
        return ResponseEntity.ok(listaProductos);
    }


    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {

        if (productoDTO.getNombre().isBlank() || productoDTO.getPrecio() == null || productoDTO.getCategoria() == null) {
            return ResponseEntity.badRequest().build();
        }

        Producto producto = Producto.builder()
                                 .id(productoDTO.getId())
                                 .nombre(productoDTO.getNombre())
                                 .precio(productoDTO.getPrecio())
                                 .categoria(productoDTO.getCategoria())
                                 .build();

        productoService.save(producto);
        return ResponseEntity.created(new URI("/api/productos/crear")).build();
    }


    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){

        Optional<Producto> productoOptional = productoService.findById(id);

        if(productoOptional.isPresent()){
            Producto producto = productoOptional.get();

            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setCategoria(productoDTO.getCategoria());
            productoService.save(producto);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){

        if(id != null){
            productoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body("El producto no se encuentra");
    }
}
