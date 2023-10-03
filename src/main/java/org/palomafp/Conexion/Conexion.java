package org.palomafp.Conexion;

import lombok.Data;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
@Getter
public class Conexion {
    public Scanner sc;


    public Conexion(Scanner sc) throws FileNotFoundException {
        this.sc = new Scanner(new File("//src//agenda.csv"));
    }
    public void cerrar(){
        this.sc.close();
    }

    public  int leerNumer(int n1, int n2) {
        boolean trigger = false;

        int introducido = sc.nextInt();
        do {
            if (n1 <= introducido && introducido <= n2) {
                trigger = true;
            } else {
                System.out.println("Opcion no valida ");
                introducido = sc.nextInt();
            }
        } while (!trigger);

        return introducido;
    }
}
