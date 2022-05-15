package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;


/**
 * Servlet implementation class PowerAPI
 */
@WebServlet("/CustomerAPI")
public class CustomerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		Customer customerObj = new Customer();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAPI() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("done insert");
		String output = customerObj.insertCustomer(
				request.getParameter("name"), 
				request.getParameter("email"),
				request.getParameter("address"), 
				request.getParameter("district"));
		response.getWriter().write(output);
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("got here");
		Map paras = getParasMap(request); 
		 String output = customerObj.updateCustomer(
		paras.get("hidCustomerIDSave").toString(), 
		paras.get("name").toString(), 
		paras.get("email").toString(), 
		paras.get("address").toString(), 
		paras.get("district").toString());
		response.getWriter().write(output); 
	}

	private Map getParasMap(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 Map<String, String> map = new HashMap<String, String>(); 
			try
			 { 
			 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
			 String queryString = scanner.hasNext() ? 
			 scanner.useDelimiter("\\A").next() : ""; 
			 scanner.close(); 
			 String[] params = queryString.split("&"); 
			 for (String param : params) 
			 { 
			String[] p = param.split("=");
			 map.put(p[0], p[1]); 
			 } 
			 } 
			catch (Exception e) 
			 { 
			 } 
			return map; 
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = customerObj.deleteCustomer(paras.get("id").toString());
		response.getWriter().write(output);
	}

}
