import java.io.File;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testfolder();
		File folder = new File("C:/Users/Erin/Desktop/TEST/a.txt");
		File newfile = new File("C:/Users/Erin/Desktop/TEST/moved.txt");
		File[] listOfFiles = folder.listFiles();
		folder.renameTo(newfile);
	}
	
	public static String testfolder(){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a folder path: ");
		String s = reader.next();
		System.out.println(s);
		return s;
		
	}
	public static String pickfile(String s){
		File folder = new File(s);
		File[] listOfFiles = folder.listFiles();
		return "";
	}

}
