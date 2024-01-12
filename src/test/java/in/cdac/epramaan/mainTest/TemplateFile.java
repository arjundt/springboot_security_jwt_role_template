package in.cdac.epramaan.mainTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TemplateFile {

	public static void main(String[] args) throws IOException {
		String filePath = "src/main/resources/templates/temp/temp.txt";
		File file = new File(filePath);
		
		MyClass content = new MyClass("John Doe", 25);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	        writer.write(1);
		}
	}
	
//	public void writeFileToTemplatesFolder(String content) throws IOException {
//	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//	        writer.write(content);
//	    }
//	}

}
