package org.palomafp.Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.palomafp.Contactos.Contacto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//comentario en la clase agenda
@AllArgsConstructor @Data
public class Agenda {
    private List<Contacto> contactos;
    private int agenda;

    public Contacto bucarUUID(UUID id){
        Optional<Contacto> resultado = null;
        for (Contacto persona: contactos) {
            if ( persona.getId().equals(id)){
                resultado = Optional.of(persona); // Assign the matching persona to resultado            }
        }}
        return resultado.get();
    }
    public Contacto buscarNombre(String nombre){
        Optional<Contacto> resultado = null;
        for (Contacto persona: contactos) {
            if ( persona.getNombre().equals(nombre) && !persona.getId().equals(new UUID(0,0))){
                resultado = Optional.of(persona); // Assign the matching persona to resultado            }
            }}
        return resultado.get();
    }

    public void mostrarLista(){
        for (Contacto persona: contactos) {
            System.out.println(persona.toString());
        }
    }
    public void borrar (Contacto persona){
        persona.setId(new UUID(0,0));
    }
    public void añadir(){}
}
