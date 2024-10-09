package com.panelPoblacionEdad;

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
public class PoblacionEdadTemplate extends JPanel {

    //Servicios y objetos
    private PoblacionEdadComponent poblacionEdadComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;
    //Objetos decoradores
    private Color colorGris;
    //Oobjetos graficos
    private JPanel pOpciones, pDatos;
    private JButton bLimpiar, bInsertar, bModificar, bEliminar;
    private JLabel lTitulo, lInstrucciones, lEslogan;
    private JLabel lIdEntidad, lIdMunicipio, lIdLocalidad, lP_0A2_F, lP_0A2_M, lP_3YMAS_F, lP_3YMAS_M, lP_5YMAS_F, lP_5YMAS_M, lP_12YMAS_F, lP_12YMAS_M, lP_15YMAS_F, lP_15YMAS_M, lP_18YMAS_F, lP_18YMAS_M, lP_3A5_F, lP_3A5_M, lP_6A11_F, lP_6A11_M, lP_8A14_F, lP_8A14_M, lP_12A14_F, lP_12A14_M, lP_15A17_F, lP_15A17_M, lP_18A24_F, lP_18A24_M, lP_15A49_F, lP_60YMAS_F, lP_60YMAS_M;
    private JTextField tIdEntidad, tIdMunicipio, tIdlocalidad, tP_0A2_F, tP_0A2_M, tP_3YMAS_F, tP_3YMAS_M, tP_5YMAS_F, tP_5YMAS_M, tP_12YMAS_F, tP_12YMAS_M, tP_15YMAS_F, tP_15YMAS_M, tP_18YMAS_F, tP_18YMAS_M, tP_3A5_F, tP_3A5_M, tP_6A11_F, tP_6A11_M, tP_8A14_F, tP_8A14_M, tP_12A14_F, tP_12A14_M, tP_15A17_F, tP_15A17_M, tP_18A24_F, tP_18A24_M, tP_15A49_F, tP_60YMAS_F, tP_60YMAS_M;

    // Declaración objetos para JTable
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera =
    {
        "Id entidad", "Id municipio", "Id localidad", "P_0A2_F", "P_0A2_M", "P_3YMAS_F", "P_3YMAS_M", "P_5YMAS_F", "P_5YMAS_M", "P_12YMAS_F", "P_12YMAS_M", "P_15YMAS_F", "P_15YMAS_M", "P_18YMAS_F", "P_18YMAS_M", "P_3A5_F", "P_3A5_M", "P_6A11_F", "P_6A11_M", "P_8A14_F", "P_8A14_M", "P_12A14_F", "P_12A14_M", "P_15A17_F", "P_15A17_M", "P_18A24_F", "P_18A24_M", "P_15A49_F", "P_60YMAS_F", "P_60YMAS_M"
    };

    public PoblacionEdadTemplate(PoblacionEdadComponent poblacionEdadComponent) {
        this.poblacionEdadComponent = poblacionEdadComponent;
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
        bLimpiar.addMouseListener(poblacionEdadComponent);
        bLimpiar.addActionListener(poblacionEdadComponent);
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
        bInsertar.addMouseListener(poblacionEdadComponent);
        bInsertar.addActionListener(poblacionEdadComponent);
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
        bModificar.addMouseListener(poblacionEdadComponent);
        bModificar.addActionListener(poblacionEdadComponent);
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
        bEliminar.addMouseListener(poblacionEdadComponent);
        bEliminar.addActionListener(poblacionEdadComponent);
        pOpciones.add(bEliminar);
    }

