package components;

import java.util.ArrayList;
import java.util.Iterator;

public class EnigmaMachine {
 
	private ArrayList<Rotor> rotorArray;
	private Reflector reverser;
	private PlugBoard plugs;
	
	public EnigmaMachine(){
	rotorArray = new ArrayList<Rotor>();
	}
	
	public EnigmaMachine(Rotor slot1Rotor, Rotor slot2Rotor, Rotor slot3Rotor, Reflector reflector, PlugBoard plugBoard) {
		rotorArray.add(slot1Rotor);
		rotorArray.add(slot2Rotor);
		rotorArray.add(slot3Rotor);
		reverser=reflector;
		plugs=plugBoard;
	}
	
	public void addRotor(Rotor r){
	rotorArray.add(r);
	}
	
	public void clearRotors(){
		rotorArray=new ArrayList<Rotor>();
	}
	
	public void setPlugBoard(PlugBoard p){
		plugs=p;
	}
	
	public void setReflector(Reflector r){
		reverser=r;
	}
	
	public Rotor getRotor(int index){
		return rotorArray.get(index);
	}  


	public Character encypher(Character input){
		Character output = plugs.get(input);
		System.out.println(input);
		System.out.println(output);
		for(int i=0; i<rotorArray.size(); i++) {
			output=rotorArray.get(i).getForward(output);
			System.out.println(rotorArray.get(i).getName()+" : "+output+" A="+rotorArray.get(i).getForward('A'));
		}
		
		output=reverser.get(output);
		System.out.println("Reflect:"+output);
		
		for(int k=rotorArray.size()-1; k >= 0;k--) {
			output=rotorArray.get(k).getBackward(output);
			System.out.println(rotorArray.get(k).getName()+" : "+output+" A="+rotorArray.get(k).getForward('A'));
		}
		
		output=plugs.get(output);
		indexRotors();
		System.out.println(output);
		return output;
	}

	private void indexRotors(){
		boolean indexSubsequent = rotorArray.get(0).getForward('A').equals(rotorArray.get(0).getNotch());
		rotorArray.get(0).indexRotor(1);
		
		for(int i=1;i<rotorArray.size();i++){
			Rotor currRotor = rotorArray.get(i);
			if(indexSubsequent){
				indexSubsequent = currRotor.getForward('A').equals(currRotor.getNotch());
				currRotor.indexRotor(1);
			}
		}
	}
}
