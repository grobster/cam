package com.grobster.camstar;

import java.nio.file.Path;

public interface RenameBehavior {
	public int renameFiles(Path path, String filter);
}