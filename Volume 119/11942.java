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

		int groups = Integer.parseInt(Main.readLn(255).trim());
		System.out.println("Lumberjacks:");
		while(groups-- != 0){
			StringTokenizer tokens = new StringTokenizer(Main.readLn(10000));
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			boolean ordered = true;
			if(n1 > n2){
				for(int i = 2; i < 10 && ordered; i++){
					n1 = n2;
					n2 = Integer.parseInt(tokens.nextToken());
					if(n1 < n2)
						ordered = false;
				}
			} else if(n1 < n2){
				for(int i = 2; i < 10 && ordered; i++){
					n1 = n2;
					n2 = Integer.parseInt(tokens.nextToken());
					if(n1 > n2)
						ordered = false;
				}
			} else {
				ordered = false;
			}
			if(ordered)
				System.out.println("Ordered");
			else
				System.out.println("Unordered");
		}
	}
}