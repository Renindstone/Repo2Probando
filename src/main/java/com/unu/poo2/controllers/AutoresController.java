package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.model.AutoresModel;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
    AutoresModel modelo = new AutoresModel();
    
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		 if (request.getParameter("op")==null) {
			 listar(request,response);
			 return;
		}
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
	 
	 private void listar(HttpServletRequest request, HttpServletResponse response) {
		 try {
				request.setAttribute("listaAutores", modelo.listarAutores());
				request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
		 	} catch (ServletException | IOException ex) {
			 Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		 	}
		 }
}
