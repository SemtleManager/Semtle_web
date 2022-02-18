package com.User;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserCommand {
	
	int execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
