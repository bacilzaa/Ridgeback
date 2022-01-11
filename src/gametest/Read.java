package gametest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Read {
	
	public String text;
	
	public Read() throws IOException {
		text ="";
		File read = new File("D:\\CP212 B01\\test\\text.txt");
		Scanner sc = new Scanner(read);
		while (sc.hasNextLine()) {
			text += sc.nextLine() + "\r\n";
		}
		sc.close();
	}
	
	public String Print() {
		return text;
	}

}
