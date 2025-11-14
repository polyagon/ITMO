package org.example.table;

import java.io.Serializable;
import java.util.ArrayList;
import org.example.table.TableRow;

public class Table implements Serializable {
    private ArrayList<TableRow> tableRows;

    public Table() {
        tableRows = new ArrayList<>();
    }

    public ArrayList<TableRow> getTableRows() {
        return tableRows;
    }
}