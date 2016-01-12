package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class Rotor{
	public static final ArrayList<Character> STANDARD_ALPHABET = new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
	
	private HashMap<Character,Character> rotorMapping;
	private HashMap<Character,Character> rotorMappingInverse;
	Character notch = 'Z';
	

	Character ringSetting = 'A';
	String name;
	Character top = 'A';

	public Rotor(List<Character> sequence, Character ringSetting, Character notchCharacter, String nom) {
		
		mapSequence(sequence);
		setRingSetting(ringSetting);
		notch = notchCharacter;
		name=nom;
	} 


	
	public void mapSequence(List<Character> sequence){
		rotorMapping = new HashMap<Character, Character>();
		int key=0;
			for(Character current: sequence){
				rotorMapping.put(STANDARD_ALPHABET.get(key), current);
				key++;
			}
			populateInverse();
	}
	
	public void setRingSetting(Character setting){
		
		int ringSettingPos = STANDARD_ALPHABET.indexOf(ringSetting);
		int settingPos = STANDARD_ALPHABET.indexOf(setting);
		
		while(ringSettingPos!=settingPos){
			indexRotor();
			ringSettingPos = (ringSettingPos + 1)%26;
		}
		ringSetting=setting;
		
	}
	
	public Character getRingSetting(){
		return ringSetting;	
	}
	
	public Character getNotch(){
		return notch;
	}
	
	public void setNotch(Character n){
		notch=n;
	}
	
	public void indexRotor(int setting){
		for(int i=0; i<setting; i++){
			indexRotor();
		}
	}
	
	public void  stepRotor(){
		indexRotor();
		top = STANDARD_ALPHABET.get((STANDARD_ALPHABET.indexOf(top) + 1 ) % 26);
	}
	
	// Indexes the given sequence of letters by 1
	// end to the beginning on overlaps
	private void indexRotor() {
		Iterator<Character> sequenceIterator = rotorMapping.values().iterator();
		ArrayList<Character> newSequence = new ArrayList<Character>();

		Character firstPart =STANDARD_ALPHABET.get((STANDARD_ALPHABET.indexOf(sequenceIterator.next()) + 1 ) % 26);
		
		while (sequenceIterator.hasNext()) {
			newSequence.add(STANDARD_ALPHABET.get((STANDARD_ALPHABET.indexOf(sequenceIterator.next()) + 1 ) % 26));
		}
		newSequence.add(firstPart);
		
		mapSequence(newSequence);

	}

	public Character getForward(Character input) {
	 
			return rotorMapping.get(input);
	}
	
	public Character getBackward(Character input){
		return rotorMappingInverse.get(input);
	}
	
	public String toString(){
		return name;
	}
	 
	public int getTop(){
		return top;	
	} 
	public int size(){
		return rotorMapping.size();
	}
	
	public String getName(){
		return name;
	}
	
	public Collection<Character> outputs(){
		return rotorMapping.values();
	}
	
	public Collection<Character>inputs(){
		return rotorMapping.keySet();
	}
	
	public Rotor getCopy(){
		return new Rotor(new ArrayList<Character>(rotorMapping.values()),getRingSetting(),getNotch(),getName());
	}
	
	private void populateInverse(){
		rotorMappingInverse=new HashMap<Character,Character>();
		for(Character key: rotorMapping.keySet()){
			rotorMappingInverse.put(rotorMapping.get(key), key);
		}
	}
	
}