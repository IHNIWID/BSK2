
public class Zad4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter = 'A';
		char alphabet[] = new char[26];
		char alphabetwithout[] = new char[26];
		String ciphers = "TOMCZUK";
		String plaintext = "CRYPTOGRAPHY";
		char cipher[] = new char[ciphers.length()];
		char coded[] = new char[26];
		char decoded[] = new char[26];
		char cryptogram[] = new char[26];

		for (int i = 0; i < 26; i++) {
			alphabet[i] = (char) (letter + i);
			alphabetwithout[i] = (char) (letter + i);
			// System.out.println(alphabet[i]);
		}

		for (int i = 0; i < ciphers.length(); i++) {
			
				cipher[i] = ciphers.charAt(i);
			
			
			// wpisanie wyrazu do szyfrogramu
			// System.out.println(cipher[i]);
		}
		// uwazac jesli litery w szyfrze sie powtarzaja
		// wpisanie szyfru
		for (int i = 0; i < 26; i++) {
			if (i < ciphers.length()) {
				cryptogram[i] = cipher[i];
			}
		}
		// sprawdzenie ktore znaki znajduja sie szyrogramie i zastapienie ich
		// zerem
		for (int i = 0; i < ciphers.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (cipher[i] == alphabetwithout[j]) {
					alphabetwithout[j] = 0;
				}
			}
		}
		// wpisanie reszty znakow z alfabetu do szyfrogramu
		int counter = ciphers.length();

		for (int i = 25; i >=0; i--) {
			if (alphabetwithout[i] != 0) {
				cryptogram[counter] = alphabetwithout[i];
				counter++;
			}
		}

		// check
		for (int i = 0; i < 26; i++) {
			System.out.println(cryptogram[i]);
		}
		// wpisanie reszty alfabetu do szyfrogramu
		coded = Code(alphabet, cryptogram, plaintext);
		System.out.println("LALALALA");
		for (int i = 0; i < plaintext.length(); i++) {
			System.out.println(coded[i]);
		}
		decoded = Decode(alphabet, cryptogram, coded);
		System.out.println("LALALALA222");
		for (int i = 0; i < plaintext.length(); i++) {
			System.out.println(decoded[i]);
		}
	}

	private static char[] Code(char alphabet[], char cryptogram[], String plaintext) {
		char coded[] = new char[26];
		char text[] = new char[plaintext.length()];

		for (int i = 0; i < plaintext.length(); i++) {
			text[i] = plaintext.charAt(i);
		}
		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < 26; j++) {
				if (text[i] == alphabet[j]) {
					coded[i] = cryptogram[j];
				}
			}
		}
		return coded;
		// TODO Auto-generated method stub

	}

	private static char[] Decode(char alphabet[], char cryptogram[], char coded[]) {
		char decoded[] = new char[26];

		for (int i = 0; i < coded.length; i++) {
			for (int j = 0; j < 26; j++) {
				if (coded[i] == cryptogram[j]) {
					decoded[i] = alphabet[j];
				}
			}
		}

		return decoded;
	}

}
