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
		String input;
		while(tc-- != 0){
			input = Main.readLn(255).trim();
			if(input.equals("1") || input.equals("4") || input.equals("78"))
				System.out.println("+");
			else if(input.matches("[0-9]+35"))
				System.out.println("-");
			else if(input.matches("9[0-9]+4[0-9]*"))
				System.out.println("*");
			else
				System.out.println("?");
		}
	}
}