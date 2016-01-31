import java.util.Scanner;

class Main implements Runnable {

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void solve(){
		
		Scanner in = new Scanner(System.in);
		Byte cases = in.nextByte();
		Short n;

		for(int i = 0; i < cases; i++){
			n = in.nextShort();
			int res = ((n*63+7492)*5)-498;
			StringBuilder sb = new StringBuilder(res + "");
			System.out.println(sb.charAt(sb.length()-2));
		}
	}

	public void run(){
		solve();
	}
}