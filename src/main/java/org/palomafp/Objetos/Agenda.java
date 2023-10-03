package org.palomafp.Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.palomafp.Conexion.Conexion;
import org.palomafp.Contactos.Contacto;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//clase  que genera una agenda de contactos en tu programa mediante un csv
@Data
public class Agenda {
/*
lista de contactos
 */
    private List<Contacto> contactos = new LinkedList<Contacto>();
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
            String[] csv = c1.getSc().next().split(",");

            for (int i = 0; i < csv.length; i++) {
                String dato = csv[i];
                csv[i]=csv[i].substring(1, csv[i].length() - 1);
            }

            Contacto contacto1 = new Contacto(UUID.fromString(csv[0]), csv[1], csv[2], Integer.parseInt(csv[3]));
            if(contacto1!=null){
            this.contactos.add(contacto1);}else {
                System.out.println("no tienes contactos");
            }
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
    public List<Contacto> buscarNombre(String nombre) {
        List<Contacto> resultado= new LinkedList<Contacto>();
        for (Contacto persona : contactos) {
            if (persona.getNombre().contains(nombre) && !persona.getId().equals(new UUID(0, 0))) {
                resultado.add(persona);
            }
        }
        return resultado;
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
    //todo : hay que hacer este metodo que peta el resto funciona
    public void borrar(Contacto persona) {
        String
        persona.setId(new UUID(0, 0));
        persona
    }
/*
    añade al csv un contacto
 */
    public void anadir(String nombre,String telefono,int edad) {
        Contacto nuevo= new Contacto(UUID.randomUUID(),nombre,telefono,edad);
        this.c1.escribir(nuevo);
    }
    /*
    referesca los contactos en la agenda
     */
    public void refrescar(){
        contactos();
    }
}
