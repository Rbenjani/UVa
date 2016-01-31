import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		int cont = 0, pos;
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()){
			sb = new StringBuilder(sc.nextLine());
			pos = sb.indexOf("\"");
			while(pos != -1){
				sb.deleteCharAt(pos);
				if(cont % 2 == 0)					
					sb.insert(pos, "``");				
				else
					sb.insert(pos, "\'\'");
				cont++;
				pos = sb.indexOf("\"", pos+1);
			}
			System.out.println(sb.toString());		
		}
	}
}