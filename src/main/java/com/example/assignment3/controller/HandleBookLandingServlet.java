package com.example.assignment3.controller;

import com.example.assignment3.dao.BookDao;
import com.example.assignment3.model.Book;
import com.example.assignment3.model.Movie;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="handleBookLandingServlet",value = "/handleBookLanding")
public class HandleBookLandingServlet extends HttpServlet {

    private BookDao bookDao;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            switch(action){
                case "add":
                    addBooks(req,resp);
                    break;
                case "addBooks":
                    showNumberOfBooks(req,resp);
                    break;
                case "numBooks":
                    generateBookForms(req,resp);
                    break;
                default:
                    listBooks(req,resp);
                    break;
            }
    }

    private void showNumberOfBooks(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("addBooks.jsp");
        dispatcher.forward(req,resp);
    }

    private void generateBookForms(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        String num = req.getParameter("numberOfBooks");
        req.setAttribute("numberOfBooks",Integer.valueOf(num));
        RequestDispatcher dispatcher = req.getRequestDispatcher("bookForms.jsp");
        dispatcher.forward(req,resp);
    }

    private void listBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        List<Book> listBooks = bookDao.getAllBooks();
        req.setAttribute("listBooks", listBooks);
        RequestDispatcher dispatcher = req.getRequestDispatcher("browseBooks.jsp");
        dispatcher.forward(req,resp);
    }

    private void addBooks(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
        int i =0;
        while(true){
            String isbn = req.getParameter("isbn"+i);
            String author = req.getParameter("author"+i);
            String title = req.getParameter("title"+i);
            String price = req.getParameter("price"+i);

            if(isbn == null || author==null || title==null || price==null)
                break;

            Float fprice = Float.parseFloat(price);

            bookDao.addBook(new Book(isbn,title,author,fprice));
            i++;
        }
        listBooks(req,resp);
    }
}
