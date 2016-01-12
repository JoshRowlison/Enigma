package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings("serial")
public class PlugBoard extends AlphabetMapping {

	public PlugBoard(){
		super(STANDARD_ALPHABET);
	}
	public PlugBoard(ArrayList<Character> sequence) {
		super(sequence);
	}

	public PlugBoard(HashMap<Character,Character> plugs){
		super(STANDARD_ALPHABET);
		ArrayList<Character> sequence = new ArrayList<Character>(STANDARD_ALPHABET);
		Iterator<Character> plugKeyIterator = plugs.keySet().iterator();
		
		while(plugKeyIterator.hasNext()){
		Character key = plugKeyIterator.next();
		Character value = plugs.get(key);
		
		sequence.set(sequence.indexOf(key) , value);
		sequence.set(sequence.indexOf(value) , key);
		}
		mapSequence(sequence);
	}
}
