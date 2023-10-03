package org.palomafp;

import java.util.Scanner;

import org.palomafp.Objetos.Agenda;

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
    			"5 " + "Borrar un contacto" + "\n"+
						"0 Salir"
    			);
    	int num = 0;
    	switch (num) {

    	case 1 :

    	case 2 :
    		
    	case 3 :
    		
    	case 4 :
    		
    	case 5 :
    		
    	default :
    		System.out.println("Fin del programa");
    	}
    	return num;
    }
}
