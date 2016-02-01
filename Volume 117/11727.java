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

		Byte tc = Byte.parseByte(Main.readLn(255).trim());
		Byte cases = tc;
		StringTokenizer tokens;
		while(tc-- != 0){
			tokens = new StringTokenizer(Main.readLn(255));
			Short[] salarios = new Short[3];
			salarios[0] = Short.parseShort(tokens.nextToken());
			salarios[1] = Short.parseShort(tokens.nextToken());
			salarios[2] = Short.parseShort(tokens.nextToken());
			Arrays.sort(salarios);
			StringBuilder sb = new StringBuilder("Case " + (cases-tc) + ": " + salarios[1]);
			System.out.println(sb.toString());
		}		
	}
}