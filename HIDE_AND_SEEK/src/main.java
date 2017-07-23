import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//testfolder();
		File folder = new File("C:/Users/Erin/Desktop/TEST/a.txt");
		File newfile = new File("C:/Users/Erin/Desktop/TEST/moved.txt");
		File[] listOfFiles = folder.listFiles();
		folder.renameTo(newfile);
		new Interface();
		
		
		//FileMethods test=new FileMethods();
		
		
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
		int index = (int) Math.floor((Math.random()*listOfFiles.length));
	//	listOfFiles[index]=renameTo("C:/Users/Erin/Desktop/TEST/moved.txt"+filename());
		return "";
	}

	public static Object filename(){
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz()[]{}^*!@#$";
		int numChars = 64;
		int length = 20;
		Random rand = new Random();
		File File = new File("");
		String filename = File.getName();
		//String base = FilenameUtils.removeExtension(filename);
        for (int i = 0; i < length; i++){
            int index = (int) (rand.nextFloat() * numChars);
          //  File = File(charset.charAt(index));
        }
        return File;
	}

}
