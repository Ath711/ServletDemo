package com.example.servletdemo;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class SquareServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int addition =0;

        /* when using RequestDispatcher
           to fetch values from request object we can use getAttribute method of request object
        addition = (int) request.getAttribute("result");
        */


        /* when using URL Rewriting
            we cannot use getAttribute now as we are not passing the value from request object
            as we are passing the value in URL we can use getParameter to fetch it
        addition = Integer.parseInt(request.getParameter("result"));
        */


        /* when using HttpSession
        HttpSession session = request.getSession();
        try {
            addition = (int) session.getAttribute("result");
        }
        catch (NullPointerException e){
            printWriter.println("session timeout \n" + e);
        }
        session.removeAttribute("result"); // this will delete the value obtained from session, comment this code if you don't want the session to delete the value after page refresh, causing null pointer exception
        */

        Cookie cookies[] = request.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equals("result"))
                addition = Integer.parseInt(c.getValue());
        }

        printWriter.println("Addition is " + addition + " Square is " + addition*addition);
    }
}
