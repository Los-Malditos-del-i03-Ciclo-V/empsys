package edu.certus.empsys.controller.jobs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "/categorias")
public class CategoriaController {

    @GetMapping("/index")
    //@RequestMapping(value="/index", method=RequestMethod.GET)
    public String mostrarIndex(Model model) {

        return "categorias/listCategorias";

    }

    @GetMapping("/create")
    //@RequestMapping(value="/create", method=RequestMethod.GET)
    public String crear() {

        return "categorias/formCategoria";

    }

    @PostMapping("/save")
    //@RequestMapping(value="/save", method=RequestMethod.POST)
    public String guardar(String nombre, String descripcion) {

        System.out.println("Categorias: " + nombre);
        System.out.println("Descripcion: " + descripcion);

        return "categorias/listCategorias";
    }
}
