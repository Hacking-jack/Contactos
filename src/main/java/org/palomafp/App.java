package org.palomafp;

import java.io.FileNotFoundException;
import java.util.UUID;

import org.palomafp.Conexion.Conexion;
import org.palomafp.Conexion.Datos;
import org.palomafp.Contactos.Contacto;
import org.palomafp.Objetos.Agenda;

/**
 * Hello world!
 */
public class App {
    /*
        El metodo lazador del programa, aqui inicializamos los objetos indispensables para el funcionamiento de la aplicacion
        e introducimos el nombre de la agenda de contactos ( el archivo csv )
     */
    public static void main(String[] args) {
        try {
            Conexion c1 = new Conexion("agenda.csv");
            Agenda agenda1 = new Agenda(c1);
            Datos utilidades = new Datos(c1);

            int accion = 0;

            do {
                accion = menu(utilidades, agenda1);
            } while (accion != 0);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
/*
*
* Esta metodo muestra un menu y solicita que accion quieres realizar.
*
*/
    public static int menu(Datos utilidades, Agenda agenda1) {
        System.out.println("¿Que quieres hacer?");
        System.out.println(
                "1 " + "Buscar por código de usuario" + "\n" +
                        "2 " + "Buscar por el comienzo del nombre" + "\n" +
                        "3 " + "Mostrar la agenda completa" + "\n" +
                        "4 " + "Añadir un contacto" + "\n" +
                        "5 " + "Borrar un contacto" + "\n" +
                        "0 Salir"
        );
        int num = utilidades.numero(0, 5, "Numero invalido");
        switch (num) {

            case 1:
                System.out.println(agenda1.bucarUUID(UUID.fromString(utilidades.texto())));
                break;
            case 2:
                System.out.println(agenda1.buscarNombre(utilidades.texto()));
                break;

            case 3:
               agenda1.mostrarLista();
                break;

            case 4:

                break;

            case 5:
                System.out.println("Introduce el id de un contacto que quieras borrar");
                Contacto borrarContacto = agenda1.bucarUUID(UUID.fromString(utilidades.texto()));
                System.out.println("Tu contacto es : "+borrarContacto.toString());
                int seguro = utilidades.numero(0,1,"Dato no valido");
                if(seguro==1){
                agenda1.borrar(borrarContacto);
                    System.out.println("Contacto borrado");
                }else {
                    System.out.println("Entendido");
                }
                break;

            default:
                System.out.println("Fin del programa");
                break;
        }
        return num;
    }
}
