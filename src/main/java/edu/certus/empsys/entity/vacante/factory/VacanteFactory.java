package edu.certus.empsys.entity.vacante.factory;

import edu.certus.empsys.entity.vacante.model.Vacante;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VacanteFactory {

    public static List<Vacante> listaDeVacantes = new ArrayList<>();

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void crearVacante(int id, String nombre, String descripcion, String fecha, double salario, int destacado, String imagen) {
        try {

            Vacante vacante = Vacante.builder()
                    .id(id)
                    .nombre(nombre)
                    .descripcion(descripcion)
                    .fecha(sdf.parse(fecha))
                    .salario(salario)
                    .destacado(destacado)
                    .imagen(imagen)
                    .build();

            listaDeVacantes.add(vacante);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        crearVacante(
                1,
                "Desarrollador Java",
                "Desarrolla aplicaciones web y aplicaciones móviles en Java",
                "08-02-2019",
                15000.0,
                1,
                "logo1.png"
        );
        crearVacante(
                2,
                "Desarrollador .NET",
                "Desarrolla aplicaciones web y aplicaciones móviles en .NET",
                "08-02-2019",
                15000.0,
                1,
                "logo2.png"
        );

        crearVacante(
                3,
                "Desarrollador PHP",
                "Desarrolla aplicaciones web y aplicaciones móviles en PHP",
                "08-02-2019",
                15000.0,
                1,
                "logo3.png"
        );
        crearVacante(
                4,
                "Desarrollador Ruby",
                "Desarrolla aplicaciones web y aplicaciones móviles en Ruby",
                "08-02-2019",
                15000.0,
                1,
                "logo4.png"
        );


    }


}