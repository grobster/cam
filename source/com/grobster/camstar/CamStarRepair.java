package com.grobster.camstar;

import java.nio.file.Path;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Paths;

public class CamStarRepair implements RenameBehavior {
	public static final String SECOND_PART_PHOTO_CONSENT_NAME = " - Photo Consent";

	public int renameFiles(Path path, String filter) {
		int numberOfFilesRepaired = 0;
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*" + filter)){ // filter based on file type
			for (Path entry: stream) {
				if (CamStarRepair.countPeriodsInFileName(entry) == 1) {
					String[] tokens = entry.getFileName().toString().split("_");
					if (tokens.length > 0) {
						String firstFileNameRepair = tokens[0].trim();
						String[] userNameTokens = firstFileNameRepair.split("\\s+");
						if (userNameTokens.length == 2) {
							Path target = Paths.get(new StringBuilder(path.toString() + "\\" + userNameTokens[1].trim() + "_" + userNameTokens[0].trim() + CamStarRepair.SECOND_PART_PHOTO_CONSENT_NAME + filter).toString());
							Files.move(entry, target, REPLACE_EXISTING, ATOMIC_MOVE); //rename the file
							if (Files.exists(target)) {
								numberOfFilesRepaired++;
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return numberOfFilesRepaired;
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