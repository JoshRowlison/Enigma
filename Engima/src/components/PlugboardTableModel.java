package components;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class PlugboardTableModel extends AbstractTableModel {
	private HashMap<Character,Character> plugPairs;
	private String[] columns = {"Inputs","Outputs"};
			
	public PlugboardTableModel(){
		clear();
	}
	
	public void clear(){
		plugPairs= new HashMap<Character,Character>();

		this.fireTableDataChanged();
	}
	
	public void addPair(Character input, Character output){
		plugPairs.put(input, output);
		this.fireTableDataChanged();
	}
	
		
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return plugPairs.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}

	public HashMap<Character,Character> getMap(){
		return plugPairs;
	}
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg1 == 1){
			return plugPairs.values().toArray()[arg0];
		} else if(arg1 == 0 ){
			return plugPairs.keySet().toArray()[arg0];
		}

		return null;
	}
}
