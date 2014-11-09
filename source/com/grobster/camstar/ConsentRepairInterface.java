package com.grobster.camstar;

import java.nio.file.Path;

public interface ConsentRepairInterface {
	public int renameFiles(Path path, String filter);
	public void setRenameBehavior(RenameBehavior renameBehavior); // new just added uses Strategy Pattern
	public String getOldFileName();
	public String getNewFileName();
	public int getNumberFilesRenamed();
	public void registerObserver(FileRenamerObserver o);
	public void removeObserver(FileRenamerObserver o);
	public void notifyObservers();
}