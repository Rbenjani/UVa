import java.util.Scanner;
import java.text.DecimalFormat;

class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s;
		byte h, m;
		double angMin, angHor, res;
		DecimalFormat decimalFormat = new DecimalFormat("#0.000");
		while(!((s = in.next()).equals("0:00"))){
			h = Byte.parseByte(s.substring(0,s.length()-3));
			m = Byte.parseByte(s.substring(s.length()-2));
			angMin = (m*360)/60;
			angHor = (h*360)/12 + (angMin/12);
			res = Math.abs(angHor-angMin);
			if(res >= 180.0)
				res = 360.0-res;
			System.out.println(decimalFormat.format(res));
		}
	}
}