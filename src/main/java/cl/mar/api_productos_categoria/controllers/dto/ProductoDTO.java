package cl.mar.api_productos_categoria.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import cl.mar.api_productos_categoria.models.Categoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Categoria categoria;
}
