package org.palomafp.Conexion;

import lombok.Data;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
@Getter
/*
Clase diseñada para la proveer entradas y salidas de datos de una unica vez
 */
public class Conexion {
    private Scanner sc;
    protected Scanner s2;
    private PrintWriter txt;
/*
Construxtor de la calse iniclaliza todos los IO del programa
 */
    public Conexion(String path) throws FileNotFoundException {
        File file =new File(path);
        this.sc = new Scanner(file);
        this.s2= new Scanner(System.in);
        this.txt = new PrintWriter(file);
    }
    public void cerrar(){
        this.sc.close();
        this.s2.close();
    }

}
