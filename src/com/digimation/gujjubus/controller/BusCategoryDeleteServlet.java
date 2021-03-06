package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.dao.BusCategoryDAO;
import com.digimation.gujjubus.dao.PassTypeDAO;
public class BusCategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busCategoryid=request.getParameter("id");	
		if(new BusCategoryDAO().checkReference(Integer.parseInt(busCategoryid)))
			request.setAttribute("msgbuscat", " can't be  deleted[child record found]");
		else	if(new BusCategoryDAO().removeBusCategory(Integer.parseInt(busCategoryid)))
			request.setAttribute("msgbuscat", " successfully delete");
		
		else
			request.setAttribute("msgbuscat", " failed to delete");
		request.getRequestDispatcher("BusCategoryListServlet").forward(request, response);
	
	}

}
