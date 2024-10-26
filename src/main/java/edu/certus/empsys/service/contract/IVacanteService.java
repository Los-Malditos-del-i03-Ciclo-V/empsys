package edu.certus.empsys.service.contract;

import edu.certus.empsys.entity.vacante.model.Vacante;

import java.util.List;

public interface IVacanteService {

    List<Vacante> obtenerTodasLasVacantes();

    Vacante obtenerVacantePorId(Integer id);

    void guardarVacante(Vacante vacante);

//    void eliminarVacantePorId(Integer id);

}
