package edu.certus.empsys.controller.jobs;

import edu.certus.empsys.entity.vacante.model.Vacante;
import edu.certus.empsys.service.contract.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class VacanteController {

    @Autowired
    private IVacanteService vacanteService;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {

        // TODO 1. Obtener todas las vacantes (recuperar con la clase de servicio)
        List<Vacante> listaVacantes = vacanteService.obtenerTodasLasVacantes();

        // TODO 2. Agregar al modelo el listado de vacantes.
        model.addAttribute("vacantes", listaVacantes);

        // TODO 3. Rederizar las vacantes en la vista (integrar el archivo
        // template-empleos/listVacantes.html).

        // TODO 4. Agregar al menu una opción llamada "Vacantes" configurando la URL
        // "vacantes/index"

        return "vacantes/listVacantes";
    }

    @GetMapping("/create")
    public String crear() {

        return "vacantes/formVacante";

    }

    @PostMapping("/save")
    public String guardar(Vacante vacante) {

        vacanteService.guardarVacante(vacante);

        return "redirect:/vacantes/index";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {

        System.out.println("Borrando vacante con id: " + idVacante);

        model.addAttribute("id", idVacante);

        return "mensaje";
    }

    @GetMapping("/view/{id}")
        public String verDetalles(@PathVariable("id") int idVacante, Model model) {

            Vacante vacante = vacanteService.obtenerVacantePorId(idVacante);

        System.out.println("Vacante: " + vacante.getId());

        model.addAttribute("vacante", vacante);

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