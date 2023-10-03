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
//clase  que genera una agenda de contactos en tu programa mediante un csv
@Data
public class Agenda {
/*
lista de contactos
 */
    private List<Contacto> contactos;
    /*
    conexion
     */
    private Conexion c1;

    public Agenda(Conexion c1) {
        this.c1 = c1;
        contactos();
    }
/*
carga el contenido del csv a un lista de contactos por objetos
 */
    private void contactos() {

        while (c1.getSc().hasNext()) {
            String csv = c1.getSc().next().substring(1);
            String csv1 = csv.substring(0, csv.length() - 1);
            String[] datos = csv1.split(" \",\" ");
            Contacto contacto1 = new Contacto(UUID.fromString(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]));
            this.contactos.add(contacto1);
        }


    }
/*
busca un uuid mediante uuid
 */
    public Contacto bucarUUID(UUID id) {
        Optional<Contacto> result = null;
        for (Contacto persona : contactos) {
            if (persona.getId().equals(id)) {
                result = Optional.of(persona); // Assign the matching persona to resultado            }
            }
        }
        return result.get();
    }
/*
busca un contacto mediante su nombre
 */
    public Contacto buscarNombre(String nombre) {
        Optional<Contacto> result = null;
        for (Contacto persona : contactos) {
            if (persona.getNombre().equals(nombre) && !persona.getId().equals(new UUID(0, 0))) {
                result = Optional.of(persona); // Assign the matching persona to resultado
            }
        }
        return result.get();
    }
/*
muestra todos los contactos de la lista
 */
    public void mostrarLista() {
        for (Contacto persona : contactos) {
            System.out.println(persona.toString());
        }
    }
/*
borra el contacto al asignar su uuid a 0 todos los numeros
 */
    public void borrar(Contacto persona) {
        persona.setId(new UUID(0, 0));
    }

    public void anadir() {

    }
}
