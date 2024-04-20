package com.halberdski.antlr4;

import java.util.Hashtable;
import java.util.Vector;

import org.antlr.v4.runtime.tree.ParseTree;

import com.halberdski.engine.DBApp;
import com.halberdski.exceptions.DBAppException;

public class Controller extends BasicSQLBaseListener {

    @Override
    public void enterSelectStatement(BasicSQLParser.SelectStatementContext ctx) {
        System.out.println("Entering selectStatement: " + ctx.toStringTree());
    }

    @Override
    public void enterInsertStatement(BasicSQLParser.InsertStatementContext ctx) throws RuntimeException {
        // System.out.println("Entering insertStatement: " + ctx.toStringTree());
        String tableName = ctx.tableName().getText();

        Vector<String> columnNames = new Vector<String>();

        for (int i = 0; i < ctx.columnNameList().getChildCount(); i++) {
            if (ctx.columnNameList().getChild(i).getChildCount() > 0) {
                columnNames.add(ctx.columnNameList().getChild(i).getText());
            }
        }

        Vector<Object> columnValues = new Vector<Object>();

        for (int i = 0; i < ctx.valueList().getChildCount(); i++) {
            ParseTree child = ctx.valueList().getChild(i);

            if (child.getChildCount() > 0) {
                String subChild = child.getChild(0).getText();

                // System.out.println(subChild);

                if (subChild.contains("'")) {
                    columnValues.add(subChild.substring(1, subChild.length() - 1));
                    continue;
                }
                try {
                    Integer integer = Integer.parseInt(subChild);
                    columnValues.add(integer);
                    continue;
                } catch (Exception e) {
                    // TODO: handle exception
                }
                try {
                    Boolean bool = Boolean.parseBoolean(subChild);
                    columnValues.add(bool);
                    continue;
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }

        if (columnNames.size() != columnValues.size()) {
            throw new RuntimeException("Column Names and Values do not match");
        }

        try {
            Hashtable<String, Object> colNameVal = new Hashtable<>();

            for (int i = 0; i < columnNames.size(); i++) {
                colNameVal.put(columnNames.get(i), columnValues.get(i));
            }

            DBApp dbApp = new DBApp();
            dbApp.insertIntoTable(tableName, colNameVal);
        } catch (DBAppException e) {
            throw new RuntimeException(e.getMessage());
        }

        // System.out.println("Table Name: " + tableName);
        // System.out.println("Column Names: " + columnNames);
        // System.out.println("Column Values: " + columnValues);

    }

    @Override
    public void enterCreateTableStatement(BasicSQLParser.CreateTableStatementContext ctx) {
        String tableName = ctx.tableName().getText(); // Get the table name
        Hashtable<String, String> colNameType = new Hashtable<String, String>();
        String primaryKeyColumn = null;

        // System.out.println(ctx.toStringTree());

        for (int i = 0; i < ctx.tableDefinition().getChildCount(); i++) {
            if (ctx.tableDefinition().getChild(i).getChildCount() > 0) {
                ParseTree columnEntry = ctx.tableDefinition().getChild(i);
                // System.out.println(ctx.tableDefinition().getChild(i).getText());

                String columnName = columnEntry.getChild(0).getText();
                String dataType = columnEntry.getChild(1).getText();

                if (dataType.toLowerCase().equals("int")) {
                    colNameType.put(columnName, "java.lang.Integer");
                } else if (dataType.toLowerCase().equals("varchar")) {
                    colNameType.put(columnName, "java.lang.String");
                } else if (dataType.toLowerCase().equals("float")) {
                    colNameType.put(columnName, "java.lang.Double");
                } else {
                    throw new RuntimeException("Unsupported Data Type");
                }

                if (columnEntry.getChildCount() > 2) {
                    if (primaryKeyColumn == null) {
                        primaryKeyColumn = columnName;
                    } else {
                        throw new RuntimeException("Multiple Primary Keys");
                    }
                }
            }
        }
        // System.out.println(tableName);
        // System.out.println(colNameType);
        // System.out.println(primaryKeyColumn);

        try {
            DBApp dbApp = new DBApp();
            dbApp.createTable(tableName, primaryKeyColumn, colNameType);
        } catch (DBAppException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void enterCreateIndexStatement(BasicSQLParser.CreateIndexStatementContext ctx) {
        System.out.println("Entering CreateIndexStatement: " + ctx.toStringTree());
    }

    @Override
    public void enterDeleteStatement(BasicSQLParser.DeleteStatementContext ctx) {
        System.out.println("Entering DeleteStatement: " + ctx.toStringTree());
    }

    @Override
    public void enterUpdateStatement(BasicSQLParser.UpdateStatementContext ctx) {
        System.out.println("Entering UpdateStatement: " + ctx.toStringTree());
    }

    public static void main(String[] args) {
        // QueryTester.testQuery("select * from mytable where name = 5;");
        // QueryTester.testQuery("CREATE INDEX ta ON tableName (column1);");

        // QueryTester.testQuery("insert into mytable (name, age) values ('mo', 5);");
        QueryTester.testQuery("CREATE TABLE moski (age INT, name VARCHAR primary key);");
    }
}
