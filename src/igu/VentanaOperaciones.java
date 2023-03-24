package igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.OperacionesMatematicas;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaOperaciones extends JInternalFrame implements ActionListener, KeyListener {

	//-----------declaro variables de tipo elementos graficos--------------------------
		private JPanel panelPrincipal;
		private JTextField txtCamp1;
		private JTextField txtCamp2;
		JButton btnSuma, btnResta, btnMult, btnDivide;// declaradas con el elemento grafico automaticamente y sacadas luego
														// como variables globales

		OperacionesMatematicas misOperaciones;
		private JLabel lblResultado;
		
		KeyListener eventoTeclado;

	//-----------creo el constructor de clase--------------	
		public VentanaOperaciones() {
			setFrameIcon(new ImageIcon(VentanaOperaciones.class.getResource("/iconos16/icon_calculadora216.jpg")));
			setIconifiable(true);
			setMaximizable(true);
			setClosable(true);

			iniciarComponentes();// llamo al metodo inciarComponentes
			setTitle("CALCULADORA");
			

		}
	
	//----------fin constructor--------------------------------	

	//----------creo el metodo iniciarComponentes que contiene todos los componentes graficos-------		
		private void iniciarComponentes() {

			setBounds(100, 100, 496, 386);
			panelPrincipal = new JPanel();
			panelPrincipal.setForeground(new Color(0, 0, 0));
			panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(panelPrincipal);
			panelPrincipal.setLayout(null);

			JLabel lblTitulo = new JLabel("OPERACIONES MATEMATICAS");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setForeground(new Color(0, 0, 0));
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
			lblTitulo.setBounds(10, 48, 414, 14);
			panelPrincipal.add(lblTitulo);
			txtCamp1 = new JTextField();
			txtCamp1.addKeyListener(this);//escuho el caracter introducido
			
			txtCamp1.setBounds(162, 85, 200, 20);
			panelPrincipal.add(txtCamp1);
			txtCamp1.setColumns(10);

			JLabel lblCamp1 = new JLabel("NUMERO 1");
			lblCamp1.setBounds(79, 88, 85, 14);
			panelPrincipal.add(lblCamp1);

			JLabel lblCamp2 = new JLabel("NUMERO 2");
			lblCamp2.setBounds(79, 119, 85, 14);
			panelPrincipal.add(lblCamp2);

			txtCamp2 = new JTextField();
			txtCamp2.addKeyListener(this);//escuho el caracter introducido
	
			txtCamp2.setColumns(10);
			txtCamp2.setBounds(162, 116, 200, 20);
			panelPrincipal.add(txtCamp2);

			btnSuma = new JButton("");
			btnSuma.setIcon(new ImageIcon(VentanaOperaciones.class.getResource("/iconos32/icon_boton[+].jpg")));
			btnSuma.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSuma.setForeground(new Color(240, 240, 240));
			btnSuma.setBounds(27, 162, 100, 100);
			btnSuma.addActionListener(this);// indicamos que se escuhe este boton
			panelPrincipal.add(btnSuma);

			btnResta = new JButton("");
			btnResta.setIcon(new ImageIcon(VentanaOperaciones.class.getResource("/iconos32/icon_boton[-].jpg")));
			btnResta.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnResta.setForeground(new Color(0, 0, 0));
			btnResta.setBounds(137, 162, 100, 100);
			btnResta.addActionListener(this);// indicamos que se escuhe este boton
			panelPrincipal.add(btnResta);

			btnMult = new JButton("");
			btnMult.setIcon(new ImageIcon(VentanaOperaciones.class.getResource("/iconos32/icon_boton[x].jpg")));
			btnMult.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnMult.setForeground(new Color(0, 0, 0));
			btnMult.setBounds(247, 162, 100, 100);
			btnMult.addActionListener(this);// indicamos que se escuhe este boton
			panelPrincipal.add(btnMult);

			btnDivide = new JButton("");
			btnDivide.setIcon(new ImageIcon(VentanaOperaciones.class.getResource("/iconos32/icon_boton[%].jpg")));
			btnDivide.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnDivide.setForeground(new Color(0, 0, 0));
			btnDivide.setBounds(357, 162, 100, 100);
			btnDivide.addActionListener(this);// indicamos que se escuhe este boton
			panelPrincipal.add(btnDivide);
			
			lblResultado = new JLabel("");
			lblResultado.setFont(new Font("Arial Black", Font.BOLD, 20));
			lblResultado.setBounds(10, 273, 460, 72);
			panelPrincipal.add(lblResultado);
		}
	//------------fin del metodo iniciarComponentes--------------------		

	//------------implemento los metodos de la interfase actionListener-----------------
		@Override
		public void actionPerformed(ActionEvent e) {
			if (btnSuma == e.getSource()) {// condicionamos la captura de eventos del boton btnSuma
				//JOptionPane.showMessageDialog(null, "Sumar");// publicamos los eventos del boton btnSuma en un JOptionPane
				double num1 = Double.parseDouble(txtCamp1.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				double num2 = Double.parseDouble(txtCamp2.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				double resp=misOperaciones.sumar(num1,num2);
				lblResultado.setText("La suma es= "+resp);

			}
			if (btnResta == e.getSource()) {
				//JOptionPane.showMessageDialog(null, "Restar");
				double num1 = Double.parseDouble(txtCamp1.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				double num2 = Double.parseDouble(txtCamp2.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				double resp=misOperaciones.restar(num1,num2);
				lblResultado.setText("La resta es= "+resp);
			}
			if (btnMult == e.getSource()) {
				//JOptionPane.showMessageDialog(null, "Multiplicar");
				double num1 = Double.parseDouble(txtCamp1.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				double num2 = Double.parseDouble(txtCamp2.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				double resp=misOperaciones.multiplicar(num1,num2);
				lblResultado.setText("La multiplicacion es= "+resp);
			}
			if (btnDivide == e.getSource()) {
				//JOptionPane.showMessageDialog(null, "Dividir");
				double num1 = Double.parseDouble(txtCamp1.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				double num2 = Double.parseDouble(txtCamp2.getText());//capturo el numero introducido en campo 1, lo paso a double y lo guardo en num1
				String resp=misOperaciones.dividir(num1,num2);
				lblResultado.setText(resp);
			}
			 
				
		}
		
		
		

		public void asignarOperaciones(OperacionesMatematicas misOperaciones) {

			this.misOperaciones = misOperaciones;
		}

		
		@Override
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
				if (!Character.isDigit(c) && c !='.'){
					JOptionPane.showInternalMessageDialog(null,"El caracter introducido no es un numero");
			    	e.consume();
			    }

			    if (c == '.' && txtCamp1.getText().contains(".")) {
			    	e.consume();
			    }
			    
			    if (c == '.' && txtCamp2.getText().contains(".")) {
			    	e.consume();
			    }
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			
		}
		

		@Override
		public void keyReleased(KeyEvent e) {
		
		}
}//fin clase VentanaOperaciones
