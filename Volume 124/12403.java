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

		int amount = 0;
		int tc = Integer.parseInt(Main.readLn(255).trim());
		StringTokenizer tokens;

		while(tc-- != 0){
			tokens = new StringTokenizer(Main.readLn(100000).trim());
			switch(tokens.nextToken()){
				case "donate":
					amount += Integer.parseInt(tokens.nextToken());
					break;
				case "report":
					System.out.println(amount);
					break;
			}
		}		
	}
}