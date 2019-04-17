import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    int counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("<h1>Hello, World!</h1>");


        counter ++;
        String name = req.getParameter("name");
        if (name == null) name = "World";


        req.setAttribute("name", name);
        req.setAttribute("counter", counter);
        req.getRequestDispatcher("/profile.jsp").forward(req, res);





    }
}
