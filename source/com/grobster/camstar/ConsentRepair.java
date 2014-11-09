package com.grobster.camstar;

import java.nio.file.Path;
import java.nio.file.Files;

public class ConsentRepair implements ConsentRepairInterface { //implementation class
	private RenameBehavior renameBehavior;
	private int numberOfFilesRenamed;
	
	public int renameFiles(Path path, String filter){
		numberOfFilesRenamed = 0;
		if (Files.exists(path) && Files.isDirectory(path)) {
			return numberOfFilesRenamed = renameBehavior.renameFiles(path, filter);
		}
		return 0;
	}

	public int getNumberFilesRenamed() {
		return numberOfFilesRenamed;
	}
	public void setFileEnding(String fileEnding){}
	
	public String getFileEnding() {
		return null;
	}
	public void registerObserver(FileRenamerObserver o){}
	
	public void removeObserver(FileRenamerObserver o){}
	
	public void notifyObservers(){}
	
	public String getOldFileName() {
		return null;
	}
	public String getNewFileName() {
		return null;
	}
	
	public void setRenameBehavior(RenameBehavior renameBehavior){
		this.renameBehavior = renameBehavior;
	} // new--just added--uses Strategy Pattern
}