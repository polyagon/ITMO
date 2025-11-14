package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.table.Table;
import org.example.table.TableRow;
import org.json.JSONArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ControllerServlet", urlPatterns="/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log(request.toString());
        // Если запрос содержит параметры координат - делегируем AreaCheckServlet
        if (checkArgumentExists(request)) {
            getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
        } 
        // Если запрос на получение таблицы (для AJAX)
        else if (checkGetTableRequest(request)) {
            response.setContentType("application/json");
            HttpSession session = request.getSession();
            if (session.getAttribute("table") == null){
                session.setAttribute("table", new Table());
            }
            Table table = (Table) session.getAttribute("table");
            List<TableRow> rows = table.getTableRows();
            PrintWriter out = response.getWriter();
            out.print(new JSONArray(rows));
            out.close();
            response.setStatus(HttpServletResponse.SC_OK);
        } 
        // Иначе перенаправляем на JSP с формой
        else {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkArgumentExists(request)) {
            getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
        } else {
            response.sendError(400, "Bad Request");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(checkCleanRequest(request)){
            PrintWriter out = response.getWriter();
            request.getSession().invalidate();
            out.print("Success");
            out.close();
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.sendError(400, "Bad Request");
        }

    }


    private boolean checkCleanRequest(HttpServletRequest req) {
        return "true".equals(req.getParameter("clean"));
    }

    private void cleanTable(HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        currentSession.setAttribute("table", new Table());
    }

    private boolean checkArgumentExists(HttpServletRequest request) {
        return request.getParameter("x") != null &&
                request.getParameter("y") != null &&
                request.getParameter("r") != null &&
                request.getParameter("offset") != null;
    }

    private boolean checkGetTableRequest(HttpServletRequest request) {
        return "true".equals(request.getParameter("getTable"));
    }
}