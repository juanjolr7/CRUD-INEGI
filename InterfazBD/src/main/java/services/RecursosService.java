package services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author juanj
 */
public class RecursosService {

    private Color colorCatalogo, colorPrincipalOscuro, colorPrincipal, colorGrisClaro, colorGrisOscuro;
    private Border bInferiorGris, bAzul;
    private Cursor cMano;
    private Font fontMediana, fontTitulo, fontLigera, fontPanel;

    static private RecursosService servicio;

    public RecursosService() {
        crearColores();
        crearCursores();
        crearFuentes();
        crearBordes();
    }

    public static RecursosService getService() {
        if (servicio == null)
        {
            servicio = new RecursosService();
        }
        return servicio;
    }

    public void crearColores() {
        colorCatalogo = new Color(39, 54, 77);
        colorPrincipalOscuro = new Color(30, 48, 90);
        colorPrincipal = new Color(60, 78, 120);
        colorGrisClaro = new Color(247, 247, 247);
        colorGrisOscuro = new Color(80, 80, 80);
    }

    private void crearFuentes() {
        //fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        //fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
        fontMediana = new Font("LuzSans-Book", Font.PLAIN, 20);
        fontLigera = new Font("LuzSans-Book", Font.PLAIN, 12);
        fontPanel = new Font("Calibri (Cuerpo)", Font.BOLD, 30);
    }

    private void crearCursores() {
        cMano = new Cursor(Cursor.HAND_CURSOR);
    }

    public void crearBordes() {
        bInferiorGris = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
        bAzul = BorderFactory.createLineBorder(colorPrincipal, 2, true);
    }

    public Color getColorCatalogo() {
        return this.colorCatalogo;
    }

    public Cursor getCMano() {
        return cMano;
    }

    public Font getFontMediana() {
        return fontMediana;
    }

    public Font getFontTitulo() {
        return fontTitulo;
    }

    public Font getFontLigera() {
        return fontLigera;
    }

    public Font getFontPanel() {
        return fontPanel;
    }

    public Color getColorPrincipalOscuro() {
        return colorPrincipalOscuro;
    }

    public Border getBInferiorGris() {
        return bInferiorGris;
    }

    public Border getBAzul() {
        return bAzul;
    }

    public Color getColorGrisClaro() {
        return colorGrisClaro;
    }

    public Color getColorGrisOscuro() {
        return colorGrisOscuro;
    }
    
    public Color getColorPrincipal() {
        return colorPrincipal;
    }
}
