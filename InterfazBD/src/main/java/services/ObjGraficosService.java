package services;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author juanj
 */
public class ObjGraficosService {

    static private ObjGraficosService servicio;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JTextField textField;
    private JScrollPane panelScroll;
    
    private ObjGraficosService() {
    }

    public static ObjGraficosService getService() {
        if (servicio == null)
        {
            servicio = new ObjGraficosService();
        }
        return servicio;
    }

    public JPanel construirJPanel(int x, int y, int ancho, int alto, Color colorFondo, Border borde) {
        panel = new JPanel();
        panel.setSize(ancho, alto);
        panel.setLocation(x, y);
        panel.setLayout(null);
        panel.setBackground(colorFondo);
        panel.setBorder(borde);
        return panel;
    }

    public JButton construirJButton(
            String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente,
            Color colorFondo, Color colorFuente, Border borde, String direccion, boolean esSolido
    ) {
        button = new JButton(texto);
        button.setLocation(x, y);
        button.setSize(ancho, alto);
        button.setFocusable(false);
        button.setCursor(cursor);
        button.setFont(fuente);
        button.setBackground(colorFondo);
        button.setForeground(colorFuente);
        button.setIcon(imagen);
        button.setBorder(borde);
        button.setContentAreaFilled(esSolido);
        switch (direccion)
        {
            case "l":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "r":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                button.setHorizontalTextPosition(SwingConstants.LEFT);
                break;
            case "t":
                button.setVerticalTextPosition(SwingConstants.TOP);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            case "b":
                button.setVerticalTextPosition(SwingConstants.BOTTOM);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            default:
                break;
        }
        return button;
    }

    public JLabel construirJLabel(
            String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen,
            Font fuente, Color colorFondo, Color colorFuente, Border borde, String direccion
    ) {
        label = new JLabel(texto);
        label.setLocation(x, y);
        label.setSize(ancho, alto);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        label.setCursor(cursor);
        label.setIcon(imagen);
        label.setBorder(borde);
        if (colorFondo != null)
        {
            label.setOpaque(true);
            label.setBackground(colorFondo);
        }
        switch (direccion)
        {
            case "c":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "r":
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                label.setHorizontalTextPosition(SwingConstants.LEFT);
                break;
            case "t":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalTextPosition(SwingConstants.TOP);
                label.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            case "b":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalTextPosition(SwingConstants.BOTTOM);
                label.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            default:
                break;
        }
        return label;
    }

    public JTextField construirJTextField(
            String texto, int x, int y, int ancho, int alto, Font fuente, Color colorFondo,
            Color colorFuente, Color colorCaret, Border borde, String direccion
    ) {
        textField = new JTextField();
        textField.setLocation(x, y);
        textField.setSize(ancho, alto);
        textField.setText(texto);
        textField.setForeground(colorFuente);
        textField.setBackground(colorFondo);
        textField.setCaretColor(colorCaret);
        textField.setFont(fuente);
        textField.setBorder(borde);
        switch (direccion)
        {
            case "c":
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "r":
                textField.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                break;
        }
        return textField;
    }

    public JScrollPane construirPanelBarra(Component componente, int x, int y, int ancho, int alto, Color colorFondo, Border borde) {
        panelScroll = new JScrollPane(componente);
        panelScroll.setLocation(x, y);
        panelScroll.setSize(ancho, alto);
        panelScroll.getViewport().setBackground(colorFondo);
        panelScroll.setBorder(borde);
        return panelScroll;
    }
}
