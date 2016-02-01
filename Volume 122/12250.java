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
		int cont = 1;
		while(!((input = Main.readLn(255).trim()).equals("#"))){
			String lang;
			switch(input){
				case "HELLO":
					lang = "ENGLISH";
					break;
				case "HOLA":
					lang = "SPANISH";
					break;
				case "HALLO":
					lang = "GERMAN";
					break;
				case "BONJOUR":
					lang = "FRENCH";
					break;
				case "CIAO":
					lang = "ITALIAN";
					break;
				case "ZDRAVSTVUJTE":
					lang = "RUSSIAN";
					break;
				default:
					lang = "UNKNOWN";
					break;
			}
			StringBuilder sb = new StringBuilder("Case " + cont++ + ": " + lang);
			System.out.println(sb);
		}
	}
}