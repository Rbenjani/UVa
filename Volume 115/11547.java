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
		while(tc-- != 0){
			Short n = Short.parseShort(Main.readLn(255).trim());
			int res = ((n*63+7492)*5)-498;
			StringBuilder sb = new StringBuilder(res + "");
			System.out.println(sb.charAt(sb.length()-2));
		}		
	}
}