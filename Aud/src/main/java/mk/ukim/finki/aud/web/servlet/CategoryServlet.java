package mk.ukim.finki.aud.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.aud.model.Category;
import mk.ukim.finki.aud.service.CategoryService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "category-servlet",urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService;
    public CategoryServlet(CategoryService categoryService){
        this.categoryService=categoryService;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAdress=req.getRemoteAddr();
        String clientAgent=req.getHeader("User-Agent");
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>User Info</h3>");
        out.format("Ip adress %s </br>",ipAdress);
        out.format("Client agent %s",clientAgent);
        out.println("<h3>Category List</h3>");
        out.println("<ul>");
        categoryService.listCategories().forEach(r ->out.format("<li>%s (%s)</li>",r.getName(),r.getDescription()));

        out.println("</ul>");
        out.println("<h3>Add Category</h3>");
        out.println("<form method='POST' action='/servlet/category'>");
        out.println("<label for='name'>Name:</label>");
        out.println("<input id='name' type='text' name='name'/>");
        out.println("<label for='desc'>Description:</label>");
        out.println("<input id='desc' type='text' name='desc'/>");
        out.println("<input type='submit' value'Submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String categoryName=req.getParameter("name");
        String categoryDesc=req.getParameter("desc");
        categoryService.create(categoryName,categoryDesc);
        resp.sendRedirect("/servlet/category");
    }


}
