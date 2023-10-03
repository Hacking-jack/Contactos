package org.palomafp.Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.palomafp.Conexion.Conexion;
import org.palomafp.Contactos.Contacto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//comentario en la clase agenda
@RequiredArgsConstructor
@Data
public class Agenda {

    private List<Contacto> contactos;
    @NonNull
    private Conexion c1;

    public Agenda(Conexion c1) {
        this.contactos = contactos();
    }
    private List<Contacto> contactos(){
        Optional<List<Contacto>> resultado = null;

        while (c1.getSc().hasNext()){
            String csv = c1.getSc().next().substring(1);
            String csv1= csv.substring(0,csv.length()-1);
            String [] datos = csv1.split(" \",\" ");
            Contacto contacto1 = new Contacto(UUID.fromString(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]));
            this.contactos.add(contacto1);
        }

        return resultado.get();
    }
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
    public void anadir(){

    }
}
