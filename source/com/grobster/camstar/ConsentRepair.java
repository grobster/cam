package com.grobster.camstar;

import java.nio.file.Path;
import java.nio.file.Files;

public class ConsentRepair implements ConsentRepairInterface { //implementation class
	private RenameBehavior renameBehavior;
	
	public void renameFiles(Path path, String filter){
		if (Files.exists(path) && Files.isDirectory(path)) {
			renameBehavior.renameFiles(path, filter);
		}
	}

	public int getNumberFilesRenamed() {
		return 0;
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