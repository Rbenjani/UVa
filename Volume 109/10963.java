// Correct output but not accepted
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
		String input;
		int cols, size, f1, f2;
		while(tc-- != 0){
			boolean same = true;
			input = Main.readLn(20);
			cols = Integer.parseInt(Main.readLn(255).trim());
			StringBuilder sb = new StringBuilder();

			if(cols == 0)
				sb.append("yes");
			else if(cols < 0)
				sb.append("no");			
			else {
				input = Main.readLn(255).trim();
				f1 = Integer.parseInt(input.split(" ")[0]);
				f2 = Integer.parseInt(input.split(" ")[1]);
				size = Math.abs(f1 - f2);
				while(--cols > 0 && same){
					input = Main.readLn(255).trim();
					f1 = Integer.parseInt(input.split(" ")[0]);
					f2 = Integer.parseInt(input.split(" ")[1]);
					same = Math.abs(f1 - f2) == size;
				}
				sb.append(same ? "yes" : "no");
			}
			if(tc != 0)
				sb.append("\n");
			System.out.println(sb);
		}

	}
}