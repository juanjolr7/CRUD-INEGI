package com.panelPoblacionEdad;

import com.conexion.PoblacionEdadDAO;
import com.interfazBD.InterfazCatalogoComponent;
import com.objects.PoblacionEdad;
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
public class PoblacionEdadComponent implements ActionListener, MouseListener, FocusListener {

    private PoblacionEdadTemplate poblacionEdadTemplate;
    private InterfazCatalogoComponent interfazCatalogoComponent;
    private PoblacionEdadDAO poblacionEdadDAO;
    private PoblacionEdad poblacionEdad;
    private String[] placeholdes =
    {
        "Id entidad", "Id municipio", "Id localidad", "P_0A2_F", "P_0A2_M", "P_3YMAS_F", "P_3YMAS_M", "P_5YMAS_F", "P_5YMAS_M", "P_12YMAS_F", "P_12YMAS_M", "P_15YMAS_F", "P_15YMAS_M", "P_18YMAS_F", "P_18YMAS_M", "P_3A5_F", "P_3A5_M", "P_6A11_F", "P_6A11_M", "P_8A14_F", "P_8A14_M", "P_12A14_F", "P_12A14_M", "P_15A17_F", "P_15A17_M", "P_18A24_F", "P_18A24_M", "P_15A49_F", "P_60YMAS_F", "P_60YMAS_M"
    };

    public PoblacionEdadComponent(InterfazCatalogoComponent interfazCatalogoComponent) {
        poblacionEdadDAO = new PoblacionEdadDAO();
        this.interfazCatalogoComponent = interfazCatalogoComponent;
        poblacionEdadTemplate = new PoblacionEdadTemplate(this);
        mostrarRegistrosTabla();
    }

    // MÉTODO IMPLEMENTADO DE ACTIONLISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == poblacionEdadTemplate.getbLimpiar())
        {
            poblacionEdadTemplate.gettIdEntidad().setText("Id entidad");
            poblacionEdadTemplate.gettIdMunicipio().setText("Id municipio");
            poblacionEdadTemplate.gettIdlocalidad().setText("Id localidad");

        }
        if (e.getSource() == poblacionEdadTemplate.getBInsertar())
        {
            insertarRegistroTabla();
        }
        if (e.getSource() == poblacionEdadTemplate.getBModificar())
        {
            modificarRegistroTabla();
        }
        if (e.getSource() == poblacionEdadTemplate.getBEliminar())
        {
            eliminarRegistroTabla();
        }
    }

