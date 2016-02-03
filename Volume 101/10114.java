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
		int months, depr, contMonths, aux;
		int[] nextMonth;
		double debt, downPayment, carValue, monthlyPayment;
		double[] percDepr;
		while(true){
			tokens = new StringTokenizer(Main.readLn(255).trim());			
			months = Integer.parseInt(tokens.nextToken());
			if(months < 0)
				return;
			downPayment = Double.parseDouble(tokens.nextToken());
			debt = Double.parseDouble(tokens.nextToken());
			carValue = downPayment + debt;
			monthlyPayment = debt / months;
			depr = Integer.parseInt(tokens.nextToken());

			nextMonth = new int[depr];
			percDepr = new double[depr];

			for(int i = 0; i < depr; i++){
				tokens = new StringTokenizer(Main.readLn(255));
				nextMonth[i] = Integer.parseInt(tokens.nextToken());
				percDepr[i] = Double.parseDouble(tokens.nextToken());
			}			
			carValue *= (1-percDepr[0]);
			aux = 0;
			contMonths = 0;
			while(debt > carValue){
				contMonths++;				
				if(aux+1 < depr && nextMonth[aux+1] == contMonths)
					aux++;
				carValue *= (1-percDepr[aux]);
				debt -= monthlyPayment;			
			}
			
			if(contMonths != 1)
				System.out.println(contMonths + " months");
			else
				System.out.println("1 month");
		}
	}
}