import java.io.File;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("C:/Users/Erin/Desktop/TEST/a.txt");
		File newfile = new File("C:/Users/Erin/Desktop/TEST/moved.txt");
		File[] listOfFiles = folder.listFiles();
		folder.renameTo(newfile);
	}
	
	public static void testfolder(String path){
		
	}

}
