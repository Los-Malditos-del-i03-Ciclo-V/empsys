package edu.certus.empsys.controller.jobs;

import edu.certus.empsys.entity.categoria.model.Categoria;
import edu.certus.empsys.entity.vacante.model.Vacante;
import edu.certus.empsys.service.contract.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value= "/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {

        // TODO 1. Obtener todas las vacantes (recuperar con la clase de servicio)
        List<Categoria> listaCategorias = categoriaService.obtenerTodasLasCategorias();

        // TODO 2. Agregar al modelo el listado de vacantes.
        model.addAttribute("categorias", listaCategorias);

        return "categorias/listCategorias";
    }

    @GetMapping("/create")
    public String crear(Categoria categoria) {
        return "categorias/formCategorias";

    }

    @PostMapping("/save")
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrió un error: " + error.getDefaultMessage());
            }
            return "categorias/formCategorias"; // Redirecciona al formulario para mostrar errores
        }
        categoriaService.guardarCategoria(categoria);
        redirectAttributes.addFlashAttribute("mensaje", "Categoría guardada exitosamente!");
        System.out.println("Categoria: " + categoria);
        return "redirect:/categorias/index"; // Redirecciona a la lista de vacantes
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idCategoria, Model model) {

        System.out.println("Borrando categoria con id: " + idCategoria);

        model.addAttribute("id", idCategoria);

        return "mensaje";
    }

    @GetMapping("/view/{id}")
    public String verDetalles(@PathVariable("id") int idCategoria, Model model) {

        Categoria categoria = categoriaService.buscarCategoriaPorId(idCategoria);

        System.out.println("Categoría: " + categoria.getId());

        model.addAttribute("categoria", categoria);

        // return "vacantes/detalle"; = el "vacante/" es por que el archivo anterior
        // estaba en una carpeta

        return "detalle";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    }
}
