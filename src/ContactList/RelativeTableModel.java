package ContactList;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RelativeTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String ColumnName[] = {"Name","Mobile No.","Email Address","Birthday","Date of Last Meeting"};
	
	List<Relative> relativelist = null;
	
	RelativeTableModel(List<Relative> list){
		relativelist = list;
	}
	@Override
	public int getColumnCount() {
		return ColumnName.length;
	}

	@Override
	public int getRowCount() {
		return relativelist.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Relative therelative = relativelist.get(row);
		switch(column){
		case 0:
			return therelative.getName();
		case 1:
			return therelative.getMobNumber();
		case 2:
			return therelative.getEmailaddress();
		case 3:
			return therelative.getBirthday();
		case 4:
			return therelative.getDateoflastmeeting();
		case 5:
			return therelative;
		default:
			return therelative;
		}
	}
	@Override
	public Class getColumnClass(int col) {
		return getValueAt(0,col).getClass();
	}
	@Override
	public String getColumnName(int col) {
		return ColumnName[col];
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}
