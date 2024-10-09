package com.panelPrincipal;

import com.interfazBD.InterfazCatalogoComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanj
 */
public class PanelPrincipalComponent implements ActionListener{
    private InterfazCatalogoComponent interfazCatalogoComponent;
    private PanelPrincipalTemplate panelPrincipalTemplate;
    
    public PanelPrincipalComponent(InterfazCatalogoComponent interfazCatalogoComponent){
        this.interfazCatalogoComponent = interfazCatalogoComponent;
        this.panelPrincipalTemplate = new PanelPrincipalTemplate(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
    }
    
    public PanelPrincipalTemplate getPanelPrincipalTemplate(){
        return panelPrincipalTemplate;
    }
}
