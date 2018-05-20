package classes;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CSVTemplater {
	public static void main(String[] args) throws FileNotFoundException {
		Map<String, String> replacement = new HashMap<>();
		String filewithtemp = "";
		String csvfile = "";
		String out = "templater-%05d.txt";
		for (String a : args) {
			String[] arguments = a.split("=");
			switch (arguments[0]) {
				case "--csv":
					csvfile = arguments[1];
					break;
				case "--template":
					filewithtemp = arguments[1];
					break;
				case "--out":
					out = arguments[1];
					break;
				default:
					continue;
			}
		}	
		
		FileReader reader = new FileReader(csvfile);
		Scanner sc = new java.util.Scanner(reader);
		String[] replacers = null;
		if (sc.hasNextLine()) {
			replacers = sc.nextLine().split(",");
		}
		List<String[]> words = new LinkedList<>();
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split(",");
			words.add(line);
		}
		FileReader templatereader = new FileReader(filewithtemp);
		Scanner template = new java.util.Scanner(templatereader);
		String text = "";
		while (template.hasNextLine()) {
			text += template.nextLine() + "\n";
		}
		for (int i = 1; i <= words.size(); i++) {
			String[] line = words.get(i - 1);
			for (int r = 0; r < replacers.length; r++) {
				replacement.put(replacers[r], line[r]);
			}
			PrintWriter writer = new PrintWriter(String.format(out, i));			
			writer.print(Replace.replace(text,replacement));
			writer.close();
		}		
	}
}
