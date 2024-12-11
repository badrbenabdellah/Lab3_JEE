package ma.fstt.ejbprovider;

import java.io.*;

import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.fstt.ejbcontainer.HelloLocal;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @EJB(lookup = "java:global/ejbprovider-1.0-SNAPSHOT/HelloImpl!ma.fstt.ejbcontainer.HelloLocal")
    HelloLocal myejb ;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + myejb.sayHello("My Servlet consumption") + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}