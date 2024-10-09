package com.navegacionUsuario;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import services.ObjGraficosService;
import services.RecursosService;

//Este es el buenoo
public class NavegacionUsuarioTemplate extends JPanel{
    
    private NavegacionUsuarioComponent navegacionUsuarioComponent;
    
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    
    //Declaración objetos gráficos
    private JPanel pSuperior, pInferior;
    private JButton bHome, bEntidades, bMunicipios, bLocalidades, bCenso2020, bPoblacionEdad;
    private JLabel lNombreUsuario, lEslogan, lImagenUsuario, lIconoUsuario;
    
    //Declaración Objetos Decoradores
    private ImageIcon iHome,iIconoUsuario, iImagenUsuario, iFondo, iEntidades, iMunicipios, iLocalidades, iCenso2020, iPoblacionEdad, iDimAux;
    private Border bVacio;
    
    public NavegacionUsuarioTemplate(NavegacionUsuarioComponent navegacionUsuarioComponent){
        this.navegacionUsuarioComponent = navegacionUsuarioComponent;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        
        this.crearObjetosDecoradores();
        this.crearPaneles();
        this.crearJButtons();
        this.crearJLabels();
        
        this.setSize(250, 800);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    public void crearPaneles(){
        this.pSuperior = sObjGraficos.construirJPanel(
                0, 0, 250, 300,
                sRecursos.getColorCatalogo(),
                null
        );
        this.add(pSuperior);

        this.pInferior = sObjGraficos.construirJPanel(
                0, 300, 250, 500,
                /*sRecursos.getColorCatalogo()*/sRecursos.getColorCatalogo(),
                null
        );
        this.add(pInferior);
    }
    
    public void crearObjetosDecoradores(){
        this.iMunicipios = new ImageIcon("src/main/resources/images/municipio.png");
        this.iLocalidades = new ImageIcon("src/main/resources/images/localidad.png");
        this.iEntidades = new ImageIcon("src/main/resources/images/entidad.png");
        this.iCenso2020 = new ImageIcon("src/main/resources/images/censo.png");
        this.iPoblacionEdad = new ImageIcon("src/main/resources/images/poblacion.png");
        this.iFondo = new ImageIcon("src/main/resources/images/INEGI.png");
        this.iIconoUsuario = new ImageIcon("src/main/resources/images/usuario.png");
        this.iImagenUsuario = new ImageIcon("src/main/resources/images/calamardo.jpg");
        this.iHome = new ImageIcon("src/main/resources/images/home.png");
        this.bVacio = new EmptyBorder(2, 20, 2, 2);
    }
 
    public void crearJButtons() {
        // BOTÓN HOME--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iHome.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.bHome = sObjGraficos.construirJButton(
                "    Home",
                10, 30, 200, 60,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontMediana(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bHome.addActionListener((ActionListener) navegacionUsuarioComponent);
        this.bHome.addMouseListener(navegacionUsuarioComponent);
        this.pInferior.add(bHome);
        
        // BOTÓN ENTIDADES--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iEntidades.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.bEntidades = sObjGraficos.construirJButton(
                "    Entidades",
                10, 80, 200, 60,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontMediana(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bEntidades.addActionListener((ActionListener) navegacionUsuarioComponent);
        this.bEntidades.addMouseListener(navegacionUsuarioComponent);
        this.pInferior.add(bEntidades);

        // BOTÓN MUNICIPIOS--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iMunicipios.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.bMunicipios = sObjGraficos.construirJButton(
                "    Municipios",
                10, 130, 200, 60,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontMediana(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bMunicipios.addActionListener((ActionListener) navegacionUsuarioComponent);
        this.bMunicipios.addMouseListener(navegacionUsuarioComponent);
        this.pInferior.add(bMunicipios);

        // BOTÓN LOCALIDADES--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iLocalidades.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.bLocalidades = sObjGraficos.construirJButton(
                "    Localidades",
                10, 180, 200, 60,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontMediana(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bLocalidades.addActionListener((ActionListener) navegacionUsuarioComponent);
        this.bLocalidades.addMouseListener(navegacionUsuarioComponent);
        this.pInferior.add(bLocalidades);

        // BOTÓN CENSO2020--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iCenso2020.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.bCenso2020 = sObjGraficos.construirJButton(
                "    Censo2020",
                10, 230, 200, 60,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontMediana(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bCenso2020.addActionListener((ActionListener) navegacionUsuarioComponent);
        this.bCenso2020.addMouseListener(navegacionUsuarioComponent);
        this.pInferior.add(bCenso2020);

        // BOTÓN POBLACION EDAD--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iPoblacionEdad.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.bPoblacionEdad = sObjGraficos.construirJButton(
                "<html><div align='center'>"+"        "+"Población <br/>"+"       "+"     edad</div></html>",
                30, 280, 200, 60,
                sRecursos.getCMano(),
                iDimAux,
                sRecursos.getFontMediana(),
                null,
                Color.WHITE,
                bVacio,
                "l",
                false
        );
        this.bPoblacionEdad.addActionListener((ActionListener) navegacionUsuarioComponent);
        this.bPoblacionEdad.addMouseListener(navegacionUsuarioComponent);
        this.pInferior.add(bPoblacionEdad);
    }
    
    public void crearJLabels() {
        // LABEL ICONO USUARIO--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iIconoUsuario.getImage()
                        .getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );
        this.lIconoUsuario = sObjGraficos.construirJLabel(
                null,
                10, 20, 40, 40,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.pSuperior.add(lIconoUsuario);

        // LABEL NOMBRE USUARIO--------------------------------------------------------------------
        this.lNombreUsuario = sObjGraficos.construirJLabel(
                "Nombre de Usuario",
                ((this.pSuperior.getWidth() - 200) / 2) + 10, 20, 200, 40,
                null, null,
                sRecursos.getFontTitulo(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        this.pSuperior.add(lNombreUsuario);

        // LABEL IMAGEN USUARIO--------------------------------------------------------------------
        iDimAux = new ImageIcon(
                iImagenUsuario.getImage()
                        .getScaledInstance(180, 180, Image.SCALE_AREA_AVERAGING)
        );
        this.lImagenUsuario = sObjGraficos.construirJLabel(
                null,
                (this.pSuperior.getWidth() - 180) / 2, 75, 180, 180,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.pSuperior.add(lImagenUsuario);

        // LABEL ESLOGAN--------------------------------------------------------------------
        this.lEslogan = sObjGraficos.construirJLabel(
                "<html><div align='center'> Datos del estudio de <br/>Inegi 2020</div></html>",
                (this.pSuperior.getWidth() - 180) / 2, 265, 180, 40,
                null, null,
                sRecursos.getFontLigera(),
                null,
                Color.WHITE,
                null,
                "c");
        this.pSuperior.add(lEslogan);
    }
    
    public JButton getBHome(){ 
        return this.bHome; 
    }
    
    public JButton getBEntidades(){ 
        return this.bEntidades; 
    }
    
    public JButton getBMunicipios(){ 
        return this.bMunicipios; 
    }
    
    public JButton getBLocalidades(){ 
        return this.bLocalidades; 
    }
    
    public JButton getBCenso2020(){ 
        return this.bCenso2020; 
    }
    
    public JButton getBPoblacionEdad(){ 
        return this.bPoblacionEdad; 
    }
}
