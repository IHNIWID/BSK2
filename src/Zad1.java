
public class Zad1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter = 'A';
		char alphabet [] = new char [26];
		String ciphers= "SZYFEREK";
		char cipher[]=new char [ciphers.length()];
		char code[]=new char[ciphers.length()];
		
		for(int i=0; i<26;i++){
			alphabet[i]=(char) (letter+i);
			System.out.println(alphabet[i]);
		}
		
		for(int i=0;i<ciphers.length();i++){			
			cipher[i]=ciphers.charAt(i);
			System.out.println(cipher[i]);
		}
		//uwazac jesli litery w szyfrze sie powtarzaja
		
	}

}
