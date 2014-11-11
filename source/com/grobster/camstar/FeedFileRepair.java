package com.grobster.camstar;

import java.nio.file.Path;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Paths;

public class FeedFileRepair implements RenameBehavior {
	public static final String FIRST_PART_FEED_FILE_NAME = "SAP_IM_chngs_20141105112500 - ";

	public int renameFiles(Path path, String filter) {
		int numberOfFilesRepaired = 0;
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*" + filter)){ // filter based on file type
			for (Path entry: stream) {
				if (CamStarRepair.countPeriodsInFileName(entry) == 2) { // make sure file name has only 1 period in it
					String[] tokens = entry.getFileName().toString().split("-"); // split the file name on the hyphen
					if (tokens.length == 2) { // make sure there are only two tokens after the split
						String secondPartFileName = tokens[1].trim(); //set second part of file name
						String[] extraTokens = secondPartFileName.split("\\.");
						Path target = Paths.get(new StringBuilder(path.toString() + "\\" + FIRST_PART_FEED_FILE_NAME + extraTokens[0] + filter).toString());
						Files.move(entry, target, REPLACE_EXISTING, ATOMIC_MOVE); //rename the file
						if (Files.exists(target)) {
							numberOfFilesRepaired++;
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return numberOfFilesRepaired;
	}
}