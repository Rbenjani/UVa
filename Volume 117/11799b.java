import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Byte casos = Byte.parseByte(in.nextLine());
		for(int i = 0; i < casos; i++){
			Short mayor = Short.MIN_VALUE;
			String[] numeros = in.nextLine().split(" ");
			for(String s: numeros){
				Short num = Short.parseShort(s);
				if(num > mayor)
					mayor = num;
			}            
			System.out.println("Case " + (i+1) + ": " + mayor);
		}
	}
}