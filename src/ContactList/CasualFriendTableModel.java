package ContactList;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CasualFriendTableModel extends AbstractTableModel{

	String ColumnName[] = {"Name","Mobile NO.","Email Address","Time Of Meeting","Place Of Meeting","Circumstance Of Meeting"};
	private List<CasualFriend> thelist;
	
	CasualFriendTableModel(List<CasualFriend> list){
		thelist = list;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getColumnCount() {
		return ColumnName.length;
	}

	@Override
	public int getRowCount() {
		return thelist.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		CasualFriend tempfriend = thelist.get(row);
		switch(col){
		case 0:
			return tempfriend.getName();
		case 1:
			return tempfriend.getMobNumber();
		case 2:
			return tempfriend.getEmailaddress();
		case 3:
			return tempfriend.getTimeofmeeting();
		case 4:
			return tempfriend.getPlaceofmeeting();
		case 5:
			return tempfriend.getCircumstanceofmeeting();
		default:
			return tempfriend;
		}
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return getValueAt(0,columnIndex).getClass();
	}

	@Override
	public String getColumnName(int column) {
		return ColumnName[column];
	}

}
