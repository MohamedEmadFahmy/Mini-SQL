package com.halberdski.antlr4;

public class YourCustomListener extends BasicSQLBaseListener {

    @Override
    public void enterSqlStatement(BasicSQLParser.SqlStatementContext ctx) {
        // System.out.println("Entering sqlStatement: " + ctx.getText());
        System.out.println(ctx.toStringTree());
    }
}
