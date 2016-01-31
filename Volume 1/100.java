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
		int n1, n2, from, to, cont, max, num;
		while((input = Main.readLn(255)) != null){
			tokens = new StringTokenizer(input);
			n1 = Integer.parseInt(tokens.nextToken());
			n2 = Integer.parseInt(tokens.nextToken());
			if(n1 > n2){
				from = n2;
				to = n1;
			}
			else {
				from = n1;
				to = n2;
			}
			max = 1;
			while(from <= to){
				num = from++;
				cont = 1;
				while(num != 1){
					if(num % 2 == 0)
						num /= 2;
					else
						num = 3*num + 1;
					cont++;
				}
				if(cont > max)
					max = cont;
			}
			System.out.println(n1 + " " + n2 + " " + max);
		}
	}
}