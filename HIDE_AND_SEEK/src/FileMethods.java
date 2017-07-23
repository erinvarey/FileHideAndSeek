import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileMethods {
	final static File dir = new File("C:\\");
	boolean FoundFile;
	boolean FoundLocation;
	private String FilePathLocation;
	private String FileName;
	private String NewFileLocation;
	
	
	
	public FileMethods(){
		this.FilePathLocation="C:\\";
		this.FileName="";
		this.NewFileLocation="C:";
		this.FoundFile=false;
		this.FoundLocation=false;
		//grabFile();	
		//System.out.println(getFileName());
		//System.out.println(getFilePath());
		//moveFile("C:\\Python27","kyle.txt","C:\\testcase");
		//deleteFile("C:\\Python27\\kyle.txt");
		MoveFolderPath();
	}
	private String getFileName(){
		return this.FileName; 	
	}
	private String getFilePath(){
		return this.FilePathLocation;
	}
	
	private void moveFile(String OldPath,String File,String newLocation){
		File folder = new File(OldPath+"\\"+File);
		File newfile = new File(newLocation+"\\"+File);
		folder.renameTo(newfile);
	}
	
	private void createFile(){
		
		
	}
	
	private void grabFile(){
		File[] files = dir.listFiles();
		
		while (!this.FoundFile){
			int i = (int)(Math.random()*files.length);
			files=deeperOrNot(files,i);
			
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
	
	private void deleteFile(String a){
		File deletion=new File(a);
		deletion.delete();
	}
	private void MoveFolderPath(){
		File[] folder = dir.listFiles();
		String Path="C:";
		
		List<String> PossibleFolders=NewPath(folder);
		
		while (PossibleFolders.size()!=0){
			System.out.println(PossibleFolders.size());
			int i = (int)(Math.random()*PossibleFolders.size());
			Path=Path+"\\"+PossibleFolders.get(i);
			folder=new File(Path).listFiles();
			PossibleFolders=NewPath(folder);
			
		}
		this.NewFileLocation=Path;
		System.out.println(Path);
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
