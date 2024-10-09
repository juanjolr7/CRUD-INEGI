package prueba;

import com.objects.Entidad;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author juanj
 */
public class ModeloTablaPrueba extends JFrame {

    public static void main(String[] args) {
        List<Entidad> entidades = new ArrayList<>();

        for (int i = 0; i < 100; i++)
        {
            entidades.add(new Entidad(i, "Entidad: " + i));
        }

        String[] columnNames =
        {
            "Id", "Valor"
        };

        ModelEntidad model = new ModelEntidad();
        model.setColumnIdentifiers(columnNames);
        model.agregarData(entidades);
        JTable table = new JTable(model);

        JButton prevButton = new JButton("Anterior");
        JButton nextButton = new JButton("Siguiente");

//        prevButton.addActionListener(e -> model.previousPage());
//        nextButton.addActionListener(e -> model.nextPage());
        prevButton.addActionListener(e ->
        {
            model.previousPage();
            nextButton.setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        });

        nextButton.addActionListener(e ->
        {
            model.nextPage();
            if ((model.getCurrentPage() + 1) * model.getPAGE_SIZE() >= entidades.size())
            {
                nextButton.setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
