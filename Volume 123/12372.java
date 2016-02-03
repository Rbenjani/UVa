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

		int tc = Integer.parseInt(Main.readLn(255).trim()), numCase = 0;
		StringTokenizer tokens;

		while(numCase++ < tc){
			tokens = new StringTokenizer(Main.readLn(255).trim());
			boolean fits = true;
			while(tokens.hasMoreTokens() && fits)
				if(Integer.parseInt(tokens.nextToken()) > 20)
					fits = false;
			StringBuilder sb = new StringBuilder("Case " + numCase + ": " + (fits ? "good" : "bad"));
			System.out.println(sb);
		}
	}
}