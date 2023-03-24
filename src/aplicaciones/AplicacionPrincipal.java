package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import igu.panelPrincipal;

public class AplicacionPrincipal {
	//---------metodo main inicia la ejecucion--------------------------------------------------------------	
		public static void main(String[] args) {
	//---------llamo la clase panelPrincipal y genero el Objeto miAplicacion dentro de un try/catch, agrego un mensaje de orientacion de usuario-----------------------------------
			
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						panelPrincipal miAplicacion = new panelPrincipal();
						miAplicacion.setVisible(true);
						JOptionPane.showMessageDialog(null, "SELECCIONE EL CONVERSOR EN EL MENU O LA BARRA DE HERRAMIENTAS");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
}
