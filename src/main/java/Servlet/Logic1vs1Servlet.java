package Servlet;

import Sourse.Field;
import Sourse.Figure;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Logic1vs1Servlet",value = "/logic")
public class Logic1vs1Servlet extends HttpServlet implements TicTacToe{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Получаем объект игрового поля из сессии
        Field field = LogicHelp.extractField(session);
        int index = LogicHelp.getSelectedIndex(req);
        int step = (int) session.getAttribute("step");

        Figure figure = field.getField().get(index);

        if (figure != Figure.EMPTY) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/1vsPC.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        field.getField().put(index, Figure.CROSS);
        System.out.println(field.getEmptyFieldIndex());
        if (step<4) {
            field = computerResponse(field, index);
        }

        // Считаем список значков
        List<Figure> data = field.getFieldData();
        step++;


        // Обновляем объект поля и список значков в сессии
        session.setAttribute("data", data);
        session.setAttribute("field", field);
        session.setAttribute("step", step);

        resp.sendRedirect("/1vsPC.jsp");

    }


    private Field computerResponse(Field field, int xIndex){
        int[] index = getIndexComputerResponse(xIndex);
        int count = 0;
        do {
            count++;
        }while (field.getField().get(index[count]) != Figure.EMPTY);
        field.getField().put(index[count],Figure.NOUGHT);
        return field;
    }
    private int[] getIndexComputerResponse(int xIndex){
        switch (xIndex){
            case 0 -> {
                return new int[]{4,2,1,8,3,5,6,7,0};
            }
            case 1->{
                return new int[]{7,8,0,4,6,5,3,2,1};
            }
            case 2->{
                return new int[]{6,3,1,8,2,0,4,5,7};
            }
            case 3-> {
                return new int[]{7,5,4,1,6,3,4,2,0};
            }
            case 5 ->{
                return new int[]{6,4,3,1,5,0,2,7,8};
            }
            case 6 ->{
                return new int[]{1,3,2,0,7,4,5,6,8};
            }
            case 7 ->{
                return new int[]{4,1,3,5,0,2,6,7,8};
            }
            case 4 ->{
                return new int[]{0,2,1,8,6,2,3,5,4,7};
            }
            case 8 ->{
                return new int[]{6,3,7,0,1,5,4,2,8};
            }
            default -> {
                return new int[]{0};
            }
        }
    }
}