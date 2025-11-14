

<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.table.TableRow" %>
<%@ page import="org.example.table.Table" %>
<jsp:useBean id="table" scope="session" beanName="org.example.table.Table" type="org.example.table.Table"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    String tableRowToHtml(TableRow tableRow) {
        if (tableRow == null) return "";
        return "<tr>" +
                "<td>" + tableRow.getX() + "</td>" +
                "<td>" + tableRow.getY() + "</td>" +
                "<td>" + tableRow.getR() + "</td>" +
                "<td>" + tableRow.getClientDate() + "</td>" +
                "<td>" + tableRow.getScriptWorkingTime() + " ms</td>" +
                "<td>" + tableRow.isHit() + "</td>" +
                "</tr>";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="source/css/main.css">
        <title>Лабораторная работа №2</title>
    </head>

    <body>
        <div class="head">
            <header class="element">
                <h1>Polina Kozitskaja 408809</h1>
            </header>
        </div>
        <div class="all">
            <div class="main-container">
                <div class="input-container">
                    <div class="input_XYR element">
                        <label for="X_input" class="input_text">Input X:</label>
                        <label>
                            <select id="X_input">
                                <option value="-3">-3</option>
                                <option value="-2">-2</option>
                                <option value="-1">-1</option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </select>
                        </label>
                    </div>

                    <div class="input_XYR element">
                        <label for="Y_input" class="input_text">Input Y:</label>
                        <label>
                            <input required name="Y-input" id="Y_input" type="text" placeholder="-5..3" class="input">
                        </label>
                    </div>

                    <div class="input_XYR element">
                        <label for="R_table" class="input_text">Choose R:</label>
                        <div class="R_table_container" id="R_table">
                            <div class="r-radio" >
                                <input class="r" name="r" type="radio" value="1" !checked /> <label>1</label>
                                <input class="r" name="r" type="radio" value="1.5" !checked /> <label>1.5</label>
                                <input class="r" name="r" type="radio" value="2" !checked /> <label>2</label>
                                <input class="r" name="r" type="radio" value="2.5" !checked /> <label>2.5</label>
                                <input class="r" name="r" type="radio" value="3" !checked /> <label>3</label>
                            </div>
                        </div>
                    </div>

                    <div class="canvas-container element" id="canvas-container">
                        <canvas id="graph_canvas" width="400" height="400"></canvas>
                    </div>
                </div>
                <div class="button-container">
                    <button type="button" class="buttons" id="check_button" disabled="true">Check</button>
                    <button type="button" class="buttons" id="clear_button">Clear</button>
                </div>
            </div>
                <table id="results-table">
                    <thead>
                        <tr>
                            <th width="5%">X</th>
                            <th width="5%">Y</th>
                            <th width="5%">R</th>
                            <th width="45%">Current Time</th>
                            <th width="20%">Script Time(ms)</th>
                            <th width="20%">Result</th>
                        </tr>
                    </thead>
                    <tbody id="results-content">
                    </tbody>
                </table>
            </div>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <script src="source/js/main.js"></script>
        <script src="source/js/canvas.js"></script>
        <script src="source/js/communication.js"></script>
        <script src="source/js/validator.js"></script>
        <script src="source/js/tableWorker.js"></script>
    </body>
</html>