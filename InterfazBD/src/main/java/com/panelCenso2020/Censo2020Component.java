package com.panelCenso2020;

import com.conexion.Censo2020DAO;
import com.interfazBD.InterfazCatalogoComponent;
import com.objects.Censo2020;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import services.RecursosService;

/**
 *
 * @author juanj
 */
public class Censo2020Component implements ActionListener, MouseListener, FocusListener {

    private Censo2020Template censo2020Template;
    private InterfazCatalogoComponent interfazCatalogoComponent;
    private Censo2020DAO censo2020DAO;
    private Censo2020 censo2020;
    private String[] placeholdes =
    {
        "Id entidad", "Id municipio", "Id localidad", "Población total", "Población femenina", "Población masculina"
    };

    public Censo2020Component(InterfazCatalogoComponent interfazCatalogoComponent) {
        censo2020DAO = new Censo2020DAO();
        this.interfazCatalogoComponent = interfazCatalogoComponent;
        censo2020Template = new Censo2020Template(this);
        mostrarRegistrosTabla();
    }

    // MÉTODO IMPLEMENTADO DE ACTIONLISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == censo2020Template.getbLimpiar())
        {
            censo2020Template.gettIdEntidad().setText("Id entidad");
            censo2020Template.gettIdMunicipio().setText("Id municipio");
            censo2020Template.gettIdlocalidad().setText("Id localidad");
            censo2020Template.gettPobTotal().setText("Población total");
            censo2020Template.gettPobFem().setText("Población femenina");
            censo2020Template.gettPobMasc().setText("Población masculina");
        }
        if (e.getSource() == censo2020Template.getBInsertar())
        {
            insertarRegistroTabla();
        }
        if (e.getSource() == censo2020Template.getBModificar())
        {
            modificarRegistroTabla();
        }
        if (e.getSource() == censo2020Template.getBEliminar())
        {
            eliminarRegistroTabla();
        }
    }

// MÉTODOS IMPLEMENTADO DE FOCUSLISTENER
    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getBAzul());
        if (textField.getText().equals(placeholdes[0]) || textField.getText().equals(placeholdes[1]) || textField.getText().equals(placeholdes[2]) || textField.getText().equals(placeholdes[3]) || textField.getText().equals(placeholdes[4]) || textField.getText().equals(placeholdes[5]))
        {
            textField.setText("");
        }
    }

    //Realiza una acción una vez el objeto deja de estar seleccionado y pierde el enfoque, en este caso simplemente queremos que vuelva a estar sin ningún borde
    @Override
    public void focusLost(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(null);
    }

