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
		StringTokenizer tokens;
		int n1, n2, diff, maxDiff;
		boolean isJolly;

		while((input = Main.readLn(10000000)) != null){
			isJolly = true;
			tokens = new StringTokenizer(input);
			n1 = Integer.parseInt(tokens.nextToken());
			boolean[] diferencias = new boolean[n1];
			if(n1 == 1)
				System.out.println("Jolly");
			else {
				maxDiff = n1;
				n1 = Integer.parseInt(tokens.nextToken());
				n2 = Integer.parseInt(tokens.nextToken());	
				diff = Math.abs(n1-n2);			
				do {
					if(diff < maxDiff && diff > 0 && !diferencias[diff-1])
						diferencias[diff-1] = true;
					else {
						isJolly = false;
						break;
					}

					if(tokens.hasMoreElements()){
						n1 = n2;
						n2 = Integer.parseInt(tokens.nextToken());
						diff = Math.abs(n1-n2);	
					} else 
						break;
									
				} while(true);
				if(isJolly)
					System.out.println("Jolly");
				else
					System.out.println("Not jolly");
			}
		}
	}
}