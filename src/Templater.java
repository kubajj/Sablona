
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Templater {
	public static void main(String[] args) {
		Map<String, String> replacement= new HashMap<>();		
		for (String a : args) {
			String[] spliteda = a.split("=");
			if (!spliteda[0].equals("--var")) {
				continue;
			} else {	
				replacement.put(spliteda[1], spliteda[2]);				
			}
		}
		Scanner sc = new Scanner(System.in);
		String text = "";
		while (sc.hasNextLine()) {
			text += sc.nextLine() + "\n";
		}
		String print = Replace.replace(text,replacement);
		System.out.println(print);
	}
}