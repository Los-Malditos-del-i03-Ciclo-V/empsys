package edu.certus.empsys.controller.core;

import edu.certus.empsys.entity.vacante.model.Vacante;
import edu.certus.empsys.service.contract.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IVacanteService vacanteService;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {

        List<Vacante> lista = vacanteService.obtenerTodasLasVacantes();

        model.addAttribute("vacante", lista);

        return "vacantes";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {

        Vacante vacante =  Vacante.builder()
                .nombre("Ingeniero electrónico")
                .descripcion("Se solicita un Ingeniero electrónico")
                .fecha(new Date())
                .salario(4000.00)
                .build();

        model.addAttribute("vacante", vacante);

        return "detalle";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {

        List<String> lista= new LinkedList<String>();

        lista.add("Ingeniería de sistemas");
        lista.add("Marketing");
        lista.add("Contador");

        model.addAttribute("empleos", lista);

        return "listado";
    }

    @GetMapping("/")
    public String mostrarHome(Model model) {

        List<Vacante> lista = vacanteService.obtenerTodasLasVacantes();

        model.addAttribute("vacantes", lista);

        return "home";
    }

}
