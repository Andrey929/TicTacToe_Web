package Servlet;

import Sourse.Field;
import Sourse.Figure;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name ="Logic1vs1",value = "/logic1vs1")
public class Logic1vs1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Получаем объект игрового поля из сессии
        Field field = LogicHelp.extractField(session);
        int index = LogicHelp.getSelectedIndex(req);
        int step = (int) session.getAttribute("step");

        Figure figure = field.getField().get(index);

        if (figure != Figure.EMPTY) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/1vs1Page.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        if (step <9) {
            if (step % 2 == 0) {
                field.getField().put(index, Figure.CROSS);
            } else {
                field.getField().put(index, Figure.NOUGHT);
            }
        }

        // Считаем список значков
        List<Figure> data = field.getFieldData();
        step++;


        // Обновляем объект поля и список значков в сессии
        session.setAttribute("data", data);
        session.setAttribute("field", field);
        session.setAttribute("step", step);

        resp.sendRedirect("/1vs1Page.jsp");
    }
}
