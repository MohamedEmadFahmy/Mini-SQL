// Generated from d:/Semester 6/Databases 2/Projects/Project 1/database-system/src/main/java/com/halberdski/antlr4/BasicSQL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicSQLParser}.
 */
public interface BasicSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(BasicSQLParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(BasicSQLParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#helloWorld}.
	 * @param ctx the parse tree
	 */
	void enterHelloWorld(BasicSQLParser.HelloWorldContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#helloWorld}.
	 * @param ctx the parse tree
	 */
	void exitHelloWorld(BasicSQLParser.HelloWorldContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(BasicSQLParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(BasicSQLParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(BasicSQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(BasicSQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(BasicSQLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(BasicSQLParser.ConditionContext ctx);
}