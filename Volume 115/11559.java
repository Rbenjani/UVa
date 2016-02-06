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

		String input;
		while((input = Main.readLn(255)) != null){
			StringTokenizer tokens = new StringTokenizer(input);
			int participants = Integer.parseInt(tokens.nextToken());
			int budget = Integer.parseInt(tokens.nextToken());
			int hotels = Integer.parseInt(tokens.nextToken());
			int weeks = Integer.parseInt(tokens.nextToken());
			double maxPrice = Math.ceil(1.0*budget/participants);
			int minCost = Integer.MAX_VALUE;
			while(hotels-- != 0) {
				tokens = new StringTokenizer(Main.readLn(255));
				int hotelPrice = Integer.parseInt(tokens.nextToken());			
				tokens = new StringTokenizer(Main.readLn(255));
				boolean cond1 = hotelPrice < maxPrice;
				boolean cond2 = false;
				for(int i = 0; i < weeks && !cond2; i++){
					if(Integer.parseInt(tokens.nextToken()) >= participants)
						cond2 = true;				
				}

				if(cond1 && cond2 && hotelPrice * participants < minCost)
						minCost = hotelPrice * participants;
				
			}
			if(minCost != Integer.MAX_VALUE)
				System.out.println(minCost);		
			else
				System.out.println("stay home");
		}
	}
}
