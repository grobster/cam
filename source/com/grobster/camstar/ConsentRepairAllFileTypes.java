package com.grobster.camstar;

import java.nio.file.Path;
import java.nio.file.Files;

public class ConsentRepairAllFileTypes implements ConsentRepairInterface { // class is a decorator
	private ConsentRepairInterface consentRepair;
	private int fileCount;
	public static final String[] FILE_TYPES = {".pdf", ".PDF", ".jpg", ".JPG", ".tif"};
	
	public ConsentRepairAllFileTypes(ConsentRepairInterface consentRepair) {
		this.consentRepair = consentRepair;
	}
	
	public int renameFiles(Path path, String filter) {
		fileCount = 0;
		
		for (int i = 0; i < ConsentRepairAllFileTypes.FILE_TYPES.length; i++) {
			filter = FILE_TYPES[i];
			fileCount = fileCount + consentRepair.renameFiles(path, filter);
		}
		return fileCount;
	}
	public void setRenameBehavior(RenameBehavior renameBehavior) {
		consentRepair.setRenameBehavior(renameBehavior);
	}	// new just added uses Strategy Pattern
	
	public int getNumberFilesRenamed() {
		return fileCount;
	}
	
}