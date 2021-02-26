package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

//importamos toda la biblioteca de java al poner el * (asterisco)
import javax.swing.*;                                          //María José Párraga  

import uniandes.cupi2.sistemapacientes.mundo.Paciente;
import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

//hacemos una subclase con la clase JFrame
public class InterfazSistemaPacientes extends JFrame{      
	
	//-------------------------------------------------------
	//ATRIBUTOS
	//-------------------------------------------------------
	
	/*
	 *Creamos aun atributo de la clase principal del paquete mundo 
	*/
	private SistemaPacientes sistemaPacientes;
	
	/*
	 *Creamos aun atributo de la clase principal del paquete mundo 
	*/
	private PanelDatosPaciente panelDatosPaciente;
	
	/*
	 *Creamos aun atributo de la clase principal del paquete mundo 
	*/
	private PanelDatosMuestra panelDatosMuestra;
	
	/*
	 *Creamos aun atributo de la clase principal del paquete mundo 
	*/
	private PanelExtensiones panelExtensiones;
	
	//-------------------------------------------------------
		//MAIN
		//-------------------------------------------------------
		public static void main(String[] args) {                                  
			//instanciamos la interfaz con el constructor principal            
			InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();   
			//Hacemos visible la interfaz
			interfaz.setVisible(true);                                             
		}

	
	//-------------------------------------------------------
	//CONSTRUCTORES 					JHON ZAMBRANO
	//-------------------------------------------------------
	
	/*
	 * Creamos un constructor de la unterefaz grafica, 
	 * inicializando con los datos del paciente
	 * */
		public InterfazSistemaPacientes() {		
			
			setTitle("Sistema de Pacientes by: JhonZambrano");
			setSize(700,450);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			//crea la clase principal
			sistemaPacientes = new SistemaPacientes();		
			//crea el panel de datos de la muestra
			panelDatosMuestra = new PanelDatosMuestra(this);  
			//crea el panel de datos del paciente
			panelDatosPaciente = new PanelDatosPaciente(this);
			//crea el panel de extensiones
			panelExtensiones = new PanelExtensiones(this);
			
			//Organizar el panel principal
			add(panelDatosPaciente, BorderLayout.NORTH);
			add(panelDatosMuestra, BorderLayout.CENTER);
			add(panelExtensiones, BorderLayout.SOUTH);		
		}
	
	
/**
 * 
 * @param pPaciente
 */
		/**
		 * Actualiza la informacion del paciente dado por parametro
		 * @param pPaciente
		 */
		public void actualizarInfoPaciente(Paciente pPaciente) {		
			String nombre = pPaciente.darNombre();
			String apellido= pPaciente.darApellido();
			
			String sexo = "F";
			int iSexo = pPaciente.darSexo();
			if(iSexo ==2)
				sexo = "M";
			String fechaTomaMuestra = pPaciente.darFechaTomaMuestra();	
			String fechaN= pPaciente.darFechaNacimiento();
			String imagen = pPaciente.darImagen();
			double volumenMuestra = pPaciente.darVolumenMuestra();
			double volumenEritrocitos = pPaciente.darVolumenEritrocitos();
			int conteoLeucocitos = pPaciente.darConteoLeucocitos();
			int conteoPlaquetas = pPaciente.darConteoPlaquetas();
			boolean enAyunas = pPaciente.darEnAyunas();
			
			panelDatosPaciente.actualizarCampos(nombre, apellido, sexo, fechaN, imagen );	
			panelDatosMuestra.actualizarCampos(fechaTomaMuestra, enAyunas, volumenMuestra,
					volumenEritrocitos, conteoLeucocitos, conteoPlaquetas);
			
			panelDatosMuestra.limpiarCampos();
		}
		
		/**
		 * Avanza al siguiente paciente  actualiza la informacion de la interfaz
		 */
		public void Avanzar() {
			Paciente actual = sistemaPacientes.darPacienteSiguiente();	
			actualizarInfoPaciente(actual);

		}
		
