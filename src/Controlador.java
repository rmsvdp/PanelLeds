import Tools.Menu;
import java.util.Scanner;

import Panel2D.PanelLed;

/**
 * Editor de Panel de Leds    
 * Versión : BETA 2
 * TODO     No está terminada completamente la gestión de las posiciones
 * 			- eliminar y reasignar posición
 * 			- escritura a fichero para edición más cómoda
 *          - Optimizar gestión del panel
 * @author root
 * FECHA : 04/03/2025
 */

public class Controlador {
   public Controlador() {
   }

   public static void main(String[] args) {
      PanelLed av = null;
      String[] opciones = new String[]{"Define Tablero", "Editar Figura", "Editar Posiciones"};
      boolean finSesion = false;
      boolean inicializado = false;
      Menu menuPrincipal = new Menu(opciones);
      menuPrincipal.setTitulo("Editor de Panel de Leds");

      while(!finSesion) {
    	  
         menuPrincipal.mostrarMenu();
         int result = menuPrincipal.eligeOpcion();
         switch (result) {
            case 0:
               if (inicializado) {
                  System.out.println("------------------------------------------------------");
                  System.out.println("\nCaptura las posiciones que aparecen en este terminal\npara definir la tira de leds en tu programa y");
                  System.out.println("Cierra la ventana para terminar la Aplicaci\u00f3n ...");
               }
               finSesion = true;
               break;
            case 1:
               if (!inicializado) {
                  Scanner sc = new Scanner(System.in);
                  System.out.print("Filas del tablero >?");
                  int alto = sc.nextInt();
                  System.out.print("Columnas del tablero >?");
                  int ancho = sc.nextInt();
                  av = new PanelLed(ancho, alto);
                  av.turnOff();
                  inicializado = true;
               }
            case 2:
               if (inicializado) {
                  System.out.println("------------------------------------------------------");
                  System.out.println("\nEntrando en modo edici\u00f3n Figura:\nHaciendo click en la celda se activa/desactiva posici\u00f3n\n");
                  av.setMode(0);
                  System.out.println("------------------------------------------------------");
               } else {
                  System.out.println("Inicializa el tablero primero!");
               }
               break;
            case 3:
               if (inicializado) {
                  System.out.println("------------------------------------------------------");
                  System.out.println("\nEntrando en modo edici\u00f3n Posciones:\nLa rejilla acepta clicks para marcar/desmarcar celdas\n");
                  av.setMode(1);
                  System.out.println("------------------------------------------------------");
               } else {
                  System.out.println("Inicializa el tablero primero!");
               }
         }
      }

      System.out.println("------------------------------------------------------");
   }
}
