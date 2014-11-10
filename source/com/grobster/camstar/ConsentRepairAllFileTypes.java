package com.grobster.camstar;

import java.nio.file.Path;
import java.nio.file.Files;

public class ConsentRepairAllFileTypes implements ConsentRepairInterface { // class is a decorator
	private ConsentRepairInterface consentRepair;
	private int fileCount;
	
	public ConsentRepairAllFileTypes(ConsentRepairInterface consentRepair) {
		this.consentRepair = consentRepair;
	}
	
	public int renameFiles(Path path, String filter) {
		return 0;
	}
	public void setRenameBehavior(RenameBehavior renameBehavior) {
		consentRepair.setRenameBehavior(renameBehavior);
	}	// new just added uses Strategy Pattern
	public int getNumberFilesRenamed() {
		return fileCount;
	}
	
}