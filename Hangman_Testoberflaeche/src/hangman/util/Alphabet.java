package hangman.util;


public class Alphabet {

	public static char [] alphabet =  {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	public static char getLetter(int z) {

		return alphabet[z];

	}


	public static int getNummber(char x) {

		int z=0;

		for (int i = 0; i < 26; i++) {

			if(alphabet[i]==x) {
				z=i;
			}
		}

		return z;

	}

}