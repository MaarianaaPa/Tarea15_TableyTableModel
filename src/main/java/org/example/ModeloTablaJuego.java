package org.example;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class ModeloTablaJuego implements TableModel {
    public static final int COLS = 6;
    ArrayList<Videojuego> datos;

    public ModeloTablaJuego(ArrayList<Videojuego> datos) {
        //datos iniciales a mostrar
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        // Informacion que muestra la tabla, en el arraylist
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        //regresamos con una constantE
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        //titulo de cada columna
        String columnName = "";
        switch (columnIndex) {
            case 0:
                columnName = "Id: ";
                break;
            case 1:
                columnName = "Nombre: ";
                break;
            case 2:
                columnName = "Genero: ";
                break;
            case 3:
                columnName = "Peso en GB: ";
                break;
            case 4:
                columnName = "Plataforma: ";
                break;
            case 5:
                columnName = "Desarrollador: ";
                break;
        }
        return columnName;
        // segun indice indica que poner arriba en la tabla
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // tipo de clase
        // como estamos indicando la resp del metdodo no es necesario poner un break
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        // si no es ninguno no sabemos, aunq no deberia llegar a esta linea
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // si es editable
        // se queda false pq no
        return false;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Videojuego tmp = datos.get(rowIndex); // obtenemos columnas
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getGenero();
            case 3:
                return tmp.getPesoEnGb();
            case 4:
                return tmp.getPlataforma();
            case 5:
                return tmp.getDesarrollador();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void agregarJuego(Videojuego juego){
        this.datos.add(juego);
    }
}
