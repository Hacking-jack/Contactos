package org.palomafp.Conexion;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.palomafp.Contactos.Contacto;

import java.io.*;
import java.util.Scanner;
@Getter
@Setter
/*
Clase diseñada para la proveer entradas y salidas de datos de una unica vez
 */
public class Conexion {
    private File file;
    private Scanner sc;
    protected Scanner s2;
    private PrintWriter txt;
/*
Construxtor de la calse iniclaliza todos los IO del programa
 */
    public Conexion(String path) throws IOException {
        this.file =new File(path);
        this.sc = new Scanner(this.file);
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
    public void vaciar() throws IOException {
        FileWriter fileWriter = new FileWriter(this.file);

        // Crear un PrintWriter para escribir en el archivo
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.close();
    }

    }
