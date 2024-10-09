package com.panelPrincipal;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import services.ObjGraficosService;
import services.RecursosService;

/**
 *
 * @author juanj
 */
public class PanelPrincipalTemplate extends JPanel{
    private ImageIcon iconoFondo, iDimAux;
    private PanelPrincipalComponent panelPrincipalComponent;
    private JLabel leyenda, lFondo; 
    
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    
    public PanelPrincipalTemplate(PanelPrincipalComponent panelPrincipalComponent){
        this.panelPrincipalComponent = panelPrincipalComponent;
        this.obtenerServicios();
        this.iniciarPanel();
        this.crearObjetosDecoradores();
        //crearObjetosDecoradores();
    }
    
    public void obtenerServicios() {
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
    }
    
    public void crearObjetosDecoradores(){
        iconoFondo = new ImageIcon("src/main/resources/images/INEGI.png");
        leyenda = sObjGraficos.construirJLabel("Bienvenido al Catalogo de INEGI 2020", 350, 30, 600, 40,null, null, sRecursos.getFontPanel(), Color.orange, Color.BLACK, null , "c");
        
        iDimAux = new ImageIcon(
                iconoFondo.getImage()
                        .getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING)
        );
        this.lFondo = sObjGraficos.construirJLabel(
                null,
                350, 100, 600, 600,
                null,
                iDimAux,
                null, null, null, null,
                "c"
        );
        this.add(lFondo);
        
        this.add(leyenda);
    }
    
    public void iniciarPanel(){
        this.setSize(1287, 800);
        //this.setLocation(250, 0);
        this.setLayout(null);
        //this.setBackground(Color.GRAY);
        //this.setBackground(Color.red);
    }
}
