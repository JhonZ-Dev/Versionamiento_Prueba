package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel implements ActionListener{
	
	/*
	 * CONSTANTES			jhon zambrano macias
	 */
	private static final String AVANZAR = "AVANZAR";
	private static final String RETROCEDER = "RETROCEDER";
	//comando para el boton1
	private final String OPCION_1 = "OPCION_1";
	//Para el boton2
	private final String OPCION_2 = "OPCION_2";
	
	//------------------------------------------
	//ATRIBUTOS   				JHON ZAMBRANO
	//------------------------------------------
	private InterfazSistemaPacientes principal;
	private JButton btnAvanzar;
	private JButton btnRetroceder;
	private JButton butOpcion1;
	private JButton butOpcion2;
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------------
    // Constructores         JHON ZAMBRANO MACIAS
    //-----------------------------------------------------------------

	public PanelExtensiones(InterfazSistemaPacientes v) {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de Extensión");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		JPanel panelInformacion;                                                               
		panelInformacion = new JPanel();                                                       
		add(panelInformacion,BorderLayout.CENTER);  
		
		/**
		 * SE CREAN LOS BOTONES PARA AVANZAR Y RETROCEDER
		 */
		btnAvanzar = new JButton(">");
		btnAvanzar.setActionCommand(AVANZAR);
		
		btnRetroceder = new JButton("<");
		btnRetroceder.setActionCommand(RETROCEDER);
		/*
		 * SE CREAN LOS BOTONES DE ACCION 1 Y 2
		 * 
		 */
			butOpcion1 = new	JButton("OPCION 1");
			butOpcion1.setActionCommand("OPCION_1");
			
			butOpcion2 = new 	JButton("OPCION 2");
			butOpcion2.setActionCommand(OPCION_2);
	

				
				//Creación de etiquetas
				//Creacion y configuracion del boton para avanzar al siguiente paciente
				btnAvanzar = new JButton("<");    							                           
				btnRetroceder = new JButton (">");							                        
				butOpcion1 = new JButton("opción 1");                                                  
				butOpcion2 = new JButton("opción 2");                                                  
				
				//el llamado al método addActionListener de la clase JButton o
				//JCheckBox sobre todos los botones de los páneles de su aplicación.
				btnAvanzar.addActionListener(this);
				btnRetroceder.addActionListener(this);
				butOpcion1.addActionListener(this);
				butOpcion2.addActionListener(this);
				
				/**
				 * Se crean los botones para avanzar y retroceder
				 * y se les asocia los comandos respecivo (las constantes)
				 */		
				//
				btnAvanzar.setActionCommand(AVANZAR);													
				
				btnRetroceder.setActionCommand(RETROCEDER);											
				
				/**
				 * 	Se crean los botones de opcion 1 y 2
				 * se le asocia con su respecitiva constante
				 */
				//
				butOpcion1.setActionCommand(OPCION_1);													

				butOpcion2.setActionCommand (OPCION_2);												
				
				//Asociación del Panel Auxiliar
				panelInformacion.setLayout(new FlowLayout());											
				panelInformacion.add(new JLabel(""));											    
				panelInformacion.add(new JLabel(""));												    
				panelInformacion.add(btnAvanzar);											            
				panelInformacion.add(butOpcion1);											            
				panelInformacion.add(butOpcion2);														
				panelInformacion.add(btnRetroceder);		
	}
			
			public void  actionPerformed(ActionEvent evento) {
				String comando = evento.getActionCommand();
				if(comando.equals(AVANZAR))
				{
					principal.Avanzar();
				}
				else if (comando.equals(RETROCEDER))
				{
					principal.Retroceder();
				}
				else if(comando.equals(OPCION_1))
				{
					principal.reqFuncOpcion1();
				}
				else if (comando.equals (OPCION_2))
				{
					principal.reqFuncOpcion2();
				}
			}
}
			

	
