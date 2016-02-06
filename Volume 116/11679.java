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

		String input = Main.readLn(255);
		StringTokenizer tokens = new StringTokenizer(input);
		int banks = Integer.parseInt(tokens.nextToken());
		int debentures = Integer.parseInt(tokens.nextToken());
		while(banks != 0 && debentures != 0){
			input = Main.readLn(255);
			tokens = new StringTokenizer(input);
			int[] reserves = new int[banks];
			for(int i = 0; i < banks; i++)
				reserves[i] = Integer.parseInt(tokens.nextToken());
			while(debentures-- != 0){
				tokens = new StringTokenizer(Main.readLn(255));
				int bfrom = Integer.parseInt(tokens.nextToken());
				int bto = Integer.parseInt(tokens.nextToken());
				int amount = Integer.parseInt(tokens.nextToken());
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
			
			tokens = new StringTokenizer(Main.readLn(255));
			banks = Integer.parseInt(tokens.nextToken());
			debentures = Integer.parseInt(tokens.nextToken());
		}
	}
}