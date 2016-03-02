package ContactList;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProfessionalTableModel extends AbstractTableModel{

	String ColumnName[] = { "Name","Mobile No.","Email Address","Common Interest"};
	
	private List<ProfessionalFriend> thefriendlist;
	
	ProfessionalTableModel(List<ProfessionalFriend> list){
		thefriendlist = list;
	}
	
	@Override
	public int getColumnCount() {
		return ColumnName.length;
	}

	@Override
	public int getRowCount() {
		return thefriendlist.size();
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return getValueAt(0,columnIndex).getClass();
	}

	@Override
	public String getColumnName(int column) {
		return ColumnName[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int col) {
		ProfessionalFriend tempfriend = thefriendlist.get(row);
		switch(col){
		case 0:
			return tempfriend.getName();
		case 1:
			return tempfriend.getMobNumber();
		case 2:
			return tempfriend.getEmailaddress();
		case 3:
			return tempfriend.getCommonInterest();
		default:
			return tempfriend;
		}
	}

}
