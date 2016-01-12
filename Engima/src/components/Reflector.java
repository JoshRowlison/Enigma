package components;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Reflector extends AlphabetMapping{
	
	public static final ArrayList<Character> MIRROR_ALPHABET = new ArrayList<Character>(Arrays.asList('N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'));
	public static final ArrayList<Character>           GAMMA = new ArrayList<Character>(Arrays.asList('F','S','O','K','A','N','U','E','R','H','M','B','T','I','Y','C','W','L','Q','P','Z','X','V','G','J','D'));
	
	//Creates a reflector with the supplied cross-wiring
	public Reflector(ArrayList<Character> sequence){
		super(sequence);
	}
	
	//creates a reflector with a simple mirroring about M and N that maps A-Z and so on.
	public Reflector(){
		this(GAMMA);
	}

	
	

}
