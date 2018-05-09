
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
		Scanner template = new Scanner(System.in);
		while (template.hasNextLine()) {			
			String line = template.nextLine();
			String[] words = line.split(" ");
			Map<String, String> replace= new HashMap<>();
			for (String w : words) {
				if (replacement.containsKey(w)) {
					//replace.put();
				}
			}
		}
	}
}
