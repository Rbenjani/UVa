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
		int numbers = Integer.parseInt(Main.readLn(5).trim());
		byte setNumber = 0;
		while(numbers != 0){
			setNumber++;
			String[] lineNumbers = (Main.readLn(5001).trim().split(" "));
			int auxNumber = 0;
			short[] heights = new short[numbers];
			for(short i = 0; i < numbers; i++){
				heights[i] = Short.parseShort(lineNumbers[i]);
				auxNumber += heights[i];
			}
			auxNumber /= numbers;
			int movs = 0;
			for(short i = 0; i < numbers; i++){
				movs += Math.abs(heights[i] - auxNumber);
			}
			// Set #1
			System.out.println("Set #" + setNumber);
			System.out.println("The minimum number of moves is " + movs/2 + ".\n");
			numbers = Integer.parseInt(Main.readLn(5).trim());
		}
	}
}