package com.halberdski.antlr4;

// Generated from BasicSQL.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link BasicSQLParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(BasicSQLParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(BasicSQLParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(BasicSQLParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(BasicSQLParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(BasicSQLParser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(BasicSQLParser.LiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnList(BasicSQLParser.ColumnListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnList(BasicSQLParser.ColumnListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicSQLParser#valueList}.
	 * @param ctx the parse tree
	 */
	void enterValueList(BasicSQLParser.ValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicSQLParser#valueList}.
	 * @param ctx the parse tree
	 */
	void exitValueList(BasicSQLParser.ValueListContext ctx);
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