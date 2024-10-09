package com.panelCenso2020;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import services.GraficosAvanzadosService;
import services.ObjGraficosService;
import services.RecursosService;

/**
 *
 * @author juanj
 */
public class Censo2020Template extends JPanel {

    //Servicios y objetos
    private Censo2020Component censo2020Component;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;
    //Objetos decoradores
    private Color colorGris;
    //Oobjetos graficos
    private JPanel pOpciones, pDatos;
    private JButton bLimpiar, bInsertar, bModificar, bEliminar;
    private JLabel lTitulo, lInstrucciones, lEslogan;
    private JLabel lIdEntidad,lIdMunicipio, lIdLocalidad, lPobTotal, lPobFem, lPobMasc;
    private JTextField tIdEntidad, tIdMunicipio, tIdlocalidad, tPobTotal, tPobFem, tPobMasc;

    // Declaración objetos para JTable
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera =
    {
        "id entidad", "id municipio", "id localidad", "Población total", "Población femenina", "Población masculina"
    };

    public Censo2020Template(Censo2020Component censo2020Component) {
        this.censo2020Component = censo2020Component;
        // Dentro del constructor
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        // Dentro del constructor
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.colorGris = new Color(235, 235, 235);

        this.crearJPanels();
        this.crearContenidoPOpciones();
        this.crearContenidoPDatos();
        // Dentro del constructor
        this.crearJTable();

        // Dentro del constructor
        this.setBackground(sRecursos.getColorGrisClaro());
        this.setSize(1287, 800);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJPanels() {
        pOpciones = sObjGraficos.construirJPanel(10, 705, 1010, 80, Color.WHITE, null);
        this.add(pOpciones);

        pDatos = sObjGraficos.construirJPanel(1036, 10, 240, 772, Color.WHITE, null);
        this.add(pDatos);
    }

    public void crearContenidoPOpciones() {
        // BOTÓN LIMPIAR--------------------------------------------------------------------
        bLimpiar = sObjGraficos.construirJButton(
                "Limpiar",
                150, 25, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        bLimpiar.addMouseListener(censo2020Component);
        bLimpiar.addActionListener(censo2020Component);
        pOpciones.add(bLimpiar);

        // BOTÓN INSERTAR--------------------------------------------------------------------
        bInsertar = sObjGraficos.construirJButton(
                "Insertar",
                350, 25, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        bInsertar.addMouseListener(censo2020Component);
        bInsertar.addActionListener(censo2020Component);
        pOpciones.add(bInsertar);

        // BOTÓN MODIFICAR--------------------------------------------------------------------
        bModificar = sObjGraficos.construirJButton(
                "Modificar",
                550, 25, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        bModificar.addMouseListener(censo2020Component);
        bModificar.addActionListener(censo2020Component);
        pOpciones.add(bModificar);

        // BOTÓN ELIMINAR--------------------------------------------------------------------
        bEliminar = sObjGraficos.construirJButton(
                "Eliminar",
                750, 25, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        bEliminar.addMouseListener(censo2020Component);
        bEliminar.addActionListener(censo2020Component);
        pOpciones.add(bEliminar);
    }

    public void crearContenidoPDatos() {
        // LABEL INSTRUCCIONES ----------------------------------------------------------------
        lInstrucciones = sObjGraficos.construirJLabel(
                "<html>Datos del censo 2020<html>",
                20, 10, 120, 50,
                null, null,
                sRecursos.getFontTitulo(),
                null,
                sRecursos.getColorGrisOscuro(),
                null,
                "l"
        );
        pDatos.add(lInstrucciones);

        // LABEL ESLOGAN ----------------------------------------------------------------
        lEslogan = sObjGraficos.construirJLabel(
                "<html>A continuación puede ver y editar la información del censo 2020<html>",
                20, 50, 180, 90,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorGrisOscuro(),
                null,
                "l"
        );
        pDatos.add(lEslogan);

        // LABEL ID ENTIDAD----------------------------------------------------------------
        lIdEntidad = sObjGraficos.construirJLabel(
                "Id Entidad:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lIdEntidad);

        // TEXTFIELD ID ENTIDAD ----------------------------------------------------------------
        tIdEntidad = sObjGraficos.construirJTextField(
                "Id Entidad",
                30, 175, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tIdEntidad.addFocusListener(censo2020Component);
        pDatos.add(tIdEntidad);
        
        // LABEL ID MUNICIPIO----------------------------------------------------------------
        lIdMunicipio = sObjGraficos.construirJLabel(
                "Id Municipio:",
                20, 210, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lIdMunicipio);
         
        // TEXTFIELD ID MUNICIPIO----------------------------------------------------------------
        tIdMunicipio = sObjGraficos.construirJTextField(
                "Id Municipio",
                30, 245, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tIdMunicipio.addFocusListener(censo2020Component);
        pDatos.add(tIdMunicipio);
        
        // LABEL ID LOCALIDAD----------------------------------------------------------------
        lIdLocalidad = sObjGraficos.construirJLabel(
                "Id Localidad:",
                20, 280, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lIdLocalidad);
         
        // TEXTFIELD ID LOCALIDAD----------------------------------------------------------------
        tIdlocalidad = sObjGraficos.construirJTextField(
                "Id Localidad",
                30, 315, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tIdlocalidad.addFocusListener(censo2020Component);
        pDatos.add(tIdlocalidad);
        
        // LABEL POBLACIÓN TOTAL----------------------------------------------------------------
        lPobTotal = sObjGraficos.construirJLabel(
                "Población total:",
                20, 350, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lPobTotal);

        // TEXTFIELD POBLACIÓN TOTAL----------------------------------------------------------------
        tPobTotal = sObjGraficos.construirJTextField(
                "Población total",
                30, 385, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tPobTotal.addFocusListener(censo2020Component);
        pDatos.add(tPobTotal);
        
        // LABEL POBLACIÓN FEMENINA----------------------------------------------------------------
        lPobFem = sObjGraficos.construirJLabel(
                "Población femenina:",
                20, 420, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lPobFem);

        // TEXTFIELD POBLACIÓN FEMENINA----------------------------------------------------------------
        tPobFem = sObjGraficos.construirJTextField(
                "Población femenina:",
                30, 455, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tPobFem.addFocusListener(censo2020Component);
        pDatos.add(tPobFem);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(censo2020Component);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(580, 30));
        header.setDefaultRenderer(sGraficosAvanzados.devolverTablaPersonalizada(
                sRecursos.getColorPrincipal(), null, null, Color.WHITE, sRecursos.getFontLigera()
        ));

        pTabla = sObjGraficos.construirPanelBarra(tabla, 10, 20, 1010, 680, Color.WHITE, null);

        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.setDefaultRenderer(Object.class, sGraficosAvanzados.devolverTablaPersonalizada(
                Color.WHITE, sRecursos.getColorGrisClaro(), sRecursos.getColorPrincipalOscuro(),
                sRecursos.getColorGrisOscuro(), sRecursos.getFontLigera()
        ));

        pTabla.getVerticalScrollBar().setUI(
                sGraficosAvanzados.devolverScrollPersonalizado(
                        7, 10, Color.WHITE, Color.GRAY, sRecursos.getColorGrisOscuro()
                )
        );

        // Dentro del método crearJTable
        pCorner = new JPanel();
        pCorner.setBackground(sRecursos.getColorPrincipal());
        pTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

        this.add(pTabla);
    }
    
    public void reiniciarModelo(){
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);
        
        tabla.setModel(modelo);
    }

    public JButton getBInsertar() {
        return bInsertar;
    }

    public JButton getBModificar() {
        return bModificar;
    }

    public JButton getBEliminar() {
        return bEliminar;
    }

    public JButton getbLimpiar() {
        return bLimpiar;
    }

    public JTextField gettIdEntidad() {
        return tIdEntidad;
    }

    public JTextField gettIdMunicipio() {
        return tIdMunicipio;
    }

    public JTextField gettIdlocalidad() {
        return tIdlocalidad;
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JTextField gettPobTotal() {
        return tPobTotal;
    }

    public void settPobTotal(JTextField tPobTotal) {
        this.tPobTotal = tPobTotal;
    }

    public JTextField gettPobFem() {
        return tPobFem;
    }

    public void settPobFem(JTextField tPobFem) {
        this.tPobFem = tPobFem;
    }

    public JTextField gettPobMasc() {
        return tPobMasc;
    }

    public void settPobMasc(JTextField tPobMasc) {
        this.tPobMasc = tPobMasc;
    }
    
    
    
}
