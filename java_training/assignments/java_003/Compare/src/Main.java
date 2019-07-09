import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
//import java.nio.file.Path;
public class Main {
	
	public static void main(String[] args) {
		// intro		
		//commmand line args
		
		if(args.length > 1) {
			//intro output
			System.out.print("Compare ");
			for(String x : args) {
				System.out.print(x + " ");
			}
			System.out.println();	
			
		
		}
		else {
			System.out.println("Two files were not found");
			System.exit(0);
		}
		
		String filename1 = args[0];
		String filename2 = args[1];
		
		//comparision
		try {
			CompareFilesBytes(filename1, filename2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static boolean CompareFilesBytes(String file1, String file2) throws IOException {
		File f1 = new File(file1);
		File f2 = new File(file2);
		FileInputStream input1 = new FileInputStream(f1);
		FileInputStream input2 = new FileInputStream(f2);
		
		if(f1.length() == f2.length()) {
			//int n =0;
			byte[] fileb1 = new byte[(int) f1.length()];
			byte[] fileb2 = new byte[(int) f2.length()];
			input1.read(fileb1);
			input2.read(fileb2);
			
			if(Arrays.equals(fileb1, fileb2) == true) {
				System.out.println("identical content");
				System.out.println("character length for both: " + f1.length());
				return true;
			}
			
		}
		else {
			System.out.println("different content");
			System.out.println("character length for " + file1 + ": " + f1.length());
			System.out.println("character length for " + file2 + ": " + f2.length());
			return false;
		}
		return true;
	}
	
}
