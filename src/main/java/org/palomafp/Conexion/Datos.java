package org.palomafp.Conexion;

/*
Clase de utilidades varis para el manejo de datos de la aplicacion cmo entrada de texto y manejo de errores
 */
public class Datos {

    private Conexion c1;

    public Datos(Conexion c1) {
        this.c1 = c1;
    }
/*
este metodo maneja los errores al meter valores numericos invalidos
 */
    public int numero(int menor, int mayor, String error) {
        int evaluar = this.c1.getS2().nextInt();
        do {
            if (menor <= evaluar && mayor >= evaluar) {
            } else {
                System.out.println(error);
                evaluar = this.c1.getS2().nextInt();
            }
        } while (menor <= evaluar && mayor >= evaluar);
        return evaluar;
    }
/*
este metodo recoge texto por pantalla y le da un formato mediante el siguente metodo
 */
    public String texto() {
        return format(this.c1.getS2().next());
    }
/*
este metodo formatea el texto le quita los espacios alante y atras y lo pone en minusculas
 */
    public String format(String dato) {
        String trimmed = dato.trim();

        return trimmed.toLowerCase();

    }
}
