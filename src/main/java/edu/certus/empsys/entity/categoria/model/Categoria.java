package edu.certus.empsys.entity.categoria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {

    private Integer id;
    private String nombre;
    private String descripcion;

}
