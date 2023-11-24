package Servlet;

import Sourse.Field;
import Sourse.Figure;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InitServlet",value = "/main")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Field field = new Field();
        List<Figure> figures = field.getFieldData();
        int step = 0;
        session.setAttribute("field",field);
        session.setAttribute("data",figures);
        session.setAttribute("step",step);
//        getServletContext().getRequestDispatcher("/1vsPC.jsp").forward(req, resp);
        dropPage(req,resp);
    }
    private int getParameter(HttpServletRequest request){
        int indexPos = 0;
        try {
            indexPos = Integer.parseInt(request.getParameter("pos"));
        }catch (Exception e){
            return 0;
        }
        if (indexPos == 1 || indexPos == 2) {
            return indexPos;
        }else return 0;

    }
    private void dropPage(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int index = getParameter(request);
        if (index == 0){
            getServletContext().getRequestDispatcher("/helloPage.jsp").forward(request,resp);
        }else if (index == 1) {
            getServletContext().getRequestDispatcher("/1vsPC.jsp").forward(request, resp);
        }else if (index == 2) {
            getServletContext().getRequestDispatcher("/1vs1Page.jsp").forward(request, resp);
        }
    }
}
