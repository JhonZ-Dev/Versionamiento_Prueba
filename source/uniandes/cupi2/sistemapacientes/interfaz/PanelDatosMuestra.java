package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//dentro de border importaremos TitledBorder
import javax.swing.border.TitledBorder;


public class PanelDatosMuestra extends JPanel implements ActionListener{   
	
	//ATRIBUTOS
	
		/**
		 * interfaz principal de la aplicacion
		 */
		private InterfazSistemaPacientes principal;
		
		//Etiqueta y zona de texto para la muestra
	    private JLabel labFTomaMuestra;                                                  //JHON ZAMBRANO
		private JTextField txtFTomaMuestra;                                              
		 
		private JLabel labVolumenMuestra;                                                  
		private JTextField txtVolumenMuestra;                                            
		
		//Etiqueta y zona de texto para los Eritrocitos
		private JLabel labVolumenEritrocitos;                                                   
		private JTextField txtVolumenEritrocitos;                                               //JHON ZAMBRANO
		
		//Etiqueta y zona de texto para los Leucocitos
		private JLabel labConteoLeucocitos;                                              
		private JTextField txtConteoLeucocitos;                                       
	    
		//Etiqueta y zona de texto para las Plaquetas
		private JLabel labConteoPlaquetas;                                                   
		private JTextField txtConteoPlaquetas;                                                 

		//Etiqueta para mostrar caja donde se indica si la muestra se tomo en ayunas
		private JCheckBox cbAyunas;                                                            

		//Botón para ejecutar el calculo de valor de Hematocrito
		private JButton butHematocrito;                                                       
		private JTextField txtHematocrito; 
		
		//Botón para calcular Leucocitos
		private JButton butLeucocitos;                                                          
		  
		//Zona de texto para mostrar el valor de Leucocitos
		private JTextField txtLeucocitos;
		
		
	/**
	 * Comando para la opción en ayunas
	 */
	private final static String AYUNAS = "EN AYUNAS";                               
	
	/**
	 * Comando para el boton de calcular el hematocrito
	 */
	private final static String CALCULAR_HEMATOCRITO = "CALCULAR HEMATOCRITO";      
	
	/**
	 * Comando para el boton de calcular los Leucocitos
	 */
	private final static String CALCULAR_LEUCOCITOS = "CALCULAR LEUCOCITOS";      
	
