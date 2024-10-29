package edu.certus.empsys.service.provider;

import edu.certus.empsys.entity.categoria.model.Categoria;
import edu.certus.empsys.entity.vacante.model.Vacante;
import edu.certus.empsys.service.contract.ICategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

import static edu.certus.empsys.entity.categoria.factory.CategoriaFactory.listaDeCategorias;
import static edu.certus.empsys.entity.vacante.factory.VacanteFactory.listaDeVacantes;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    @Override
    public void guardarCategoria(Categoria categoria) {
        listaDeCategorias.add(categoria);
    }

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return listaDeCategorias;
    }

    @Override
    public Categoria buscarCategoriaPorId(Integer id) {
        for (Categoria categoria: listaDeCategorias) {
            if(categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }
    /**
     *  TODO: 1. Crear la clase CategoriasServiceImpl que implemente esta Interfaz (Guardar las categorías en una lista (LinkedList))
     *
     *  TODO: 2. Inyectar la clase de servicio en CategoriasController.
     *
     *  TODO: 3. Completar los siguientes métodos en CategoriasController:
     *
     *  	mostrarIndex -> Renderizar el listado de Categorias (listCategorias.html)
     *  					Configurar la URL del botón para crear una Categoría
     *
     *		guardar -> Guardar el objeto Categoria a traves de la clase de servicio
     *				   Validar errores de Data Binding y mostrarlos al usuario en caso de haber
     *				   Mostrar al usuario mensaje de confirmacion de registro guardado
     *
     *	TODO: 4. Agregar un nuevo menu llamado Categorias y configurar la URL al listado de Categorias
     *
     */


}
