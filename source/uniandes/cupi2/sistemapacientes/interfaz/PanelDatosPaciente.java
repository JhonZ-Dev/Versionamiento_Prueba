package uniandes.cupi2.sistemapacientes.interfaz;

//importamos toda la biblioteca awt y Swing
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//dentro de border importaremos TitledBorder
import javax.swing.border.TitledBorder;


//establecemos una subclase de JPanel
public class PanelDatosPaciente extends JPanel implements ActionListener{                   
	
	public void  actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(CALCULAR_EDAD))
		{
			principal.calcularEdad();
		}
		else if (comando.equals("")) 
		{
			
		}
		
	}
	/**
	 * comando para el botón calcular edad
	 */
	private final static String CALCULAR_EDAD = "CALCULAR EDAD";   
	
	
	/**
	 * 
	 * @param pEdad
	 */
	public void mostrarEdad(int pEdad) 
	{
		txtEdad.setText(pEdad+"");
	}
	
	/**
	 * 
	 * @return
	 */
	public String darCalculodeEdad()
	{
		String rta=txtEdad.getText();
		return rta;
	}
	
	/**
	 * Limpia los campos de texto de panel
	 */
	public void limpiarCampos()
	{
		txtEdad.setText("");
	}
	
	
	public void actualizarCampos(String pNombre, String pApellido, String pSexo, 
			String pFechaNac, String pImagen)
	{
	txtNombre.setText(pNombre);
	txtApellido.setText(pApellido);
	txtSexo.setText(pSexo);
	txtFNacimiento.setText(pFechaNac);
	labImagen.setIcon(new ImageIcon(pImagen));
	txtEdad.setText("");
	
	}
	
	// ATRIBUTOS- ETIQUETAS
	/**
	 * interfaz principal de la aplicacion
	 */
	private InterfazSistemaPacientes principal;
	
	//Etiqueta y zona de texto para el nombre
    private JLabel labNombre;                                    
	private JTextField txtNombre;                            
	 
	//Etiqueta y zona de texto para el apellido
	private JLabel labApellido;                                   
	private JTextField txtApellido;                               
	
	//Etiqueta y zona de texto para la fecha de nacimiento
	private JLabel labFNacimiento;                                
	private JTextField txtFNacimiento;                            
    
	//Etiqueta y zona de texto para el sexo
	private JLabel labSexo;                                       
	private JTextField txtSexo;                                   

	//Etiqueta para mostrar la imagen
	private JLabel labImagen;                                     

	//Botón para calcular la edad
	private JButton butEdad;                                     
	
	//Zona donde se muestra la edad
	private JTextField txtEdad;                                   

	
	/**
	 * Metodo actionPerformed que se ejecuta cada vez que se genera un evento
	 * @param evento Evento generado
	 */
	
	//constructor
	//DECLARACIÓN DE LOS ELEMENTOS GRÁFICOS
	public PanelDatosPaciente(InterfazSistemaPacientes v) {          
		 principal = v;
		 
		//Creación  de todas las etiquetas
		labNombre=new JLabel ("Nombre:");                         
		labApellido = new JLabel("Apellido:");                    
		labSexo = new JLabel ("Sexo:");                           
		labFNacimiento = new JLabel ("Fecha de nacimiento:");     
		
		//Creación y Configuración de la zona de texto para el nombre
		txtNombre = new JTextField(15);                           
		txtNombre.setEditable(false);                             
		txtNombre.setBackground(Color.LIGHT_GRAY);              
		txtNombre.setForeground(Color.BLUE);                     
		
		//Creación y Configuración de la zona de texto para el apellido
		txtApellido = new JTextField(15);                           
		txtApellido.setEditable(false);                             
		txtApellido.setBackground(Color.LIGHT_GRAY);               
		txtApellido.setForeground(Color.BLUE);                      
		
		//Creación y Configuración de la zona de texto para el apellido
		txtSexo = new JTextField(2);                                
		txtSexo.setEditable(false);                                  
		txtSexo.setBackground(Color.LIGHT_GRAY);                    
		txtSexo.setForeground(Color.BLUE);                           
		
		//Creación y Configuración de la zona de texto para la fecha de Nacimiento
		txtFNacimiento = new JTextField(10);                          
		txtFNacimiento.setEditable(false);                            
		txtFNacimiento.setBackground(Color.LIGHT_GRAY);               
		txtFNacimiento.setForeground(Color.BLUE);                     
		
		//Creación y Configuración del botón y la zona de texto para la edad
		butEdad = new JButton("Calcular Edad");                      
		txtEdad= new JTextField(10);                                  
		txtEdad.setEditable(false);                                   
		
		setLayout(new BorderLayout());                               
		TitledBorder border = BorderFactory.createTitledBorder("Datos del paciente");
		border.setTitleColor(Color.BLUE);                            
		setBorder(border);                                          
		
		/**
		 * Se crea el boton para calcular la edad del paciente
		 * y se le asocia con el comando respectivo, la constante
		 */
		butEdad.setActionCommand (CALCULAR_EDAD);					   
		
		//el llamado al método addActionListener de la clase JButton o
		//JCheckBox sobre todos los botones de los páneles de su aplicación.
		butEdad.addActionListener(this);
		
		//Panel donde se muestra la foto del paciente 
		JPanel panelFoto;
		
		//Panel donde se muestra la información del paciente 
		JPanel panelInformacion;                                  
		panelFoto = new JPanel();                                 
		add(panelFoto, BorderLayout.EAST);                         
		//etiqueta para mostrar la foto
		labImagen = new JLabel ("FOTO");                          
		panelFoto.add(labImagen);                                  
		
		panelInformacion = new JPanel();                           
		add(panelInformacion,BorderLayout.CENTER);                
	
		
		//Asociación del Panel Auxiliar
	    panelInformacion.setLayout(new GridLayout(6,2));           
	    panelInformacion.add(labNombre);                           
	    panelInformacion.add(txtNombre);		  				   
	    panelInformacion.add(labApellido);                         
	    panelInformacion.add(txtApellido);                        
	    panelInformacion.add(labSexo);                             
	    panelInformacion.add(txtSexo);                             
	    panelInformacion.add(labFNacimiento);                      
	    panelInformacion.add(txtFNacimiento);                      
	    panelInformacion.add(butEdad);                            
	    panelInformacion.add(txtEdad);                                                     
		
	}
	
	
}
