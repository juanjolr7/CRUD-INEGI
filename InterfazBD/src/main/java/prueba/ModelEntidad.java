package prueba;

import com.objects.Entidad;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author juanj
 */
public class ModelEntidad extends AbstractTableModel {

    private static final int PAGE_SIZE = 10;
    private List<Entidad> entidades;
    private String[] columnNames;
    private int currentPage;

    public ModelEntidad() {
        this.currentPage = 0;
    }

    public void setColumnIdentifiers(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void agregarData(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    public void nextPage() {
        currentPage++;
        if (currentPage * PAGE_SIZE >= entidades.size())
        {
            currentPage--;
        }
        fireTableDataChanged();
    }

    public void previousPage() {
        currentPage--;
        if (currentPage < 0)
        {
            currentPage = 0;
        }
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int start = currentPage * PAGE_SIZE;
        return Math.min(entidades.size() - start, PAGE_SIZE);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int actualIndex = (currentPage * PAGE_SIZE) + rowIndex;
        if (actualIndex < entidades.size())
        {
            Entidad entity = entidades.get(actualIndex);
            switch (columnIndex)
            {
                case 0:
                    return entity.getIdentidad();
                case 1:
                    return entity.getNom_entidad();
                default:
                    return ""; // En caso de tener más columnas, manejar aquí
            }
        }
        return null;
    }

    public void limpiarDatos() {
        if (entidades != null)
        {
            entidades.clear();
            fireTableDataChanged();
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public static int getPAGE_SIZE() {
        return PAGE_SIZE;
    }

}
