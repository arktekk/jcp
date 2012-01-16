package student.innerclasses;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

// This class displays a Swing frame, containing a JTable (i.e. a data grid).
public class TableSortDemo extends JPanel {

    public static void main(String[] args) {

        // Create an instance of our class, which is a custom panel.
        TableSortDemo pane = new TableSortDemo();

    	// Create and set up the top-level frame window.
        JFrame frame = new JFrame("Extreme Sports 'R' Us");
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
    public TableSortDemo() {
        super(new GridLayout(1,0));

        // Set the table's model (plus UI properties).
        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        // Create a scroll pane, and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to this panel.
        add(scrollPane);
    }
}


// Custom model class, specifies the data (and data types) in the table's underlying model.
// TODO: Define this as an inner/nested class within TableSortDemo - you decide which mechanism to use.
class MyTableModel extends AbstractTableModel {
    
	private final String[] columnNames = {"First Name", "Last Name", "Sport", "# of Years", "Expert"};
    
	private Object[][] data = {
        {"Mary", "Sorensen", "Snowboarding", 5,  false},
        {"John", "Flagen",   "Skiing",       3,  true},
        {"Sara", "Walrath",  "Bobsleigh",    2,  false},
        {"Rune", "Petersen", "Water skiing", 20, true},
        {"Carl", "Smith",    "Ski jumping",  12, true}
    };

	// Tells the JTable how many columns to display. 
    public int getColumnCount() {
        return columnNames.length;
    }

	// Tells the JTable how many rows to display. 
    public int getRowCount() {
        return data.length;
    }

	// Tells the JTable what column names to display. 
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Tells the JTable what data to display in a particular cell.
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    // Helps the JTable determine the default renderer/editor for each cell.  
    // If we didn't implement this method, the last column would contain text ("true"/"false"),
    // rather than a check box.
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    // Tells the JTable which cells are editable.
    public boolean isCellEditable(int row, int col) {
        return (col >= 2);
    }

    // Enables the JTable to set the value for an (editable) cell.
    public void setValueAt(Object value, int row, int col) {
    	System.out.printf("Cell [%d][%d] old value: %s, new value: %s\n", row, col, data[row][col], value);
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
