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
}
