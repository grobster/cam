package com.grobster.camstar;

public class CamStarRepair implements RenameBehavior {
	private ConsentRepairInterface consentRepair;
	
	public CamStarRepair(ConsentRepairInterface consentRepair) {
		this.consentRepair = consentRepair;
	}
	
	public void renameFiles() {
		
	}
}