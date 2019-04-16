import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("This is working");

            String name = request.getParameter("name");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello, World, and " + name + "!</h1>" +
                    "<p>Welcome to the home page of my super awesome website</p>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, World!</h1>" +
                "<p>Welcome to the home page of my super awesome website.</p>" +
                "<p>This is your email: " + email);
    }

}
