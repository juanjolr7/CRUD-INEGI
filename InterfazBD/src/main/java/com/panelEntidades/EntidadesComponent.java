package com.panelEntidades;

import com.conexion.EntidadDAO;
import com.interfazBD.InterfazCatalogoComponent;
import com.objects.Entidad;
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
public class EntidadesComponent implements ActionListener, MouseListener, FocusListener {

    private EntidadesTemplate entidadesTemplate;
    private InterfazCatalogoComponent interfazCatalogoComponent;
    private EntidadDAO entidadDAO;
    private Entidad entidad;
    private String[] placeholdes =
    {
        "Id entidad", "Nombre entidad"
    };

    public EntidadesComponent(InterfazCatalogoComponent interfazCatalogoComponent) {
        entidadDAO = new EntidadDAO();
        this.interfazCatalogoComponent = interfazCatalogoComponent;
        entidadesTemplate = new EntidadesTemplate(this);
        mostrarRegistrosTabla();
    }

    // MÉTODO IMPLEMENTADO DE ACTIONLISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == entidadesTemplate.getbLimpiar())
        {
            entidadesTemplate.gettId().setText("Id");
            entidadesTemplate.getTNombre().setText("Nombre");
        }
        if (e.getSource() == entidadesTemplate.getBInsertar())
        {
            insertarRegistroTabla();
        }
        if (e.getSource() == entidadesTemplate.getBModificar())
        {
            modificarRegistroTabla();
        }
        if (e.getSource() == entidadesTemplate.getBEliminar())
        {
            eliminarRegistroTabla();
        }
//        if (e.getSource() == entidadesTemplate.getBFiltrar())
//        {
//            filtrarRegistrosTabla();
//        }
    }

// MÉTODOS IMPLEMENTADO DE FOCUSLISTENER
    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getBAzul());
        if (textField.getText().equals(placeholdes[0]) || textField.getText().equals(placeholdes[1]))
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
            int fila = entidadesTemplate.getTabla().getSelectedRow(), columna = entidadesTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                entidadesTemplate.gettId().setText(Integer.toString((Integer) entidadesTemplate.getModelo().getValueAt(fila, 0)));
                entidadesTemplate.getTNombre().setText((String) entidadesTemplate.getModelo().getValueAt(fila, 1));
            } else
            {
                entidadesTemplate.gettId().setText(Integer.toString((Integer) entidadesTemplate.getModelo().getValueAt(fila, 0)));
                entidadesTemplate.getTNombre().setText((String) entidadesTemplate.getModelo().getValueAt(fila, 1));
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
        List<Entidad> entidades = entidadDAO.seleccionar();
        int tamanio = entidades.size();
        for (int i = 0; i < tamanio; i++)
        {
            entidad = entidades.get(i);
            this.agregarRegistro(entidad);
        }

    }

    public void insertarRegistroTabla() {
        entidad = new Entidad();
        try
        {
            entidad.setIdentidad(Integer.parseInt(entidadesTemplate.gettId().getText()));
            entidad.setNom_entidad(entidadesTemplate.getTNombre().getText());
            entidadDAO.insertar(entidad);
            restaurarValores();
            entidadesTemplate.getTabla().removeAll();
            entidadesTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void restaurarValores() {
        entidadesTemplate.gettId().setText(Integer.toString(entidad.getIdentidad()));
        entidadesTemplate.getTNombre().setText(entidad.getNom_entidad());
    }

    public void modificarRegistroTabla() {
        int fSeleccionada = entidadesTemplate.getTabla().getSelectedRow();
        if (fSeleccionada != -1)
        {
            int id = (Integer) entidadesTemplate.getModelo().getValueAt(entidadesTemplate.getTabla().getSelectedRow(), 0);
//            entidadesTemplate.getModelo().setValueAt(
//                    entidadesTemplate.gettId().getText(), fSeleccionada, 0
//            );
//            entidadesTemplate.getModelo().setValueAt(
//                    entidadesTemplate.getTNombre().getText(), fSeleccionada, 1
//            );
            entidad.setIdentidad(Integer.parseInt(entidadesTemplate.gettId().getText()));
            entidad.setNom_entidad(entidadesTemplate.getTNombre().getText());
            entidadDAO.actualizar(entidad, id);
            entidadesTemplate.getTabla().removeAll();
            entidadesTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarRegistroTabla() {
        int fila = entidadesTemplate.getTabla().getSelectedRow();
        if (fila != -1)
        {
            
            int columna = entidadesTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                entidad.setIdentidad((Integer) entidadesTemplate.getModelo().getValueAt(fila, columna));
                entidad.setNom_entidad((String) entidadesTemplate.getModelo().getValueAt(fila, columna + 1));
            } else
            {
                entidad.setIdentidad((Integer) entidadesTemplate.getModelo().getValueAt(fila, columna - 1));
                entidad.setNom_entidad((String) entidadesTemplate.getModelo().getValueAt(fila, columna));
            }
            
            entidadesTemplate.getModelo().removeRow(fila);
            entidadDAO.eliminar(entidad);
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filtrarRegistrosTabla() {
    }

    public void agregarRegistro(Entidad entidad) {
        entidadesTemplate.getModelo().addRow(
                new Object[]
                {
                    entidad.getIdentidad(), entidad.getNom_entidad()
                }
        );
    }

    public EntidadesTemplate getEntidadesTemplate() {
        return entidadesTemplate;
    }

}
