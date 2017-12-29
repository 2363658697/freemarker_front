package cn.et.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import cn.et.model.MyNews;


public class ShowNewsServlet extends HttpServlet {

    static final String HTML_DIR="D:/html";
    MyNews  myNews = new MyNews();
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String htmlPath=request.getParameter("htmlPath");
	    
	    String path=HTML_DIR+htmlPath;
	    
	    byte[] bs=FileUtils.readFileToByteArray(new File(path));
	    
	    response.getOutputStream().write(bs);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
