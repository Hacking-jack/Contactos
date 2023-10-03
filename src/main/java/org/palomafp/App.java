package org.palomafp;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int accion = 0;
    	do{
    	accion = menu(); 	
    	}while(accion != 0);
    }
    
    public static int menu() {
    	System.out.println("¿Que quieres hacer?");
    	System.out.println(
    			"1 " + "Buscar por código de usuario" + "\n" +
    			"2 " + "Buscar por el comienzo del nombre" +  "\n" +
    			"3 " + "Mostrar la agenda completa" + "\n" +
    			"4 " + "Añadir un contacto" + "\n" +
    			"5 " + "Borrar un contacto" + "\n" 
    			);
    	int num = 0;
    	switch (num) {
    	
    	case 1 :
    		System.out.println("Introduce la clave del usuario");
    		buscarUUID();
    	case 2 :
    		System.out.println("Introduce el nombre por el que buscar");
    		buscarNombre();
    	case 3 :
    		System.out.println("Agenda");
    		mostrarLista();
    	case 4 :
    		System.out.println("Introduce los datos del usuario");
    		anadir();
    	case 5 :
    		System.out.println("Introduce la clave del usuario que quieras eliminar");
    		borrar();
    	default :
    		System.out.println("Fin del programa");
    	}
    	return num;
    }
}
