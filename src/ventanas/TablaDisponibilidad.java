package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TablaDisponibilidad extends JPanel{

    public static void main(String[] args) {
        //new TablaDisponibilidad();
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //frame.setMaximumSize(new java.awt.Dimension(250,350));
        frame.setMinimumSize(new java.awt.Dimension(250,350));
        JPanel panel= new JPanel();
        panel.add(new TablaDisponibilidad());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    DefaultTableModel model = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column){
                        return false;
                    }
    };
    
    JTable table;
    
    
    public TablaDisponibilidad() {
        
        model.addColumn("Lugar");
        model.addColumn("Cant. ocupada");
        
        
        table = new JTable(model);
        DeleteRowFromTableAction deleteAction = new DeleteRowFromTableAction(table, model);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(170);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        JToolBar tb = new JToolBar();
        tb.add(deleteAction);
        tb.setFloatable(false);
        
        InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = table.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "deleteRow");
        am.put("deleteRow", deleteAction);
        
        
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(new JScrollPane(table));
        setPreferredSize(new java.awt.Dimension(290,250));
        setMinimumSize(new java.awt.Dimension(290,250));
        setVisible(true);
        
        
        
    }

    public abstract class AbstractTableAction<T extends JTable, M extends TableModel> extends AbstractAction {

        private T table;
        private M model;

        public AbstractTableAction(T table, M model) {
            this.table = table;
            this.model = model;
        }

        public T getTable() {
            return table;
        }

        public M getModel() {
            return model;
        }

    }

    public class DeleteRowFromTableAction extends AbstractTableAction<JTable, DefaultTableModel> {

        public DeleteRowFromTableAction(JTable table, DefaultTableModel model) {
            super(table, model);
            putValue(NAME, "Eliminar filas");
            putValue(SHORT_DESCRIPTION, "Eliminar filas");
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    setEnabled(getTable().getSelectedRowCount() > 0);
                }
            });
            setEnabled(getTable().getSelectedRowCount() > 0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JTable table = getTable();
            if (table.getSelectedRowCount() > 0) {
                List<Vector> selectedRows = new ArrayList<>(25);
                DefaultTableModel model = getModel();
                Vector rowData = model.getDataVector();
                for (int row : table.getSelectedRows()) {
                    int modelRow = table.convertRowIndexToModel(row);
                    Vector rowValue = (Vector) rowData.get(modelRow);
                    selectedRows.add(rowValue);
                }

                for (Vector rowValue : selectedRows) {
                    int rowIndex = rowData.indexOf(rowValue);
                    model.removeRow(rowIndex);
                }
            }
        }

    }

    public void addFila(String lugar, int cantidad){
        if(lugarYaIngresado(lugar, cantidad)){
            
        }
        else{
            Vector<String> fila = new Vector<>(2);
            fila.add(lugar);
            fila.add(String.valueOf(cantidad));
            model.addRow(fila);
            table.revalidate();
        }
    }
    
    public boolean lugarYaIngresado(String lugar, int cant){
        // Recorrer tabla
        // Si encuentra un lugar igual, lo suma
        int filas= model.getRowCount();
        for(int i=0; i<filas; i++) {
            if(lugar.equals((String)model.getValueAt(i, 0))){
                int aux=Integer.valueOf((String)model.getValueAt(i, 1))+cant;
                
                model.setValueAt(Integer.toString(aux), i, 1);
                return true;
            }
        }
        return false;
    }
    
    public void verificarLugares(String[] lugares){
        
        // recorrer la tabla, si algun elemento no esta en la lista de lugares, eliminarlo
        for(int i=0; i<model.getRowCount(); i++) {
            // Se elimina si el lugar de la tabla NO esta en la lista actual
            if(!Arrays.asList(lugares).contains((String)model.getValueAt(i, 0))){
                model.removeRow(i);
            }
        }
        
    }
    
    public String[][] getContenido(){
        String[][] nuevo;
        
        //model;
        int cols = model.getColumnCount();
        int fils = model.getRowCount();
        nuevo= new String[fils][cols];
        for(int i=0; i<fils; i++) {
            for(int j=0; j<cols; j++) 
                nuevo[i][j]=(String)model.getValueAt(i,j); 
        }
        
        return nuevo;
    }
    
    public boolean tieneDisponibilidades(){
        return(0<model.getRowCount());
    }
}
