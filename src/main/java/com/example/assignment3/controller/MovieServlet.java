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
import java.util.Objects;

@WebServlet(name="movieServlet", value = "/movies/*")
public class MovieServlet extends HttpServlet {
    private MovieDao movieDao;

    public void init(){
        movieDao = new MovieDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        addMovie(req,resp);
//        String action = req.getParameter("action");
//        if(Objects.equals(action, "browse")){
//            listMovies(req,resp);
//        }
//        else if(Objects.equals(action,"addNewMovie")){
//            showNewForm(req,resp);
//        }
//        else{
//            System.out.println("addMovie in doPost");
//            addMovie(req,resp);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("movieLanding.jsp");
        dispatcher.forward(request, response);
    }

//    private void addMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String title = request.getParameter("title");
//        String genre = request.getParameter("genre");
//        String director = request.getParameter("director");
//        int releaseYear = Integer.parseInt(request.getParameter("release_year"));
//        Movie newMovie = new Movie(title, genre, director, releaseYear);
//        movieDao.addMovie(newMovie);
//        response.sendRedirect("movies");
//    }
////
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
//        RequestDispatcher dispatcher = request.getRequestDispatcher("addMovie.jsp");
//        dispatcher.forward(request, response);
//    }
////
//    private void listMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
//        List<Movie> listMovies = movieDao.getAllMovies();
//        System.out.println(listMovies);
//        request.setAttribute("listMovies", listMovies);
//        System.out.println("here");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("browseMovies.jsp");
//        dispatcher.forward(request, response);
//    }
}
