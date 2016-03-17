
public class Zad2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter = 'A';
		String keys = "BREAK";
		char key[] = new char[keys.length()];
		String word = "CRYPTOGRAPHY";
		char coded[] = new char[word.length()];
		char decoded[] = new char[word.length()];
		char longkey[] = new char[word.length()];
		char text[] = new char[word.length()];
		char alphabet[] = new char[26];
		char alphabets[][] = new char[26][26];
		int counter = 0;
		int temp = 0;
		int witch = 0;
		// alfabet
		for (int i = 0; i < 26; i++) {
			alphabet[i] = (char) (letter + i);
		}
		// tablica vigenera
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (j + counter >= 26) {
					witch = 0 + temp;
					temp++;
					alphabets[i][j] = (char) (alphabet[witch]);
				} else {
					witch = j;
					alphabets[i][j] = (char) (alphabet[witch] + counter);
				}

			}
			counter++;
			temp = 0;
		}
		// check
		for (int i = 0; i < 26; i++) {
			for (int i1 = 0; i1 < 26; i1++) {
				System.out.print(alphabets[i][i1]);
			}
			System.out.println();
		}
		// string to char
		for (int i = 0; i < keys.length(); i++) {
			key[i] = keys.charAt(i);
		}
		for (int i = 0; i < word.length(); i++) {
			text[i] = word.charAt(i);
		}
		// dostowanie klucza do dlugosci szyfrowanego slowa
		for (int i = 0; i < text.length; i++) {
			longkey[i] = key[i % key.length];
			// System.out.println(longkey[i]);
		}

		// System.out.println(letter+1+"AAAAAAAAAAAA");
		coded = Code(alphabets, text, longkey);
		// check
		for (int i = 0; i < text.length; i++) {
			System.out.print(coded[i]);
		}
		decoded = Decode(alphabets, coded, longkey);
		System.out.println();
		for (int i = 0; i < text.length; i++) {
			System.out.print(decoded[i]);
		}
	}

	private static char[] Code(char alphabets[][], char text[], char[] longkey) {

		char[] coded = new char[text.length];

		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < 26; k++) {
					if (alphabets[0][j] == text[i] && alphabets[k][0] == longkey[i]) {
						coded[i] = alphabets[k][j];
					}
				}
			}
		}

		return coded;

		// TODO Auto-generated method stub

	}

	private static char[] Decode(char alphabets[][], char coded[], char[] longkey) {
		char[] decoded = new char[coded.length];

		for (int i = 0; i < coded.length; i++) {
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < 26; k++) {
					if (alphabets[0][j] == longkey[i] && alphabets[k][j] == coded[i]) {
						decoded[i] = alphabets[0][k];
					}
				}
			}
		}
		return decoded;
	}
}
