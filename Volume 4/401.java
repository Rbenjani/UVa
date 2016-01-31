import java.util.Scanner;
import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int cont = 0;
			String linea = in.nextLine();
			if(linea.equals(reverse(linea)))
				cont += 1;
			if(isMirror(linea))
				cont += 2;
			StringBuilder sb = new StringBuilder(linea + " -- ");
			switch(cont){
				case 0:
					sb.append("is not a palindrome.\n");
					break;
				case 1:
					sb.append("is a regular palindrome.\n");
					break;
				case 2:
					sb.append("is a mirrored string.\n");
					break;
				case 3:
					sb.append("is a mirrored palindrome.\n");
					break;
			}
			System.out.println(sb.toString());
		}
	}

	public static String reverse(String linea){

		StringBuilder sb = new StringBuilder();
		for(int i = linea.length()-1; i >= 0; i--)
			sb.append(linea.charAt(i));

		return sb.toString();
	}

	public static boolean isMirror(String linea){

		String letras = "AEHIJLMOSTUVWXYZ12358";
		String letras2 = "A3HILJMO2TUVWXY51SEZ8";

		for(int i = 0; i < linea.length()/2; i++)
			if(letras.indexOf(linea.charAt(i)) < 0 || letras.indexOf(linea.charAt(i)) != letras2.indexOf(linea.charAt(linea.length()-i-1)))
				return false;
		char letra = linea.charAt(linea.length()/2);	
		if(linea.length() % 2 == 1){
			if(letras.indexOf(letra) < 0 || letras.indexOf(letra) != letras2.indexOf(letra))
				return false;
		}
		return true;
	}
}