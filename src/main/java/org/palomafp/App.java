package org.palomafp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.UUID;

import org.palomafp.Conexion.Conexion;
import org.palomafp.Conexion.Datos;
import org.palomafp.Contactos.Contacto;
import org.palomafp.Objetos.Agenda;

/**
 * Main del programa
 */
public class App {
    /*
        El metodo lazador del programa, aqui inicializamos los objetos indispensables para el funcionamiento de la aplicacion
        e introducimos el nombre de la agenda de contactos ( el archivo csv )
     */
    public static void main(String[] args) {
        try {
            Conexion c1 = new Conexion("src//main//java//org//palomafp//agenda.csv");
            Agenda agenda1 = new Agenda(c1);
            Datos utilidades = new Datos(c1);

            int accion = 0;

            do {
                accion = menu(utilidades, agenda1);
            } while (accion != 0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
     *
     * Esta metodo muestra un menu y solicita que accion quieres realizar.
     *
     */
    public static int menu(Datos utilidades, Agenda agenda1) throws IOException {
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
                try{
                System.out.println(agenda1.bucarUUID(UUID.fromString(utilidades.texto("Introduece UUID"))));}
                catch (Exception e){
                    System.out.println("UUID no valido");
                }
                agenda1.refrescar();

                break;
            case 2:
                List<Contacto> lista= agenda1.buscarNombre(utilidades.texto("INtroduce un nombre para buscar"));
                Iterator<Contacto> it = lista.iterator();
                while(it.hasNext()){
                    System.out.println( it.next());
                }
                agenda1.refrescar();

                break;

            case 3:
                agenda1.mostrarLista();
                break;

            case 4:
                String nombre = utilidades.texto("Introduce el nombre del contacto");
                String telefono = utilidades.texto("Introduce el telefono del contacto");
                System.out.println("Introduce la edad de tu contacto");
                int edad = utilidades.numero(0, 150, "Esa edad es demasiado alta");
                agenda1.anadir(nombre,telefono,edad);
                agenda1.refrescar();
                break;

            case 5:
                System.out.println("Introduce el id de un contacto que quieras borrar");
                Contacto borrarContacto = agenda1.bucarUUID(UUID.fromString(utilidades.texto()));
                System.out.println("Tu contacto es : " + borrarContacto.toString());
                System.out.println("Quieres borrarlo? 1 si 0 no");
                int seguro = utilidades.numero(0, 1, "Dato no valido");
                if (seguro == 1) {
                    agenda1.borrar(borrarContacto);
                    System.out.println("Contacto borrado");
                    agenda1.refrescar();
                } else {
                    System.out.println("Entendido");
                }
                agenda1.refrescar();
                break;

            default:
                System.out.println("Fin del programa");
                utilidades.cerrar();
                break;
        }
        return num;
    }
}
