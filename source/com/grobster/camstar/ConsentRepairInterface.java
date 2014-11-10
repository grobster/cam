package com.grobster.camstar;

import java.nio.file.Path;

public interface ConsentRepairInterface {
	public int renameFiles(Path path, String filter);
	public void setRenameBehavior(RenameBehavior renameBehavior); // new just added uses Strategy Pattern
	public int getNumberFilesRenamed();
}