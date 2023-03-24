package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logica.OperacionesMatematicas;
//import igu.VentanaDivisas.SliderCambio;
import javax.swing.ImageIcon;

public class VentanaDivisas extends JInternalFrame implements ActionListener {
	// -----------declaro variables de clase--------------
	int cantidad = 0;
	double conversion = 0;
	private String monedaOrigen = "Peso Argentino";
	private String monedaDestino = "Peso Argentino";

	private JPanel contentPane;
	JLabel valorAConvertir = new JLabel("New label");
	JLabel valorConvertido = new JLabel("Resultado");
	JSlider sliderValorAConvertir;
	JComboBox cBox_MonedaOrigen;
	JComboBox cBox_MonedaDestino;

	OperacionesMatematicas misOperaciones;

	// ---------------Metodo de asignacion, con el parametro pasado por Aplicacion
	// que obtiene el resultado misOperaciones de OperacionesMatematicas

	public void asignarOperaciones(OperacionesMatematicas misOperaciones) {
		this.misOperaciones = misOperaciones;

	}
	// -------fin metodo asignarOperaciones---------------------

	// -----------creo el constructor de clase VentanaDivisas--------------
	public VentanaDivisas() {
		setRootPaneCheckingEnabled(false);
		
		setFrameIcon(new ImageIcon(VentanaDivisas.class.getResource("/iconos16/icon_moneda16.jpg")));
		setClosable(true);
		iniciarComponentesDiv();// llamo al metodo inciarComponentes();
		
		this.setTitle("CONVERSOR DE DIVISAS");
		JOptionPane.showMessageDialog(null, "Mover el deslizador para seleccionar cantidad a convertir");// indico al
																											// usuario
																											// que mueva
																											// el
																											// deslizador

	}

//----------creo el metodo iniciarComponentes que contiene todos los componentes graficos-------		
	private void iniciarComponentesDiv() {
		setBounds(100, 100, 525, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		valorAConvertir.setFont(new Font("Tahoma", Font.BOLD, 16));
		valorAConvertir.setBounds(341, 49, 61, 26);
		contentPane.add(valorAConvertir);
		
		sliderValorAConvertir = new JSlider();
		sliderValorAConvertir.setValue(0);
		sliderValorAConvertir.addChangeListener(new SliderCambio());// indicamos que se escuche este boton
		//mouseClicked(null);
		sliderValorAConvertir.setMajorTickSpacing(10);
		sliderValorAConvertir.setMinorTickSpacing(10);
		sliderValorAConvertir.setMinimum(1);
		sliderValorAConvertir.setBounds(40, 49, 261, 26);
		contentPane.add(sliderValorAConvertir);

		JLabel jlvalorAConvertir = new JLabel("VALOR A CONVERTIR");
		jlvalorAConvertir.setBounds(40, 24, 146, 14);
		contentPane.add(jlvalorAConvertir);
//Moneda origen________________________________________________________________________________
		JLabel jlMonedaOrigen = new JLabel("MONEDA ORIGEN");
		jlMonedaOrigen.setBounds(39, 119, 147, 14);
		contentPane.add(jlMonedaOrigen);

		cBox_MonedaOrigen = new JComboBox();

		cBox_MonedaOrigen.setModel(new DefaultComboBoxModel(new String[] { "Peso Argentino", "Dólar", "Euro",
				"Libra Esterlina", "Yen Japonés", "Won sul-coreano" }));
		cBox_MonedaOrigen.addActionListener(this);// indicamos que se escuche este boton
		//mouseClicked(null);
		cBox_MonedaOrigen.setBounds(40, 144, 200, 22);
		contentPane.add(cBox_MonedaOrigen);

//Moneda destino________________________________________________________________________________		
		JLabel jlMonedaDestino = new JLabel("MONEDA DESTINO");
		jlMonedaDestino.setBounds(281, 119, 176, 14);
		contentPane.add(jlMonedaDestino);

		cBox_MonedaDestino = new JComboBox();

		cBox_MonedaDestino.setModel(new DefaultComboBoxModel(new String[] { "Peso Argentino", "Dólar", "Euro",
				"Libra Esterlina", "Yen Japonés", "Won sul-coreano" }));
		cBox_MonedaDestino.addActionListener(this);// indicamos que se escuche este boton
		//mouseClicked(null);
		cBox_MonedaDestino.setBounds(281, 144, 200, 22);
		contentPane.add(cBox_MonedaDestino);

//Resultado________________________________________________________________________________________		

		valorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
		valorConvertido.setForeground(Color.RED);
		valorConvertido.setFont(new Font("Arial", Font.BOLD, 18));
		valorConvertido.setBounds(40, 206, 445, 34);
		contentPane.add(valorConvertido);

		JLabel jlvalorConvertido = new JLabel("VALOR CONVERTIDO");
		jlvalorConvertido.setBounds(40, 181, 250, 14);
		contentPane.add(jlvalorConvertido);

	}

	// ------------fin del metodo iniciarComponentes--------------------

//-------genero clase interna para captura los cambios en Slider---------------

	private class SliderCambio implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {

			if (sliderValorAConvertir == e.getSource()) {// condicionamos la captura de eventos del slider
				cantidad = sliderValorAConvertir.getValue();
				System.out.println(cantidad);
				valorAConvertir.setText("" + cantidad);
				String resultado = misOperaciones.convertir(cantidad, monedaOrigen, monedaDestino);
				valorConvertido.setText(resultado);
			}

		}

	}
//-------fin clase interna ---------------	

//-------sobreescritura de metodos ---------------	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (cBox_MonedaOrigen == e.getSource() || cBox_MonedaDestino == e.getSource()
				|| sliderValorAConvertir == e.getSource()) {
			monedaOrigen = cBox_MonedaOrigen.getSelectedItem().toString();// capturo seleccion en cbox moneda origen y
																			// lo guardo en monedaOrigen
			System.out.println("Moneda original: " + monedaOrigen);
			monedaDestino = cBox_MonedaDestino.getSelectedItem().toString();// capturo seleccion en cbox moneda destino
																			// y lo guardo en monedaDestino
			System.out.println("Moneda destino: " + monedaDestino);
			cantidad = sliderValorAConvertir.getValue();
			String resultado = misOperaciones.convertir(cantidad, monedaOrigen, monedaDestino);

			valorConvertido.setText(resultado);
			

		}

	}


}
