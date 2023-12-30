# Servlet Demo

This repository contains a simple Java servlet demo showcasing a basic web application that performs addition and displays the square of the result.

## Servlets

### AddServlet

The `AddServlet` class is a Java servlet that handles both GET and POST requests. It retrieves two numbers from the request parameters, performs addition, and prints the result. It also demonstrates different ways to pass the result to another servlet (`SquareServlet`) using RequestDispatcher, URL Rewrite, HttpSession, and Cookies.

### SquareServlet

The `SquareServlet` class is another Java servlet that retrieves the addition result and displays both the addition and its square.

## JSP Page

### index.jsp

The `index.jsp` file contains a simple HTML form that allows users to input two numbers. It uses the GET method to submit the form to the `AddServlet`. Change the get method of this form to post and observe the url of the web app.

## Configuration

### web.xml

The `web.xml` file configures servlets and their mappings. It specifies that `AddServlet` handles requests at "/add" and `SquareServlet` at "/square".
```xml
 <servlet>
        <servlet-name>AddServlet</servlet-name>
        <servlet-class>com.example.servletdemo.AddServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>AddServlet</servlet-name>
        <url-pattern>/add</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>SquareServlet</servlet-name>
        <servlet-class>com.example.servletdemo.SquareServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>SquareServlet</servlet-name>
        <url-pattern>/square</url-pattern>
    </servlet-mapping>


