package Panel2D;

import java.awt.Color;

public class Led {
   Color c;
   int pos_led;
   int pos_tab_fila;
   int pos_tab_columna;


   public Led(int pos) {
      this.c = Color.BLACK;
      this.pos_led = pos;
      this.pos_tab_fila = 0;
      this.pos_tab_columna = 0;
   }
   public Color getC() 									{      return this.c;   }
   public void setC(Color c) 							{      this.c = c;   }
   public int getPos_led() 								{      return this.pos_led;   }
   public void setPos_led(int pos_led) 					{      this.pos_led = pos_led;   }
   public int getPos_tab_fila() 						{      return this.pos_tab_fila;   }
   public void setPos_tab_fila(int pos_tab_fila) 		{      this.pos_tab_fila = pos_tab_fila;   }
   public int getPos_tab_columna() 						{      return this.pos_tab_columna;   }
   public void setPos_tab_columna(int pos_tab_columna) 	{      this.pos_tab_columna = pos_tab_columna;   }
}
