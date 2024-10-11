package com.example.assignment3.controller;

import com.example.assignment3.dao.MovieDao;
import com.example.assignment3.model.Movie;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="handleMovieLandingServlet",value = "/handleMovieLanding")
public class HandleMovieLandingServlet extends HttpServlet {
    private MovieDao movieDao;

    @Override
    public void init() throws ServletException {
        movieDao = new MovieDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        switch (action) {
            case "browse":
                listMovies(req, resp);
                break;
            case "search":
                showSearchForm(req, resp);
                break;
            case "src":
                searchMovies(req,resp);
                break;
            case "addNewMovie":
                showNewForm(req, resp);
                break;
            default:
                System.out.println("addMovie req in post");
                addMovie(req, resp);
                break;
        }
    }


    private void showSearchForm(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchMovies.jsp");
        dispatcher.forward(req, resp);
    }

    private void searchMovies(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        String category = req.getParameter("category");
        String keyword = req.getParameter("keyword");

        List<Movie> movies = movieDao.searchForMovies(category,keyword);
        req.setAttribute("listMovies", movies);
        RequestDispatcher dispatcher = req.getRequestDispatcher("browseMovies.jsp");
        dispatcher.forward(req, resp);
    }

    private void addMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addMovie req,resp");
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String director = request.getParameter("director");
        int releaseYear = Integer.parseInt(request.getParameter("release_year"));
        Movie newMovie = new Movie(title, genre, director, releaseYear);
        movieDao.addMovie(newMovie);
        listMovies(request,response);
//        response.sendRedirect("");
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("addMovie.jsp");
        dispatcher.forward(request, response);
    }
    //
    private void listMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        List<Movie> listMovies = movieDao.getAllMovies();
        System.out.println(listMovies);
        request.setAttribute("listMovies", listMovies);
        System.out.println("here");
        RequestDispatcher dispatcher = request.getRequestDispatcher("browseMovies.jsp");
        dispatcher.forward(request, response);
    }
}
