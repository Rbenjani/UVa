// Versión doble de lenta con Scanner
import java.io.*;
import java.util.*;

class Main implements Runnable {

	public static void main(String[] args) {

		new Thread(new Main()).start();
	}

	static String readLn(int maxLg){

		byte[] lin = new byte[maxLg];
		int lg = 0, car = -1;
		try {
			while(lg < maxLg){
				car = System.in.read();
				if((car < 0) || car == '\n')
					break;
				lin[lg++] += car;
			}
		} catch(Exception ex){
			return null;
		}

		if(car < 0 && lg == 0)
			return null;
		return new String(lin, 0, lg);
	}

	public void run(){
		solve();
	}

	public void solve(){

		Scanner sc = new Scanner(System.in);
		int banks = sc.nextInt();
		int debentures = sc.nextInt();
		while(banks != 0 && debentures != 0){
			int[] reserves = new int[banks];
			for(int i = 0; i < banks; i++)
				reserves[i] = sc.nextInt();
			while(debentures-- != 0){
				int bfrom = sc.nextInt();
				int bto = sc.nextInt();
				int amount = sc.nextInt();
				reserves[bfrom-1] -= amount;
				reserves[bto-1] += amount;
			}
			boolean possible = true;
			for(int i = 0; i < banks && possible; i++)
				possible = reserves[i] >= 0;
			if(possible)
				System.out.println("S");
			else	
				System.out.println("N");
			
			banks = sc.nextInt();
			debentures = sc.nextInt();
		}
	}
}