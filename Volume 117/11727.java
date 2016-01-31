import java.util.Scanner;
import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		byte cases = in.nextByte();
		Short[] salarios = new Short[3];
		for(int i = 1; i <= cases; i++){
			salarios[0] = in.nextShort();
			salarios[1] = in.nextShort();
			salarios[2] = in.nextShort();
			Arrays.sort(salarios);
			System.out.println("Case " + i + ": " + salarios[1]);
		}
	}
}