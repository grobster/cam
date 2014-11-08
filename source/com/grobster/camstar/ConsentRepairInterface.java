package com.grobster.camstar;

import java.nio.file.Path;

public interface ConsentRepairInterface {
	public void renameFiles(Path path);
	public void setFullDirectoryPath(String path);
	public String getFullDirectoryPath();
	public String getBaseDirectoryPath();
	public int getNumberFilesRenamed();
	public void setFileEnding(String fileEnding);
	public String getFileEnding();
	public void registerObserver(FileRenamerObserver o);
	public void removeObserver(FileRenamerObserver o);
	public void notifyObservers();
	public String getOldFileName();
	public String getNewFileName();
	public void setRenameBehavior(RenameBehavior renameBehavior); // new just added uses Strategy Pattern
}