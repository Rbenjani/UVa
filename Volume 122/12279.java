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
		int suma, tc = 1, num, cont2;
		while((cont2 = Integer.parseInt(Main.readLn(255).trim())) != 0){
			suma = 0;
			tokens = new StringTokenizer(Main.readLn(100000).trim());
			while(cont2-- > 0){
				if(Integer.parseInt(tokens.nextToken()) > 0)
					suma++;
				else
					suma--;				
			}
			StringBuilder sb = new StringBuilder("Case " + tc++ + ": " + suma);
			System.out.println(sb);
		}
	}
}