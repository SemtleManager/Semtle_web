package com.Study;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StudyCommand {
	
	int execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
