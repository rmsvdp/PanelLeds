package Tools;
import java.util.Scanner;

public class Menu {
   private String[] opciones;
   private int eleccion = 0;
   public String titulo = "";
   private int numOpc = 0;

   public Menu() {
      this.eleccion = 0;
      this.titulo = "";
      this.numOpc = 0;
   }

   public Menu(String[] opc) {
      this.opciones = opc;
      this.numOpc = opc.length;
      this.titulo = "MENU DE OPCIONES";
   }

   public String getTitulo() {
      return this.titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String[] getOpciones() {
      return this.opciones;
   }

   public void setOpciones(String[] opciones) {
      this.opciones = opciones;
   }

   public int getEleccion() {
      return this.eleccion;
   }

   public void setEleccion(int eleccion) {
      if (this.eleccion >= 0 && this.eleccion < this.numOpc) {
         this.eleccion = eleccion;
      }

   }

   public void mostrarMenu() {
      System.out.println(this.titulo);
      System.out.println("-".repeat(this.titulo.length()));

      for(int j = 0; j < this.opciones.length; ++j) {
         System.out.println(j + 1 + ".- " + this.opciones[j]);
      }

      System.out.println("0.- Salir\n");
   }

   public int eligeOpcion() {
      int opc = 0;
      boolean valido = false;
      Scanner scr = new Scanner(System.in);

      while(true) {
         while(!valido) {
            System.out.print("Elige opci\u00f3n:");
            opc = scr.nextInt();
            if (opc >= 0 && opc <= this.opciones.length) {
               valido = true;
               System.out.println();
            } else {
               System.out.println("Opci\u00f3n no v\u00e1lida");
            }
         }

         this.eleccion = opc;
         return opc;
      }
   }

   public String muestraLiteral(int opc) {
      String cadena = "";
      if (opc == 0) {
         cadena = "Salir";
      } else if (opc >= 1 && opc < this.numOpc) {
         cadena = this.opciones[opc - 1];
      }

      return cadena;
   }
}
