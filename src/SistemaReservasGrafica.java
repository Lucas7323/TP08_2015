import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.TableColumn;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


public class SistemaReservasGrafica implements ActionListener {
	private JFrame ventana = new JFrame("Sistema de reservas");
	Scanner stdin = new Scanner(System.in);

	//Contenedores 
	private JPanel panelPrincipal = new  JPanel();
	//archivos
	FileWriter archivoEscritura=null;
	PrintWriter escribirArchivo=null;
	File archivoLectura=null;
	Scanner leerArchivo=null;

	//Tabla para mostrar cocheras
	private JPanel panelTituloCocheras=new JPanel();
	private JPanel panelTablaCocheras= new JPanel();
	private JButton actualizarCocheras;
	private JLabel tituloCocheras;
	private JPanel panelActualizarCocheras = new JPanel();
	private DefaultTableModel tablaModelo;
	private String columnNames[];
	private Object filas[][];
	private JTable tablaReservas; 
	private TableColumn columna0;
	private TableColumn columna1;
	//copia de cocheras para usar en el actionListener
	private ArrayList<Cochera> cocherasAux;


	//componente del AltaCliente
	private JPanel panelTituloAltaCliente=new JPanel();
	private JLabel tituloAltaCliente;
	private JPanel panelAltaCliente= new JPanel();
	private JPanel panelContenedorAltaCliente= new JPanel();
	private JPanel panelVehiculoAltaCliente= new JPanel();
	private JPanel panelTituloVehiculoAltaCliente=new JPanel();
	private JLabel tituloVehiculoAltaCliente=new JLabel();
	private JPanel panelContenedorVehiculoAltaCliente= new JPanel();
	private JLabel nombre;
	private JTextField nombreTexto;
	private JLabel nombreOk;
	private boolean nOk=false;
	private JLabel apellido;
	private JTextField apellidoTexto;
	private JLabel apellidoOk;
	private boolean aOk=false;
	private JLabel mail;
	private JTextField mailTexto;
	private JLabel mailOk;
	private boolean mOk=false;
	private JLabel telefono;
	private JTextField telefonoTexto;
	private JLabel telefonoOk;
	private boolean tOk=false;
	private JLabel dni;
	private JTextField dniTexto;
	private JLabel dniOk ;
	private boolean dOk=false;
	private JLabel domicilio;
	private JTextField domicilioTexto;
	private JLabel domicilioOk;
	private boolean doOk=false;
	private JLabel provincia;
	private JComboBox provinciaTexto;
	private JLabel provinciaOk;
	private boolean prOk=false;
	private String provinciaString[];
	private JLabel cp;
	private JComboBox cpTexto;
	private JLabel cpOk;
	private boolean cOk=false;
	private JPanel panelBotonesSiguienteCancelarAltaCliente= new JPanel();
	private JButton botonSiguienteAltaCliente;
	private JButton botonCancelarAltaCliente;
	//pantalla vehiculo
	private JLabel tipo;
	private JComboBox tipoTexto;
	private String tipoString[];
	private JLabel tipoTextoOk;
	private boolean tiOk=false;
	private JLabel patente;
	private JTextField patenteTexto;
	private JLabel patenteTextoOk;
	private boolean pOk=false;
	private JLabel marca;
	private JComboBox marcaTexto;
	private JLabel marcaTextoOk;
	private boolean maOk=false;
	private JLabel modelo;
	private JComboBox modeloTexto;
	private JLabel modeloTextoOk;
	private boolean moOk=false;
	private JButton botonFinalizarAltaCliente;
	private JButton botonCancelarVehiculoAltaCliente;
	private JLabel leyendaAltaCliente;
	private JPanel panelAltaFinalizadaAltaCliente=new JPanel();
	private String dias[]= {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabados","Domingos"};
	private JList diasFrecuentes;
	private ArrayList<String>diasFrecuentesAux = new ArrayList<>();
	private String diasFrecu= new String();
	private JButton botonDiasFrecuentes;
	private JScrollPane scrollbarDiasFrecuentes;
	private JPanel panelDiasFrecuentes= new JPanel();
	private JLabel textoDiasFrecuentes;
	private String vehiculos[]={"Moto","Camioneta","Bicicleta","Cuatriciclo"};
	private JList vehiculosCliente;
	private ArrayList<String> otrosVehiculosAux= new ArrayList<>();
	private String otrosVehiculos= new String();
	private JScrollPane scrollbarVehiculosCliente;
	private JPanel panelVehiculosCliente= new JPanel();
	private JLabel textoVehiculosCliente;
	private JList copiaVehiculosCliente;
	private JScrollPane scrollbarCopiaVehiculosCliente;
	private JPanel panelCopiaVehiculosCliente= new JPanel();
	private DefaultListModel modeloListas;
	private JButton botonVehiculosCliente;
	private JButton botonQuitarVehiculosCliente;
	private JPanel panelBotonVehiculosCliente=new JPanel();
	private JPanel contenedorListasVehiculosCliente=new JPanel();

	private ArrayList<Cliente> clientesAux= new ArrayList<Cliente>();
	private Cliente cliente;
	private int existecliente;
	private String archivoCliente="archivos/clientes.txt";
	private String archivoProvincias="archivos/archivosDeAplicacion/provincias.txt";
	private String archivoCP="archivos/archivosDeAplicacion/cpLocalidades.txt";
	private String archivoMarcas="archivos/archivosDeAplicacion/marcaVehiculo.txt";
	private String archivoModelos="archivos/archivosDeAplicacion/modelosVehiculo.txt";
	private String archivoTipos="archivos/archivosDeAplicacion/tipoVehiculo.txt";

	//Consultar y actualizar clientes
	private JPanel panelTituloConsultaActualizaCliente=new JPanel();
	private JLabel tituloConsultaActualizaCliente;
	private JPanel panelConsultaActualizaCliente= new JPanel();
	private JPanel panelCamposConsultaActualizaCliente=new JPanel();
	private JPanel panelBotonesConsultaActualizaCliente=new JPanel();
	private JPanel panelLeyendaConsultaActualizaCliente=new JPanel();
	private JLabel buscar1ConsultaActualizaCliente;
	private JTextField buscarTexto1ConsultaActualizaCliente;
	private JButton botonBuscarConsultaActualizaCliente;
	private JLabel leyendaBuscarConsultaActualizaCliente;
	private JButton botonCancelarBuscarConsultaActualizaCliente;
	//Modificar Cliente
	private JButton botonModificarConsultaActualizaCliente;
	private JButton botonGuardarModificarConsultaActualizaCliente;
	//Baja Cliente
	private JPanel panelBajaCambiosCliente= new JPanel();
	private JPanel panelLeyendaBajaCambiosCliente=new JPanel();
	private JLabel leyendaBuscarBajaCambiosCliente;
	private JButton bajaCliente;



	//nueva reserva
	//Buscar Cliente
	private JPanel panelBuscarClienteNuevaReserva=new JPanel();
	private JPanel panelTituloClienteNuevaReserva =new JPanel();
	private JPanel panelCamposBuscarClienteNuevaReserva=new JPanel();
	private JPanel panelBotonesBuscarClienteNuevaReserva= new JPanel();
	private JPanel panelLeyendaBuscarClienteNuevaReserva=new JPanel();
	private JLabel  tituloClienteNuevaReserva;
	private JLabel tituloClienteNuevaReserva2;
	private JLabel buscarClienteNuevaReserva;
	private JTextField textoBuscarClienteNuevaReserva;
	private JLabel leyendaBuscarClienteNuevaReserva;
	private JLabel leyendaCocherasdisponiblesClienteNuevaReserva;
	//nueva Reserva
	private JPanel panelCamposHoraNuevaReserva= new JPanel();
	private JPanel panelCamposComentarioNuevaReserva= new JPanel();
	private JPanel panelNuevaReserva=new JPanel();
	private JPanel panelCamposNuevaReserva=new JPanel();
	private JPanel panelBotonesNuevaReserva= new JPanel();
	private JPanel panelLeyendaNuevaReserva=new JPanel();
	private JPanel panelFormaPagoNuevaReserva=new JPanel();
	private JPanel panelCamposFormaPagoNuevaReserva=new JPanel();
	private JPanel panelBotonesFormaPagoNuevaReserva=new JPanel();
	private JPanel panelServiciosAdicionalesNuevaReserva=new JPanel();
	private JLabel textoServicioAdicionales;
	private JPanel panelCamposServiciosAdicionalesNuevaReserva=new JPanel();
	private JPanel panelBotonesServiciosAdicionalesNuevaReserva=new JPanel();
	private ButtonGroup contenedorRadioButtonFormaPago;
	private JRadioButton RbEfectivoFormaPago;
	private JRadioButton RbTarjetaFormaPago;
	private JLabel cantidadCocheras;
	private JTextField textoCantidadCocheras;
	private boolean efectivo=true;
	private JLabel textoFormaPago;
	private JLabel textoEfectivo;
	private JLabel textoTarjeta;
	private JLabel textoLavado;
	private JLabel textoRevision;
	private JCheckBox checkLavado;
	private boolean lavadoOk=false;
	private JCheckBox checkRevision;
	private boolean revisionOk=false;
	private JComboBox hora;
	private JComboBox minuto;
	private JLabel horaNuevaReserva;
	private JLabel minutoNuevaReserva;
	private JTextArea textoComentarioNuevaReserva;
	private JLabel comentarioNuevaReserva;
	private JButton botonCancelarNuevaReserva;
	private JButton botonNuevaReserva;
	private JLabel numeroNuevaReserva;
	private JTextField textoNumeroNuevaReserva;
	private JLabel numeroCocheraNuevaReserva;
	private JTextField textoNumeroCocheraNuevaReserva;
	private JLabel leyendaNuevaReserva;
	private int contadorReservas=0;
	private ArrayList<Reserva> reservas=new ArrayList<Reserva>();

	//finalizar reserva
	private JLabel tituloFinalizarReserva;
	private JLabel leyendaFinalizarReserva;
	private JButton botonFinalizarReserva;
	private JButton botonCancelarFinalizarReserva;
	private JPanel panelFinalizarReserva =new JPanel();
	private JPanel panelCamposFinalizarReserva =new JPanel();
	private JPanel panelBotonesFinalizarReserva =new JPanel();
	private JTextField textoNumeroFinalizarReserva;

	//consulta masiva
	private JButton botonFiltrarConsulta;
	private JTextField textoFiltrarConsulta;
	private JPanel panelConsultaMasivaClientes= new JPanel();
	private JPanel panelTituloConsultaMasivaClientes= new JPanel();
	private JLabel tituloConsultaMasivaClientes;
	private JLabel totalRegistrosConsultaMasiva;
	private int totalRegistros=0;
	
	//Menues
	private JMenuBar barraMenu;
	private JMenu fileOperaciones;
	private JMenuItem consultaReservaActual;
	private JMenu fileCliente;
	private JMenuItem altaCliente;
	private JMenuItem consultaActualizaCliente;
	private JMenu fileReservas;
	private JMenuItem nuevaReserva;
	private JMenuItem finalizarReserva;
	private JMenu fileConsulta;
	private JMenuItem consultaReservaCliente;
	private JMenuItem consultaClientes;
	private JMenu fileSistema;
	private JMenuItem salir;
	private JMenuItem acercaDe;



	public SistemaReservasGrafica(ArrayList <Cochera> cocheras, ArrayList <Cliente> clientes){
		cocherasAux=cocheras;
		clientesAux=clientes;	

		//---------------------------------------------Item Estado cocheras---------------------------------------------
		//JTable de la pantalla principal
		actualizarCocheras= new JButton();
		actualizarCocheras.addActionListener(this);
		//Ejecuta el acction performed
		actualizarCocheras.doClick();

		barraMenu = new JMenuBar();
		fileOperaciones= new JMenu("Operaciones");
		consultaReservaActual= new JMenuItem("Estado Actual");
		fileCliente = new JMenu("Cliente");
		altaCliente= new JMenuItem("Alta Cliente");
		altaCliente.addActionListener(this); 
		consultaActualizaCliente= new JMenuItem("Consultar y  Actualizar Cliente");
		consultaActualizaCliente.addActionListener(this);

		fileCliente.add(altaCliente);
		fileCliente.add(consultaActualizaCliente);

		fileReservas= new JMenu("Reservas");
		nuevaReserva= new JMenuItem("Nueva reserva");
		nuevaReserva.addActionListener(this);
		finalizarReserva= new JMenuItem("Finalizar reserva");
		finalizarReserva.addActionListener(this);
		fileReservas.add(nuevaReserva);
		fileReservas.add(finalizarReserva);

		fileConsulta= new JMenu("Consultas");
		consultaReservaCliente= new JMenuItem("Consulta Reservas");
		consultaReservaCliente.addActionListener(this);
		fileConsulta.add(consultaReservaCliente);
		consultaClientes= new JMenuItem("Consulta masiva clientes");
		consultaClientes.addActionListener(this);
		fileConsulta.add(consultaClientes);
		//directamente muestra las cocheras libres
		consultaReservaActual.addActionListener(this);
		fileConsulta.add(consultaReservaActual);
		
		fileOperaciones.add(consultaReservaActual);
		fileOperaciones.add(fileCliente);
		fileOperaciones.add(fileReservas);
		fileOperaciones.add(fileConsulta);
		//-------------//
		fileSistema = new JMenu("Sistema");

		salir=new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				if(JOptionPane.showConfirmDialog(null, "Desea salir del sistemas?:", "Confirme", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				System.exit(0);
				}


			}
		});

