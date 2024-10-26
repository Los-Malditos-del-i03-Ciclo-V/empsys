package edu.certus.empsys.service.provider;

import edu.certus.empsys.entity.vacante.model.Vacante;
import edu.certus.empsys.service.contract.IVacanteService;
import org.springframework.stereotype.Service;

import java.util.List;

import static edu.certus.empsys.entity.vacante.factory.VacanteFactory.listaDeVacantes;

@Service
public class VacanteServiceImpl implements IVacanteService {

    @Override
    public List<Vacante> obtenerTodasLasVacantes() {
        return listaDeVacantes;
    }

    @Override
    public Vacante obtenerVacantePorId(Integer id) {
        for (Vacante vacante: listaDeVacantes) {
            if(vacante.getId() == id) {
                return vacante;
            }
        }
        return null;
    }

    @Override
    public void guardarVacante(Vacante vacante) {
        listaDeVacantes.add(vacante);
    }
}
