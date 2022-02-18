package com.Notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NoticeCommand {
	
	int execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
