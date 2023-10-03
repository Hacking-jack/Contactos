package org.palomafp.Contactos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor@Data
public class Contacto {
    private UUID id;
    private String nombre;
    private String telefono;
    private int edad;

}