		/**
		 * Calcula y muestra el hematocrito del paciente
		 */
	    public void calcularHematocrito()		
	    {
		   String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		   String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();		
		   
		   if(pVolumenMuestra.trim().equals("") || pVolumenEritrocitos.trim().equals(""))
		   {
			   JOptionPane.showMessageDialog(this, "Debe ingresar lo datos.",
					   "Calcular Hematocrito",JOptionPane.ERROR_MESSAGE);		
		   }
		   else if ( pVolumenMuestra.trim().matches("[0123456789.]*")&&
		   			pVolumenEritrocitos.trim().matches("[0123456789.]"))
		   {
			   double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());		
			   double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
			   
			   sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			   sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			   
			   double hematocrito= sistemaPacientes.darPacienteActual().calcularHematocrito();	
			   hematocrito= Math.round(hematocrito*100.0)/100.0;
			   panelDatosMuestra.mostrarHematocrito(""+hematocrito);  
		   }
		   else
		   {
		   JOptionPane.showMessageDialog(this,"Los datos ingresados no son correctos.",
				   						"Calcular Hematocrito",JOptionPane.ERROR_MESSAGE);	
		   }
		   	   
	    }
	    
	    /**
	     * Muestra un mensaje indicando la muestra esta en ayunas o no 
	     * dependiendo de la seleccion o deseleccion del usuario
	     */
	    public void cambiarEnAyunas()		
	    {
	     	if(panelDatosMuestra.estaEnAyunas())
	     	{
	     		JOptionPane.showMessageDialog(this, "En ayunas", "Estado",JOptionPane.INFORMATION_MESSAGE);  
	     	}
	     	else
	     	{
	     		JOptionPane.showMessageDialog(this, "No en ayunas", "Estado",JOptionPane.INFORMATION_MESSAGE);
	     	}
	    }
	     
	    /**
	     * Metodo para la extension 1
	     */
	    public void reqFuncOpcion1()
	    {
	    	String resultado = sistemaPacientes.metodo1();
	    	JOptionPane.showMessageDialog(this, resultado, "Respuesta",JOptionPane.INFORMATION_MESSAGE);
	    }
	     
	    public void reqFuncOpcion2()
	    {
	    	String resultado = sistemaPacientes.metodo2();
	     	JOptionPane.showMessageDialog(this, resultado, "Respuesta",JOptionPane.INFORMATION_MESSAGE);
	    }

	 	public void calcularEdad() {			
	 		
	 		int edad = sistemaPacientes.darPacienteActual().darEdad();   
			panelDatosPaciente.mostrarEdad(edad);  
			String fechaN = sistemaPacientes.darPacienteActual().darFechaNacimiento();  
			if(fechaN.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe ingresar los datos.","Calcular Edad", JOptionPane.ERROR_MESSAGE); 
			}else 
			{
				panelDatosPaciente.mostrarEdad(edad); 
			}
	 		
	 	}

	 	public void calcularLeucocito() {
	 		
	 	   String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
	 	   String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
	 	   String pConteoLeucocitos = panelDatosMuestra.darConteoLeucocitos();		
	 	   
	 	   if(pVolumenMuestra.trim().equals("") || pVolumenEritrocitos.trim().equals("") || pConteoLeucocitos.trim().equals(""))
	 	   {
	 		   JOptionPane.showMessageDialog(this, "Debe ingresar lo datos.",
	 				   "Calcular Leucocito",JOptionPane.ERROR_MESSAGE);		
	 	   }
	 	   else if ( pVolumenMuestra.trim().matches("[0123456789.]*")&&
	 			   pVolumenEritrocitos.trim().matches("[0123456789.]") &&
	 			  pConteoLeucocitos.trim().matches("[0123456789.]"))
	 	   {
	 		   double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());		
	 		   double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
	 		   int conteoLeucocitos = Integer.parseInt(pConteoLeucocitos.trim());
	 		   
	 		   sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
	 		   sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
	 		   sistemaPacientes.darPacienteActual().cambiarConteoLeucocitos(conteoLeucocitos);
	 		   
	 		   double leucocito= sistemaPacientes.darPacienteActual().calcularLeucocitos();	
	 		   leucocito= Math.round(leucocito*100.0)/100.0;
	 		   panelDatosMuestra.mostrarLeucocito(""+leucocito);  
	 	   }
	 	   else
	 	   {
	 	   JOptionPane.showMessageDialog(this,"Los datos ingresados no son correctos.",
	 			   						"Calcular Leucocitos",JOptionPane.ERROR_MESSAGE);	
	 	   }  	   
	 		
	 	}

		public void Retroceder() {
			Paciente actual = sistemaPacientes.darPacienteAnterior();	
			actualizarInfoPaciente(actual);
		}
	 	


}
