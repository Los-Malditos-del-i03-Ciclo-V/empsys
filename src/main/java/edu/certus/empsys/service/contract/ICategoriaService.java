package edu.certus.empsys.service.contract;

import edu.certus.empsys.entity.categoria.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    void guardarCategoria(Categoria categoria);
    List<Categoria> obtenerTodasLasCategorias();
    Categoria buscarCategoriaPorId(Integer idCategoria);

}