// MÉTODOS IMPLEMENTADO DE MOUSELISTENER
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable)
        {
            int fila = censo2020Template.getTabla().getSelectedRow(), columna = censo2020Template.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                censo2020Template.gettIdEntidad().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 0)));
                censo2020Template.gettIdMunicipio().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 1)));
                censo2020Template.gettIdlocalidad().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 2)));
                censo2020Template.gettPobTotal().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 3)));
                censo2020Template.gettPobFem().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 4)));
                censo2020Template.gettPobMasc().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 5)));
            } else
            {
                censo2020Template.gettIdEntidad().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 0)));
                censo2020Template.gettIdMunicipio().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 1)));
                censo2020Template.gettIdlocalidad().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 2)));
                censo2020Template.gettPobTotal().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 3)));
                censo2020Template.gettPobFem().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 4)));
                censo2020Template.gettPobMasc().setText(Integer.toString((Integer) censo2020Template.getModelo().getValueAt(fila, 5)));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton)
        {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton)
        {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorPrincipal());
        }
    }

    public void mostrarRegistrosTabla() {
        List<Censo2020> censos = censo2020DAO.seleccionar();
        int tamanio = censos.size();
        for (int i = 0; i < tamanio; i++)
        {
            censo2020 = censos.get(i);
            this.agregarRegistro(censo2020);
        }

    }

    public void insertarRegistroTabla() {
        censo2020 = new Censo2020();
        try
        {
            censo2020.setIdentidad(Integer.parseInt(censo2020Template.gettIdEntidad().getText()));
            censo2020.setIdmunicipio(Integer.parseInt(censo2020Template.gettIdMunicipio().getText()));
            censo2020.setIdlocalidad(Integer.parseInt(censo2020Template.gettIdlocalidad().getText()));
            censo2020.setPob_total(Integer.parseInt(censo2020Template.gettPobTotal().getText()));
            censo2020.setPob_femenina(Integer.parseInt(censo2020Template.gettPobFem().getText()));
            censo2020.setPob_masculina(Integer.parseInt(censo2020Template.gettPobMasc().getText()));
            censo2020DAO.insertar(censo2020);
            restaurarValores();
            censo2020Template.getTabla().removeAll();
            censo2020Template.reiniciarModelo();
            mostrarRegistrosTabla();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void restaurarValores() {
        censo2020Template.gettIdEntidad().setText(Integer.toString(censo2020.getIdentidad()));
        censo2020Template.gettIdMunicipio().setText(Integer.toString(censo2020.getIdmunicipio()));
        censo2020Template.gettIdlocalidad().setText(Integer.toString(censo2020.getIdlocalidad()));
        censo2020Template.gettPobTotal().setText(Integer.toString(censo2020.getPob_total()));
        censo2020Template.gettPobFem().setText(Integer.toString(censo2020.getPob_femenina()));
        censo2020Template.gettPobMasc().setText(Integer.toString(censo2020.getPob_masculina()));
    }

    public void modificarRegistroTabla() {
        int fSeleccionada = censo2020Template.getTabla().getSelectedRow();
        if (fSeleccionada != -1)
        {
            int idEntidad = (Integer) censo2020Template.getModelo().getValueAt(censo2020Template.getTabla().getSelectedRow(), 0);
            int idMunicipio = (Integer) censo2020Template.getModelo().getValueAt(censo2020Template.getTabla().getSelectedRow(), 1);
            int idLocalidad = (Integer) censo2020Template.getModelo().getValueAt(censo2020Template.getTabla().getSelectedRow(), 2);
            
            censo2020.setIdentidad(Integer.parseInt(censo2020Template.gettIdEntidad().getText()));
            censo2020.setIdmunicipio(Integer.parseInt(censo2020Template.gettIdMunicipio().getText()));
            censo2020.setIdlocalidad(Integer.parseInt(censo2020Template.gettIdMunicipio().getText()));
            censo2020.setPob_total(Integer.parseInt(censo2020Template.gettPobTotal().getText()));
            censo2020.setPob_femenina(Integer.parseInt(censo2020Template.gettPobFem().getText()));
            censo2020.setPob_masculina(Integer.parseInt(censo2020Template.gettPobMasc().getText()));
            censo2020DAO.actualizar(censo2020, idEntidad, idMunicipio, idLocalidad);
            censo2020Template.getTabla().removeAll();
            censo2020Template.reiniciarModelo();
            mostrarRegistrosTabla();
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarRegistroTabla() {
        int fila = censo2020Template.getTabla().getSelectedRow();
        if (fila != -1)
        {
            
            int columna = censo2020Template.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                censo2020.setIdentidad((Integer) censo2020Template.getModelo().getValueAt(fila, columna));
                censo2020.setIdmunicipio((Integer) censo2020Template.getModelo().getValueAt(fila, columna+1));
                censo2020.setIdlocalidad((Integer) censo2020Template.getModelo().getValueAt(fila, columna+2));
                censo2020.setPob_total((Integer) censo2020Template.getModelo().getValueAt(fila, columna + 3));
                censo2020.setPob_femenina((Integer) censo2020Template.getModelo().getValueAt(fila, columna + 4));
                censo2020.setPob_masculina((Integer) censo2020Template.getModelo().getValueAt(fila, columna + 5));
            } else
            {
                censo2020.setIdentidad((Integer) censo2020Template.getModelo().getValueAt(fila, columna));
                censo2020.setIdmunicipio((Integer) censo2020Template.getModelo().getValueAt(fila, columna+1));
                censo2020.setIdlocalidad((Integer) censo2020Template.getModelo().getValueAt(fila, columna+2));
                censo2020.setPob_total((Integer) censo2020Template.getModelo().getValueAt(fila, columna + 3));
                censo2020.setPob_femenina((Integer) censo2020Template.getModelo().getValueAt(fila, columna + 4));
                censo2020.setPob_masculina((Integer) censo2020Template.getModelo().getValueAt(fila, columna + 5));
            }
            
            censo2020Template.getModelo().removeRow(fila);
            censo2020DAO.eliminar(censo2020);
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filtrarRegistrosTabla() {
    }

    public void agregarRegistro(Censo2020 censo2020) {
        censo2020Template.getModelo().addRow(
                new Object[]
                {
                    censo2020.getIdentidad(), censo2020.getIdmunicipio(),censo2020.getIdlocalidad(), censo2020.getPob_total(), censo2020.getPob_femenina(), censo2020.getPob_masculina()
                }
        );
    }

    public Censo2020Template getCenso2020Template() {
        return censo2020Template;
    }

}
