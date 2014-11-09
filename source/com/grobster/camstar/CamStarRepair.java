package com.grobster.camstar;

import java.nio.file.Path;
import java.util.List;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.ArrayList;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Paths;

public class CamStarRepair implements RenameBehavior {
	public static final String SECOND_PART_PHOTO_CONSENT_NAME = " - Photo Consent";

	public void renameFiles(Path path, String filter) {
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*" + filter)){ // filter based on file type
			for (Path entry: stream) {
				if (CamStarRepair.countPeriodsInFileName(entry) == 1) {
					String[] tokens = entry.getFileName().toString().split("_");
					if (tokens.length > 0) {
						Path target = Paths.get(new StringBuilder(path.toString() + "\\" + tokens[0].trim() + CamStarRepair.SECOND_PART_PHOTO_CONSENT_NAME + filter).toString());
						Files.move(entry, target, REPLACE_EXISTING, ATOMIC_MOVE); //rename the file
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static int countPeriodsInFileName(Path path) {
		int count = 0;
		for (int i = 0; i < path.getFileName().toString().length(); i++) {
			if (path.getFileName().toString().charAt(i) == '.') {
				count++; // increase period count
			}
		}
		return count;
	}
}