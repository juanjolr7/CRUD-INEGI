package com.interfazBD;

import com.panelPrincipal.PanelPrincipalComponent;
import com.panelPrincipal.PanelPrincipalTemplate;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import services.ObjGraficosService;

/**
 *
 * @author juanj
 */
public class InterfazCatalogoTemplate extends JFrame{
    
    private InterfazCatalogoComponent interfazCatalogoComponent;
    private JPanel panelCatalogo, panelPrincipal, panel;
    //private JPanel
    
    private ObjGraficosService sObjGraficos;
    
    public InterfazCatalogoTemplate(InterfazCatalogoComponent interfazCatalogoComponent){
        this.interfazCatalogoComponent = interfazCatalogoComponent;
        
        obtenerServicios();
        crearPanel();
        confVentana();
    }
    public void confVentana() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setSize(1000, 500);
        this.setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(this);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void crearPanel(){
        panelCatalogo = sObjGraficos.construirJPanel(0, 0, 250, 800, new Color(39, 54, 77), null);
        //panelPrincipal = sObjGraficos.construirJPanel(250, 0, 1287, 800, Color.WHITE, null);
        panelPrincipal = new PanelPrincipalComponent(interfazCatalogoComponent).getPanelPrincipalTemplate();
        panelPrincipal.setLocation(250,0);
        this.add(panelCatalogo);
        this.add(panelPrincipal);
    }
    
    public void crearJLabel(){
        
    }
    
    public void obtenerServicios() {
        sObjGraficos = ObjGraficosService.getService();
        //sRecursos = RecursosService.getService();
    }
    
    public JPanel getPanelCatalogo(){
        return panelCatalogo;
    }
    
    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
