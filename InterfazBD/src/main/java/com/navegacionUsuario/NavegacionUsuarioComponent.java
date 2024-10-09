package com.navegacionUsuario;

import com.panelEntidades.EntidadesComponent;
import com.interfazBD.InterfazCatalogoComponent;
import com.panelCenso2020.Censo2020Component;
import com.panelLocalidades.LocalidadesComponent;
import com.panelMunicipios.MunicipiosComponent;
import com.panelPoblacionEdad.PoblacionEdadComponent;
import com.panelPrincipal.PanelPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import services.CambiaPanel;
import services.RecursosService;

/**
 *
 * @author juanj
 */
public class NavegacionUsuarioComponent implements ActionListener, MouseListener {
    //private CambiaPanel cambiaPanel = new CambiaPanel(container, content)
    private NavegacionUsuarioTemplate navegacionUsuarioTemplate;
    private InterfazCatalogoComponent interfazCatalogoComponent;

    public NavegacionUsuarioComponent(InterfazCatalogoComponent interfazCatalogoComponent) {
        this.navegacionUsuarioTemplate = new NavegacionUsuarioTemplate(this);
        this.interfazCatalogoComponent = interfazCatalogoComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == navegacionUsuarioTemplate.getBHome())
        {
            new CambiaPanel(interfazCatalogoComponent.getInterfazCatalogoTemplate().getPanelPrincipal(), new PanelPrincipalComponent(interfazCatalogoComponent).getPanelPrincipalTemplate());
        } else if (e.getSource() == navegacionUsuarioTemplate.getBEntidades()){
            new CambiaPanel(interfazCatalogoComponent.getInterfazCatalogoTemplate().getPanelPrincipal(), new EntidadesComponent(interfazCatalogoComponent).getEntidadesTemplate());
        } else if (e.getSource() == navegacionUsuarioTemplate.getBMunicipios()){
            new CambiaPanel(interfazCatalogoComponent.getInterfazCatalogoTemplate().getPanelPrincipal(), new MunicipiosComponent(interfazCatalogoComponent).getMunicipiosTemplate());
        } else if (e.getSource() == navegacionUsuarioTemplate.getBLocalidades()){            
            new CambiaPanel(interfazCatalogoComponent.getInterfazCatalogoTemplate().getPanelPrincipal(), new LocalidadesComponent(interfazCatalogoComponent).getLocalidadesTemplate());
        } else if (e.getSource() == navegacionUsuarioTemplate.getBCenso2020()){
            new CambiaPanel(interfazCatalogoComponent.getInterfazCatalogoTemplate().getPanelPrincipal(), new Censo2020Component(interfazCatalogoComponent).getCenso2020Template());
        } else if (e.getSource() == navegacionUsuarioTemplate.getBPoblacionEdad()){
            new CambiaPanel(interfazCatalogoComponent.getInterfazCatalogoTemplate().getPanelPrincipal(), new PoblacionEdadComponent(interfazCatalogoComponent).getPoblacionEdadTemplate());
        }
        //this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
    }

    public NavegacionUsuarioTemplate getNavegacionUsuarioTemplate() {
        return this.navegacionUsuarioTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton boton = ((JButton) e.getSource());
        boton.setContentAreaFilled(true);
        boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton boton = ((JButton) e.getSource());
        boton.setContentAreaFilled(false);
    }
}
