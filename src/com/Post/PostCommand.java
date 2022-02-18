package com.Post;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PostCommand {
	
	int execute(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
