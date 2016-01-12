package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotorBox {
	private static List<Character> rotor1Arr = Arrays.asList('Q','Y','E','J','F','G','X','P','K','C','T','W','I','H','L','S','U','D','Z','A','O','V','B','R','M','N');
	private static List<Character> rotor2Arr = Arrays.asList('K','T','C','V','J','L','N','F','Z','U','R','B','Q','W','G','H','M','E','I','O','P','D','A','X','Y','S');
	private static List<Character> rotor3Arr = Arrays.asList('C','M','F','O','G','S','J','X','L','Q','Z','K','W','B','V','U','A','N','I','H','Y','R','T','P','D','E');
	private static List<Character> rotor4Arr =Arrays.asList('I','T','E','S','V','O','R','D','H','A','U','B','C','F','J','Y','P','G','Q','K','L','N','W','Z','X','M');
	private static List<Character> rotor5Arr = Arrays.asList('V','P','A','Z','B','Q','N','C','T','U','W','K','J','Y','R','X','D','F','M','E','I','L','H','O','S','G');
	
	public static final Rotor Rotor1= (new Rotor(rotor1Arr,'A','A', "Rotor 1"));
	public static final Rotor Rotor2= (new Rotor(rotor2Arr,'A','A', "Rotor 2"));
	public static final Rotor Rotor3= (new Rotor(rotor3Arr,'A','A', "Rotor 3"));
	public static final Rotor Rotor4= (new Rotor(rotor4Arr,'A','A', "Rotor 4"));
	public static final Rotor Rotor5= (new Rotor(rotor5Arr,'A','A', "Rotor 5"));
	public static final Rotor EMPTY   = (new Rotor(AlphabetMapping.STANDARD_ALPHABET, 'A','A' ,"Empty"));
	
	
}
