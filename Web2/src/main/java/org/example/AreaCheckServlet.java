package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import org.example.table.Table;
import org.example.table.TableRow;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(name="AreaCheckServlet", urlPatterns="/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getDispatcherType().name().equals("FORWARD")) {
            resp.sendError(403, "You don't have access rights to this resource");
            return;
        }
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkPoint(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkPoint(request, response);
    }

    private void checkPoint(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long currentTime = System.currentTimeMillis();
        boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

        try {
            float x = Float.parseFloat(request.getParameter("x"));
            float y = Float.parseFloat(request.getParameter("y"));
            float r = Float.parseFloat(request.getParameter("r"));
            long offset = -Long.parseLong(request.getParameter("offset"));

            if (!validatePoint(x, y, r)) {
                response.sendError(400, "Transmitted values are not valid");
                return;
            }

            Instant clientTime = Instant.now().truncatedTo(ChronoUnit.MILLIS).plus(offset, ChronoUnit.MINUTES);
            boolean result = checkArea(x,y,r);

            double scriptWorkingTime = System.currentTimeMillis() - currentTime;
            HttpSession session = request.getSession();

            TableRow newRow = new TableRow(x, y, r, result, clientTime.toString(), scriptWorkingTime);

            if (session.getAttribute("table") == null){
                session.setAttribute("table", new Table());
            }

            Table sessionTable = (Table) request.getSession().getAttribute("table");
            sessionTable.getTableRows().add(newRow);

            // Если это AJAX запрос, возвращаем JSON (для обратной совместимости с существующим кодом)
            if (isAjax) {
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.print(new JSONObject(newRow));
                out.close();
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                // Для обычных запросов форвардим на JSP-страницу с результатами
                request.setAttribute("result", newRow);
                request.getRequestDispatcher("/result.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendError(400, "Transmitted values are not numeric");
        } catch (IOException e) {
            response.sendError(418, "Unidentified error");
        }
    }

    private boolean checkArea(float x, float y, float r){
        return  ( x <= 0 && y <= 0 && Math.sqrt(x * x + y * y) <= r/2) ||
                ( x >= 0 && y <= 0 && x <= r && y >= -1*r/2 ) ||
                ( x <= 0 && y >= 0 && y <= (x + r)/2 );
    }

    private boolean validatePoint(float x, float y, float r){
        return (x >= -3 && x <= 5) && (y >= -5 && y <= 3) && (r >= 1 && r <= 3);
    }
}