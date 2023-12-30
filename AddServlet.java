package com.example.servletdemo;

import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class AddServlet extends HttpServlet {

    /*
        service method works with GET and POST both
        doPost method works on with POST request
        When the form is submitted with the POST method, the doPost method of your servlet is called.
        servlet retrieve the form data from the request body of HTTPRequest, and you use the request.getParameter method in the same way as with the GET method.
    */
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        addNumbers(request, response);
    }

    /*
        doGet method works wit GET request
        When you use the GET method in your servlet (doGet method), the servlet can retrieve these parameters from the URL and process them.
        In servlet, you use request.getParameter("num1") and request.getParameter("num2") to get the values of num1 and num2 from the URL.
    */
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        int addition = addNumbers(request, response);

        /*
            to send data from AddServlet to SquareServlet we can use session management
            but here we will simply use setAttribute method of request object as we are passing same request object to SquareServlet
            here result is key and addition is value
        */
//        request.setAttribute("result", addition);

        /*
            We can call one servlet from another servlet using RequestDispatcher or Redirect
            square here is url
        */
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("square");
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException | IOException e) {
//            System.out.println(e);
//        }




        /*
            RequestDispatcher is usually used if both servlet belongs to same website. But if servlet is from e.g. abc.com and another is pqr.com then we need to use Redirect
            as there are two different servlet we have two different request and response
            hence we cannot simply use setAttribute of request object here
            for forwarding the value here, we need to use session management
        */
//        try {
//            response.sendRedirect("square?result="+addition);  // this technique is called URL Rewriting
//        } catch (IOException e) {
//            System.out.println(e);
//        }




        /*
            HttpSession
            If we want to pass multiple data or maintain the data throughout the session
        */
//        HttpSession session = request.getSession();
//        session.setAttribute("result",addition);
//        try {
//            response.sendRedirect("square");
//        } catch (IOException e) {
//            System.out.println(e);
//        }




        /*
            Cookies
            whenever you send request to server and server sends response back, that response object will have a cookie
            this cookie can be sent again to SquareServlet
            session will get timeout after sometime
            however here there is a token called as cookie which does not timeout
        */

        Cookie cookie = new Cookie("result", String.valueOf(addition));
        response.addCookie(cookie);
        try {
            response.sendRedirect("square");
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    private static int addNumbers(HttpServletRequest request, HttpServletResponse response) {
        int number1 = Integer.parseInt(request.getParameter("num1"));
        int number2 = Integer.parseInt(request.getParameter("num2"));
        PrintWriter printWriter = null;

        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            System.out.println(e);
        }

        printWriter.println("result " + (number1 + number2));
        return number1+number2;
    }
}