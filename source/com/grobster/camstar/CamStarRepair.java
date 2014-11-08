package com.grobster.camstar;

import java.nio.file.Path;
import java.util.List;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class CamStarRepair implements RenameBehavior {
	private int periodCount;
	
	public void renameFiles(Path path, String filter) {
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*" + filter)){ // filter based on file type
			for (Path entry: stream) {
				periodCount = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void countPeriodsInFileName(Path path) {
		for (int i = 0; i < path.getFileName().toString().length(); i++) {
			if (path.getFileName().toString().charAt(i) == '.') {
				periodCount++; // increase period count
			}
		}
	}
}