// MÉTODOS IMPLEMENTADO DE FOCUSLISTENER
    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getBAzul());
        if (textField.getText().equals(placeholdes[0]) || textField.getText().equals(placeholdes[1]) || textField.getText().equals(placeholdes[2]) || textField.getText().equals(placeholdes[3]) || textField.getText().equals(placeholdes[4]) || textField.getText().equals(placeholdes[5]) || textField.getText().equals(placeholdes[6]) || textField.getText().equals(placeholdes[7]) || textField.getText().equals(placeholdes[8]) || textField.getText().equals(placeholdes[9]) || textField.getText().equals(placeholdes[10]) || textField.getText().equals(placeholdes[11]) || textField.getText().equals(placeholdes[12]) || textField.getText().equals(placeholdes[13]) || textField.getText().equals(placeholdes[14]) || textField.getText().equals(placeholdes[15]) || textField.getText().equals(placeholdes[16]) || textField.getText().equals(placeholdes[17]) || textField.getText().equals(placeholdes[18]) || textField.getText().equals(placeholdes[19]) || textField.getText().equals(placeholdes[20]) || textField.getText().equals(placeholdes[21]) || textField.getText().equals(placeholdes[22]) || textField.getText().equals(placeholdes[23]) || textField.getText().equals(placeholdes[24]) || textField.getText().equals(placeholdes[25]) || textField.getText().equals(placeholdes[26]) || textField.getText().equals(placeholdes[27]) || textField.getText().equals(placeholdes[28]) || textField.getText().equals(placeholdes[29]))
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
            int fila = poblacionEdadTemplate.getTabla().getSelectedRow(), columna = poblacionEdadTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                poblacionEdadTemplate.gettIdEntidad().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 0)));
                poblacionEdadTemplate.gettIdMunicipio().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 1)));
                poblacionEdadTemplate.gettIdlocalidad().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 2)));
                poblacionEdadTemplate.gettP_0A2_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 3)));
                poblacionEdadTemplate.gettP_0A2_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 4)));
                poblacionEdadTemplate.gettP_3YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 5)));
                poblacionEdadTemplate.gettP_3YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 6)));
                poblacionEdadTemplate.gettP_5YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 7)));
                poblacionEdadTemplate.gettP_5YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 8)));
                poblacionEdadTemplate.gettP_12YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 9)));
                poblacionEdadTemplate.gettP_12YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 10)));
                poblacionEdadTemplate.gettP_15YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 11)));
                poblacionEdadTemplate.gettP_15YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 12)));
                poblacionEdadTemplate.gettP_18YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 13)));
                poblacionEdadTemplate.gettP_18YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 14)));
                poblacionEdadTemplate.gettP_3A5_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 15)));
                poblacionEdadTemplate.gettP_3A5_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 16)));
                poblacionEdadTemplate.gettP_6A11_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 17)));
                poblacionEdadTemplate.gettP_6A11_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 18)));
                poblacionEdadTemplate.gettP_8A14_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 19)));
                poblacionEdadTemplate.gettP_8A14_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 20)));
                poblacionEdadTemplate.gettP_12A14_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 21)));
                poblacionEdadTemplate.gettP_12A14_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 22)));
                poblacionEdadTemplate.gettP_15A17_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 23)));
                poblacionEdadTemplate.gettP_15A17_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 24)));
                poblacionEdadTemplate.gettP_18A24_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 25)));
                poblacionEdadTemplate.gettP_18A24_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 26)));
                poblacionEdadTemplate.gettP_15A49_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 27)));
                poblacionEdadTemplate.gettP_60YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 28)));
                poblacionEdadTemplate.gettP_60YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 29)));
            } else
            {
                poblacionEdadTemplate.gettIdEntidad().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 0)));
                poblacionEdadTemplate.gettIdMunicipio().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 1)));
                poblacionEdadTemplate.gettIdlocalidad().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 2)));
                poblacionEdadTemplate.gettP_0A2_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 3)));
                poblacionEdadTemplate.gettP_0A2_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 4)));
                poblacionEdadTemplate.gettP_3YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 5)));
                poblacionEdadTemplate.gettP_3YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 6)));
                poblacionEdadTemplate.gettP_5YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 7)));
                poblacionEdadTemplate.gettP_5YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 8)));
                poblacionEdadTemplate.gettP_12YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 9)));
                poblacionEdadTemplate.gettP_12YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 10)));
                poblacionEdadTemplate.gettP_15YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 11)));
                poblacionEdadTemplate.gettP_15YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 12)));
                poblacionEdadTemplate.gettP_18YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 13)));
                poblacionEdadTemplate.gettP_18YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 14)));
                poblacionEdadTemplate.gettP_3A5_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 15)));
                poblacionEdadTemplate.gettP_3A5_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 16)));
                poblacionEdadTemplate.gettP_6A11_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 17)));
                poblacionEdadTemplate.gettP_6A11_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 18)));
                poblacionEdadTemplate.gettP_8A14_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 19)));
                poblacionEdadTemplate.gettP_8A14_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 20)));
                poblacionEdadTemplate.gettP_12A14_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 21)));
                poblacionEdadTemplate.gettP_12A14_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 22)));
                poblacionEdadTemplate.gettP_15A17_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 23)));
                poblacionEdadTemplate.gettP_15A17_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 24)));
                poblacionEdadTemplate.gettP_18A24_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 25)));
                poblacionEdadTemplate.gettP_18A24_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 26)));
                poblacionEdadTemplate.gettP_15A49_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 27)));
                poblacionEdadTemplate.gettP_60YMAS_F().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 28)));
                poblacionEdadTemplate.gettP_60YMAS_M().setText(Integer.toString((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 29)));
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
        List<PoblacionEdad> poblaciones = poblacionEdadDAO.seleccionar();
        int tamanio = poblaciones.size();
        for (int i = 0; i < tamanio; i++)
        {
            poblacionEdad = poblaciones.get(i);
            this.agregarRegistro(poblacionEdad);
        }

    }

    public void insertarRegistroTabla() {
        poblacionEdad = new PoblacionEdad();
        try
        {
            set();

            poblacionEdadDAO.insertar(poblacionEdad);
            restaurarValores();
            poblacionEdadTemplate.getTabla().removeAll();
            poblacionEdadTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void restaurarValores() {
        poblacionEdadTemplate.gettIdEntidad().setText(Integer.toString(poblacionEdad.getIdentidad()));
        poblacionEdadTemplate.gettIdMunicipio().setText(Integer.toString(poblacionEdad.getIdmunicipio()));
        poblacionEdadTemplate.gettIdlocalidad().setText(Integer.toString(poblacionEdad.getIdlocalidad()));
        poblacionEdadTemplate.gettP_0A2_F().setText(Integer.toString(poblacionEdad.getP_0A2_F()));
        poblacionEdadTemplate.gettP_0A2_M().setText(Integer.toString(poblacionEdad.getP_0A2_M()));
        poblacionEdadTemplate.gettP_3YMAS_F().setText(Integer.toString(poblacionEdad.getP_3YMAS_F()));
        poblacionEdadTemplate.gettP_3YMAS_M().setText(Integer.toString(poblacionEdad.getP_3YMAS_M()));
        poblacionEdadTemplate.gettP_5YMAS_F().setText(Integer.toString(poblacionEdad.getP_5YMAS_F()));
        poblacionEdadTemplate.gettP_5YMAS_M().setText(Integer.toString(poblacionEdad.getP_5YMAS_M()));
        poblacionEdadTemplate.gettP_12YMAS_F().setText(Integer.toString(poblacionEdad.getP_12YMAS_F()));
        poblacionEdadTemplate.gettP_12YMAS_M().setText(Integer.toString(poblacionEdad.getP_12YMAS_M()));
        poblacionEdadTemplate.gettP_15YMAS_F().setText(Integer.toString(poblacionEdad.getP_15YMAS_F()));
        poblacionEdadTemplate.gettP_15YMAS_M().setText(Integer.toString(poblacionEdad.getP_15YMAS_M()));
        poblacionEdadTemplate.gettP_18YMAS_F().setText(Integer.toString(poblacionEdad.getP_18YMAS_F()));
        poblacionEdadTemplate.gettP_18YMAS_M().setText(Integer.toString(poblacionEdad.getP_18YMAS_M()));
        poblacionEdadTemplate.gettP_3A5_F().setText(Integer.toString(poblacionEdad.getP_3A5_F()));
        poblacionEdadTemplate.gettP_3A5_M().setText(Integer.toString(poblacionEdad.getP_3A5_M()));
        poblacionEdadTemplate.gettP_6A11_F().setText(Integer.toString(poblacionEdad.getP_6A11_F()));
        poblacionEdadTemplate.gettP_6A11_M().setText(Integer.toString(poblacionEdad.getP_6A11_M()));
        poblacionEdadTemplate.gettP_8A14_F().setText(Integer.toString(poblacionEdad.getP_8A14_F()));
        poblacionEdadTemplate.gettP_8A14_M().setText(Integer.toString(poblacionEdad.getP_8A14_M()));
        poblacionEdadTemplate.gettP_12A14_F().setText(Integer.toString(poblacionEdad.getP_12A14_F()));
        poblacionEdadTemplate.gettP_12A14_M().setText(Integer.toString(poblacionEdad.getP_12A14_M()));
        poblacionEdadTemplate.gettP_15A17_F().setText(Integer.toString(poblacionEdad.getP_15A17_F()));
        poblacionEdadTemplate.gettP_15A17_M().setText(Integer.toString(poblacionEdad.getP_15A17_M()));
        poblacionEdadTemplate.gettP_18A24_F().setText(Integer.toString(poblacionEdad.getP_18A24_F()));
        poblacionEdadTemplate.gettP_18A24_M().setText(Integer.toString(poblacionEdad.getP_18A24_M()));
        poblacionEdadTemplate.gettP_15A49_F().setText(Integer.toString(poblacionEdad.getP_15A49_F()));
        poblacionEdadTemplate.gettP_60YMAS_F().setText(Integer.toString(poblacionEdad.getP_60YMAS_F()));
        poblacionEdadTemplate.gettP_60YMAS_M().setText(Integer.toString(poblacionEdad.getP_60YMAS_M()));
    }

    public void set() {
        poblacionEdad.setIdentidad(Integer.parseInt(poblacionEdadTemplate.gettIdEntidad().getText()));
        poblacionEdad.setIdmunicipio(Integer.parseInt(poblacionEdadTemplate.gettIdMunicipio().getText()));
        poblacionEdad.setIdlocalidad(Integer.parseInt(poblacionEdadTemplate.gettIdlocalidad().getText()));
        poblacionEdad.setP_0A2_F(Integer.parseInt(poblacionEdadTemplate.gettP_0A2_F().getText()));
        poblacionEdad.setP_0A2_M(Integer.parseInt(poblacionEdadTemplate.gettP_0A2_M().getText()));
        poblacionEdad.setP_3YMAS_F(Integer.parseInt(poblacionEdadTemplate.gettP_3YMAS_F().getText()));
        poblacionEdad.setP_3YMAS_M(Integer.parseInt(poblacionEdadTemplate.gettP_3YMAS_M().getText()));
        poblacionEdad.setP_5YMAS_F(Integer.parseInt(poblacionEdadTemplate.gettP_5YMAS_F().getText()));
        poblacionEdad.setP_5YMAS_M(Integer.parseInt(poblacionEdadTemplate.gettP_5YMAS_M().getText()));
        poblacionEdad.setP_12YMAS_F(Integer.parseInt(poblacionEdadTemplate.gettP_12YMAS_F().getText()));
        poblacionEdad.setP_12YMAS_M(Integer.parseInt(poblacionEdadTemplate.gettP_12YMAS_M().getText()));
        poblacionEdad.setP_15YMAS_F(Integer.parseInt(poblacionEdadTemplate.gettP_15YMAS_F().getText()));
        poblacionEdad.setP_15YMAS_M(Integer.parseInt(poblacionEdadTemplate.gettP_15YMAS_M().getText()));
        poblacionEdad.setP_18YMAS_F(Integer.parseInt(poblacionEdadTemplate.gettP_18YMAS_F().getText()));
        poblacionEdad.setP_18YMAS_M(Integer.parseInt(poblacionEdadTemplate.gettP_18YMAS_F().getText()));
        poblacionEdad.setP_3A5_F(Integer.parseInt(poblacionEdadTemplate.gettP_3A5_F().getText()));
        poblacionEdad.setP_3A5_M(Integer.parseInt(poblacionEdadTemplate.gettP_3A5_M().getText()));
        poblacionEdad.setP_6A11_F(Integer.parseInt(poblacionEdadTemplate.gettP_6A11_F().getText()));
        poblacionEdad.setP_6A11_M(Integer.parseInt(poblacionEdadTemplate.gettP_6A11_M().getText()));
        poblacionEdad.setP_8A14_F(Integer.parseInt(poblacionEdadTemplate.gettP_8A14_F().getText()));
        poblacionEdad.setP_8A14_M(Integer.parseInt(poblacionEdadTemplate.gettP_8A14_M().getText()));
        poblacionEdad.setP_12A14_F(Integer.parseInt(poblacionEdadTemplate.gettP_12A14_F().getText()));
        poblacionEdad.setP_12A14_M(Integer.parseInt(poblacionEdadTemplate.gettP_12A14_M().getText()));
        poblacionEdad.setP_15A17_F(Integer.parseInt(poblacionEdadTemplate.gettP_15A17_F().getText()));
        poblacionEdad.setP_15A17_M(Integer.parseInt(poblacionEdadTemplate.gettP_15A17_M().getText()));
        poblacionEdad.setP_18A24_F(Integer.parseInt(poblacionEdadTemplate.gettP_18A24_F().getText()));
        poblacionEdad.setP_18A24_M(Integer.parseInt(poblacionEdadTemplate.gettP_18A24_M().getText()));
        poblacionEdad.setP_15A49_F(Integer.parseInt(poblacionEdadTemplate.gettP_15A49_F().getText()));
        poblacionEdad.setP_60YMAS_F(Integer.parseInt(poblacionEdadTemplate.gettP_60YMAS_F().getText()));
        poblacionEdad.setP_60YMAS_M(Integer.parseInt(poblacionEdadTemplate.gettP_60YMAS_M().getText()));
    }

    public void modificarRegistroTabla() {
        int fSeleccionada = poblacionEdadTemplate.getTabla().getSelectedRow();
        if (fSeleccionada != -1)
        {
            int idEntidad = (Integer) poblacionEdadTemplate.getModelo().getValueAt(poblacionEdadTemplate.getTabla().getSelectedRow(), 0);
            int idMunicipio = (Integer) poblacionEdadTemplate.getModelo().getValueAt(poblacionEdadTemplate.getTabla().getSelectedRow(), 1);
            int idLocalidad = (Integer) poblacionEdadTemplate.getModelo().getValueAt(poblacionEdadTemplate.getTabla().getSelectedRow(), 2);

            set();

            poblacionEdadDAO.actualizar(poblacionEdad, idEntidad, idMunicipio, idLocalidad);
            poblacionEdadTemplate.getTabla().removeAll();
            poblacionEdadTemplate.reiniciarModelo();
            mostrarRegistrosTabla();
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarRegistroTabla() {
        int fila = poblacionEdadTemplate.getTabla().getSelectedRow();
        if (fila != -1)
        {

            int columna = poblacionEdadTemplate.getTabla().getSelectedColumn();
            if (columna == 0)
            {
                poblacionEdad.setIdentidad((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 0));
                poblacionEdad.setIdmunicipio((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 1));
                poblacionEdad.setIdlocalidad((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 2));
                poblacionEdad.setP_0A2_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 3));
                poblacionEdad.setP_0A2_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 4));
                poblacionEdad.setP_3YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 5));
                poblacionEdad.setP_3YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 6));
                poblacionEdad.setP_5YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 7));
                poblacionEdad.setP_5YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 8));
                poblacionEdad.setP_12YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 9));
                poblacionEdad.setP_12YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 10));
                poblacionEdad.setP_15YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 11));
                poblacionEdad.setP_15YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 12));
                poblacionEdad.setP_18YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 13));
                poblacionEdad.setP_18YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 14));
                poblacionEdad.setP_3A5_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 15));
                poblacionEdad.setP_3A5_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 16));
                poblacionEdad.setP_6A11_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 17));
                poblacionEdad.setP_6A11_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 18));
                poblacionEdad.setP_8A14_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 19));
                poblacionEdad.setP_8A14_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 20));
                poblacionEdad.setP_12A14_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 21));
                poblacionEdad.setP_12A14_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 22));
                poblacionEdad.setP_15A17_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 23));
                poblacionEdad.setP_15A17_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 24));
                poblacionEdad.setP_18A24_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 25));
                poblacionEdad.setP_18A24_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 26));
                poblacionEdad.setP_15A49_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 27));
                poblacionEdad.setP_60YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 28));
                poblacionEdad.setP_60YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 29));
            } else
            {
                poblacionEdad.setIdentidad((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 0));
                poblacionEdad.setIdmunicipio((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 1));
                poblacionEdad.setIdlocalidad((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 2));
                poblacionEdad.setP_0A2_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 3));
                poblacionEdad.setP_0A2_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 4));
                poblacionEdad.setP_3YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 5));
                poblacionEdad.setP_3YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 6));
                poblacionEdad.setP_5YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 7));
                poblacionEdad.setP_5YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 8));
                poblacionEdad.setP_12YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 9));
                poblacionEdad.setP_12YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 10));
                poblacionEdad.setP_15YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 11));
                poblacionEdad.setP_15YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 12));
                poblacionEdad.setP_18YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 13));
                poblacionEdad.setP_18YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 14));
                poblacionEdad.setP_3A5_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 15));
                poblacionEdad.setP_3A5_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 16));
                poblacionEdad.setP_6A11_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 17));
                poblacionEdad.setP_6A11_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 18));
                poblacionEdad.setP_8A14_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 19));
                poblacionEdad.setP_8A14_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 20));
                poblacionEdad.setP_12A14_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 21));
                poblacionEdad.setP_12A14_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 22));
                poblacionEdad.setP_15A17_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 23));
                poblacionEdad.setP_15A17_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 24));
                poblacionEdad.setP_18A24_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 25));
                poblacionEdad.setP_18A24_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 26));
                poblacionEdad.setP_15A49_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 27));
                poblacionEdad.setP_60YMAS_F((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 28));
                poblacionEdad.setP_60YMAS_M((Integer) poblacionEdadTemplate.getModelo().getValueAt(fila, 29));
            }

            poblacionEdadTemplate.getModelo().removeRow(fila);
            poblacionEdadDAO.eliminar(poblacionEdad);
        } else
        {
            JOptionPane.showMessageDialog(null, "seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filtrarRegistrosTabla() {
    }

    public void agregarRegistro(PoblacionEdad poblacionEdad) {
        poblacionEdadTemplate.getModelo().addRow(
                new Object[]
                {
                    poblacionEdad.getIdentidad(), poblacionEdad.getIdmunicipio(), poblacionEdad.getIdlocalidad(), poblacionEdad.getP_0A2_F(), poblacionEdad.getP_0A2_M(), poblacionEdad.getP_3YMAS_F(),  poblacionEdad.getP_3YMAS_M(), poblacionEdad.getP_5YMAS_F(),  poblacionEdad.getP_5YMAS_M(), poblacionEdad.getP_12YMAS_F(), poblacionEdad.getP_12YMAS_M(), poblacionEdad.getP_15YMAS_F(), poblacionEdad.getP_15YMAS_M(), poblacionEdad.getP_18YMAS_F(), poblacionEdad.getP_18YMAS_M(), poblacionEdad.getP_3A5_F(), poblacionEdad.getP_3A5_M(), poblacionEdad.getP_6A11_F(), poblacionEdad.getP_6A11_M(), poblacionEdad.getP_8A14_F(), poblacionEdad.getP_8A14_M(), poblacionEdad.getP_12A14_F(), poblacionEdad.getP_12A14_M(), poblacionEdad.getP_15A17_F(), poblacionEdad.getP_15A17_M(), poblacionEdad.getP_18A24_F(), poblacionEdad.getP_18A24_M(), poblacionEdad.getP_15A49_F(), poblacionEdad.getP_60YMAS_F(), poblacionEdad.getP_60YMAS_M()
                }
        );
    }

    public PoblacionEdadTemplate getPoblacionEdadTemplate() {
        return poblacionEdadTemplate;
    }

}
