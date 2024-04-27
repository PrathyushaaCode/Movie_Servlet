package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;
import dto.Movie;


@WebServlet("/fetch-movies-id")
public class FetchMoviesById extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("enter-id.html").forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	MovieDao dao=new MovieDao();
	List<Movie> List=dao.fetchMoviesById(id);
	if(List.isEmpty()) {
		resp.getWriter().print("<h1 style='color:red' align='center'>No Movies found</h1>");
		req.getRequestDispatcher("home.html").forward(req, resp);
	}else {
		req.setAttribute("list", List);
		req.getRequestDispatcher("fetch.jsp").forward(req, resp);
	}
	}
}
