package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashBiMap;

@SuppressWarnings("serial")
public class AlphabetMapping{
	HashMap<Character,Character> primaryMap;

	
	public static final ArrayList<Character> STANDARD_ALPHABET = new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
	
	//calls makeAlphabetMapping with a sequence to map
	public AlphabetMapping(ArrayList<Character> sequence)  {
		primaryMap=new HashMap<Character,Character>();
		
		mapSequence(sequence);
	
	}

	protected void mapSequence(ArrayList<Character> sequence){
		primaryMap.clear();
		if(sequence.size() < 26){
			throw new RuntimeException("Sequence length too short");
		}
		
		Iterator<Character> standardIt = STANDARD_ALPHABET.iterator();
		Iterator<Character> sequenceIt = sequence.iterator();
		
		Character standardLetter;
		Character sequenceLetter;
		
		while(standardIt.hasNext()){
			standardLetter = standardIt.next();
			sequenceLetter = sequenceIt.next();
			primaryMap.put(standardLetter,  sequenceLetter); 
			
		}
	}
	
	public Character get(Character x){
		return primaryMap.get(x);
	}
	

	
	public Collection<Character> values(){
		return primaryMap.values();
	}
	
	public int size(){
		return primaryMap.size();
	}
	
	public Set<Character> keySet(){
		return primaryMap.keySet();
	}
}
