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

		int tc = Integer.parseInt(Main.readLn(255).trim()), cases = 1;
		while(tc-- != 0){
			String[] webs = new String[10];
			int maxRel = 0, relAct;
			for(int i = 0; i < 10; i++){
				webs[i] = Main.readLn(255).trim();
				relAct = Integer.parseInt(webs[i].split(" ")[1]);
				if(relAct > maxRel)
					maxRel = relAct;
			}

			System.out.println(new StringBuilder("Case #" + cases++ + ":"));
			for(String s: webs){
				if(s.split(" ")[1].equals(maxRel + ""))
					System.out.println(s.split(" ")[0]);
			}
		}
	}
}