package edu.certus.empsys.entity.vacante.factory;

import edu.certus.empsys.entity.vacante.model.Vacante;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VacanteFactory {

    public static List<Vacante> listaDeVacantes = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    Vacante vacante1, vacante2, vacante3, vacante4;

    {
        try {
            vacante1 = Vacante.builder()
                    .id(1)
                    .nombre("Desarrollador Java")
                    .descripcion("Desarrolla aplicaciones web y aplicaciones móviles en Java")
                    .fecha(sdf.parse("08-02-2019"))
                    .salario(15000.0)
                    .destacado(1)
                    .imagen("desarrollador_java.jpg")
                    .build();

            vacante2 = Vacante.builder()
                    .id(2)
                    .nombre("Desarrollador.NET")
                    .descripcion("Desarrolla aplicaciones web y aplicaciones móviles en.NET")
                    .fecha(sdf.parse("08-02-2019"))
                    .salario(15000.0)
                    .destacado(1)
                    .imagen("desarrollador_net.jpg")
                    .build();

            vacante3 = Vacante.builder()
                    .id(3)
                    .nombre("Desarrollador PHP")
                    .descripcion("Desarrolla aplicaciones web y aplicaciones móviles en PHP")
                    .fecha(sdf.parse("08-02-2019"))
                    .salario(15000.0)
                    .destacado(1)
                    .imagen("desarrollador_php.jpg")
                    .build();

            vacante4 = Vacante.builder()
                    .id(4)
                    .nombre("Desarrollador.NET")
                    .descripcion("Desarrolla aplicaciones web y aplicaciones móviles en.NET")
                    .fecha(sdf.parse("08-02-2019"))
                    .salario(15000.0)
                    .destacado(1)
                    .imagen("desarrollador_net.jpg")
                    .build();

            listaDeVacantes.add(vacante1);
            listaDeVacantes.add(vacante2);
            listaDeVacantes.add(vacante3);
            listaDeVacantes.add(vacante4);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}