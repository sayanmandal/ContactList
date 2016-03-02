package ContactList;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PersonalFriendTableModel extends AbstractTableModel{
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	String ColumnName[] = {"Name","Mobile No.","Email Address","Context","Date Of Meeting","Special Events"};
	
	private List<PersonalFriend> thefriendlist;
	
	PersonalFriendTableModel(List<PersonalFriend> friendlist){
		thefriendlist = friendlist;
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
	public Object getValueAt(int row, int col) {
		PersonalFriend thefriend = thefriendlist.get(row);
		switch(col){
		case 0:
			return thefriend.getName();
		case 1:
			return thefriend.getMobNumber();
		case 2:
			return thefriend.getEmailaddress();
		case 3:
			return thefriend.getContext();
		case 4:
			return thefriend.getDateofmeeting();
		case 5:
			return thefriend.getSpecialevents();
		default:
			return thefriend;
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
	
	

}
