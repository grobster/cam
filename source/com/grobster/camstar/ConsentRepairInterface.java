package com.grobster.camstar;


public interface ConsentRepairInterface {
	public void renameFiles();
	public void setFullDirectoryPath(String path);
	public String getFullDirectoryPath();
	public void manuallyAppendFolderName(String manualFolderName);
	public void autoAppendFolderName();
	public String getBaseDirectoryPath();
	public int getNumberFilesRenamed();
	public void setFileEnding(String fileEnding);
	public String getFileEnding();
	public void registerObserver(FileRenamerObserver o);
	public void removeObserver(FileRenamerObserver o);
	public void notifyObservers();
	public String getOldFileName();
	public String getNewFileName();
	public void setBaseDirectoryPath(String p);
	public void setRenameBehavior(RenameBehavior renameBehavior); // new just added uses Strategy Pattern
}