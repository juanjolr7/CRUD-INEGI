package com.conexion;

import com.objects.Entidad;
import com.objects.Municipio;

/**
 *
 * @author juanj
 */
public class Test {
    public static void main(String[] args) {
        new MunicipioDAO().seleccionar().forEach(System.out::println);
        System.out.println("daleee");
        new EntidadDAO().actualizar(new Entidad(500, "nuevo municipio"),0);
        System.out.println("yaaa");
        new MunicipioDAO().seleccionar().forEach(System.out::println);
    }
}