	/**
	 * Metodo actionPerformed que se ejecuta cada vez que se genera un evento
	 * @param evento Evento generado
	 */
	
	

	 
	//constructor 
	//DECLARACIÓN DE LOS ELEMENTOS GRÁFICOS
	public PanelDatosMuestra(InterfazSistemaPacientes v) {		
		principal=v;
		
		setLayout( new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Información muestra");		
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		//Creación de etiquetas
		labFTomaMuestra = new JLabel("Fecha de toma: ");
		labVolumenMuestra = new JLabel("Volumen muestra: ");			
		labVolumenEritrocitos = new JLabel("Volumen Eritrocitos: ");
		labConteoLeucocitos = new JLabel("Conteo Leucocitos: ");
		labConteoPlaquetas = new JLabel("Conteo Plaquetas: ");
		
		//Creacion y configuracion de la zona de texto para Fecha Toma
		txtFTomaMuestra = new JTextField(15);  
		txtFTomaMuestra.setEditable(false);
		txtFTomaMuestra.setBackground(Color.LIGHT_GRAY);				
		txtFTomaMuestra.setForeground(Color.BLUE);
		
		//Creaciòn y configuracion de la zona de texto para el volumen muestra
		txtVolumenMuestra = new JTextField(15);
		txtVolumenMuestra.setEditable(true);
		txtVolumenMuestra.setBackground(Color.WHITE);				
		txtVolumenMuestra.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el volumen eritrocitos
		txtVolumenEritrocitos = new JTextField(2);
		txtVolumenEritrocitos.setEditable(true);
		txtVolumenEritrocitos.setBackground(Color.WHITE);		
		txtVolumenEritrocitos.setForeground(Color.BLUE);
				
		//Creacion y configuracion de la zona de texto pare el conteo de leucocitos
		txtConteoLeucocitos = new JTextField(10);
		txtConteoLeucocitos.setEditable(true);
		txtConteoLeucocitos.setBackground(Color.WHITE);			
		txtConteoLeucocitos.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el conteo de plaquetas
		txtConteoPlaquetas = new JTextField(10);
		txtConteoPlaquetas.setEditable(true);
		txtConteoPlaquetas.setBackground(Color.WHITE);			
		txtConteoPlaquetas.setForeground(Color.BLUE);
		
		//Creacion y configuracion del boton y la zona de texto para el Hematocrito
		butHematocrito = new JButton();
		txtHematocrito = new JTextField(10);
		txtHematocrito.setEditable(false);			
		
		//Creacion y configuracion del boton y la zona de texto para los leucocitos
		butLeucocitos = new JButton();
		txtLeucocitos = new JTextField(10);
		txtLeucocitos.setEditable(false);			
			
		/**
		 * Se crea el boton para calcular el valor del hematocrito
		 * y se le asocia el comando espectivo (la constante)
		 */
		
		butHematocrito.setText("Calcular Hematocrito");
		butHematocrito.setActionCommand(CALCULAR_HEMATOCRITO);	
		
		/**
		 * Se crea el boton para calcular los leucocitos
		 * y se le asocia el comando respectivo (la constante
		 */
		
		butLeucocitos.setText("Cacular Leucocitos");
		butLeucocitos.setActionCommand(CALCULAR_LEUCOCITOS);	
		
		/**
		 * Se cre el boton de chequeo para indicar si la muestra
		 * esta en ayudas y se le asocia el comando resectivo (la constante)
		 */
		cbAyunas = new JCheckBox("Ayunas");
		cbAyunas.setActionCommand(AYUNAS);		
		
		butHematocrito.addActionListener(this);
		butLeucocitos.addActionListener(this);		
		cbAyunas.addActionListener(this);	
		
		//Creacion de la caja de chequeo para ayunas
		cbAyunas = new JCheckBox("Ayunas");
		
		setLayout(new GridLayout(6,4));	
		add(labFTomaMuestra);
		add(txtFTomaMuestra);
		add(new JLabel(""));
		add(cbAyunas);
		add(labVolumenMuestra);
		add(txtVolumenMuestra);
		add(new JLabel(""));			
		add(new JLabel(""));
		add(labVolumenEritrocitos);
		add(txtVolumenEritrocitos);
		add(butHematocrito);
		add(txtHematocrito);
		add(labConteoLeucocitos);		
		add(txtConteoLeucocitos);
		add(butLeucocitos);
		add(txtLeucocitos);
		add(labConteoPlaquetas);		
		add(txtConteoPlaquetas);
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));			
		add(new JLabel(""));
		add(new JLabel(""));
		
		
	}
	
	/**
	 * Metodo actionPerformed
	 */
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(CALCULAR_HEMATOCRITO)){
			principal.calcularHematocrito();
		}
		else if(comando.equals(CALCULAR_LEUCOCITOS)) {	
			principal.calcularLeucocito();
		}
		else if(comando.equals(AYUNAS)) {		 //JHON ZAMBRANO
			principal.cambiarEnAyunas();
		}	
	}
	
	/**
	 * Metodo que muestra el valor de hematocrito
	 */
	public void mostrarHematocrito(String pHematocrito) {	 //JHON ZAMBRANO
		txtHematocrito.setText(pHematocrito +"");
	}
	
	/**
	 * Metodo que muestra el valor de leucocito
	 */
	public void mostrarLeucocito(String pLeucocito){	
		txtLeucocitos.setText(pLeucocito +"");
	}
	
	/**
	 * Metodo que muestra el valor de "en ayunas"
	 */
	public void mostrarAyunas(boolean pAyunas) {	
		cbAyunas.setSelected(pAyunas);
	}
	
	/**
	 * Metodo que devuelve el volumen de la muestra ingresado
	 */
	public String darVolumenMuestra() {
		String rta=txtVolumenMuestra.getText();		
		return rta;
	}
	
	/**
	 * Metodo que devuelve el volumen de eritrocitos ingresado
	 */
	public String darVolumenEritrocitos() {
		String rta=txtVolumenEritrocitos.getText();	
		return rta;
	}
	
	/**
	 * Metodo que devuelve el conteo de leucocitos ingresado
	 */
	public String darConteoLeucocitos() {
		String rta=txtConteoLeucocitos.getText();	
		return rta;
	}
	
	/**
	 * Metodo que devuelve el conteo de plaquetas ingresado
	 */
	public String darConteoPlaquetas() {
		String rta=txtConteoPlaquetas.getText();	
		return rta;
	}
	
	/**
	 * Metodo que devuelve el valor (true/false) de la caja de chequeo
	 */
	public boolean estaEnAyunas() {
		return cbAyunas.isSelected();  	
	}
	
	/**
	 * Metodo limpiar los campos de texto del panel
	 */
	public void limpiarCampos() {
		txtHematocrito.setText("");	
		txtLeucocitos.setText("");
	}
	
	/**
	 * Metodo que actualiza los campos del panel con la informacion que entra como parametro
	 */
	public void actualizarCampos(String pFMuestra,boolean pEnAyunas, double pVMuestra, double pVEritrocitos,
			int pConteoLeucocitos, int pConteoPlaquetas ) {	
		txtFTomaMuestra.setText(pFMuestra);
		txtVolumenMuestra.setText(pVMuestra +"");
		txtVolumenEritrocitos.setText(pVEritrocitos +"");			
		txtConteoLeucocitos.setText(pConteoLeucocitos +"");	
		txtConteoPlaquetas.setText(pConteoPlaquetas +"");			
		cbAyunas.setSelected(pEnAyunas);
	}
}
