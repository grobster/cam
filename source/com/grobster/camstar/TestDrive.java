package com.grobster.camstar;

import java.nio.file.*;

public class TestDrive {
	public static void main(String[] args) {
		ConsentRepairInterface cr = new ConsentRepair();
		Path p = Paths.get("C:\\Users\\quarles\\Desktop\\bad_consents");
		cr.setRenameBehavior(new CamStarRepair());
		cr.renameFiles(p, ".pdf");
	}
}