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
		int cont = 1;
		while(!( (input = Main.readLn(255).trim()).equals("*")) ){
			StringBuilder sb = new StringBuilder("Case " + cont++ + ": ");
			if(input.equals("Hajj"))
				System.out.println(sb.append("Hajj-e-Akbar"));
			else
				System.out.println(sb.append("Hajj-e-Asghar"));
		}
	}
}