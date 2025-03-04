import Panel2D.PanelLed;
import Panel2D.TiraLed;
import java.awt.Color;
public class PanleLedDemo {

	public static void main(String[] args) {

		PanleLedDemo app = new PanleLedDemo();
		app.run();
		
	}

	public void run() {
		
		Demo();
	}
	
	public  void Demo() {
		
		PanelLed av = new PanelLed (8,8);
		av.turnOff();
		Color[] _color = {av.negro,av.azul,av.cyan,av.verde,av.naranja,av.amarillo,av.magenta,av.rojo,av.gris,av.blanco};
		
//		 Acceso directo al panel 
		for (int i = 1;i<_color.length;i++) {
			av.squareDemo(_color[i],25);
			}
		av.turnOff(); 	
		av.delay(500);
//------------------------------------- Led cuadrado de 3 x 3		
		TiraLed t1 = new TiraLed(8);
		int pos1[][] = {
						{1,1},{1,2},{1,3},{2,1},{2,3},{3,1},{3,2},{3,3},
		                {2,2},{2,3},{2,4},{3,4},{4,4},{4,3},{4,2},{3,2}
		                };
		t1.locateLeds(pos1);

		for (int i = 1;i<_color.length;i++) {
			t1.allLeds(_color[i]);  //Actualizo los leds
			av.refresh(t1);			
			}

//------------------------------------- Rombo 4 x 4
		TiraLed t2 = new TiraLed(12);
		int pos2[][] = {{1,3},{2,2},{2,4},{3,1},{3,5},{4,0},{4,6},{5,1},{5,5},{6,2},{6,4},{7,3}};
		t2.locateLeds(pos2);			
		av.turnOff(); 
		for (int i = 1;i<_color.length;i++) {
			t2.allLeds(_color[i]);  //Actualizo los leds
			av.refresh(t2);
			av.delay(500);
			}
		av.turnOff();
//------------------------------------- Rectángulo 3 x 12
		TiraLed t3 = new TiraLed(18);
		int pos3[][] = {{5,0},{5,1},{5,2},{5,3},{5,4},{5,5},{5,6},{5,7},{6,7},{7,7},{7,6},{7,5},{7,4},{7,3},{7,2},{7,1},{7,0},{6,0}};
		t3.locateLeds(pos3);		
		for (int i = 1;i<_color.length;i++) {
			t3.allLeds(_color[i]);  //Actualizo los leds
			av.refresh(t3);
			av.delay(500);
			}
		av.turnOff();
		int j=0;
		TiraLed t0;
		t0 = t3;
		do {
			t0.setHead(0);
			for (int i = 0;i<t0.getnumLeds();i++) {
				t0.shiftHead(1, Color.YELLOW, true);
				av.refresh(t0);
				av.delay(250);
				}
			j++;
		}
		while (j<1);
		av.turnOff();
		
	} // Demo

	
	
	
}
