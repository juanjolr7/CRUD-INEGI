package com.panelLocalidades;

import com.conexion.LocalidadDAO;
import com.interfazBD.InterfazCatalogoComponent;
import com.objects.Localidad;
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
public class LocalidadesComponent implements ActionListener, MouseListener, FocusListener {

    private LocalidadesTemplate localidadesTemplate;
    private InterfazCatalogoComponent interfazCatalogoComponent;
    private LocalidadDAO localidadDAO;
    private Localidad localidad;
    private String[] placeholdes =
    {
        "Id entidad", "Id municipio", "Id localidad", "Nombre localidad"
    };

    public LocalidadesComponent(InterfazCatalogoComponent interfazCatalogoComponent) {
        localidadDAO = new LocalidadDAO();
        this.interfazCatalogoComponent = interfazCatalogoComponent;
        localidadesTemplate = new LocalidadesTemplate(this);
        mostrarRegistrosTabla();
    }

    // MÉTODO IMPLEMENTADO DE ACTIONLISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == localidadesTemplate.getbLimpiar())
        {
            localidadesTemplate.gettIdEntidad().setText("Id entidad");
            localidadesTemplate.gettIdMunicipio().setText("Id municipio");
            localidadesTemplate.gettIdlocalidad().setText("Id localidad");
            localidadesTemplate.getTNombre().setText("Nombre localidad");
        }
        if (e.getSource() == localidadesTemplate.getBInsertar())
        {
            insertarRegistroTabla();
        }
        if (e.getSource() == localidadesTemplate.getBModificar())
        {
            modificarRegistroTabla();
        }
        if (e.getSource() == localidadesTemplate.getBEliminar())
        {
            eliminarRegistroTabla();
        }
    }

// MÉTODOS IMPLEMENTADO DE FOCUSLISTENER
    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getBAzul());
        if (textField.getText().equals(placeholdes[0]) || textField.getText().equals(placeholdes[1]) || textField.getText().equals(placeholdes[2]) || textField.getText().equals(placeholdes[3]))
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
            int fila = localidadesTemplate.getTabla().getSelectedRow(), columna = localidadesTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                localidadesTemplate.gettIdEntidad().setText(Integer.toString((Integer) localidadesTemplate.getModelo().getValueAt(fila, 0)));
                localidadesTemplate.gettIdMunicipio().setText(Integer.toString((Integer) localidadesTemplate.getModelo().getValueAt(fila, 1)));
                localidadesTemplate.gettIdlocalidad().setText(Integer.toString((Integer) localidadesTemplate.getModelo().getValueAt(fila, 2)));
                localidadesTemplate.getTNombre().setText((String) localidadesTemplate.getModelo().getValueAt(fila, 3));
            } else
            {
                localidadesTemplate.gettIdEntidad().setText(Integer.toString((Integer) localidadesTemplate.getModelo().getValueAt(fila, 0)));
                localidadesTemplate.gettIdMunicipio().setText(Integer.toString((Integer) localidadesTemplate.getModelo().getValueAt(fila, 1)));
                localidadesTemplate.gettIdlocalidad().setText(Integer.toString((Integer) localidadesTemplate.getModelo().getValueAt(fila, 2)));
                localidadesTemplate.getTNombre().setText((String) localidadesTemplate.getModelo().getValueAt(fila, 3));
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
        List<Localidad> localidades = localidadDAO.seleccionar();
        int tamanio = localidades.size();
        for (int i = 0; i < tamanio; i++)
        {
            localidad = localidades.get(i);
            this.agregarRegistro(localidad);
        }

    }

    public void insertarRegistroTabla() {
        localidad = new Localidad();
        try
        {
            localidad.setIdentidad(Integer.parseInt(localidadesTemplate.gettIdEntidad().getText()));
            localidad.setIdmunicipio(Integer.parseInt(localidadesTemplate.gettIdMunicipio().getText()));
            localidad.setIdlocalidad(Integer.parseInt(localidadesTemplate.gettIdlocalidad().getText()));
            localidad.setNom_localidad(localidadesTemplate.getTNombre().getText());
            localidadDAO.insertar(localidad);
            restaurarValores();
            localidadesTemplate.getTabla().removeAll();
            localidadesTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void restaurarValores() {
        localidadesTemplate.gettIdEntidad().setText(Integer.toString(localidad.getIdentidad()));
        localidadesTemplate.gettIdMunicipio().setText(Integer.toString(localidad.getIdmunicipio()));
        localidadesTemplate.gettIdlocalidad().setText(Integer.toString(localidad.getIdlocalidad()));
        localidadesTemplate.getTNombre().setText(localidad.getNom_localidad());
    }

    public void modificarRegistroTabla() {
        int fSeleccionada = localidadesTemplate.getTabla().getSelectedRow();
        if (fSeleccionada != -1)
        {
            int idEntidad = (Integer) localidadesTemplate.getModelo().getValueAt(localidadesTemplate.getTabla().getSelectedRow(), 0);
            int idMunicipio = (Integer) localidadesTemplate.getModelo().getValueAt(localidadesTemplate.getTabla().getSelectedRow(), 1);
            int idLocalidad = (Integer) localidadesTemplate.getModelo().getValueAt(localidadesTemplate.getTabla().getSelectedRow(), 2);
            localidad.setIdentidad(Integer.parseInt(localidadesTemplate.gettIdEntidad().getText()));
            localidad.setIdmunicipio(Integer.parseInt(localidadesTemplate.gettIdMunicipio().getText()));
            localidad.setIdlocalidad(Integer.parseInt(localidadesTemplate.gettIdMunicipio().getText()));
            localidad.setNom_localidad(localidadesTemplate.getTNombre().getText());
            localidadDAO.actualizar(localidad, idEntidad, idMunicipio, idLocalidad);
            localidadesTemplate.getTabla().removeAll();
            localidadesTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarRegistroTabla() {
        int fila = localidadesTemplate.getTabla().getSelectedRow();
        if (fila != -1)
        {
            
            int columna = localidadesTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                localidad.setIdentidad((Integer) localidadesTemplate.getModelo().getValueAt(fila, columna));
                localidad.setIdmunicipio((Integer) localidadesTemplate.getModelo().getValueAt(fila, columna+1));
                localidad.setIdlocalidad((Integer) localidadesTemplate.getModelo().getValueAt(fila, columna+2));
                localidad.setNom_localidad((String) localidadesTemplate.getModelo().getValueAt(fila, columna + 3));
            } else
            {
                localidad.setIdentidad((Integer) localidadesTemplate.getModelo().getValueAt(fila, columna));
                localidad.setIdmunicipio((Integer) localidadesTemplate.getModelo().getValueAt(fila, columna+1));
                localidad.setIdlocalidad((Integer) localidadesTemplate.getModelo().getValueAt(fila, columna+2));
                localidad.setNom_localidad((String) localidadesTemplate.getModelo().getValueAt(fila, columna + 3));
            }
            
            localidadesTemplate.getModelo().removeRow(fila);
            localidadDAO.eliminar(localidad);
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filtrarRegistrosTabla() {
    }

    public void agregarRegistro(Localidad localidad) {
        localidadesTemplate.getModelo().addRow(
                new Object[]
                {
                    localidad.getIdentidad(), localidad.getIdmunicipio(),localidad.getIdlocalidad(), localidad.getNom_localidad()
                }
        );
    }

    public LocalidadesTemplate getLocalidadesTemplate() {
        return localidadesTemplate;
    }

}
