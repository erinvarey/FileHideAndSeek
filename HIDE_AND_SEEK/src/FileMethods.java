import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileMethods {
	final static File dir = new File("C:\\\\Users\\cloni\\Documents");
	boolean FoundFile;
	boolean FoundLocation;
	private String FilePathLocation;
	private String FileName;
	private String NewFileLocation;
	
	
	
	public FileMethods()throws IOException{
		this.FilePathLocation="C:\\\\Users\\cloni\\Documents";
		this.FileName="";
		this.NewFileLocation="C:\\\\Users\\cloni\\Documents";
		this.FoundFile=false;
		this.FoundLocation=false;
		
		grabFile();	
		System.out.println(getFileName());
		System.out.println(getFilePath());
		MoveFolderPath();
		System.out.println(getNewFileLocation());
		
		moveFile(getFilePath(),getFileName(),getNewFileLocation());
		
		
		//deleteFile("C:\\Python27\\kyle.txt");
		
		
		//MoveFolderPath();
		//System.out.println(getNewFileLocation());
		
	}
	public String getFileName(){
		return this.FileName; 	
	}
	public String getFilePath(){
		if(this.FilePathLocation.equals("C:\\")){
			this.FilePathLocation="C:\\\\";	
			return "C:\\\\";
		}
		else{
			return this.FilePathLocation;
		}
	}
	public Object filename(){
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
	public void makefile(){
		for(int i =0;i<5;i++){
			MoveFolderPath();
			File spam = new File(getNewFileLocation()+filename());
			//System.out.println(spam);
			
		}
	}
	
	public String getNewFileLocation(){
		return this.NewFileLocation;
	}
	
	public void moveFile(String OldPath,String File,String newLocation){
		File folder = new File(OldPath+"\\"+File);
		File newfile = new File(newLocation+"\\"+File);
		folder.renameTo(newfile);
	}
	
	private void createFile(){
		
		
	}
	
	private void grabFile(){
		File[] files = dir.listFiles();
		
		while (!this.FoundFile){
			try{
				if(files.length!=0){
					int i = (int)(Math.random()*files.length);
					files=deeperOrNot(files,i);
				}
			}
			catch(NullPointerException e){
				System.out.println("error ");
				System.out.println(this.FilePathLocation);
				files = dir.listFiles();
				this.FilePathLocation="C:\\\\Users\\cloni\\Documents";
			}
		}
		
	}
	private File[] deeperOrNot(File[] Files,int i){
		File[] newFiles={};
		String FileName=Files[i].getName();
		
		if(!FileName.contains(".")){
			this.FilePathLocation=this.FilePathLocation+"\\"+FileName;
			newFiles = new File(this.FilePathLocation).listFiles();
			
		}
		else {
			this.FileName=FileName;
			this.FoundFile=true;
		}
		return newFiles;
		
	}
	
	public void deleteFile(String a){
		File deletion=new File(a);
		deletion.delete();
	}
	private void MoveFolderPath(){
		int depth=0;
		boolean done=false;
		File[] folder = dir.listFiles();
		String Path="C:\\\\Users\\cloni\\Documents";
		
		List<String> PossibleFolders=NewPath(folder);
		
		while (PossibleFolders.size()!=0 & done==false){
			if(depth>25){
				done=true;
			}
			//System.out.println(PossibleFolders.size());
			//System.out.println(Path);
			try{
				depth++;
				int i = (int)(Math.random()*PossibleFolders.size());
				Path=Path+"\\"+PossibleFolders.get(i);
				folder=new File(Path).listFiles();
				PossibleFolders=NewPath(folder);
			}
			catch(NullPointerException e){
			}
			
		}
		this.NewFileLocation=Path;
	}
	private List<String> NewPath(File[] folder){
		List<String> newPossibleFolders=new ArrayList <String>();
		
		for(File f : folder){
			String Name = f.getName();
			//String fileExtension = Name.substring(Name.indexOf(".") + 1, f.getName().length());
			//fileExtension = fileExtension.toLowerCase();
			if(Name.indexOf(".")==-1){
				newPossibleFolders.add(Name);
			}
		}
		
		return newPossibleFolders;
	}
	
}
