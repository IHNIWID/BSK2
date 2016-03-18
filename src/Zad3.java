
public class Zad3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "KUBAJKBTR";
		String text = "CRYPTOGRAPHY";
		char letter = 'A';
		char alphabet[] = new char[26];
		
		char table[][] = new char[5][5];

		// sprawdzenie parzystosci
		if (key.length() % 2 == 1) {
			key += 'X';
		}
		char rawkey[] = new char[key.length()];
		// uzupelnienie tablicy z kluczem
		for (int i = 0; i < key.length(); i++) {

			rawkey[i] = key.charAt(i);
			System.out.println(rawkey[i]);
		}
		
		// sprawdzenie powotrzen w kluczu
		int counter = 0;

		for (int i = 0; i < key.length(); i++) {
			for (int j = 0; j < key.length(); j++) {
				if (i != j && j > i) {
					if (rawkey[i] == 'J') {
						rawkey[i] = '0';
						counter++;
					}
					if (rawkey[i] == rawkey[j]) {
						rawkey[j] = '0';
						counter++;
					}
				}
			}
			System.out.println(rawkey[i]);
		}
		// usuniecie 0 z klucza
		char readykey[] = new char[rawkey.length - (counter / 2)];// this line
																	// is so bad
		int temp = 0;
		for (int i = 0; i < key.length(); i++) {
			if (rawkey[i] != '0') {
				readykey[temp] = rawkey[i];
				System.out.println(readykey[temp] + "temp");
				temp++;
			}
		}
		temp = 0;

		// alfabet
		for (int i = 0; i < 26; i++) {
			alphabet[i] = (char) (letter + i);
		}
		// alfabet bez liter z klucza
		for (int i = 0; i < readykey.length; i++) {
			for (int j = 0; j < 26; j++) {
				if (readykey[i] == alphabet[j] || alphabet[j] == 'J') {
					alphabet[j] = '0';
				}
				System.out.print(alphabet[j]);
			}
		}
		// wstawienie w tabele alfabetu
		System.out.println(alphabet.length);
		temp = 0;
		counter = 0;
		// wstawienie klucza do tablicy
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (temp < readykey.length) {
					table[i][j] = readykey[temp];
					temp++;
					// System.out.print(table[i][j]);

				} else {
					if (alphabet[counter] != '0') {
						table[i][j] = alphabet[counter];
						counter++;
					} else {
						counter++;
						j--;

					}
				}

			}
		//check
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
		//podobnie z tekstem sprawdzanie czy jest J i czy da sie podzielic na 2 i czy nie ma dwoch takich samych znakow obok siebie
		if(text.length()%2==1){
			text+='X';
		}
		
		char rawtext[] = new char[text.length()*2];
		// uzupelnienie tablicy z tekstem
				for (int i = 0; i < text.length(); i++) {					
					rawtext[i] = text.charAt(i);
					
					if(rawtext[i]=='J'){
						rawtext[i]='I';
					}
					if(i>1&&i<text.length()*2-1){
						if(rawtext[i]==rawtext[i-1]){
							rawtext[i+1]=rawtext[i];
							rawtext[i]='X';
						}
					}
					else{
						rawtext[i]='0';
					}
				}
				System.out.println(rawtext.length);
//				if(rawtext.length%2==1){
//					
//				}
//				temp=0;
//		for (int i=0; i<rawtext.length; i++){
//			if(rawtext[i]==0){
//				temp++;
//			}
//		}
//		System.out.println(temp);
				
	}

}
