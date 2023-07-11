package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Category;
import model.Product;
import model.User;
import DAO.*;

/**
 *
 * @author PC
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

//        Lay gia tri input nhap vao
        String xUsername = request.getParameter("username");
        String xPass = request.getParameter("password");

//        khai bao User va UserDAO
        User x;
        UserDAO t = new UserDAO();

//      Từ input nhập vào sẽ lấy ra user tương ứng và set cho user đó 
//      là người cùng hiện tại (curUser) bằng getSession() 
        x = t.getUser(xUsername, xPass);
        request.getSession().setAttribute("currUser", x);

//        Nếu không tìm ra ai sẽ quay lại trang login cùng với thông báo 
        if (x == null) {
            request.setAttribute("status", "Sorry, username and/or password are/is invalid!");
            request.getRequestDispatcher("Login.jsp").include(request, response);
        } else {
//            Nếu có thì sẽ chuyển tiếp sang trang home.jsp 
//          Khai bao ProductDao và CategoryDAO
            ProductDAO u = new ProductDAO();
            CategoryDAO c = new CategoryDAO();

//            In ra list cac san pham
            List<Product> lst = u.getProducts();
            request.setAttribute("lst", lst);

//            In ra list 5 san pham moi nha
            List<Product> lst5 = u.getNewestProductsBy5();
            request.setAttribute("lst5", lst5);

//            in ra list Category (loai san pham)
            List<Category> lstc = c.getCategorys();
            request.setAttribute("lstc", lstc);

            request.getRequestDispatcher("home.jsp").include(request, response);

        }
    }
}
