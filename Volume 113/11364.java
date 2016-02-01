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

		int tc = Integer.parseInt(Main.readLn(255).trim());
		int stores, min, max, loc;
		StringTokenizer tokens;

		while(tc-- != 0){	
			min = 100;
			max = 0;						
			stores = Integer.parseInt(Main.readLn(255).trim());
			tokens = new StringTokenizer(Main.readLn(255));
			while(stores-- != 0){
				loc = Integer.parseInt(tokens.nextToken());
				if(loc < min)
					min = loc;
				if(loc > max)
					max = loc;				
			}			
			System.out.println(2*(max-min));
		}
	}
}