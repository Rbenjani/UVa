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
		String[] input;
		while(tc-- != 0){
			int farmers = Integer.parseInt(Main.readLn(255).trim());
			int budget = 0;
			while(farmers-- != 0){
				input = Main.readLn(255).trim().split(" ");
				budget += Integer.parseInt(input[0]) * Integer.parseInt(input[2]);
			}
			System.out.println(budget);
		}
	}
}