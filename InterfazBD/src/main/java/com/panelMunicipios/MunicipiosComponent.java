package com.panelMunicipios;

import com.conexion.MunicipioDAO;
import com.interfazBD.InterfazCatalogoComponent;
import com.objects.Municipio;
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
public class MunicipiosComponent implements ActionListener, MouseListener, FocusListener {

    private MunicipiosTemplate municipiosTemplate;
    private InterfazCatalogoComponent interfazCatalogoComponent;
    private MunicipioDAO municipioDAO;
    private Municipio municipio;
    private String[] placeholdes =
    {
        "Id entidad", "Id municipio", "Nombre municipio"
    };

    public MunicipiosComponent(InterfazCatalogoComponent interfazCatalogoComponent) {
        municipioDAO = new MunicipioDAO();
        this.interfazCatalogoComponent = interfazCatalogoComponent;
        municipiosTemplate = new MunicipiosTemplate(this);
        mostrarRegistrosTabla();
    }

    // MÉTODO IMPLEMENTADO DE ACTIONLISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == municipiosTemplate.getbLimpiar())
        {
            municipiosTemplate.gettIdEntidad().setText("Id Entidad");
            municipiosTemplate.gettIdMunicipio().setText("Id Municipio");
            municipiosTemplate.getTNombre().setText("Nombre Municipio");
        }
        if (e.getSource() == municipiosTemplate.getBInsertar())
        {
            insertarRegistroTabla();
        }
        if (e.getSource() == municipiosTemplate.getBModificar())
        {
            modificarRegistroTabla();
        }
        if (e.getSource() == municipiosTemplate.getBEliminar())
        {
            eliminarRegistroTabla();
        }
    }

// MÉTODOS IMPLEMENTADO DE FOCUSLISTENER
    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getBAzul());
        if (textField.getText().equals(placeholdes[0]) || textField.getText().equals(placeholdes[1]) || textField.getText().equals(placeholdes[2]))
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
            int fila = municipiosTemplate.getTabla().getSelectedRow(), columna = municipiosTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                municipiosTemplate.gettIdEntidad().setText(Integer.toString((Integer) municipiosTemplate.getModelo().getValueAt(fila, columna)));
                municipiosTemplate.gettIdMunicipio().setText(Integer.toString((Integer) municipiosTemplate.getModelo().getValueAt(fila, columna + 1)));
                municipiosTemplate.getTNombre().setText((String) municipiosTemplate.getModelo().getValueAt(fila, columna + 2));
            } else
            {
                municipiosTemplate.gettIdEntidad().setText(Integer.toString((Integer) municipiosTemplate.getModelo().getValueAt(fila, 0)));
                municipiosTemplate.gettIdMunicipio().setText(Integer.toString((Integer) municipiosTemplate.getModelo().getValueAt(fila, 1)));
                municipiosTemplate.getTNombre().setText((String) municipiosTemplate.getModelo().getValueAt(fila, 2));
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
        List<Municipio> municipios = municipioDAO.seleccionar();
        int tamanio = municipios.size();
        for (int i = 0; i < tamanio; i++)
        {
            municipio = municipios.get(i);
            this.agregarRegistro(municipio);
        }

    }

    public void insertarRegistroTabla() {
        municipio = new Municipio();
        try
        {
            municipio.setIdentidad(Integer.parseInt(municipiosTemplate.gettIdEntidad().getText()));
            municipio.setIdmunicipio(Integer.parseInt(municipiosTemplate.gettIdMunicipio().getText()));
            municipio.setNom_municipio(municipiosTemplate.getTNombre().getText());
            municipioDAO.insertar(municipio);
            restaurarValores();
            municipiosTemplate.getTabla().removeAll();
            municipiosTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void restaurarValores() {
        municipiosTemplate.gettIdEntidad().setText(Integer.toString(municipio.getIdentidad()));
        municipiosTemplate.gettIdMunicipio().setText(Integer.toString(municipio.getIdmunicipio()));
        municipiosTemplate.getTNombre().setText(municipio.getNom_municipio());
    }

    public void modificarRegistroTabla() {
        int fSeleccionada = municipiosTemplate.getTabla().getSelectedRow();
        if (fSeleccionada != -1)
        {
            int idEntidad = (Integer) municipiosTemplate.getModelo().getValueAt(municipiosTemplate.getTabla().getSelectedRow(), 0);
            int idMunicipio = (Integer) municipiosTemplate.getModelo().getValueAt(municipiosTemplate.getTabla().getSelectedRow(), 1);
//            municipiosTemplate.getModelo().setValueAt(
//                    municipiosTemplate.gettIdEntidad().getText(), fSeleccionada, 0
//            );
//            municipiosTemplate.getModelo().setValueAt(
//                    municipiosTemplate.gettIdMunicipio().getText(), fSeleccionada, 1
//            );
//            municipiosTemplate.getModelo().setValueAt(
//                    municipiosTemplate.getTNombre().getText(), fSeleccionada, 2
//            );
            municipio.setIdentidad(Integer.parseInt(municipiosTemplate.gettIdEntidad().getText()));
            municipio.setIdmunicipio(Integer.parseInt(municipiosTemplate.gettIdMunicipio().getText()));
            municipio.setNom_municipio(municipiosTemplate.getTNombre().getText());
            municipioDAO.actualizar(municipio, idEntidad, idMunicipio);
            municipiosTemplate.getTabla().removeAll();
            municipiosTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarRegistroTabla() {
        int fila = municipiosTemplate.getTabla().getSelectedRow();
        if (fila != -1)
        {
            
            int columna = municipiosTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                municipio.setIdentidad((Integer) municipiosTemplate.getModelo().getValueAt(fila, 0));
                municipio.setIdmunicipio((Integer) municipiosTemplate.getModelo().getValueAt(fila, 1));
                municipio.setNom_municipio((String) municipiosTemplate.getModelo().getValueAt(fila, 2));
            } else
            {
                municipio.setIdentidad((Integer) municipiosTemplate.getModelo().getValueAt(fila, 0));
                municipio.setIdmunicipio((Integer) municipiosTemplate.getModelo().getValueAt(fila, 1));
                municipio.setNom_municipio((String) municipiosTemplate.getModelo().getValueAt(fila, 2));
            }
            
            municipiosTemplate.getModelo().removeRow(fila);
            municipioDAO.eliminar(municipio);
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filtrarRegistrosTabla() {
    }

    public void agregarRegistro(Municipio municipio) {
        municipiosTemplate.getModelo().addRow(
                new Object[]
                {
                    municipio.getIdentidad(), municipio.getIdmunicipio(), municipio.getNom_municipio()
                }
        );
    }

    public MunicipiosTemplate getMunicipiosTemplate() {
        return municipiosTemplate;
    }

}
