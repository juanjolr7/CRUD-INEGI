package com.panelEntidades;

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
public class EntidadesTemplate extends JPanel {

    //Servicios y objetos
    private EntidadesComponent entidadesComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;
    //Objetos decoradores
    private Color colorGris;
    //Oobjetos graficos
    private JPanel pOpciones, pDatos;
    private JButton bLimpiar, bInsertar, bModificar, bEliminar;
    private JLabel lTitulo, lInstrucciones, lEslogan;
    private JLabel lId, lNombre;
    private JTextField tNombre, tId;

    // Declaración objetos para JTable
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera =
    {
        "id entidad", "Nombre entidad"
    };

    public EntidadesTemplate(EntidadesComponent entidadesComponent) {
        this.entidadesComponent = entidadesComponent;
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
        bLimpiar.addMouseListener(entidadesComponent);
        bLimpiar.addActionListener(entidadesComponent);
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
        bInsertar.addMouseListener(entidadesComponent);
        bInsertar.addActionListener(entidadesComponent);
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
        bModificar.addMouseListener(entidadesComponent);
        bModificar.addActionListener(entidadesComponent);
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
        bEliminar.addMouseListener(entidadesComponent);
        bEliminar.addActionListener(entidadesComponent);
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

        // LABEL ID ----------------------------------------------------------------
        lId = sObjGraficos.construirJLabel(
                "Id Contacto:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lId);

        // TEXTFIELD NOMBRE ----------------------------------------------------------------
        tId = sObjGraficos.construirJTextField(
                "Id",
                30, 175, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tId.addFocusListener(entidadesComponent);
        pDatos.add(tId);

//        // LABEL ID CONTENIDO ----------------------------------------------------------
//        lIdValor = sObjGraficos.construirJLabel(
//                "0",
//                120, 140, 160, 30,
//                null, null,
//                sRecursos.getFontLigera(),
//                null,
//                sRecursos.getColorPrincipalOscuro(),
//                null,
//                "l"
//        );
//        pDatos.add(lIdValor);
        // LABEL NOMBRE ----------------------------------------------------------------
        lNombre = sObjGraficos.construirJLabel(
                "Nombre Contacto:",
                20, 210, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lNombre);

        // TEXTFIELD NOMBRE ----------------------------------------------------------------
        tNombre = sObjGraficos.construirJTextField(
                "Nombre",
                30, 245, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tNombre.addFocusListener(entidadesComponent);
        pDatos.add(tNombre);

//        // LABEL EDAD ----------------------------------------------------------------
//        lEdad = sObjGraficos.construirJLabel(
//                "Edad Contacto:",
//                20, 265, 160, 30,
//                null, null,
//                sRecursos.getFontLigera(),
//                null,
//                sRecursos.getColorPrincipalOscuro(),
//                null,
//                "l"
//        );
//        pDatos.add(lEdad);
//        // TEXTFIELD NOMBRE ----------------------------------------------------------------
//        tEdad = sObjGraficos.construirJTextField(
//                "Edad",
//                30, 300, 180, 30,
//                sRecursos.getFontLigera(),
//                colorGris,
//                sRecursos.getColorGrisOscuro(),
//                sRecursos.getColorGrisOscuro(),
//                null,
//                "c"
//        );
//        tEdad.addFocusListener(entidadesComponent);
//        pDatos.add(tEdad);
//        // LABEL OFICIO ----------------------------------------------------------------
//        lOficio = sObjGraficos.construirJLabel(
//                "Oficio Contacto:",
//                20, 350, 160, 30,
//                null, null,
//                sRecursos.getFontLigera(),
//                null,
//                sRecursos.getColorPrincipalOscuro(),
//                null,
//                "l"
//        );
//        pDatos.add(lOficio);
//        // TEXTFIELD OFICIO ----------------------------------------------------------------
//        tOficio = sObjGraficos.construirJTextField(
//                "Oficio",
//                30, 385, 180, 30,
//                sRecursos.getFontLigera(),
//                colorGris,
//                sRecursos.getColorGrisOscuro(),
//                sRecursos.getColorGrisOscuro(),
//                null,
//                "c"
//        );
//        tOficio.addFocusListener(entidadesComponent);
//        pDatos.add(tOficio);
//        // LABEL TELEFONO ----------------------------------------------------------------
//        lTelefono = sObjGraficos.construirJLabel(
//                "Telefono Contacto:",
//                20, 425, 160, 30,
//                null, null,
//                sRecursos.getFontLigera(),
//                null,
//                sRecursos.getColorPrincipalOscuro(),
//                null,
//                "l"
//        );
//        pDatos.add(lTelefono);
//        // TEXTFIELD TELEFONO ----------------------------------------------------------------
//        tTelefono = sObjGraficos.construirJTextField(
//                "Telefono",
//                30, 460, 180, 30,
//                sRecursos.getFontLigera(),
//                colorGris,
//                sRecursos.getColorGrisOscuro(),
//                sRecursos.getColorGrisOscuro(),
//                null,
//                "c"
//        );
//        tTelefono.addFocusListener(entidadesComponent);
//        pDatos.add(tTelefono);
//        // LABEL EMAIL ----------------------------------------------------------------
//        lEmail = sObjGraficos.construirJLabel(
//                "Email Contacto:",
//                20, 510, 160, 30,
//                null, null,
//                sRecursos.getFontLigera(),
//                null,
//                sRecursos.getColorPrincipalOscuro(),
//                null,
//                "l"
//        );
//        pDatos.add(lEmail);
//        // TEXTFIELD EMAIL ----------------------------------------------------------------
//        tEmail = sObjGraficos.construirJTextField(
//                "Email",
//                30, 545, 180, 30,
//                sRecursos.getFontLigera(),
//                colorGris,
//                sRecursos.getColorGrisOscuro(),
//                sRecursos.getColorGrisOscuro(),
//                null,
//                "c"
//        );
//        tEmail.addFocusListener(entidadesComponent);
//        pDatos.add(tEmail);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(entidadesComponent);

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

    public JTextField gettId() {
        return tId;
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
}
