package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class VentanaTemperatura extends JInternalFrame implements ActionListener{
	// -----------declaro variables de clase--------------
	int cantidad = 0;
	double conversion = 0;
	private String temperaturaOrigen = "CELSIUS";
	private String temperaturaDestino = "CELSIUS";

	private JPanel contentPane;
	JLabel valorAConvertir = new JLabel("Valor");
	JLabel valorConvertido = new JLabel("Resultado");
	JSlider sliderValorAConvertirTemp;
	JComboBox cBox_TemperaturaOrigen;
	JComboBox cBox_TemperaturaDestino;

	OperacionesMatematicas misOperaciones;

	// ---------------Metodo de asignacion, con el parametro pasado por Aplicacion
	// que obtiene el resultado misOperaciones de OperacionesMatematicas

	public void asignarOperaciones(OperacionesMatematicas misOperaciones) {
		this.misOperaciones = misOperaciones;

	}
	// -------fin metodo asignarOperaciones---------------------

	// -----------creo el constructor de clase VentanaTemperatura--------------
	public VentanaTemperatura() {
		setRootPaneCheckingEnabled(false);
		
		setFrameIcon(new ImageIcon(VentanaTemperatura.class.getResource("/iconos16/icon_temperatura16.jpg")));
		setClosable(true);
		iniciarComponentesTemp();// llamo al metodo inciarComponentes();
		
		this.setTitle("CONVERSOR DE TEMPERATURA");
		JOptionPane.showMessageDialog(null, "Mover el deslizador para seleccionar TEMPERATURA a convertir");// indico al
																											// usuario
																											// que mueva
																											// el
																											// deslizador

	}

//----------creo el metodo iniciarComponentes que contiene todos los componentes graficos-------		
	private void iniciarComponentesTemp() {
		setBounds(100, 100, 525, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		valorAConvertir.setHorizontalAlignment(SwingConstants.CENTER);
		valorAConvertir.setFont(new Font("Tahoma", Font.BOLD, 20));
		valorAConvertir.setBounds(113, 144, 129, 26);
		contentPane.add(valorAConvertir);
		
		sliderValorAConvertirTemp = new JSlider();
		sliderValorAConvertirTemp.setBorder(UIManager.getBorder("Spinner.border"));
		sliderValorAConvertirTemp.setPaintLabels(true);
		sliderValorAConvertirTemp.setPaintTicks(true);
		sliderValorAConvertirTemp.setMaximum(150);
		sliderValorAConvertirTemp.setOrientation(SwingConstants.VERTICAL);
		sliderValorAConvertirTemp.setValue(0);
		sliderValorAConvertirTemp.addChangeListener(new SliderCambio());// indicamos que se escuche este boton
		sliderValorAConvertirTemp.setMajorTickSpacing(30);
		sliderValorAConvertirTemp.setMinorTickSpacing(5);
		sliderValorAConvertirTemp.setMinimum(-150);
		sliderValorAConvertirTemp.setBounds(27, 52, 67, 189);
		contentPane.add(sliderValorAConvertirTemp);

		JLabel jlvalorAConvertir = new JLabel("TEMPERATURA A CONVERTIR");
		jlvalorAConvertir.setBounds(77, 27, 176, 14);
		contentPane.add(jlvalorAConvertir);
//Temperatura origen________________________________________________________________________________
		JLabel jlTemperaturaOrigen = new JLabel("ESCALA ORIGEN");
		jlTemperaturaOrigen.setBounds(124, 71, 118, 14);
		contentPane.add(jlTemperaturaOrigen);

		cBox_TemperaturaOrigen = new JComboBox();

		cBox_TemperaturaOrigen.setModel(new DefaultComboBoxModel(new String[] { "CELSIUS", "KELVIN", "FAHRENHEIT"}));
		cBox_TemperaturaOrigen.addActionListener(this);// indicamos que se escuche este boton
		cBox_TemperaturaOrigen.setBounds(124, 96, 100, 22);
		contentPane.add(cBox_TemperaturaOrigen);

//Temperatura destino________________________________________________________________________________		
		JLabel jlTemperaturaDestino = new JLabel("ESCALA DESTINO");
		jlTemperaturaDestino.setBounds(305, 71, 147, 14);
		contentPane.add(jlTemperaturaDestino);

		cBox_TemperaturaDestino = new JComboBox();

		cBox_TemperaturaDestino.setModel(new DefaultComboBoxModel(new String[] { "CELSIUS", "KELVIN", "FAHRENHEIT"}));
		cBox_TemperaturaDestino.addActionListener(this);// indicamos que se escuche este boton
		cBox_TemperaturaDestino.setBounds(305, 96, 100, 22);
		contentPane.add(cBox_TemperaturaDestino);

//Resultado________________________________________________________________________________________		

		valorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
		valorConvertido.setForeground(Color.RED);
		valorConvertido.setFont(new Font("Arial", Font.BOLD, 25));
		valorConvertido.setBounds(281, 140, 155, 34);
		contentPane.add(valorConvertido);

		JLabel jlvalorConvertido = new JLabel("TEMPERATURA CONVERTIDA");
		jlvalorConvertido.setBounds(312, 27, 187, 14);
		contentPane.add(jlvalorConvertido);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.GRAY);
		separator.setBounds(263, 27, 2, 214);
		contentPane.add(separator);

	}

	// ------------fin del metodo iniciarComponentes--------------------

//-------genero clase interna para captura los cambios en Slider---------------

	private class SliderCambio implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {

			if (sliderValorAConvertirTemp == e.getSource()) {// condicionamos la captura de eventos del slider
				cantidad = sliderValorAConvertirTemp.getValue();
				System.out.println(cantidad);
				valorAConvertir.setText(cantidad+ misOperaciones.convertirTemp(cantidad, temperaturaOrigen, temperaturaDestino)[0]);
				
				String resultado = misOperaciones.convertirTemp(cantidad, temperaturaOrigen, temperaturaDestino)[1];
				valorConvertido.setText(resultado);
			}

		}

	}
//-------fin clase interna ---------------	

//-------sobreescritura de metodos ---------------	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (cBox_TemperaturaOrigen == e.getSource() || cBox_TemperaturaDestino == e.getSource()
				|| sliderValorAConvertirTemp == e.getSource()) {
			temperaturaOrigen = cBox_TemperaturaOrigen.getSelectedItem().toString();// capturo seleccion en cbox Temperatura origen y
																			// lo guardo en temperaturaOrigen
			System.out.println("temperatura original: " + temperaturaOrigen);
			temperaturaDestino = cBox_TemperaturaDestino.getSelectedItem().toString();// capturo seleccion en cbox Temperatura destino
																			// y lo guardo en TemperaturaDestino
			System.out.println("Temperatura destino: " + temperaturaDestino);
			cantidad = sliderValorAConvertirTemp.getValue();
			valorAConvertir.setText(cantidad+ misOperaciones.convertirTemp(cantidad, temperaturaOrigen, temperaturaDestino)[0]);
			
			String resultado = misOperaciones.convertirTemp(cantidad, temperaturaOrigen, temperaturaDestino)[1];

			valorConvertido.setText(resultado);
			

		}

	}
}
