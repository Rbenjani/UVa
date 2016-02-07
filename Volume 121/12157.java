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
		for(int cases = 1; cases <= tc; cases++){
			int phoneCalls = Integer.parseInt(Main.readLn(255).trim());
			int s1 = 0, s2 = 0;
			for (String numStr: Main.readLn(255).trim().split("\\s")){
				int num = Integer.parseInt(numStr);
		        s1 += (num+30)/30 * 10;
		        s2 += (num+60)/60 * 15;
			}

			if(s1 < s2)
				System.out.println(new StringBuilder("Case " + cases + ": Mile " + s1));
			else if(s2 < s1)
				System.out.println(new StringBuilder("Case " + cases + ": Juice " + s2));
			else
				System.out.println(new StringBuilder("Case " + cases + ": Mile Juice " + s1));
		}
	}
}