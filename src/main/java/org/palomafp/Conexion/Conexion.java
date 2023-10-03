package org.palomafp.Conexion;

import lombok.Data;
import lombok.Getter;
import org.palomafp.Contactos.Contacto;

import java.io.*;
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
    public Conexion(String path) throws IOException {
        File file =new File(path);
        this.sc = new Scanner(file);
        this.s2= new Scanner(System.in);
        this.txt = new PrintWriter (new FileWriter(path,true));
    }
    public void cerrar(){
        this.sc.close();
        this.s2.close();
        this.txt.close();
    }
    public void escribir(Contacto nuevo){
        String linea = nuevo.toCsv();
        this.txt.println(linea);

    }

}
