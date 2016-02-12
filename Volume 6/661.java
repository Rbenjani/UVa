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

		StringTokenizer tokens = new StringTokenizer(Main.readLn(255));
		int devices = Integer.parseInt(tokens.nextToken());
		int cont = 1;
		while(devices != 0){
			int oper = Integer.parseInt(tokens.nextToken());
			int maxCap = Integer.parseInt(tokens.nextToken());
			int powActual = 0, maxPow = 0;
			int[] powDev = new int[devices];
			boolean[] devOn = new boolean[devices];
			boolean blown = false;
			for(int i = 0; i < devices; i++)
				powDev[i] = Integer.parseInt(Main.readLn(255).trim());

			for(int i = 0; i < oper; i++){
				int nextDev = Integer.parseInt(Main.readLn(255).trim());
				if(devOn[nextDev-1]){
					devOn[nextDev-1] = false;
					powActual -= powDev[nextDev-1];
				}
				else {
					powActual += powDev[nextDev-1];
					devOn[nextDev-1] = true;
				}
				if(powActual > maxPow)
					maxPow = powActual;
				
				if(powActual > maxCap)
					blown = true;
			}

			System.out.println(new StringBuilder("Sequence " + cont++));

			if(blown)
				System.out.println("Fuse was blown.\n");
			else {
				System.out.println("Fuse was not blown.");
				System.out.println(new StringBuilder("Maximal power consumption was " + maxPow + " amperes.\n"));
			}

			tokens = new StringTokenizer(Main.readLn(255));
			devices = Integer.parseInt(tokens.nextToken());
		}
	}
}