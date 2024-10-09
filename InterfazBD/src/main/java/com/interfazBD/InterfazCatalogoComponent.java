package com.interfazBD;

import com.navegacionUsuario.NavegacionUsuarioComponent;
import com.panelPrincipal.PanelPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author juanj
 */
public class InterfazCatalogoComponent implements ActionListener{
    private InterfazCatalogoTemplate interfazCatalogoTemplate;
    private NavegacionUsuarioComponent navegacionUsuarioComponent;
    private PanelPrincipalComponent panelPrincipalComponent;
    
    public InterfazCatalogoComponent(){
        this.interfazCatalogoTemplate = new InterfazCatalogoTemplate(this);
        this.navegacionUsuarioComponent = new NavegacionUsuarioComponent(this);
        
        interfazCatalogoTemplate.getPanelCatalogo().add(navegacionUsuarioComponent.getNavegacionUsuarioTemplate());
    }
    
    public InterfazCatalogoTemplate getInterfazCatalogoTemplate(){
        return this.interfazCatalogoTemplate;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == loginTemplate.getBEntrar())
//        {
//            this.mostrarDatosUsuario();
//            this.entrar();
//        }
//        if (e.getSource() == loginTemplate.getBCerrar())
//        {
//            System.exit(0);
//        }
//        if (e.getSource() == loginTemplate.getBOpcion1())
//        {
//            JOptionPane.showMessageDialog(null, "Botón Opcion", "Advertencia", 1);
//        }
//        if (e.getSource() == loginTemplate.getBRegistrarse())
//        {
//            JOptionPane.showMessageDialog(null, "Boton Registro", "Advertencia", 1);
//        }
    }
}
