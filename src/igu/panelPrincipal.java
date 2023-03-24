package igu;

import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

public class panelPrincipal extends JFrame implements ActionListener{

	private JPanel contenedorPrincipal;
	private VentanaDivisas divisas;
	private VentanaTemperatura temperatura;
	private VentanaOperaciones calculadora;
	private JDesktopPane panelEscritorio;
	
	private JMenuItem mnItemDivisas;
	private JMenuItem mnItemTemperatura;
	private JMenuItem mnItemCalculadora;
	private JMenuItem mnItemSalir;
	private JButton btnDivisas;
	private JButton btnTemperatura;
	private JButton btnCalculadora;
	
	
	//creo funcion que contiene todo los componentes graficos
	void iniciarComponentes(){
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConvertidores = new JMenu("CONVERTIDORES");
		mnConvertidores.setFont(new Font("Arial Black", Font.PLAIN, 12));
		menuBar.add(mnConvertidores);
		
		mnItemDivisas = new JMenuItem("CONVERSOR DIVISAS");
		mnItemDivisas.addActionListener(this); //escucho si hay click en el item
		mnItemDivisas.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnItemDivisas.setIcon(new ImageIcon(panelPrincipal.class.getResource("/iconos16/icon_moneda50.jpg")));
		mnConvertidores.add(mnItemDivisas);
		
		mnItemTemperatura = new JMenuItem("CONVERSOR TEMPERATURA");
		mnItemTemperatura.addActionListener(this); //escucho si hay click en el item
		mnItemTemperatura.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnItemTemperatura.setIcon(new ImageIcon(panelPrincipal.class.getResource("/iconos16/icon_temperatura50.jpg")));
		mnConvertidores.add(mnItemTemperatura);
		
		mnItemCalculadora = new JMenuItem("CALCULADORA");
		mnItemCalculadora.addActionListener(this); //escucho si hay click en el item
		mnItemCalculadora.setIcon(new ImageIcon(panelPrincipal.class.getResource("/iconos32/icon_calculadora250.jpg")));
		mnItemCalculadora.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnConvertidores.add(mnItemCalculadora);
		
		JSeparator separator = new JSeparator();
		mnConvertidores.add(separator);
		
		mnItemSalir = new JMenuItem("SALIR");
		mnItemSalir.addActionListener(this); //escucho si hay click en el item
		mnItemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mnItemSalir.setHorizontalAlignment(SwingConstants.TRAILING);
		mnItemSalir.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mnItemSalir.setIcon(new ImageIcon(panelPrincipal.class.getResource("/iconos16/icon_salida.jpg")));
		mnConvertidores.add(mnItemSalir);
		contenedorPrincipal = new JPanel();
		contenedorPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contenedorPrincipal);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		
		panelEscritorio = new JDesktopPane();
		panelEscritorio.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contenedorPrincipal);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
				.addComponent(panelEscritorio, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEscritorio, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
					.addGap(0))
		);
		
		btnDivisas = new JButton("DIVISAS");
		btnDivisas.addActionListener(this); //escucho si hay click en el boton
		btnDivisas.setIcon(new ImageIcon(panelPrincipal.class.getResource("/iconos16/icon_moneda16.jpg")));
		btnDivisas.setFont(new Font("Arial Black", Font.PLAIN, 10));
		toolBar.add(btnDivisas);
		
		btnTemperatura = new JButton("TEMPERATURA");
		btnTemperatura.addActionListener(this); //escucho si hay click en el boton
		btnTemperatura.setIcon(new ImageIcon(panelPrincipal.class.getResource("/iconos16/icon_temperatura16.jpg")));
		btnTemperatura.setFont(new Font("Arial Black", Font.PLAIN, 10));
		toolBar.add(btnTemperatura);
		
		btnCalculadora = new JButton("CALCULADORA");
		btnCalculadora.addActionListener(this); //escucho si hay click en el boton
		btnCalculadora.setIcon(new ImageIcon(panelPrincipal.class.getResource("/iconos16/icon_calculadora216.jpg")));
		btnCalculadora.setFont(new Font("Arial Black", Font.PLAIN, 10));
		toolBar.add(btnCalculadora);
		contenedorPrincipal.setLayout(gl_contentPane);
		
		
	}
	
	//constructor panel principal llamamos a iniciarComponentes para que se carguen todos los componentes graficos
	public panelPrincipal() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.iniciarComponentes();
		setTitle("CONVERSOR DE UNIDADES");
		setIconImage(Toolkit.getDefaultToolkit().getImage(panelPrincipal.class.getResource("/iconos16/icon_conversion.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 370);
		
		
	}
	
	//fondo panel principal 
	
	
	
	
	
	//-------sobreescritura de metodos ActionListener para interactuar con los elementos graficos---------------	
		@Override
	public void actionPerformed(ActionEvent e) {

			if (mnItemDivisas == e.getSource() || btnDivisas == e.getSource()) {// capturo click en menu o boton
				cargaDivisas();// invoco a la funcion carga divisas
				
			}
			if (mnItemTemperatura == e.getSource() || btnTemperatura == e.getSource()) {// capturo click en menu o boton
				cargaTemperatura();// invoco a la funcion carga temperatura
				
			}
		
			if (mnItemCalculadora == e.getSource() || btnCalculadora == e.getSource()) {// capturo click en menu o boton
				cargaCalculadora();// invoco a la funcion carga temperatura
				
			}
			if (mnItemSalir == e.getSource()) {// capturo click en menu item salir
				if(JOptionPane.showConfirmDialog(null,"¿Realmente desea abandonar la aplicacion?","CERRAR",JOptionPane.YES_NO_OPTION)==0) {
					
					JOptionPane.showMessageDialog(null, "OK, HASTA LA PROXIMA");
					
					System.exit(0);
				};
				
			}

		}
	
	//funcion que llama a la ventana divisas
	void cargaDivisas() {
		if(divisas==null||divisas.isClosed()) {//verifico que divisa no existe en el escritorio (si es nulo o esta cerrado)
		divisas=new VentanaDivisas();//Creo un objeto tipo VentanaDivisas
		panelEscritorio.add(divisas);//cargo el objeto (divisas) en panel escritorio
		
		Dimension tDivisas=divisas.getSize();
		divisas.setLocation((panelEscritorio.getWidth()-tDivisas.width)/2,(panelEscritorio.getHeight()-(tDivisas.height))/2);
		
		
		divisas.show();//hago visible el objeto
		
	}
	}
	//funcion que llama a la ventana Temperatura
	void cargaTemperatura() {
		if(temperatura==null||temperatura.isClosed()) {//verifico que temperatura no existe en el escritorio (si es nulo o esta cerrado)
		temperatura=new VentanaTemperatura();//Creo un objeto tipo VentanaTemperatura
		panelEscritorio.add(temperatura);//cargo el objeto (temperatura) en panel escritorio
		Dimension tTemperatura=temperatura.getSize();
		temperatura.setLocation((panelEscritorio.getWidth()-tTemperatura.width)/2,(panelEscritorio.getHeight()-(tTemperatura.height))/2);
		temperatura.show();//hago visible el objeto
		
	}
	}
	void cargaCalculadora() {
		if(calculadora==null||calculadora.isClosed()) {//verifico que calculadora no existe en el escritorio (si es nulo o esta cerrado)
		calculadora=new VentanaOperaciones();//Creo un objeto tipo VentanaOperaciones
		panelEscritorio.add(calculadora);//cargo el objeto (calculadora) en panel escritorio
		Dimension tCalculadora=calculadora.getSize();
		calculadora.setLocation((panelEscritorio.getWidth()-tCalculadora.width)/2,(panelEscritorio.getHeight()-(tCalculadora.height))/2);
		calculadora.show();//hago visible el objeto
		
	}
	}
}
