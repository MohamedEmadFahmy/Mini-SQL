package com.halberdski.antlr4;

public class YourCustomListener extends BasicSQLBaseListener {

    @Override
    public void enterSelectStatement(BasicSQLParser.SelectStatementContext ctx) {
        System.out.println("Entering selectStatement: " + ctx.toStringTree());
    }

    @Override
    public void enterInsertStatement(BasicSQLParser.InsertStatementContext ctx) {
        System.out.println("Entering insertStatement: " + ctx.toStringTree());
    }

    @Override
    public void enterCreateTableStatement(BasicSQLParser.CreateTableStatementContext ctx) {
        System.out.println("Entering CreateTableStatement: " + ctx.toStringTree());
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
}