    public void crearContenidoPDatos() {
        // LABEL INSTRUCCIONES ----------------------------------------------------------------
        lInstrucciones = sObjGraficos.construirJLabel(
                "<html>Datos de población por edad<html>",
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
                "<html>A continuación puede ver y editar la información de la población por edad<html>",
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
        tIdEntidad.addFocusListener(poblacionEdadComponent);
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
        tIdMunicipio.addFocusListener(poblacionEdadComponent);
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
        tIdlocalidad.addFocusListener(poblacionEdadComponent);
        pDatos.add(tIdlocalidad);
        
        
        
        // LABEL P_0A2_F----------------------------------------------------------------
        lP_0A2_F = sObjGraficos.construirJLabel(
                "P_0A2_F:",
                20, 350, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_0A2_F);

        // TEXTFIELD P_0A2_F----------------------------------------------------------------
        tP_0A2_F = sObjGraficos.construirJTextField(
                "P_0A2_F",
                30, 385, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_0A2_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_0A2_F);
        
        
        
        // LABEL P_0A2_M----------------------------------------------------------------
        lP_0A2_M = sObjGraficos.construirJLabel(
                "P_0A2_M:",
                20, 420, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_0A2_M);

        // TEXTFIELD P_0A2_M----------------------------------------------------------------
        tP_0A2_M = sObjGraficos.construirJTextField(
                "P_0A2_M:",
                30, 455, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_0A2_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_0A2_M);
        
        
        
        // LABEL P_3YMAS_F----------------------------------------------------------------
        lP_3YMAS_F = sObjGraficos.construirJLabel(
                "P_3YMAS_F:",
                20, 490, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_3YMAS_F);

        // TEXTFIELD P_3YMAS_F----------------------------------------------------------------
        tP_3YMAS_F = sObjGraficos.construirJTextField(
                "P_3YMAS_F:",
                30, 525, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_3YMAS_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_3YMAS_F);
        
        
        
        // LABEL P_3YMAS_M----------------------------------------------------------------
        lP_3YMAS_M = sObjGraficos.construirJLabel(
                "P_3YMAS_M:",
                20, 560, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_3YMAS_M);

        // TEXTFIELD P_3YMAS_M----------------------------------------------------------------
        tP_3YMAS_M = sObjGraficos.construirJTextField(
                "P_3YMAS_M:",
                30, 595, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_3YMAS_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_3YMAS_M);
        
        
        
        // LABEL P_5YMAS_F----------------------------------------------------------------
        lP_5YMAS_F = sObjGraficos.construirJLabel(
                "P_5YMAS_F:",
                20, 630, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_5YMAS_F);

        // TEXTFIELD P_3YMAS_M----------------------------------------------------------------
        tP_5YMAS_F = sObjGraficos.construirJTextField(
                "P_5YMAS_F:",
                30, 665, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_5YMAS_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_5YMAS_F);
        
        
        
        // LABEL P_5YMAS_M----------------------------------------------------------------
        lP_5YMAS_M = sObjGraficos.construirJLabel(
                "P_5YMAS_M:",
                20, 700, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_5YMAS_M);

        // TEXTFIELD P_3YMAS_M----------------------------------------------------------------
        tP_5YMAS_M = sObjGraficos.construirJTextField(
                "P_5YMAS_M:",
                30, 735, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_5YMAS_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_5YMAS_M);
        
        
        
        // LABEL P_12YMAS_F----------------------------------------------------------------
        lP_12YMAS_F = sObjGraficos.construirJLabel(
                "P_12YMAS_F:",
                20, 770, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_12YMAS_F);

        // TEXTFIELD P_12YMAS_F----------------------------------------------------------------
        tP_12YMAS_F = sObjGraficos.construirJTextField(
                "P_12YMAS_F:",
                30, 805, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_12YMAS_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_12YMAS_F);
        
        
        
        // LABEL P_12YMAS_M----------------------------------------------------------------
        lP_12YMAS_M = sObjGraficos.construirJLabel(
                "P_12YMAS_M:",
                20, 840, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_12YMAS_M);

        // TEXTFIELD P_12YMAS_M----------------------------------------------------------------
        tP_12YMAS_M = sObjGraficos.construirJTextField(
                "P_12YMAS_M:",
                30, 875, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_12YMAS_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_12YMAS_M);
        
        
        
        // LABEL P_15YMAS_F----------------------------------------------------------------
        lP_15YMAS_F = sObjGraficos.construirJLabel(
                "P_15YMAS_F:",
                20, 910, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_15YMAS_F);

        // TEXTFIELD P_15YMAS_F----------------------------------------------------------------
        tP_15YMAS_F = sObjGraficos.construirJTextField(
                "P_15YMAS_F:",
                30, 945, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_15YMAS_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_15YMAS_F);
        
        
        
        // LABEL P_15YMAS_M----------------------------------------------------------------
        lP_15YMAS_M = sObjGraficos.construirJLabel(
                "P_15YMAS_M:",
                20, 980, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_15YMAS_M);

        // TEXTFIELD P_15YMAS_M----------------------------------------------------------------
        tP_15YMAS_M = sObjGraficos.construirJTextField(
                "P_15YMAS_M:",
                30, 1015, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_15YMAS_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_15YMAS_M);
        
        
        
        // LABEL P_18YMAS_F----------------------------------------------------------------
        lP_18YMAS_F = sObjGraficos.construirJLabel(
                "P_18YMAS_F:",
                20, 1050, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_18YMAS_F);

        // TEXTFIELD P_18YMAS_F----------------------------------------------------------------
        tP_18YMAS_F = sObjGraficos.construirJTextField(
                "P_18YMAS_F:",
                30, 1085, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_18YMAS_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_18YMAS_F);
        
        
        
        // LABEL P_18YMAS_M----------------------------------------------------------------
        lP_18YMAS_M = sObjGraficos.construirJLabel(
                "P_18YMAS_M:",
                20, 1120, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_18YMAS_M);

        // TEXTFIELD P_18YMAS_M----------------------------------------------------------------
        tP_18YMAS_M = sObjGraficos.construirJTextField(
                "P_18YMAS_M:",
                30, 1155, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_18YMAS_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_18YMAS_M);
        
        
        
        // LABEL P_3A5_F----------------------------------------------------------------
        lP_3A5_F = sObjGraficos.construirJLabel(
                "P_3A5_F:",
                20, 1190, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_3A5_F);

        // TEXTFIELD P_3A5_F----------------------------------------------------------------
        tP_3A5_F = sObjGraficos.construirJTextField(
                "P_3A5_F:",
                30, 1225, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_3A5_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_3A5_F);
        
        
        
        // LABEL P_3A5_M----------------------------------------------------------------
        lP_3A5_M = sObjGraficos.construirJLabel(
                "P_3A5_M:",
                20, 1260, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_3A5_M);

        // TEXTFIELD P_3A5_M----------------------------------------------------------------
        tP_3A5_M = sObjGraficos.construirJTextField(
                "P_3A5_M:",
                30, 1295, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_3A5_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_3A5_M);
        
        
        
        // LABEL P_6A11_F----------------------------------------------------------------
        lP_6A11_F = sObjGraficos.construirJLabel(
                "P_6A11_F:",
                20, 1330, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_6A11_F);

        // TEXTFIELD P_6A11_F----------------------------------------------------------------
        tP_6A11_F = sObjGraficos.construirJTextField(
                "P_6A11_F:",
                30, 1365, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_6A11_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_6A11_F);
        
        
        
        // LABEL P_6A11_M----------------------------------------------------------------
        lP_6A11_M = sObjGraficos.construirJLabel(
                "P_6A11_M:",
                20, 1400, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_6A11_M);

        // TEXTFIELD P_6A11_M----------------------------------------------------------------
        tP_6A11_M = sObjGraficos.construirJTextField(
                "P_6A11_M:",
                30, 1435, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_6A11_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_6A11_M);
        
        
        
        // LABEL P_8A14_F----------------------------------------------------------------
        lP_8A14_F = sObjGraficos.construirJLabel(
                "P_8A14_F:",
                20, 1470, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_8A14_F);

        // TEXTFIELD P_8A14_F----------------------------------------------------------------
        tP_8A14_F = sObjGraficos.construirJTextField(
                "P_8A14_F:",
                30, 1505, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_8A14_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_8A14_F);
        
        
        
        // LABEL P_8A14_M----------------------------------------------------------------
        lP_8A14_M = sObjGraficos.construirJLabel(
                "P_8A14_M:",
                20, 1540, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_8A14_M);

        // TEXTFIELD P_8A14_F----------------------------------------------------------------
        tP_8A14_M = sObjGraficos.construirJTextField(
                "P_8A14_M:",
                30, 1575, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_8A14_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_8A14_M);
        
        
        
        // LABEL P_12A14_F----------------------------------------------------------------
        lP_12A14_F = sObjGraficos.construirJLabel(
                "P_12A14_F:",
                20, 1610, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_12A14_F);

        // TEXTFIELD P_12A14_F----------------------------------------------------------------
        tP_12A14_F = sObjGraficos.construirJTextField(
                "P_12A14_F:",
                30, 1645, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_12A14_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_12A14_F);
        
        
        
        // LABEL P_12A14_M----------------------------------------------------------------
        lP_12A14_M = sObjGraficos.construirJLabel(
                "P_12A14_M:",
                20, 1680, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_12A14_M);

        // TEXTFIELD P_12A14_M----------------------------------------------------------------
        tP_12A14_M = sObjGraficos.construirJTextField(
                "P_12A14_M:",
                30, 1715, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_12A14_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_12A14_M);
        
        
        
        // LABEL P_15A17_F----------------------------------------------------------------
        lP_15A17_F = sObjGraficos.construirJLabel(
                "P_15A17_F:",
                20, 1750, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_15A17_F);

        // TEXTFIELD P_15A17_F----------------------------------------------------------------
        tP_15A17_F = sObjGraficos.construirJTextField(
                "P_15A17_F:",
                30, 1785, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_15A17_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_15A17_F);
        
        
        
        // LABEL P_15A17_M----------------------------------------------------------------
        lP_15A17_M = sObjGraficos.construirJLabel(
                "P_15A17_M:",
                20, 1820, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_15A17_M);

        // TEXTFIELD P_15A17_M----------------------------------------------------------------
        tP_15A17_M = sObjGraficos.construirJTextField(
                "P_15A17_M:",
                30, 1855, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_15A17_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_15A17_M);
        
        
        
        // LABEL P_18A24_F----------------------------------------------------------------
        lP_18A24_F = sObjGraficos.construirJLabel(
                "P_18A24_F:",
                20, 1890, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_18A24_F);

        // TEXTFIELD P_18A24_F----------------------------------------------------------------
        tP_18A24_F = sObjGraficos.construirJTextField(
                "P_18A24_F:",
                30, 1925, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_18A24_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_18A24_F);
        
        
        
        // LABEL P_18A24_M----------------------------------------------------------------
        lP_18A24_M = sObjGraficos.construirJLabel(
                "P_18A24_M:",
                20, 1960, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_18A24_M);

        // TEXTFIELD P_18A24_M----------------------------------------------------------------
        tP_18A24_M = sObjGraficos.construirJTextField(
                "P_18A24_M:",
                30, 1995, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_18A24_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_18A24_M);
        
        
        
        // LABEL P_15A49_F----------------------------------------------------------------
        lP_15A49_F = sObjGraficos.construirJLabel(
                "P_15A49_F:",
                20, 570, 2030, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_15A49_F);

        // TEXTFIELD P_15A49_F----------------------------------------------------------------
        tP_15A49_F = sObjGraficos.construirJTextField(
                "P_15A49_F:",
                30, 605, 2065, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_15A49_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_15A49_F);
        
        
        
        // LABEL P_60YMAS_F----------------------------------------------------------------
        lP_60YMAS_F = sObjGraficos.construirJLabel(
                "P_60YMAS_F:",
                20, 570, 2100, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_60YMAS_F);

        // TEXTFIELD P_60YMAS_F----------------------------------------------------------------
        tP_60YMAS_F = sObjGraficos.construirJTextField(
                "P_60YMAS_F:",
                30, 605, 2135, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_60YMAS_F.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_60YMAS_F);
        
        
        
        // LABEL P_60YMAS_M----------------------------------------------------------------
        lP_60YMAS_M = sObjGraficos.construirJLabel(
                "P_60YMAS_M:",
                20, 570, 2170, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        pDatos.add(lP_60YMAS_M);

        // TEXTFIELD P_60YMAS_M----------------------------------------------------------------
        tP_60YMAS_M = sObjGraficos.construirJTextField(
                "P_60YMAS_M:",
                30, 605, 2205, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP_60YMAS_M.addFocusListener(poblacionEdadComponent);
        pDatos.add(tP_60YMAS_M);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(poblacionEdadComponent);

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

    public JTextField gettP_0A2_F() {
        return tP_0A2_F;
    }

    public JTextField gettP_0A2_M() {
        return tP_0A2_M;
    }

    public JTextField gettP_3YMAS_F() {
        return tP_3YMAS_F;
    }

    public JTextField gettP_3YMAS_M() {
        return tP_3YMAS_M;
    }

    public JTextField gettP_5YMAS_F() {
        return tP_5YMAS_F;
    }

    public JTextField gettP_5YMAS_M() {
        return tP_5YMAS_M;
    }

    public JTextField gettP_12YMAS_F() {
        return tP_12YMAS_F;
    }

    public JTextField gettP_12YMAS_M() {
        return tP_12YMAS_M;
    }

    public JTextField gettP_15YMAS_F() {
        return tP_15YMAS_F;
    }

    public JTextField gettP_15YMAS_M() {
        return tP_15YMAS_M;
    }

    public JTextField gettP_18YMAS_F() {
        return tP_18YMAS_F;
    }

    public JTextField gettP_18YMAS_M() {
        return tP_18YMAS_M;
    }

    public JTextField gettP_3A5_F() {
        return tP_3A5_F;
    }

    public JTextField gettP_3A5_M() {
        return tP_3A5_M;
    }

    public JTextField gettP_6A11_F() {
        return tP_6A11_F;
    }

    public JTextField gettP_6A11_M() {
        return tP_6A11_M;
    }

    public JTextField gettP_8A14_F() {
        return tP_8A14_F;
    }

    public JTextField gettP_8A14_M() {
        return tP_8A14_M;
    }

    public JTextField gettP_12A14_F() {
        return tP_12A14_F;
    }

    public JTextField gettP_12A14_M() {
        return tP_12A14_M;
    }

    public JTextField gettP_15A17_F() {
        return tP_15A17_F;
    }

    public JTextField gettP_15A17_M() {
        return tP_15A17_M;
    }

    public JTextField gettP_18A24_F() {
        return tP_18A24_F;
    }

    public JTextField gettP_18A24_M() {
        return tP_18A24_M;
    }

    public JTextField gettP_15A49_F() {
        return tP_15A49_F;
    }

    public JTextField gettP_60YMAS_F() {
        return tP_60YMAS_F;
    }

    public JTextField gettP_60YMAS_M() {
        return tP_60YMAS_M;
    }
    
    
    
}
