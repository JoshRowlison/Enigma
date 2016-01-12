package components;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class RotorTableModel extends AbstractTableModel {

	private Rotor rotorData;
	private String[] columns = {"Inputs","Outputs"};
			
	public RotorTableModel(){
		
	}
	
	public RotorTableModel(Rotor t){
		rotorData=t;
	}
	
	
	public void switchRotor(Rotor t){
		rotorData=t;
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
		return rotorData.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg1 == 1){
			return rotorData.outputs().toArray()[arg0];
		} else if(arg1 == 0 ){
			return rotorData.inputs().toArray()[arg0];
		}

		return null;
	}
	
	public Rotor getRotor(){
		return rotorData;
	}

	public void changeTop(){
		
	}
}
