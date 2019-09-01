/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennisclubnetbeans;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Szymon
 */
public class TableModel extends AbstractTableModel{
    
    List<List<String>> list;
    List<String> columnNames;
    
    public TableModel(List<List<String>> list, List<String> columns){
        this.list = list;
        this.columnNames = columns;
    }
    


    
    @Override
    public int getRowCount(){
        return this.list.size();
    }
    @Override
    public int getColumnCount() {
        return this.list.get(0).size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        return this.list.get(row).get(column);
    }
    @Override
    public String getColumnName(int col){
       return columnNames.get(col);
    }
    
    
}
