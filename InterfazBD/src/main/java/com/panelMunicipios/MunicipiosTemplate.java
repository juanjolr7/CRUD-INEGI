package com.panelMunicipios;

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
public class MunicipiosTemplate extends JPanel {

    //Servicios y objetos
    private MunicipiosComponent municipiosComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;
    //Objetos decoradores
    private Color colorGris;
    //Oobjetos graficos
    private JPanel pOpciones, pDatos;
    private JButton bLimpiar, bInsertar, bModificar, bEliminar;
    private JLabel lTitulo, lInstrucciones, lEslogan;
    private JLabel lId,lIdMunicipio ,lNombre;
    private JTextField tNombre, tIdEntidad, tIdmunicipio;

    // Declaración objetos para JTable
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera =
    {
        "id entidad", "id municipio", "Nombre municipio"
    };

    public MunicipiosTemplate(MunicipiosComponent municipiosComponent) {
        this.municipiosComponent = municipiosComponent;
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
        bLimpiar.addMouseListener(municipiosComponent);
        bLimpiar.addActionListener(municipiosComponent);
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
        bInsertar.addMouseListener(municipiosComponent);
        bInsertar.addActionListener(municipiosComponent);
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
        bModificar.addMouseListener(municipiosComponent);
        bModificar.addActionListener(municipiosComponent);
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
        bEliminar.addMouseListener(municipiosComponent);
        bEliminar.addActionListener(municipiosComponent);
        pOpciones.add(bEliminar);
    }

    public void crearContenidoPDatos() {
        // LABEL INSTRUCCIONES ----------------------------------------------------------------
        lInstrucciones = sObjGraficos.construirJLabel(
                "<html>Datos de las entidades<html>",
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
                "<html>A continuación puede ver y editar la información de la Entidad<html>",
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
        lId = sObjGraficos.construirJLabel(
                "Id Entidad:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lId);
         
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
        tIdEntidad.addFocusListener(municipiosComponent);
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
        tIdmunicipio = sObjGraficos.construirJTextField(
                "Id Municipio",
                30, 245, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tIdmunicipio.addFocusListener(municipiosComponent);
        pDatos.add(tIdmunicipio);
        
        // LABEL NOMBRE MUNICIPIO----------------------------------------------------------------
        lNombre = sObjGraficos.construirJLabel(
                "Nombre Municipio:",
                20, 280, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lNombre);

        // TEXTFIELD NOMBRE MUNICIPIO----------------------------------------------------------------
        tNombre = sObjGraficos.construirJTextField(
                "Nombre Municipio",
                30, 315, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tNombre.addFocusListener(municipiosComponent);
        pDatos.add(tNombre);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(municipiosComponent);

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

//    public JLabel getLIdValor() {
//        return lIdValor;
//    }
    public JTextField getTNombre() {
        return tNombre;
    }

    public JTextField gettIdEntidad() {
        return tIdEntidad;
    }
    
    public JTextField gettIdMunicipio() {
        return tIdmunicipio;
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
}
