package org.palomafp.Contactos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
/*
Clase generadira de los objetos Contacto que van a contener los datos de al agenda
 */
@AllArgsConstructor@Data
public class Contacto {
    private UUID id;
    private String nombre;
    private String telefono;
    private int edad;
public String toCsv(){
    String csv = '"'+id.toString()+ "\",\"" +nombre+ "\",\"" +telefono+ "\",\"" +edad+'"';
    return csv;
}

}
