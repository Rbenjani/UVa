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
		short degrees, suma;
		byte[] pos = new byte[4];

		while(true){
			suma = 0;
			degrees = 1080;
			input = Main.readLn(255);
			tokens = new StringTokenizer(input);
			byte b = -1;
			while(b++ < 3){				
				pos[b] = Byte.parseByte(tokens.nextToken());
				suma += pos[b];
			}	
			if(suma != 0)
				degrees += (((40+pos[0]-pos[1])%40) + ((40+pos[2]-pos[1])%40) + ((40+pos[2]-pos[3])%40)) *9;
			else
				break;
			
		System.out.println(degrees);			
		}
	}
}