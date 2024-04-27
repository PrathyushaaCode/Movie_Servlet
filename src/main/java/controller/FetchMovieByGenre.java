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

@WebServlet("/fetch-genre")
public class FetchMovieByGenre extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("fetch-by-genre.html").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String genre=req.getParameter("genre");
		MovieDao dao=new MovieDao();
		List<Movie> list=dao.fetchMoviesByGenre(genre);
		if(list.isEmpty())
		{
			resp.getWriter().print("<h1 style='colour:red' align:'center'>No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("fetch.jsp").forward(req, resp);
		}
	}
}
