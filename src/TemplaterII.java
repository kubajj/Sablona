
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Templater {
	public static void main(String[] args) {
		Map<String, String> replacement= new HashMap<>();
		List<String> keys = new LinkedList<>();
		for (String a : args) {
			String[] spliteda = a.split("=");
			if (!spliteda[0].equals("--var")) {
				continue;
			} else {	
				spliteda[1] = "__ " + spliteda[1] + " __";
				replacement.put(spliteda[1], spliteda[2]);
				keys.add(spliteda[1]);
			}
		}
		Scanner template = new Scanner(System.in);
		while (template.hasNextLine()) {			
			String line = template.nextLine();
			for (String k : keys) {				
				//line.replaceAll("\\{\\{ " + k + " \\}\\}", replacement.get(k));
				line.replaceAll(k, replacement.get(k));
			}	
			System.out.println(line);
		}
		for (String h : keys) {	
			System.out.println(h + "--->" + replacement.get(h));
		}
	}
}