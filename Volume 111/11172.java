import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n1, n2;
		int comp = sc.nextInt();
		String cadena = "";
		//String signos[] = new String[comp];

		for(int i = 0; i < comp; i++){
			n1 = sc.nextInt();
			n2 = sc.nextInt();

			if(n1 > n2)
				cadena += ">";
			else if(n1 == n2)
				cadena += "=";
			else
				cadena += "<";

			if(i+1 != comp)
				cadena += '\n';			
		}
			System.out.print(cadena);
	}
}