package com.grobster.camstar;

import java.nio.file.Path;

public class CamStarRepair implements RenameBehavior {
	private ConsentRepairInterface consentRepair;
	
	public CamStarRepair(ConsentRepairInterface consentRepair) {
		this.consentRepair = consentRepair;
	}
	
	public void renameFiles(Path path) {
		
	}
}