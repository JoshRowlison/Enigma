package components;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class RotorRackTableModel extends AbstractTableModel {
	
	private String[] columns = {"Slot 1", "Slot 2", "Slot 3"};
	private ArrayList<Rotor> rotorRack;
	
	
	public RotorRackTableModel(){
		clear();
	}
	
	public void clear(){
		rotorRack = new ArrayList<Rotor>();
		rotorRack.add(RotorBox.EMPTY);
		rotorRack.add(RotorBox.EMPTY);
		rotorRack.add(RotorBox.EMPTY);
		this.fireTableDataChanged();
	}
	
	public boolean add(Rotor t){
		boolean didWork = false;
		if(rotorRack.get(0).equals(RotorBox.EMPTY)){
			rotorRack.set(0, t);
			didWork=true;
		} else if(rotorRack.get(1).equals(RotorBox.EMPTY)){
			rotorRack.set(1, t);
			didWork=true;
		} else if(rotorRack.get(2).equals(RotorBox.EMPTY)){
			rotorRack.set(2, t);
			didWork=true;
		} 
		this.fireTableDataChanged();
		return didWork;
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return rotorRack.get(arg1);
	}
	
	public Rotor getRotor(int index){
		return rotorRack.get(index);
	}
	
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}
	


}
