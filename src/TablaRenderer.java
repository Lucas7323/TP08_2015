import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaRenderer{
	DefaultTableCellRenderer renderer; 
	
	 public TableCellRenderer tablaRendererHeader(JTable table) {
		  
	        renderer = (DefaultTableCellRenderer)
	        table.getTableHeader().getDefaultRenderer();
	        renderer.setHorizontalAlignment(JLabel.CENTER);
	        table.getTableHeader().setFont(new Font("Italic",Font.BOLD,17));//font del header
	        return renderer;
	 }

	///formateo la tabla con esto
	
}