		int cargaClientes=existeCliente("");
				
		
		acercaDe=new JMenuItem("Acerca de...");
		acercaDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog (null, "Sistema de reserva de cocheras.","Acerca de...",1);

			}
		});
		fileSistema.add(acercaDe);
		fileSistema.add(salir);
		barraMenu.add(fileOperaciones);
		barraMenu.add(fileSistema);
		ventana.add(panelPrincipal);
		ventana.setLayout(new FlowLayout());
		ventana.setJMenuBar(barraMenu);
		ventana.setVisible(true);
		ventana.setSize(900,700);

	}



	@Override
	public void actionPerformed(ActionEvent e) {


		//---------------------------------------------Item Estado Actual ---------------------------------------------
		if (e.getSource()==actualizarCocheras||e.getSource()==consultaReservaActual){
			panelPrincipal.removeAll();
			panelActualizarCocheras.removeAll();
			panelTablaCocheras.removeAll();
			panelTituloCocheras.removeAll();
			panelTablaCocheras.repaint();
			panelPrincipal.updateUI();
			actualizarCocheras= new JButton("Actualizar");
			actualizarCocheras.addActionListener(this);
			tituloCocheras= new JLabel();
			tituloCocheras.setText("Sistemas de reserva de cocheras");
			tituloCocheras.setFont(new Font("Italic",Font.BOLD,17));

			//JTable
			columnNames= new String [2];
			columnNames[0]="N Cochera";
			columnNames[1]="Disponible";
			//tipo object

			//se dimensiona tomando el tamano del array
			filas=new Object[cocherasAux.size()][2];
			for(int i=0;i<cocherasAux.size();i++){
				filas[i][0]=Integer.toString(cocherasAux.get(i).getNumeroCochera());
				if(cocherasAux.get(i).isDisponible()){
					filas[i][1]="Disponible";
				}else{
					filas[i][1]="Ocupado";
				}

			}
			//JTable celdas no editables.
			tablaModelo=new DefaultTableModel(filas, columnNames){
				@Override
				public boolean isCellEditable(int row, int column) {
					//all cells false
					return false;
				}

			}; 
			tablaReservas = new JTable(tablaModelo);

			tablaReservas.getColumn("Disponible").setCellRenderer(new DefaultTableCellRenderer(){

				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

					DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) 
							super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					setHorizontalAlignment(SwingConstants.CENTER);
					table.getColumnModel().getColumn(1).setCellRenderer(this);

					if(String.valueOf(table.getValueAt(row,1)).equals("Disponible")){
						setForeground(Color.GREEN);

					}else{  
						if(String.valueOf(table.getValueAt(row,1)).equals("Ocupado")){
							setForeground(Color.RED);
						}
					}
					return renderer;
				}
			});

			tablaReservas.setFont(new Font("Italic",Font.BOLD,15));	
			panelTablaCocheras.setLayout(new BoxLayout(panelTablaCocheras,BoxLayout.Y_AXIS));
			columna0 = tablaReservas.getColumn(columnNames[0]);//obtiene la columna de la tabla. el tipo de datos es TableColumn
			columna1 = tablaReservas.getColumn(columnNames[1]);//obtiene la columna de la tabla. el tipo de datos es TableColumn
			columna0.setPreferredWidth(150);//ancho de la columna
			columna1.setPreferredWidth(150);//ancho de la columna
			JTableHeader header = tablaReservas.getTableHeader();
			TablaRenderer renderHeader = new TablaRenderer();
			header.setDefaultRenderer(renderHeader.tablaRendererHeader(tablaReservas));

			//Panel para el titulo
			panelTituloCocheras.add(tituloCocheras);
			panelTablaCocheras.add(panelTituloCocheras);
			//panel del header y tabla que va a contener al titulo y al boton actualizar
			panelTablaCocheras.add(tablaReservas.getTableHeader());
			panelTablaCocheras.add(tablaReservas);
			//panel para el boton
			panelActualizarCocheras.add(actualizarCocheras);
			panelTablaCocheras.add(panelActualizarCocheras);
			// el panelTablaCochera contiene el panel del titulo, el header de la tabla y la tabla y el panel del boton
			panelPrincipal.add(panelTablaCocheras);
		}


		//---------------------------------------------Item Alta Cliente---------------------------------------------
		if(e.getSource()==altaCliente){
			panelPrincipal.removeAll();	
			panelContenedorAltaCliente.removeAll();
			panelAltaCliente.removeAll();
			panelTituloAltaCliente.removeAll();
			panelBotonesSiguienteCancelarAltaCliente.removeAll();
			panelDiasFrecuentes.removeAll();
			panelCopiaVehiculosCliente.removeAll();
			panelVehiculosCliente.removeAll();
			panelBotonVehiculosCliente.removeAll();
			panelContenedorVehiculoAltaCliente.removeAll();
			panelPrincipal.updateUI();


			nombre = new JLabel("Nombre");
			nombreTexto= new JTextField(15);
			nombreOk= new JLabel();

			apellido = new JLabel("Apellido");
			apellidoTexto= new JTextField(15);
			apellidoOk= new JLabel();

			mail = new JLabel("Mail");
			mailTexto= new JTextField(15);
			mailOk= new JLabel();

			telefono = new JLabel("Telefono");
			telefonoTexto= new JTextField(15);
			telefonoOk = new JLabel();

			dni = new JLabel("DNI (sin puntos)");
			dniTexto= new JTextField(15);
			dniOk = new JLabel();


			domicilio = new JLabel("Domicilio");
			domicilioTexto= new JTextField(15);
			domicilioOk= new JLabel();


			provincia = new JLabel("Provincia");
			provinciaTexto= new JComboBox();
			provinciaOk=new JLabel();
			archivoProvincias();
			provinciaTexto.addActionListener(this);

			cp = new JLabel("CP");
			cpTexto= new JComboBox();
			cpOk=new JLabel();

			
			//Lista estatica con seleccion multiple
			//Inicializo el array 
			diasFrecu="-";
			otrosVehiculos="-";
			textoDiasFrecuentes=new JLabel("Dias reservas frecuentes:");
			diasFrecuentes= new JList(dias);
			botonDiasFrecuentes=new JButton("Seleccionar");
			scrollbarDiasFrecuentes= new JScrollPane(diasFrecuentes);
			diasFrecuentes.setVisibleRowCount(5);
			diasFrecuentes.setFont(new Font("Italic",Font.BOLD,12));
			diasFrecuentes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			botonDiasFrecuentes.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Object [] elementos = diasFrecuentes.getSelectedValues();
					diasFrecu="";
					String prueba=new String ();
					for (Object elementos2: elementos) {
						diasFrecuentesAux.add((String)elementos2);
						
					}
					
				}
				});
			
			
			panelDiasFrecuentes.add(textoDiasFrecuentes);
			panelDiasFrecuentes.add(scrollbarDiasFrecuentes);
			panelDiasFrecuentes.add(botonDiasFrecuentes);
			panelDiasFrecuentes.setLayout(new BoxLayout (panelDiasFrecuentes,BoxLayout.Y_AXIS ));

			//Lista dinamica con seleccion multiple
			textoVehiculosCliente=new JLabel("Otros vehiculos del Cliente");
			botonVehiculosCliente=new JButton("Seleccionar");
			botonVehiculosCliente.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Object [] elemSel = vehiculosCliente.getSelectedValues();
					otrosVehiculos=" ";
					for(Object eSel: elemSel ){
						modeloListas.addElement((String)eSel);
						otrosVehiculosAux.add((String)eSel);
					}
					
					
				}
				
			});

	
			panelBotonVehiculosCliente.add(botonVehiculosCliente);
			panelBotonVehiculosCliente.setLayout(new BoxLayout(panelBotonVehiculosCliente, BoxLayout.Y_AXIS));

			vehiculosCliente=new JList(vehiculos);
			scrollbarVehiculosCliente= new JScrollPane(vehiculosCliente);
			vehiculosCliente.setVisibleRowCount(3);
			vehiculosCliente.setFixedCellWidth(250);
			vehiculosCliente.setFont(new Font("Italic",Font.BOLD,12));
			vehiculosCliente.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			panelVehiculosCliente.add(scrollbarVehiculosCliente);

			modeloListas= new DefaultListModel();
			copiaVehiculosCliente=new JList(modeloListas);
			scrollbarCopiaVehiculosCliente=new JScrollPane(copiaVehiculosCliente);
			copiaVehiculosCliente.setVisibleRowCount(3);
			copiaVehiculosCliente.setFont(new Font("Italic",Font.BOLD,12));
			copiaVehiculosCliente.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			panelCopiaVehiculosCliente.add(scrollbarCopiaVehiculosCliente);

			JPanel panelContenedor1VehiculoAltaCliente = new JPanel();
			JPanel panelContenedor2VehiculoAltaCliente = new JPanel();
			panelContenedor1VehiculoAltaCliente.add(textoVehiculosCliente);
			panelContenedor2VehiculoAltaCliente.add(panelVehiculosCliente);
			panelContenedor2VehiculoAltaCliente.add(panelBotonVehiculosCliente);
			panelContenedor2VehiculoAltaCliente.add(panelCopiaVehiculosCliente);
			panelContenedorVehiculoAltaCliente.add(panelContenedor1VehiculoAltaCliente);
			panelContenedorVehiculoAltaCliente.add(panelContenedor2VehiculoAltaCliente);
			panelContenedorVehiculoAltaCliente.setLayout(new BoxLayout(panelContenedorVehiculoAltaCliente, BoxLayout.Y_AXIS));	

			panelAltaCliente.add(nombre);
			panelAltaCliente.add(nombreTexto);
			nombreOk.setVisible(false);
			panelAltaCliente.add(nombreOk);

			panelAltaCliente.add(apellido);
			panelAltaCliente.add(apellidoTexto);
			apellidoOk.setVisible(false);
			panelAltaCliente.add(apellidoOk);

			panelAltaCliente.add(mail);
			panelAltaCliente.add(mailTexto);
			mailTexto.addActionListener(this);
			mailOk.setVisible(false);
			panelAltaCliente.add(mailOk);

			panelAltaCliente.add(telefono);
			panelAltaCliente.add(telefonoTexto);
			telefonoTexto.addActionListener(this);
			telefonoOk.setVisible(false);
			panelAltaCliente.add(telefonoOk);

			panelAltaCliente.add(dni);
			panelAltaCliente.add(dniTexto);
			dniTexto.addActionListener(this);
			dniOk.setVisible(false);
			panelAltaCliente.add(dniOk);

			panelAltaCliente.add(domicilio);
			panelAltaCliente.add(domicilioTexto);
			domicilioOk.setVisible(false);
			panelAltaCliente.add(domicilioOk);

			panelAltaCliente.add(provincia);
			panelAltaCliente.add(provinciaTexto);
			provinciaOk.setVisible(false);
			panelAltaCliente.add(provinciaOk);

			panelAltaCliente.add(cp);
			panelAltaCliente.add(cpTexto);
			cpOk.setVisible(false);
			panelAltaCliente.add(cpOk);

			panelAltaCliente.setLayout(new GridLayout(9,3));

			botonSiguienteAltaCliente= new JButton("Siguiente");
			botonSiguienteAltaCliente.addActionListener(this);

			botonCancelarAltaCliente=new JButton("Cancelar");
			botonCancelarAltaCliente.addActionListener(this);
			botonCancelarAltaCliente.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(JOptionPane.showConfirmDialog(null, "Desea cancelar el alta del cliente?", "Confirme", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
						altaCliente.doClick();
					}

				}
			});


			panelBotonesSiguienteCancelarAltaCliente.add(botonCancelarAltaCliente);
			panelBotonesSiguienteCancelarAltaCliente.add(botonSiguienteAltaCliente);

			tituloAltaCliente=new JLabel();
			tituloAltaCliente.setText("Alta de Cliente");
			tituloAltaCliente.setFont(new Font("Italic",Font.BOLD,17));
			panelTituloAltaCliente.add(tituloAltaCliente);
			panelContenedorAltaCliente.setLayout(new BoxLayout(panelContenedorAltaCliente, BoxLayout.Y_AXIS));
			panelContenedorAltaCliente.add(panelTituloAltaCliente);
			panelContenedorAltaCliente.add(panelAltaCliente);
			panelContenedorAltaCliente.add(panelDiasFrecuentes);
			panelContenedorAltaCliente.add(panelContenedorVehiculoAltaCliente);
			panelContenedorAltaCliente.add(panelBotonesSiguienteCancelarAltaCliente);
			panelPrincipal.add(panelContenedorAltaCliente);
			//panelPrincipal.repaint();

		}

		//combo cp
		if(e.getSource()==provinciaTexto){

			Object string= provinciaTexto.getSelectedItem(); 
			String texto = String.valueOf(string);
			cpTexto.removeAllItems();	
			try{

				archivoLectura=new File(archivoCP);
				leerArchivo= new Scanner(archivoLectura);
				ArrayList<String> cp= new ArrayList<>();
				while(leerArchivo.hasNextLine()){
					cp.add(leerArchivo.nextLine());
				}
				//la primer posicion del archivo tiene la provincia
				for (int i = 0; i < cp.size(); i++) {
					String cpAux[]=cp.get(i).split(";");
					if(texto.equals(cpAux[0])){
						cpTexto.removeAllItems();
						for (int j = 1; j < cpAux.length; j++) {
							cpTexto.addItem(cpAux[j]);
						}
					}
				}
			}catch(IOException error ){
				if(!archivoLectura.exists()){
					JOptionPane.showMessageDialog (null, "No se encuentra archivo "+ archivoLectura.getName(),"Error",2);
				}else{
					JOptionPane.showMessageDialog (null, "Error IOException","Error",2);
				}
			}
		}


		//valida campo nombre no vacio
		if(e.getSource()==botonSiguienteAltaCliente||e.getSource()==botonGuardarModificarConsultaActualizaCliente){
			if(!nombreTexto.getText().equals("")){
				nOk=true;
				nombreOk.setVisible(false);
			}else{
				nOk=false;
				nombreOk.setText("No ingreso Nombre");
				nombreOk.setVisible(true);
				nombreOk.setForeground(Color.RED);
			}

		}

		//valida campo apellido no vacio
		if(e.getSource()==botonSiguienteAltaCliente||e.getSource()==botonGuardarModificarConsultaActualizaCliente){
			if(!apellidoTexto.getText().equals("")){
				aOk=true;
				apellidoOk.setVisible(false);
			}else{
				aOk=false;
				apellidoOk.setText("No ingreso Apellido");
				apellidoOk.setVisible(true);
				apellidoOk.setForeground(Color.RED);
			}

		}
		//Validacion mail
		if(e.getSource()==mailTexto||e.getSource()==botonSiguienteAltaCliente||e.getSource()==botonGuardarModificarConsultaActualizaCliente){

			Pattern patron= Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$");
			Matcher match= patron.matcher(mailTexto.getText());

			if(match.find()){
				mOk=true;
				mailOk.setVisible(false);
			}else{
				if(mailTexto.getText().equals("")){
					mOk=false;
					mailOk.setText("No ingreso mail");
					mailOk.setVisible(true);
					mailOk.setForeground(Color.RED);
				}else{
					mailOk.setVisible(true);
					mailOk.setForeground(Color.RED);
					mailOk.setText("Mail invalido");
				}
			}

		}

		//valida campo telefono no vacio y que sea un numero
		if(e.getSource()==telefonoTexto||e.getSource()==botonSiguienteAltaCliente||e.getSource()==botonGuardarModificarConsultaActualizaCliente){
			if(!telefonoTexto.getText().equals("")){
				try{
			
					long telefono=Integer.parseInt(telefonoTexto.getText());	
					tOk=true;
					telefonoOk.setVisible(false);

				}catch(Exception numberFoException){

					tOk=false;
					telefonoOk.setText("Ingrese un valor numerico.");
					telefonoOk.setForeground(Color.RED);
					telefonoOk.setVisible(true);
				}

			}else{
				tOk=false;
				telefonoOk.setText("No ingreso telefono");
				telefonoOk.setVisible(true);
				telefonoOk.setForeground(Color.RED);
			}

		}
		//Validacion de DNI
		if(e.getSource()==dniTexto||e.getSource()==botonSiguienteAltaCliente){

			try{
				long dni=Integer.parseInt(dniTexto.getText());	
				if(dni>2000000&&dni<45000000){
					dOk=true;
					dniOk.setVisible(false);

				}else{
					dOk=false;
					dniOk.setVisible(true);
					dniOk.setForeground(Color.RED);
					dniOk.setText("Ingrese un valor valido");
				}

			}catch(Exception numberFoException){
				if(dniTexto.getText().equals("")){
					dOk=false;
					dniOk.setText("No ingreso DNI");
					dniOk.setForeground(Color.RED);
					dniOk.setVisible(true);
				}else{
					dOk=false;
					dniOk.setText("Ingrese un valor numerico.");
					dniOk.setForeground(Color.RED);
					dniOk.setVisible(true);
				}
			}

		}	
		//valida campo domicilio no vacio
		if(e.getSource()==botonSiguienteAltaCliente||e.getSource()==botonGuardarModificarConsultaActualizaCliente){
			if(!domicilioTexto.getText().equals("")){
				doOk=true;
				domicilioOk.setVisible(false);
			}else{
				doOk=false;
				domicilioOk.setText("No ingreso domicilio");
				domicilioOk.setVisible(true);
				domicilioOk.setForeground(Color.RED);
			}

		}

		//valida campo provincia no vacio
		if(e.getSource()==botonSiguienteAltaCliente||e.getSource()==botonGuardarModificarConsultaActualizaCliente){
			Object string= provinciaTexto.getSelectedItem(); 
			String texto = String.valueOf(string);

			if(!texto.equals("")){
				prOk=true;
				provinciaOk.setVisible(false);
			}else{
				prOk=false;
				provinciaOk.setText("No selecciono provincia.");
				provinciaOk.setVisible(true);
				provinciaOk.setForeground(Color.RED);
			}

		}



		//valida campo cp no vacio
		if(e.getSource()==botonSiguienteAltaCliente||e.getSource()==botonGuardarModificarConsultaActualizaCliente){

			Object string= cpTexto.getSelectedItem(); 
			String texto = String.valueOf(string);
			if(!texto.equals("")){
				cOk=true;
				cpOk.setVisible(false);
			}else{
				cOk=false;
				cpOk.setText("No selecciono Codigo postal.");
				cpOk.setVisible(true);
				cpOk.setForeground(Color.RED);
			}

		}


		//----------------- Vehiculo Alta cliente-----------------

		if(e.getSource()==botonSiguienteAltaCliente&&nOk&&aOk&&mOk&&tOk&&dOk&&doOk&&cOk&&prOk){
			
			//Guardo los elementos seleccionados en la lista estatica
			for (int j = 0; j < diasFrecuentesAux.size(); j++) {
				diasFrecu+=diasFrecuentesAux.get(j);
			
			}
			
			//Guardo los elementos seleccionados en la lista dinamicas
			for (int j = 0; j < modeloListas.size(); j++) {
				otrosVehiculos+=otrosVehiculosAux.get(j);
			}
			
			panelPrincipal.removeAll();
			panelVehiculoAltaCliente.removeAll();
			panelContenedorVehiculoAltaCliente.removeAll();
			panelTituloVehiculoAltaCliente.removeAll();
			panelPrincipal.updateUI();


			//tipo
			tipo =new JLabel("Tipo vehiculo");
			tipoTexto=new JComboBox();
			tipoTextoOk=new JLabel();
			try{

				archivoLectura=new File(archivoTipos);
				leerArchivo= new Scanner(archivoLectura);
				String aux=leerArchivo.nextLine();
				tipoString=aux.split(";");
				tipoTexto= new JComboBox(tipoString);
				tipoTexto.addActionListener(this);

			}catch(IOException error ){
				if(!archivoLectura.exists()){
					JOptionPane.showMessageDialog (null, "No se encuentra archivo "+ archivoLectura.getName(),"Error",2);
				}else{
					JOptionPane.showMessageDialog (null, "Error IOException","Error",2);

				}
			}

			panelVehiculoAltaCliente.add(tipo);
			panelVehiculoAltaCliente.add(tipoTexto);
			panelVehiculoAltaCliente.add(tipoTextoOk);


			//marca
			marca =new JLabel();
			marca.setText("Marca");
			marcaTexto=new JComboBox();
			marcaTextoOk=new JLabel();
			marcaTextoOk.setVisible(false);
			panelVehiculoAltaCliente.add(marca);
			panelVehiculoAltaCliente.add(marcaTexto);
			panelVehiculoAltaCliente.add(marcaTextoOk);

			//modelo
			modelo =new JLabel();
			modelo.setText("Modelo");
			modeloTexto=new JComboBox();
			modeloTextoOk=new JLabel();
			modeloTextoOk.setVisible(false);
			panelVehiculoAltaCliente.add(modelo);
			panelVehiculoAltaCliente.add(modeloTexto);
			panelVehiculoAltaCliente.add(modeloTextoOk);


			//patente
			patente =new JLabel();
			patente.setText("Patente");
			patenteTexto=new JTextField(15);
			patenteTexto.addActionListener(this);
			patenteTextoOk=new JLabel();
			patenteTextoOk.setVisible(false);
			panelVehiculoAltaCliente.add(patente);
			panelVehiculoAltaCliente.add(patenteTexto);
			panelVehiculoAltaCliente.add(patenteTextoOk);

			botonCancelarVehiculoAltaCliente=new JButton("Cancelar");
			botonCancelarVehiculoAltaCliente.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(JOptionPane.showConfirmDialog(null, "Desea cancelar el alta del vehiculo del cliente?", "Confirme", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
						botonSiguienteAltaCliente.doClick();
					}
				}
			});
			botonFinalizarAltaCliente = new JButton("Finalizar alta usuario");
			botonFinalizarAltaCliente.addActionListener(this);
			panelVehiculoAltaCliente.add(botonCancelarVehiculoAltaCliente);
			panelVehiculoAltaCliente.add(botonFinalizarAltaCliente);
			panelVehiculoAltaCliente.setLayout(new GridLayout(5,2));
			leyendaAltaCliente= new JLabel();
			leyendaAltaCliente.setVisible(false);
			tituloVehiculoAltaCliente.setText("Alta vehiculo");
			tituloVehiculoAltaCliente.setFont(new Font("Italic",Font.BOLD,17));
			panelTituloVehiculoAltaCliente.add(tituloVehiculoAltaCliente);
			panelContenedorVehiculoAltaCliente.add(panelTituloVehiculoAltaCliente);
			panelContenedorVehiculoAltaCliente.add(panelVehiculoAltaCliente);
			panelContenedorVehiculoAltaCliente.add(leyendaAltaCliente);
			panelContenedorVehiculoAltaCliente.setLayout(new BoxLayout(panelContenedorVehiculoAltaCliente, BoxLayout.Y_AXIS));
			panelPrincipal.add(panelContenedorVehiculoAltaCliente);
		}


		//combo de marcas
		if(e.getSource()==tipoTexto){

			Object string= tipoTexto.getSelectedItem(); 
			String texto = String.valueOf(string);
			marcaTexto.removeAllItems();	
			try{

				archivoLectura=new File(archivoMarcas);
				leerArchivo= new Scanner(archivoLectura);
				ArrayList<String> marcas= new ArrayList<>();
				while(leerArchivo.hasNextLine()){
					marcas.add(leerArchivo.nextLine());
				}

				for (int i = 0; i < marcas.size(); i++) {
					String marcasAux[]=marcas.get(i).split(";");
					if(texto.equals(marcasAux[0])){
						marcaTexto.removeAllItems();
						for (int j = 1; j < marcasAux.length; j++) {
							marcaTexto.addItem(marcasAux[j]);
						}
					}
				}
				marcaTexto.addActionListener(this);

			}catch(IOException error ){
				if(!archivoLectura.exists()){
					JOptionPane.showMessageDialog (null, "No se encuentra archivo "+ archivoLectura.getName(),"Error",2);
				}else{
					JOptionPane.showMessageDialog (null, "Error IOException","Error",2);
				}
			}
		}

		//combo para la modelo
		if(e.getSource()==marcaTexto){
			Object string= marcaTexto.getSelectedItem(); 
			String texto = String.valueOf(string);
			modeloTexto.removeAllItems();	
			try{
				archivoLectura=new File(archivoModelos);
				leerArchivo= new Scanner(archivoLectura);
				ArrayList<String> modelos= new ArrayList<>();
				while(leerArchivo.hasNextLine()){
					modelos.add(leerArchivo.nextLine());
				}

				for (int i = 0; i < modelos.size(); i++) {
					String modelosAux[]=modelos.get(i).split(";");
					if(texto.equals((modelosAux[0]))){
						modeloTexto.removeAllItems();
						for (int j = 1; j < modelosAux.length; j++) {
							modeloTexto.addItem(modelosAux[j]);
						}
					}

				}

			}catch(IOException error ){
				if(!archivoLectura.exists()){
					JOptionPane.showMessageDialog (null, "No se encuentra archivo "+ archivoLectura.getName(),"Error",2);
				}else{
					JOptionPane.showMessageDialog (null, "Error IOException","Error",2);
				}
			}
		}

		//valida tipo vehiculo no este vacio
		if(e.getSource()==botonFinalizarAltaCliente){
			Object string= tipoTexto.getSelectedItem(); 
			String texto = String.valueOf(string);

			if(!texto.equals("")){
				tiOk=true;
				tipoTextoOk.setVisible(false);
			}else{
				tiOk=false;
				tipoTextoOk.setText("No selecciono tipo.");
				tipoTextoOk.setVisible(true);
				tipoTextoOk.setForeground(Color.RED);
			}
		}

		//valida marca vehiculo no este vacio
		if(e.getSource()==botonFinalizarAltaCliente){
			Object string= marcaTexto.getSelectedItem(); 
			String texto = String.valueOf(string);

			if(!texto.equals("")){
				maOk=true;
				marcaTextoOk.setVisible(false);
			}else{
				maOk=false;
				marcaTextoOk.setText("No selecciono marca.");
				marcaTextoOk.setVisible(true);
				marcaTextoOk.setForeground(Color.RED);
			}
		}

		//valida modelo vehiculo no este vacio
		if(e.getSource()==botonFinalizarAltaCliente){
			Object string= modeloTexto.getSelectedItem(); 
			String texto = String.valueOf(string);

			if(!texto.equals("")){
				moOk=true;
				modeloTextoOk.setVisible(false);
			}else{
				moOk=false;
				modeloTextoOk.setText("No selecciono modelo.");
				modeloTextoOk.setVisible(true);
				modeloTextoOk.setForeground(Color.RED);
			}
		}

		//valida patente vehiculo no este vacio
		if(e.getSource()==botonFinalizarAltaCliente||e.getSource()==patenteTexto){
			if(!patenteTexto.getText().equals("")){
				pOk=true;
				patenteTextoOk.setVisible(false);
			}else{
				pOk=false;
				patenteTextoOk.setText("No ingreso patente.");
				patenteTextoOk.setVisible(true);
				patenteTextoOk.setForeground(Color.RED);
			}
		}

		//-----------------Confirmacion de Alta -----------------
		//valida el alta del usuario
		if(e.getSource()==botonFinalizarAltaCliente&&tiOk&&pOk&&maOk&&moOk){
			panelPrincipal.removeAll();
			panelAltaFinalizadaAltaCliente.removeAll();

			//llamo a una funcion que revisa si el cliente existe
			existecliente=existeCliente(dniTexto.getText());

			if(existecliente==-1){
				cliente=new Cliente();
				Object string=cpTexto.getSelectedItem();
				String textoCp =String.valueOf(string);

				Object string2=provinciaTexto.getSelectedItem();
				String textoProvincia =String.valueOf(string2);

				string=tipoTexto.getSelectedItem();
				String textoTipo= String.valueOf(string);

				string=marcaTexto.getSelectedItem();
				String textoMarca =String.valueOf(string);

				string=modeloTexto.getSelectedItem();
				String textoModelo =String.valueOf(string);


				clientesAux.add(new Cliente(nombreTexto.getText(),apellidoTexto.getText(),mailTexto.getText(),telefonoTexto.getText(),domicilioTexto.getText(),Integer.parseInt(dniTexto.getText()),Integer.parseInt(textoCp),textoTipo,textoMarca,textoModelo,patenteTexto.getText(),textoProvincia,diasFrecu,otrosVehiculos));
				esribirArchivoCliente();
				leyendaAltaCliente.setText("Cliente creado exitosamente.");

			}else{
				leyendaAltaCliente.setText("Error al dar de alta: Cliente ya existe.");
			}


			leyendaAltaCliente.setFont(new Font("Italic",Font.BOLD,20));
			leyendaAltaCliente.setForeground(Color.BLUE);
			leyendaAltaCliente.setVisible(true);
			panelAltaFinalizadaAltaCliente.add(leyendaAltaCliente);
			panelPrincipal.add(panelAltaFinalizadaAltaCliente);		
		}

		//---------------------------------------------Item Consulta y actualizacion Cliente---------------------------------------------
		//menu busqueda de  cliente
		if(e.getSource()==consultaActualizaCliente){

			panelPrincipal.removeAll();//remueve todo los componentes del panelPrincipal	
			panelConsultaActualizaCliente.removeAll();
			panelCamposConsultaActualizaCliente.removeAll();
			panelBotonesConsultaActualizaCliente.removeAll();//remueve todos los componentes del panel
			panelLeyendaConsultaActualizaCliente.removeAll();
			panelTituloConsultaActualizaCliente.removeAll();
			panelPrincipal.updateUI();//Actualiza la GUI
			buscar1ConsultaActualizaCliente=new JLabel("Ingrese el DNI o NOMBRE del cliente  ");
			buscarTexto1ConsultaActualizaCliente=new JTextField(10);
			botonBuscarConsultaActualizaCliente=new JButton("Consultar");
			botonBuscarConsultaActualizaCliente.addActionListener(this);
			botonCancelarBuscarConsultaActualizaCliente=new JButton("Cancelar");
			botonCancelarBuscarConsultaActualizaCliente.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(JOptionPane.showConfirmDialog(null, "Desea cancelar la busqueda del cliente?", "Confirme", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
						consultaActualizaCliente.doClick();
					}

				}
			});

			leyendaBuscarConsultaActualizaCliente= new JLabel();
			leyendaBuscarConsultaActualizaCliente.setVisible(false);
			tituloConsultaActualizaCliente=new JLabel();
			tituloConsultaActualizaCliente.setText("Consultar y actualizar Cliente");
			tituloConsultaActualizaCliente.setFont(new Font("Italic",Font.BOLD,17));
			panelTituloConsultaActualizaCliente.add(tituloConsultaActualizaCliente);
			panelCamposConsultaActualizaCliente.add(buscar1ConsultaActualizaCliente);
			panelCamposConsultaActualizaCliente.add(buscarTexto1ConsultaActualizaCliente);
			panelBotonesConsultaActualizaCliente.add(botonCancelarBuscarConsultaActualizaCliente);
			panelBotonesConsultaActualizaCliente.add(botonBuscarConsultaActualizaCliente);
			panelLeyendaConsultaActualizaCliente.add(leyendaBuscarConsultaActualizaCliente);
			panelConsultaActualizaCliente.add(panelTituloConsultaActualizaCliente);
			panelConsultaActualizaCliente.add(panelCamposConsultaActualizaCliente);
			panelConsultaActualizaCliente.add(panelBotonesConsultaActualizaCliente);
			panelConsultaActualizaCliente.add(panelLeyendaConsultaActualizaCliente);
			panelConsultaActualizaCliente.setLayout(new BoxLayout(panelConsultaActualizaCliente, BoxLayout.Y_AXIS));
			panelPrincipal.add(panelConsultaActualizaCliente);

		}
		
		//busqueda en el array que el cliente exista
		if(e.getSource()==botonBuscarConsultaActualizaCliente||e.getSource()==buscarTexto1ConsultaActualizaCliente){

			if(buscarTexto1ConsultaActualizaCliente.getText().equals("")){
				leyendaBuscarConsultaActualizaCliente.setForeground(Color.RED);
				leyendaBuscarConsultaActualizaCliente.setText("No se ingreso datos para buscar.");
				leyendaBuscarConsultaActualizaCliente.setVisible(true);
			}else{

				existecliente= existeCliente(buscarTexto1ConsultaActualizaCliente.getText());

				//utilizo los mismos componentes que utilice en la interfaz del alta de cliente
				if(existecliente!=-1){
					panelPrincipal.removeAll();	
					panelContenedorAltaCliente.removeAll();
					panelAltaCliente.removeAll();
					panelTituloAltaCliente.removeAll();
					panelPrincipal.updateUI();

					nombre = new JLabel("Nombre");
					nombreTexto= new JTextField(15);
					nombreTexto.setText(clientesAux.get(existecliente).getNombre());
					nombreTexto.setEditable(false);
					nombreOk= new JLabel();

					apellido = new JLabel("Apellido");
					apellidoTexto= new JTextField(15);
					apellidoTexto.setText(clientesAux.get(existecliente).getApellido());
					apellidoTexto.setEditable(false);
					apellidoOk= new JLabel();

					mail = new JLabel("Mail");
					mailTexto= new JTextField(15);
					mailTexto.setText(clientesAux.get(existecliente).getMail());
					mailTexto.setEditable(false);
					mailOk= new JLabel();

					telefono = new JLabel("Telefono");
					telefonoTexto= new JTextField(15);
					telefonoTexto.setText(clientesAux.get(existecliente).getTelefono());
					telefonoTexto.setEditable(false);
					telefonoOk = new JLabel();

					dni = new JLabel("DNI *");
					dniTexto= new JTextField(15);
					//el dni no lo puedo modificar
					dniTexto.setEditable(false);
					dniTexto.setText(Long.toString(clientesAux.get(existecliente).getDni()));
					dniOk = new JLabel();

					domicilio = new JLabel("Domicilio");
					domicilioTexto= new JTextField(15);
					domicilioTexto.setText(clientesAux.get(existecliente).getDomicilio());
					domicilioTexto.setEditable(false);
					domicilioOk= new JLabel();

					provincia = new JLabel("Provincia");
					provinciaOk=new JLabel();
					provinciaTexto= new JComboBox();
					archivoProvincias();
					provinciaTexto.setEnabled(false);
					for (int i = 0; i < provinciaString.length; i++) {
						if(provinciaString[i].equals(clientesAux.get(existecliente).getProvincia())){
							provinciaTexto.setSelectedIndex(i);

						}
					}

					cp = new JLabel("CP");
					cpOk=new JLabel();
					String []aux=new String[2];
					aux[0]=Integer.toString(clientesAux.get(existecliente).getCp());
					cpTexto= new JComboBox(aux);
					cpTexto.setEnabled(false);

					panelAltaCliente.add(nombre);
					panelAltaCliente.add(nombreTexto);
					nombreOk.setVisible(false);
					panelAltaCliente.add(nombreOk);

					panelAltaCliente.add(apellido);
					panelAltaCliente.add(apellidoTexto);
					apellidoOk.setVisible(false);
					panelAltaCliente.add(apellidoOk);

					panelAltaCliente.add(mail);
					panelAltaCliente.add(mailTexto);
					mailTexto.addActionListener(this);
					mailOk.setVisible(false);
					panelAltaCliente.add(mailOk);

					panelAltaCliente.add(telefono);
					panelAltaCliente.add(telefonoTexto);
					telefonoTexto.addActionListener(this);
					telefonoOk.setVisible(false);
					panelAltaCliente.add(telefonoOk);

					panelAltaCliente.add(dni);
					panelAltaCliente.add(dniTexto);
					dniTexto.addActionListener(this);
					dniOk.setVisible(false);
					panelAltaCliente.add(dniOk);

					panelAltaCliente.add(domicilio);
					panelAltaCliente.add(domicilioTexto);
					domicilioOk.setVisible(false);
					panelAltaCliente.add(domicilioOk);

					panelAltaCliente.add(provincia);
					panelAltaCliente.add(provinciaTexto);
					provinciaTexto.addActionListener(this);
					panelAltaCliente.add(provinciaOk);
					provinciaOk.setVisible(false);

					panelAltaCliente.add(cp);
					panelAltaCliente.add(cpTexto);
					cpOk.setVisible(false);
					panelAltaCliente.add(cpOk);

					bajaCliente=new JButton("Baja Cliente");
					bajaCliente.addActionListener(this);
					panelAltaCliente.add(bajaCliente);

					botonModificarConsultaActualizaCliente= new JButton("Modificar");
					panelAltaCliente.add(botonModificarConsultaActualizaCliente);
					botonModificarConsultaActualizaCliente.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							nombreTexto.setEditable(true);
							apellidoTexto.setEditable(true);
							mailTexto.setEditable(true);
							telefonoTexto.setEditable(true);
							domicilioTexto.setEditable(true);
							provinciaTexto.setEnabled(true);
							cpTexto.setEnabled(true);
							//aparece el boton guardar
							botonGuardarModificarConsultaActualizaCliente.setVisible(true);

							//quito el boton baja cliente
							panelAltaCliente.remove(bajaCliente);
							botonModificarConsultaActualizaCliente.setVisible(false);
							panelPrincipal.updateUI();

						}
					});

					botonGuardarModificarConsultaActualizaCliente=new JButton("Guardar cambios");
					botonGuardarModificarConsultaActualizaCliente.setFont(new Font("Italic",Font.BOLD,12));
					botonGuardarModificarConsultaActualizaCliente.setVisible(false);
					botonGuardarModificarConsultaActualizaCliente.addActionListener(this);
					panelAltaCliente.add(botonGuardarModificarConsultaActualizaCliente);

					panelAltaCliente.setLayout(new GridLayout(10,3));

					tituloAltaCliente=new JLabel();
					tituloAltaCliente.setText("Consulta y Actualizacion");
					tituloAltaCliente.setFont(new Font("Italic",Font.BOLD,17));
					panelTituloAltaCliente.add(tituloAltaCliente);
					panelContenedorAltaCliente.setLayout(new BoxLayout(panelContenedorAltaCliente, BoxLayout.Y_AXIS));
					panelContenedorAltaCliente.add(panelTituloAltaCliente);
					panelContenedorAltaCliente.add(panelAltaCliente);
					panelPrincipal.add(panelContenedorAltaCliente);
					

				}else{

					ClienteNoEncontradoException excClienteNoEncontrado = new ClienteNoEncontradoException();

					try{
						throw(excClienteNoEncontrado);
					}catch(ClienteNoEncontradoException clientNoEncontrado){
						JOptionPane.showMessageDialog (null, "No se encontro el cliente buscado","Error",2);
						consultaActualizaCliente.doClick();
					}	
				}
			}
		}

		//---------------------------------------------guardamos cambios del cliente---------------------------------------------
		
		if(e.getSource()==botonGuardarModificarConsultaActualizaCliente&&nOk&&aOk&&mOk&&tOk&&doOk&&cOk&&prOk){
			clientesAux.get(existecliente).setNombre(nombreTexto.getText());
			clientesAux.get(existecliente).setApellido(apellidoTexto.getText());
			clientesAux.get(existecliente).setMail(mailTexto.getText());
			clientesAux.get(existecliente).setTelefono(telefonoTexto.getText());
			clientesAux.get(existecliente).setDomicilio(domicilioTexto.getText());
			Object string=provinciaTexto.getSelectedItem();
			String textoProvincia =String.valueOf(string);
			clientesAux.get(existecliente).setProvincia(textoProvincia);
			Object string2=cpTexto.getSelectedItem();
			String textoCp =String.valueOf(string2);
			clientesAux.get(existecliente).setCp(Integer.parseInt(textoCp));
			esribirArchivoCliente();
			panelPrincipal.removeAll();//remueve todo los componentes del panelPrincipal	
			panelBajaCambiosCliente.removeAll();
			panelPrincipal.updateUI();//Actualiza la GUI
			leyendaBuscarBajaCambiosCliente =new JLabel("El cliente se actualizo");
			leyendaBuscarBajaCambiosCliente.setVisible(true);
			panelLeyendaBajaCambiosCliente.add(leyendaBuscarBajaCambiosCliente);
			panelBajaCambiosCliente.add(panelLeyendaBajaCambiosCliente);
			panelBajaCambiosCliente.setLayout(new BoxLayout(panelBajaCambiosCliente, BoxLayout.Y_AXIS));
			panelPrincipal.add(panelBajaCambiosCliente);

		}

		//---------------------------------------------Baja cliente---------------------------------------------
		if(e.getSource()==bajaCliente){

			if(JOptionPane.showConfirmDialog(null, "Desea eliminar el Cliente?", "Confirme", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){

				clientesAux.remove(existecliente);
				esribirArchivoCliente();
				panelPrincipal.removeAll();//remueve todo los componentes del panelPrincipal	
				panelBajaCambiosCliente.removeAll();
				panelPrincipal.updateUI();//Actualiza la GUI
				leyendaBuscarBajaCambiosCliente =new JLabel("El cliente se elimino");
				leyendaBuscarBajaCambiosCliente.setVisible(true);
				panelLeyendaBajaCambiosCliente.add(leyendaBuscarBajaCambiosCliente);
				panelBajaCambiosCliente.add(panelLeyendaBajaCambiosCliente);
				panelBajaCambiosCliente.setLayout(new BoxLayout(panelBajaCambiosCliente, BoxLayout.Y_AXIS));
				panelPrincipal.add(panelBajaCambiosCliente);
			}	
		}


		//---------------------------------------------Item Nueva Reserva ---------------------------------------------
		if(e.getSource()==nuevaReserva){

			panelPrincipal.add(panelBuscarClienteNuevaReserva);
			panelPrincipal.removeAll();
			panelNuevaReserva.removeAll();
			panelTituloClienteNuevaReserva.removeAll();
			panelCamposNuevaReserva.removeAll();
			panelBotonesNuevaReserva.removeAll();
			panelLeyendaNuevaReserva.removeAll();
			panelCamposHoraNuevaReserva.removeAll();
			panelCamposComentarioNuevaReserva.removeAll();
			panelFormaPagoNuevaReserva.removeAll();
			panelCamposFormaPagoNuevaReserva.removeAll();
			panelBotonesFormaPagoNuevaReserva.removeAll();
			panelCamposBuscarClienteNuevaReserva.removeAll();
			panelCamposServiciosAdicionalesNuevaReserva.removeAll();
			panelBotonesServiciosAdicionalesNuevaReserva.removeAll();
			panelServiciosAdicionalesNuevaReserva.removeAll();
			//tambien puedo instanaciar de nuevo los JPanel
			panelPrincipal.updateUI();

			//Panel titulo
			tituloClienteNuevaReserva = new JLabel();
			tituloClienteNuevaReserva.setText("Nueva Reserva");
			panelTituloClienteNuevaReserva.add(tituloClienteNuevaReserva);
			tituloClienteNuevaReserva.setFont(new Font("Italic",Font.BOLD,17));
			panelNuevaReserva.add(panelTituloClienteNuevaReserva);
			buscarClienteNuevaReserva= new JLabel();
			buscarClienteNuevaReserva.setText("Ingrese el cliente (busca por dni o por nombre)");
			textoBuscarClienteNuevaReserva=new JTextField(15);
			panelCamposBuscarClienteNuevaReserva.add(buscarClienteNuevaReserva);
			panelCamposBuscarClienteNuevaReserva.add(textoBuscarClienteNuevaReserva);
			panelNuevaReserva.add(panelCamposBuscarClienteNuevaReserva);			

			//panel campos
			//subpanel hora y minutos
			String horas[]= new String[24];
			for (int i = 0; i < 24; i++) {
				horas[i]=Integer.toString(i);
			}
			String minutos[]= new String[60];
			for (int j = 0; j < 60; j++) {
				minutos[j]=Integer.toString(j);
			}
			hora =new JComboBox(horas);
			minuto=new JComboBox(minutos);
			horaNuevaReserva=new JLabel("Hora");
			minutoNuevaReserva=new JLabel("Minutos");
			panelCamposHoraNuevaReserva.add(horaNuevaReserva);
			panelCamposHoraNuevaReserva.add(hora);
			panelCamposHoraNuevaReserva.add(minutoNuevaReserva);
			panelCamposHoraNuevaReserva.add(minuto);
			panelCamposNuevaReserva.add(panelCamposHoraNuevaReserva);

			//subpanel forma de pago
			textoFormaPago=new JLabel("Forma de pago");
			panelCamposFormaPagoNuevaReserva.add(textoFormaPago);
			panelFormaPagoNuevaReserva.add(panelCamposFormaPagoNuevaReserva);
		
			contenedorRadioButtonFormaPago = new ButtonGroup();
			RbEfectivoFormaPago=new JRadioButton();
			RbEfectivoFormaPago.setSelected(true);
		
			RbEfectivoFormaPago.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					efectivo=true;
					
				}
			});
			
			RbTarjetaFormaPago= new JRadioButton();
			RbTarjetaFormaPago.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					efectivo=false;
				}
			});
			
			contenedorRadioButtonFormaPago.add(RbEfectivoFormaPago);
			contenedorRadioButtonFormaPago.add(RbTarjetaFormaPago);
			//panel para el button de efectivo
			JPanel panelCamposEfectivoButtonPagoNuevaReserva = new JPanel();
			textoEfectivo = new JLabel("Efectivo");
			panelCamposEfectivoButtonPagoNuevaReserva.add(textoEfectivo);
			panelCamposEfectivoButtonPagoNuevaReserva.add(RbEfectivoFormaPago);
			//panel para el button Tarjeta
			JPanel panelCamposTarjetaButtonPagoNuevaReserva = new JPanel();
			textoTarjeta= new JLabel("Tarjeta  ");
			panelCamposTarjetaButtonPagoNuevaReserva.add(textoTarjeta);
			panelCamposTarjetaButtonPagoNuevaReserva.add(RbTarjetaFormaPago);
			JPanel panelCamposCantidadCocherasaPagoNuevaReserva = new JPanel();
			cantidadCocheras=new JLabel();
			cantidadCocheras.setText("Cantidad de cocheras:");
			textoCantidadCocheras= new JTextField(2);
			textoCantidadCocheras.setText("1");
			panelCamposCantidadCocherasaPagoNuevaReserva.add(cantidadCocheras);
			panelCamposCantidadCocherasaPagoNuevaReserva.add(textoCantidadCocheras);
			panelBotonesFormaPagoNuevaReserva.add(panelCamposEfectivoButtonPagoNuevaReserva);
			panelBotonesFormaPagoNuevaReserva.add(panelCamposTarjetaButtonPagoNuevaReserva);
			panelBotonesFormaPagoNuevaReserva.add(panelCamposCantidadCocherasaPagoNuevaReserva);
			panelBotonesFormaPagoNuevaReserva.setLayout(new BoxLayout(panelBotonesFormaPagoNuevaReserva, BoxLayout.Y_AXIS));
			panelFormaPagoNuevaReserva.add(panelBotonesFormaPagoNuevaReserva);
			panelFormaPagoNuevaReserva.setLayout(new BoxLayout(panelFormaPagoNuevaReserva, BoxLayout.Y_AXIS));
			panelCamposNuevaReserva.add(panelFormaPagoNuevaReserva);

			//submenu servicios adicionales
			textoServicioAdicionales=new JLabel("Servicios adicionales");
			panelCamposServiciosAdicionalesNuevaReserva.add(textoServicioAdicionales);
			panelServiciosAdicionalesNuevaReserva.add(panelCamposServiciosAdicionalesNuevaReserva);
			//panel para los checkbox
			JPanel panelCheckLavarButtonPagoNuevaReserva = new JPanel();
			textoLavado = new JLabel("Lavado");
			checkLavado=new JCheckBox();
			panelCheckLavarButtonPagoNuevaReserva.add(textoLavado);
			panelCheckLavarButtonPagoNuevaReserva.add(checkLavado);
			checkLavado.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(checkLavado.isSelected()){
						lavadoOk=true;
					}else{
						lavadoOk=false;
					}

				}
			});

			//panel para el check de revision
			JPanel panelCheckRevisionButtonPagoNuevaReserva = new JPanel();
			textoRevision= new JLabel("Revisar");
			checkRevision=new JCheckBox();
			checkRevision.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(checkRevision.isSelected()){
						revisionOk=true;
					}else{
						revisionOk=false;
					}
				}
			});

			panelCheckRevisionButtonPagoNuevaReserva.add(textoRevision);
			panelCheckRevisionButtonPagoNuevaReserva.add(checkRevision);
			panelBotonesServiciosAdicionalesNuevaReserva.add(panelCheckLavarButtonPagoNuevaReserva);
			panelBotonesServiciosAdicionalesNuevaReserva.add(panelCheckRevisionButtonPagoNuevaReserva);
			panelBotonesServiciosAdicionalesNuevaReserva.setLayout(new BoxLayout(panelBotonesServiciosAdicionalesNuevaReserva, BoxLayout.Y_AXIS));
			panelServiciosAdicionalesNuevaReserva.add(panelBotonesServiciosAdicionalesNuevaReserva);
			panelServiciosAdicionalesNuevaReserva.setLayout(new BoxLayout(panelServiciosAdicionalesNuevaReserva, BoxLayout.Y_AXIS));
			panelCamposNuevaReserva.add(panelServiciosAdicionalesNuevaReserva);


			//subpanel comentarios
			comentarioNuevaReserva=new JLabel("Comentario");
			textoComentarioNuevaReserva= new JTextArea(5,20);
			panelCamposComentarioNuevaReserva.add(comentarioNuevaReserva);
			panelCamposComentarioNuevaReserva.add(textoComentarioNuevaReserva);
			panelCamposNuevaReserva.add(panelCamposComentarioNuevaReserva);
			panelCamposNuevaReserva.setLayout(new BoxLayout(panelCamposNuevaReserva, BoxLayout.Y_AXIS));
			panelNuevaReserva.add(panelCamposNuevaReserva);
			//Este panel contiene la hora y minutos. Forma de pago. Servicios adicionales. Comentarios.

			//leyenda
			leyendaNuevaReserva= new JLabel();


			//panel botones
			botonCancelarNuevaReserva=new JButton("Cancelar");
			botonCancelarNuevaReserva.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(JOptionPane.showConfirmDialog(null, "Desea cancelar la reserva?", "Confirme", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
						nuevaReserva.doClick();
					}
				}
			});

			botonNuevaReserva= new JButton("Confirmar reserva");
			botonNuevaReserva.addActionListener(this);
			panelBotonesNuevaReserva.add(botonCancelarNuevaReserva);
			panelBotonesNuevaReserva.add(botonNuevaReserva);
			panelNuevaReserva.add(panelBotonesNuevaReserva);
			panelNuevaReserva.add(leyendaNuevaReserva);
			panelNuevaReserva.setLayout(new BoxLayout(panelNuevaReserva, BoxLayout.Y_AXIS));
			panelPrincipal.add(panelNuevaReserva);
		}


		//las reservas no son persistentes
		if(e.getSource()==botonNuevaReserva){

			//validar clientes
			existecliente=existeCliente(textoBuscarClienteNuevaReserva.getText());

			if(existecliente!=-1){

				//verifico disponibilidad de cochera
				int indice=-1;
				int j=0;
				ArrayList<Cochera>cocherasTemp =new ArrayList<Cochera>();
				for (int i = 0; i < cocherasAux.size(); i++) {
	
					if(cocherasAux.get(i).isDisponible()){
						if(j<Integer.parseInt(textoCantidadCocheras.getText())){
							cocherasAux.get(i).setDisponible(false);
							cocherasTemp.add(cocherasAux.get(i));
							j++;
						
						}
					}
				}
				
				if(j!=0){

					//hora
					Object texto;
					texto= hora.getSelectedItem();
					String horaTexto =String.valueOf(texto);
					texto = minuto.getSelectedItem();
					String minutoTexto =String.valueOf(texto);
					Calendar entradaReserva=Calendar.getInstance();
					entradaReserva.set(entradaReserva.get(Calendar.YEAR), entradaReserva.get(Calendar.MONTH),entradaReserva.get(Calendar.DATE), Integer.parseInt(horaTexto),Integer.parseInt( minutoTexto));

					
					//id reserva
					contadorReservas++;
					
					//servicios adicionales
					//lavadoOk
					//revisionOk

					//forma de pag;true efectivo-false tarjeta
					//efectivo;
					
					//creo la reserva
					reservas.add(new Reserva(contadorReservas,entradaReserva,clientesAux.get(existecliente),cocherasTemp,efectivo,lavadoOk,revisionOk));
				
					panelPrincipal.removeAll();
					panelNuevaReserva.removeAll();
					panelTituloClienteNuevaReserva.removeAll();
					panelPrincipal.updateUI();
					
					for (int i = 0; i < reservas.size(); i++) {
						if(reservas.get(i).getId()==contadorReservas){
						reservas.get(i).setComentarios(textoComentarioNuevaReserva.getText());
						tituloClienteNuevaReserva.setText("Nueva Reserva Generada numero "+reservas.get(i).getId());
						}
					}

					panelNuevaReserva.add(tituloClienteNuevaReserva);
					panelPrincipal.add(panelNuevaReserva);
					
				}else{

					leyendaNuevaReserva.setForeground(Color.red);
					leyendaNuevaReserva.setText("cocheras no disponible");	
					leyendaNuevaReserva.setVisible(true);
				}

			}else{
				leyendaNuevaReserva.setForeground(Color.red);
				leyendaNuevaReserva.setText("Cliente no existe");
				leyendaNuevaReserva.setVisible(true);
			}
		}

		//---------------------------------------------Item Finalizar Reseva ---------------------------------------------

		if(e.getSource()==finalizarReserva){
			panelPrincipal.removeAll();
			panelFinalizarReserva.removeAll();
			panelCamposFinalizarReserva.removeAll();
			panelBotonesFinalizarReserva.removeAll();
			panelPrincipal.updateUI();

			tituloFinalizarReserva= new JLabel();
			tituloFinalizarReserva.setText("Finalizar reservas");
			tituloFinalizarReserva.setFont(new Font("Italic",Font.BOLD,17));
			numeroNuevaReserva=new JLabel();
			numeroNuevaReserva.setText("Ingrese el numero de la reserva a finalizar");
			textoNumeroFinalizarReserva=new JTextField(5);
			botonCancelarFinalizarReserva=new JButton("Cancelar");
			botonCancelarFinalizarReserva.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Desea cancelar la finalizacion de reservas?", "Confirme", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
						finalizarReserva.doClick();
					}
					
				}
			});
			
			leyendaFinalizarReserva= new JLabel();
			botonFinalizarReserva=new JButton("Finalizar");
			botonFinalizarReserva.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
				
					boolean encontrado=false;
					try{
					for (int i = 0; i < reservas.size(); i++){
						if(reservas.get(i).getId()==Integer.parseInt(textoNumeroFinalizarReserva.getText())){
						
						for (int j = 0; j < reservas.get(i).getCochera().size(); j++) {
							reservas.get(i).getCochera().get(j).setDisponible(true);
						}	
						reservas.remove(i);
						leyendaFinalizarReserva.setText("Reserva finalizada");
						encontrado=true;
						}
					}
					if(!encontrado){
						leyendaFinalizarReserva.setText("No se encontro reserva");
					}
					}catch(Exception error){
						leyendaFinalizarReserva.setText("Ingrese un numero");
					}
			
				}
			});
			
			
			leyendaFinalizarReserva.setVisible(true);
			
			panelBotonesFinalizarReserva.add(botonCancelarFinalizarReserva);
			panelBotonesFinalizarReserva.add(botonFinalizarReserva);
			panelCamposFinalizarReserva.add(numeroNuevaReserva);
			panelCamposFinalizarReserva.add(textoNumeroFinalizarReserva);
			panelFinalizarReserva.add(tituloFinalizarReserva);
			panelFinalizarReserva.add(panelCamposFinalizarReserva);
			panelFinalizarReserva.add(panelBotonesFinalizarReserva);
			panelFinalizarReserva.add(leyendaFinalizarReserva);
			panelFinalizarReserva.setLayout(new BoxLayout(panelFinalizarReserva,BoxLayout.Y_AXIS));
			panelPrincipal.add(panelFinalizarReserva);
			
		}
		//---------------------------------------------Item Consulta Masiva ---------------------------------------------
		if(e.getSource()==consultaClientes){
		
			panelPrincipal.removeAll();
			panelConsultaMasivaClientes.removeAll();
			panelTituloConsultaMasivaClientes.removeAll();
			panelPrincipal.updateUI();
		
			tituloConsultaMasivaClientes= new JLabel();
			tituloConsultaMasivaClientes.setText("Consulta Clientes");
			tituloConsultaMasivaClientes.setFont(new Font("Italic",Font.BOLD,17));

			//JTable
			columnNames=new String[12];
			columnNames[0]="Nombre";
			columnNames[1]="Apellido";
			columnNames[2]="Dni";
			columnNames[3]="Domicilio";
			columnNames[4]="Provincia";
			columnNames[5]="Telefono";
			columnNames[6]="Tipo Vehiculo";
			columnNames[7]="Marca";
			columnNames[8]="Modelo";
			columnNames[9]="Patente";
			columnNames[10]="Dias frecuentes";
			columnNames[11]="Otros vehiculos";
			//tipo object

			
			totalRegistrosConsultaMasiva=new JLabel();
			textoFiltrarConsulta= new JTextField(12);
			botonFiltrarConsulta=new JButton("Filtrar");
			botonFiltrarConsulta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(textoFiltrarConsulta.getText().equals("")){
						panelConsultaMasivaClientes.removeAll();
						panelPrincipal.updateUI();
						totalRegistros=0;
						filas=new Object[clientesAux.size()][12];
						for(int i=0;i<clientesAux.size();i++){
							filas[i][0]=clientesAux.get(i).getNombre();
							filas[i][1]=clientesAux.get(i).getApellido();
							filas[i][2]=clientesAux.get(i).getDni();
							filas[i][3]=clientesAux.get(i).getDomicilio();
							filas[i][4]=clientesAux.get(i).getProvincia();
							filas[i][5]=clientesAux.get(i).getTelefono();
							filas[i][6]=clientesAux.get(i).getVehiculo().getTipo();
							filas[i][7]=clientesAux.get(i).getVehiculo().getMarca();
							filas[i][8]=clientesAux.get(i).getVehiculo().getModelo();
							filas[i][9]=clientesAux.get(i).getVehiculo().getPatente();
							filas[i][10]=clientesAux.get(i).getDiasFrecuentes();
							filas[i][11]=clientesAux.get(i).getOtrosVehiculos();
							
							totalRegistros++;
						}
						//JTable celdas no editables.
						tablaModelo=new DefaultTableModel(filas, columnNames){
							@Override
							public boolean isCellEditable(int row, int column) {
								//all cells false
								return false;
							}
						}; 

						JTable tablaConsultaMasivaClientes = new JTable(tablaModelo);
						tablaConsultaMasivaClientes.setFont(new Font("Italic",Font.BOLD,10));	


						JTableHeader header = tablaConsultaMasivaClientes.getTableHeader();
						TablaRenderer renderHeader = new TablaRenderer();
						header.setFont(new Font("Italic",Font.BOLD,10));

						panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes.getTableHeader());
						panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes);
						panelConsultaMasivaClientes.setLayout(new BoxLayout(panelConsultaMasivaClientes,BoxLayout.Y_AXIS));

						totalRegistrosConsultaMasiva.setText("Total registros:"+totalRegistros);
						panelConsultaMasivaClientes.add(totalRegistrosConsultaMasiva);
						panelConsultaMasivaClientes.add(panelTituloConsultaMasivaClientes);
						panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes.getTableHeader());
						panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes);
						panelConsultaMasivaClientes.add(totalRegistrosConsultaMasiva);

					}else{

						ArrayList<Integer> array=coincidenciasConsulta(textoFiltrarConsulta.getText());
						panelConsultaMasivaClientes.removeAll();
						panelPrincipal.updateUI();

						totalRegistros=0;
					
						filas=new Object[array.size()][12];
						totalRegistros=array.size();
						for(int i=0;i<array.size();i++){
							filas[i][0]=clientesAux.get(array.get(i)).getNombre();
							filas[i][1]=clientesAux.get(array.get(i)).getApellido();
							filas[i][2]=clientesAux.get(array.get(i)).getDni();
							filas[i][3]=clientesAux.get(array.get(i)).getDomicilio();
							filas[i][4]=clientesAux.get(array.get(i)).getProvincia();
							filas[i][5]=clientesAux.get(array.get(i)).getTelefono();
							filas[i][6]=clientesAux.get(array.get(i)).getVehiculo().getTipo();
							filas[i][7]=clientesAux.get(array.get(i)).getVehiculo().getMarca();
							filas[i][8]=clientesAux.get(array.get(i)).getVehiculo().getModelo();
							filas[i][9]=clientesAux.get(array.get(i)).getVehiculo().getPatente();
							filas[i][10]=clientesAux.get(i).getDiasFrecuentes();
							filas[i][11]=clientesAux.get(i).getOtrosVehiculos();
						}
						//JTable celdas no editables.
						tablaModelo=new DefaultTableModel(filas, columnNames){
							@Override
							public boolean isCellEditable(int row, int column) {
								//all cells false
								return false;
							}
						};
						JTable tablaConsultaMasivaClientes = new JTable(tablaModelo);
						tablaConsultaMasivaClientes.setFont(new Font("Italic",Font.BOLD,10));	
						panelConsultaMasivaClientes.setLayout(new BoxLayout(panelConsultaMasivaClientes,BoxLayout.Y_AXIS));

						JTableHeader header = tablaConsultaMasivaClientes.getTableHeader();
						TablaRenderer renderHeader = new TablaRenderer();
						header.setFont(new Font("Italic",Font.BOLD,10));
						
						totalRegistrosConsultaMasiva.setText("Total registros:"+totalRegistros);
						panelConsultaMasivaClientes.add(panelTituloConsultaMasivaClientes);
						panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes.getTableHeader());
						panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes);
						panelConsultaMasivaClientes.add(totalRegistrosConsultaMasiva);

					}				

				}
			});

		
			//Panel para el titulo
			panelTituloConsultaMasivaClientes.add(tituloConsultaMasivaClientes);
			panelTituloConsultaMasivaClientes.add(botonFiltrarConsulta);
			panelTituloConsultaMasivaClientes.add(textoFiltrarConsulta);
			//panel del header y tabla que va a contener al titulo y al boton actualizar
			panelConsultaMasivaClientes.add(panelTituloConsultaMasivaClientes);
			// el panelTablaCochera contiene el panel del titulo, el header de la tabla y la tabla y el panel del boton
			panelPrincipal.add(panelConsultaMasivaClientes);

		}
		if(e.getSource()==consultaReservaCliente){

			panelPrincipal.removeAll();
			panelActualizarCocheras.removeAll();
			panelConsultaMasivaClientes.removeAll();
			panelTituloConsultaMasivaClientes.removeAll();
			panelPrincipal.updateUI();

			tituloConsultaMasivaClientes= new JLabel();
			tituloConsultaMasivaClientes.setText("Consulta Reservas");
			tituloConsultaMasivaClientes.setFont(new Font("Italic",Font.BOLD,17));

			//JTable
			columnNames=new String[11];
			columnNames[0]="ID";
			columnNames[1]="Hora entrada";
			columnNames[2]="Nombre cliente";
			columnNames[3]="Apellido Cliente";
			columnNames[4]="Marca vehiculo";
			columnNames[5]="Modelo vehiculo";
			columnNames[6]="Patente vehiculo";
			columnNames[7]="Lavar";
			columnNames[8]="Revisar";
			columnNames[9]="Efectivo";
			columnNames[10]="Cantidad cocheras";
			
		
			//tipo object

			filas=new Object[reservas.size()][11];
			for(int i=0;i<reservas.size();i++){
				filas[i][0]=reservas.get(i).getId();
				filas[i][1]=(reservas.get(i).getHoraEntrada().get(Calendar.HOUR)+"-"+(reservas.get(i).getHoraEntrada().get(Calendar.DATE)));
				filas[i][2]=reservas.get(i).getCliente().getNombre();
				filas[i][3]=reservas.get(i).getCliente().getApellido();
				filas[i][4]=reservas.get(i).getCliente().getVehiculo().getMarca();
				filas[i][5]=reservas.get(i).getCliente().getVehiculo().getModelo();
				filas[i][6]=reservas.get(i).getCliente().getVehiculo().getPatente();
				if(reservas.get(i).isLavar()){
					filas[i][7]="si";
				}else{
					filas[i][7]="no";
				}
				if(reservas.get(i).isRevision()){
					filas[i][8]="si";
				}else{
					filas[i][8]="no";
				}
				if(reservas.get(i).isPagoEfectivo()){
					filas[i][9]="si";
				}else{
					filas[i][9]="no";
				}
				filas[i][10]=reservas.get(i).getCochera().size();
				
			}
			//JTable celdas no editables.
			tablaModelo=new DefaultTableModel(filas, columnNames){
				@Override
				public boolean isCellEditable(int row, int column) {
					//all cells false
					return false;
				}
			}; 

			JTable tablaConsultaMasivaClientes = new JTable(tablaModelo);
			tablaConsultaMasivaClientes.setFont(new Font("Italic",Font.BOLD,10));	


			JTableHeader header = tablaConsultaMasivaClientes.getTableHeader();
			TablaRenderer renderHeader = new TablaRenderer();
			header.setFont(new Font("Italic",Font.BOLD,10));
			
			//Panel para el titulo
			panelTituloConsultaMasivaClientes.add(tituloConsultaMasivaClientes);
			panelConsultaMasivaClientes.add(panelTituloConsultaMasivaClientes);
			
			//panel del header y tabla que va a contener al titulo y al boton actualizar
			panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes.getTableHeader());
			panelConsultaMasivaClientes.add(tablaConsultaMasivaClientes);
			panelConsultaMasivaClientes.setLayout(new BoxLayout(panelConsultaMasivaClientes,BoxLayout.Y_AXIS));

			// el panelTablaCochera contiene el panel del titulo, el header de la tabla y la tabla y el panel del boton
			panelPrincipal.add(panelConsultaMasivaClientes);

		}
	}
	

	//---------------------------------------------Funciones ---------------------------------------------

	public int existeCliente(String criterioBusqueda){
		int res=-1;
		//-1 no existe cliente
		archivoLectura = new File (archivoCliente);
		clientesAux= new ArrayList<Cliente>();
		if(archivoLectura.exists()){
			try{
				leerArchivo= new Scanner (archivoLectura);
				while(leerArchivo.hasNextLine()){
					String linea=leerArchivo.nextLine();
					String lineaCliente[]=linea.split(";");
					//Cargo los clientes en el array

					clientesAux.add(new Cliente(lineaCliente[0],lineaCliente[1],lineaCliente[2],lineaCliente[3],lineaCliente[4],Long.parseLong(lineaCliente[5]),Integer.parseInt(lineaCliente[6]),lineaCliente[7],lineaCliente[8],lineaCliente[9],lineaCliente[10],lineaCliente[11],lineaCliente[12],lineaCliente[13]));

				}

				for (int i = 0; i < clientesAux.size(); i++) {

					try{
						if(clientesAux.get(i).getDni()==Integer.parseInt(criterioBusqueda)){
							return res=i;
						}
					}catch(NumberFormatException error){
						if(clientesAux.get(i).getNombre().equals(criterioBusqueda)){
							return res=i;
						}
					}
				}
			}catch(IOException error){

				JOptionPane.showMessageDialog (null, "Error IOException","Error",2);

			}catch(Exception error){
				JOptionPane.showMessageDialog (null, "Error Exception:"+error,"Error",2);
			}

			finally{
				leerArchivo.close();

			}
		}else{
			//porque si no existe el archivo no existe ningun cliente
			res=-1;
		}
		return res;
	}	

	public void esribirArchivoCliente (){

		try{
			//no agrego infor sino que lo reescribo para que actualice el cliente eliminado
			archivoEscritura=new FileWriter(archivoCliente);
			escribirArchivo= new PrintWriter(archivoEscritura);
			for (int i = 0; i < clientesAux.size(); i++) {
				escribirArchivo.println(clientesAux.get(i).getNombre()+";"+clientesAux.get(i).getApellido()+";"+clientesAux.get(i).getMail()+";"+clientesAux.get(i).getTelefono()+";"+clientesAux.get(i).getTelefono()+";"+clientesAux.get(i).getDni()+";"+clientesAux.get(i).getCp()+";"+clientesAux.get(i).getVehiculo().getTipo()+";"+clientesAux.get(i).getVehiculo().getMarca()+";"+clientesAux.get(i).getVehiculo().getModelo()+";"+clientesAux.get(i).getVehiculo().getPatente()+";"+clientesAux.get(i).getProvincia()+";"+clientesAux.get(i).getDiasFrecuentes()+";"+clientesAux.get(i).getOtrosVehiculos());

			}

		}catch(IOException error){

			JOptionPane.showMessageDialog (null, "Error IOException- en funcion escribirArchivo","Error",2);

		}
		finally{
			escribirArchivo.close();
		}

	}
	
	public void archivoProvincias(){
		try {
			archivoLectura=new File(archivoProvincias);
			leerArchivo= new Scanner(archivoLectura);
			String aux=leerArchivo.nextLine();
			provinciaString=new String[5];
			provinciaString[0]=aux.substring(0,10);
			provinciaString[1]=aux.substring(10,20);
			provinciaString[2]=aux.substring(20,30);
			provinciaString[3]=aux.substring(30,40);
			provinciaString[4]=aux.substring(40,50);

			//quita los guiones del archivo provincia de ancho fijo de 10 caracteres
			for (int i = 0; i < provinciaString.length; i++) {

				while(provinciaString[i].charAt(0)=='-'){
					provinciaString[i]=provinciaString[i].substring(1,provinciaString[i].length());
				}
			}

			provinciaTexto= new JComboBox(provinciaString);		

		} catch (IOException error) {
			// TODO: handle exception
			if(!archivoLectura.exists()){
				JOptionPane.showMessageDialog (null, "No se encuentra archivo "+ archivoLectura.getName(),"Error",2);
			}else{
				JOptionPane.showMessageDialog (null, "Error IOException","Error",2);

			}
		}
	}
	
	public ArrayList<Integer> coincidenciasConsulta(String texto){
		
		ArrayList<Integer> coincidencias= new ArrayList<Integer>();
		
		for (int i = 0; i < clientesAux.size(); i++) {
			if((clientesAux.get(i).getProvincia().indexOf(texto)!=-1)||(clientesAux.get(i).getApellido().indexOf(texto)!=-1)||(clientesAux.get(i).getNombre().indexOf(texto)!=-1)||(Long.toString(clientesAux.get(i).getDni()).indexOf(texto)!=-1)||(clientesAux.get(i).getMail().indexOf(texto)!=-1)||(clientesAux.get(i).getTelefono().indexOf(texto)!=-1)||(clientesAux.get(i).getDomicilio().indexOf(texto)!=-1)||(Integer.toString(clientesAux.get(i).getCp()).indexOf(texto)!=-1)||(clientesAux.get(i).getVehiculo().getTipo().indexOf(texto)!=-1)||(clientesAux.get(i).getVehiculo().getMarca().indexOf(texto)!=-1)||(clientesAux.get(i).getVehiculo().getModelo().indexOf(texto)!=-1)||(clientesAux.get(i).getVehiculo().getPatente().indexOf(texto)!=-1)){
			coincidencias.add(new Integer(i));
			
			}
			
		}
	
		return coincidencias;
	
	}
}
