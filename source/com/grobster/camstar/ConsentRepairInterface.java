package com.grobster.camstar;

import java.nio.file.Path;

public interface ConsentRepairInterface {
	public void renameFiles(Path path);
	public void setFullDirectoryPath(String path);
	public void setFileEnding(String fileEnding);
	public void setRenameBehavior(RenameBehavior renameBehavior); // new just added uses Strategy Pattern
	public String getFullDirectoryPath();
	public String getBaseDirectoryPath();
	public String getOldFileName();
	public String getNewFileName();
	public String getFileEnding();
	public int getNumberFilesRenamed();
	public void registerObserver(FileRenamerObserver o);
	public void removeObserver(FileRenamerObserver o);
	public void notifyObservers();
}