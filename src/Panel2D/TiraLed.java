package Panel2D;

import java.awt.Color;

public class TiraLed {
   int idTira = 0;
   int numLeds;
   int head;
   Led[] leds;

   public TiraLed(int num) {
      if (num > 0 && num < 128) {
         this.leds = new Led[num];
         this.numLeds = num;
         this.initTira();
      }

   }

   public int getnumLeds() {      return this.numLeds;   }
   public int getHead() {      return this.head;   }
   public Led getLed(int posicion) {      return this.leds[posicion];   }

   public void setHead(int head) {
      if (head >= 0 && head < this.numLeds) {
         this.head = head;
      }

   }

   public void initTira() {
      for(int i = 0; i < this.numLeds; ++i) {
         this.leds[i] = new Led(i);
      }

      this.clear();
      this.head = 0;
   }

   public void clear() {
      this.allLeds(Color.BLACK);
   }

   public void allLeds(Color _color) {
      for(int i = 0; i < this.numLeds; ++i) {
         this.leds[i].c = _color;
      }

   }

   public void drawLine(int ini, int fin, Color _color) {
      int com;
      int des;
      byte inc;
      if (ini <= fin) {
         com = ini;
         des = fin;
         inc = 1;
      } else {
         com = fin;
         des = ini;
         inc = -1;
      }

      for(int i = com; i <= des; i += inc) {
         this.leds[i].c = _color;
      }

   }

   public void shiftHead(int dir, Color _color, boolean persist) {
      int tmpPos = this.head;
      if (!persist) {
         this.leds[tmpPos].c = Color.BLACK;
      }

      tmpPos += dir;
      if (tmpPos < 0) {
         tmpPos = this.numLeds - 1;
      }

      if (tmpPos == this.numLeds) {
         tmpPos = 0;
      }

      this.leds[tmpPos].c = _color;
      this.head = tmpPos;
   }

   public void locateLeds(int[][] posiciones) {
      if (posiciones.length == this.numLeds) {
         for(int i = 0; i < this.numLeds; ++i) {
            this.leds[i].pos_tab_fila = posiciones[i][0];
            this.leds[i].pos_tab_columna = posiciones[i][1];
         }
      }

   }
}
