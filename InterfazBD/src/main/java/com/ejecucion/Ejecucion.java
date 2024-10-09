package com.ejecucion;

import com.interfazBD.InterfazCatalogoComponent;
import javax.swing.SwingUtilities;

/**
 *
 * @author juanj
 */
public class Ejecucion {
    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            public void run() {
                InterfazCatalogoComponent vista = new InterfazCatalogoComponent();
                vista.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }
}
