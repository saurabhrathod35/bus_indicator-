	package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digimation.gujjubus.bean.CityBean;
import com.digimation.gujjubus.dao.CityDAO;
public class CityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<CityBean> listOfCityBeans=new CityDAO().getCityList();
		request.setAttribute("listofcity", listOfCityBeans);
		request.getRequestDispatcher("CityList.jsp").forward(request, response);

	}

}
