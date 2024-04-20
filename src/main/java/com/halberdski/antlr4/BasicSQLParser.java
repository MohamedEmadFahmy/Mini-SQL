package com.halberdski.antlr4;

// Generated from BasicSQL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BasicSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, SEMICOLON=4, SELECT=5, STAR=6, FROM=7, WHERE=8, 
		INSERT=9, INTO=10, VALUES=11, LOGICAL_OPERATOR=12, CREATE=13, TABLE=14, 
		INDEX=15, ON=16, DELETE=17, UPDATE=18, SET=19, INTTYPE=20, FLOATTYPE=21, 
		VARCHARTYPE=22, PRIMARYKEY=23, BOOLEAN=24, ID=25, STRING=26, NUMBER=27, 
		INT=28, DOT=29, DECIMAL=30, OPERATOR=31, EQUAL=32, WS=33, DIGIT=34;
	public static final int
		RULE_sqlStatement = 0, RULE_selectStatement = 1, RULE_insertStatement = 2, 
		RULE_createTableStatement = 3, RULE_createIndexStatement = 4, RULE_deleteStatement = 5, 
		RULE_updateStatement = 6, RULE_updateSetClause = 7, RULE_updateWhereClause = 8, 
		RULE_tableDefinition = 9, RULE_columnConstraint = 10, RULE_columnName = 11, 
		RULE_literalValue = 12, RULE_columnNameList = 13, RULE_valueList = 14, 
		RULE_tableName = 15, RULE_condition = 16, RULE_updateCondition = 17, RULE_columnDefinition = 18, 
		RULE_dataType = 19, RULE_indexName = 20, RULE_deleteCondition = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlStatement", "selectStatement", "insertStatement", "createTableStatement", 
			"createIndexStatement", "deleteStatement", "updateStatement", "updateSetClause", 
			"updateWhereClause", "tableDefinition", "columnConstraint", "columnName", 
			"literalValue", "columnNameList", "valueList", "tableName", "condition", 
			"updateCondition", "columnDefinition", "dataType", "indexName", "deleteCondition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "';'", null, "'*'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'.'", null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "SEMICOLON", "SELECT", "STAR", "FROM", "WHERE", 
			"INSERT", "INTO", "VALUES", "LOGICAL_OPERATOR", "CREATE", "TABLE", "INDEX", 
			"ON", "DELETE", "UPDATE", "SET", "INTTYPE", "FLOATTYPE", "VARCHARTYPE", 
			"PRIMARYKEY", "BOOLEAN", "ID", "STRING", "NUMBER", "INT", "DOT", "DECIMAL", 
			"OPERATOR", "EQUAL", "WS", "DIGIT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BasicSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqlStatementContext extends ParserRuleContext {
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public InsertStatementContext insertStatement() {
			return getRuleContext(InsertStatementContext.class,0);
		}
		public CreateTableStatementContext createTableStatement() {
			return getRuleContext(CreateTableStatementContext.class,0);
		}
		public CreateIndexStatementContext createIndexStatement() {
			return getRuleContext(CreateIndexStatementContext.class,0);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public UpdateStatementContext updateStatement() {
			return getRuleContext(UpdateStatementContext.class,0);
		}
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterSqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitSqlStatement(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlStatement);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				selectStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				insertStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				createTableStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				createIndexStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				deleteStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				updateStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(BasicSQLParser.SELECT, 0); }
		public TerminalNode STAR() { return getToken(BasicSQLParser.STAR, 0); }
		public TerminalNode FROM() { return getToken(BasicSQLParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(BasicSQLParser.WHERE, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicSQLParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(BasicSQLParser.EOF, 0); }
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(BasicSQLParser.LOGICAL_OPERATOR); }
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(BasicSQLParser.LOGICAL_OPERATOR, i);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(SELECT);
			setState(53);
			match(STAR);
			setState(54);
			match(FROM);
			setState(55);
			tableName();
			setState(56);
			match(WHERE);
			setState(57);
			condition();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(58);
				match(LOGICAL_OPERATOR);
				setState(59);
				condition();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(SEMICOLON);
			setState(66);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InsertStatementContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(BasicSQLParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(BasicSQLParser.INTO, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnNameListContext columnNameList() {
			return getRuleContext(ColumnNameListContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(BasicSQLParser.VALUES, 0); }
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicSQLParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(BasicSQLParser.EOF, 0); }
		public InsertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterInsertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitInsertStatement(this);
		}
	}

	public final InsertStatementContext insertStatement() throws RecognitionException {
		InsertStatementContext _localctx = new InsertStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_insertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(INSERT);
			setState(69);
			match(INTO);
			setState(70);
			tableName();
			setState(71);
			columnNameList();
			setState(72);
			match(VALUES);
			setState(73);
			valueList();
			setState(74);
			match(SEMICOLON);
			setState(75);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(BasicSQLParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(BasicSQLParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TableDefinitionContext tableDefinition() {
			return getRuleContext(TableDefinitionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicSQLParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(BasicSQLParser.EOF, 0); }
		public CreateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterCreateTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitCreateTableStatement(this);
		}
	}

	public final CreateTableStatementContext createTableStatement() throws RecognitionException {
		CreateTableStatementContext _localctx = new CreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_createTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(CREATE);
			setState(78);
			match(TABLE);
			setState(79);
			tableName();
			setState(80);
			tableDefinition();
			setState(81);
			match(SEMICOLON);
			setState(82);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateIndexStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(BasicSQLParser.CREATE, 0); }
		public TerminalNode INDEX() { return getToken(BasicSQLParser.INDEX, 0); }
		public IndexNameContext indexName() {
			return getRuleContext(IndexNameContext.class,0);
		}
		public TerminalNode ON() { return getToken(BasicSQLParser.ON, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicSQLParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(BasicSQLParser.EOF, 0); }
		public CreateIndexStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createIndexStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterCreateIndexStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitCreateIndexStatement(this);
		}
	}

	public final CreateIndexStatementContext createIndexStatement() throws RecognitionException {
		CreateIndexStatementContext _localctx = new CreateIndexStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_createIndexStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(CREATE);
			setState(85);
			match(INDEX);
			setState(86);
			indexName();
			setState(87);
			match(ON);
			setState(88);
			tableName();
			setState(89);
			columnName();
			setState(90);
			match(SEMICOLON);
			setState(91);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteStatementContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(BasicSQLParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(BasicSQLParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicSQLParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(BasicSQLParser.EOF, 0); }
		public DeleteConditionContext deleteCondition() {
			return getRuleContext(DeleteConditionContext.class,0);
		}
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterDeleteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitDeleteStatement(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_deleteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(DELETE);
			setState(94);
			match(FROM);
			setState(95);
			tableName();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(96);
				deleteCondition();
				}
			}

			setState(99);
			match(SEMICOLON);
			setState(100);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateStatementContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(BasicSQLParser.UPDATE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SET() { return getToken(BasicSQLParser.SET, 0); }
		public UpdateSetClauseContext updateSetClause() {
			return getRuleContext(UpdateSetClauseContext.class,0);
		}
		public UpdateWhereClauseContext updateWhereClause() {
			return getRuleContext(UpdateWhereClauseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicSQLParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(BasicSQLParser.EOF, 0); }
		public UpdateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterUpdateStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitUpdateStatement(this);
		}
	}

	public final UpdateStatementContext updateStatement() throws RecognitionException {
		UpdateStatementContext _localctx = new UpdateStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_updateStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(UPDATE);
			setState(103);
			tableName();
			setState(104);
			match(SET);
			setState(105);
			updateSetClause();
			setState(106);
			updateWhereClause();
			setState(107);
			match(SEMICOLON);
			setState(108);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateSetClauseContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(BasicSQLParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(BasicSQLParser.EQUAL, i);
		}
		public List<LiteralValueContext> literalValue() {
			return getRuleContexts(LiteralValueContext.class);
		}
		public LiteralValueContext literalValue(int i) {
			return getRuleContext(LiteralValueContext.class,i);
		}
		public UpdateSetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateSetClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterUpdateSetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitUpdateSetClause(this);
		}
	}

	public final UpdateSetClauseContext updateSetClause() throws RecognitionException {
		UpdateSetClauseContext _localctx = new UpdateSetClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_updateSetClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			columnName();
			setState(111);
			match(EQUAL);
			setState(112);
			literalValue();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(113);
				match(T__0);
				setState(114);
				columnName();
				setState(115);
				match(EQUAL);
				setState(116);
				literalValue();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateWhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(BasicSQLParser.WHERE, 0); }
		public List<UpdateConditionContext> updateCondition() {
			return getRuleContexts(UpdateConditionContext.class);
		}
		public UpdateConditionContext updateCondition(int i) {
			return getRuleContext(UpdateConditionContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(BasicSQLParser.LOGICAL_OPERATOR); }
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(BasicSQLParser.LOGICAL_OPERATOR, i);
		}
		public UpdateWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterUpdateWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitUpdateWhereClause(this);
		}
	}

	public final UpdateWhereClauseContext updateWhereClause() throws RecognitionException {
		UpdateWhereClauseContext _localctx = new UpdateWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_updateWhereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(WHERE);
			setState(124);
			updateCondition();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(125);
				match(LOGICAL_OPERATOR);
				setState(126);
				updateCondition();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableDefinitionContext extends ParserRuleContext {
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public TableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterTableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitTableDefinition(this);
		}
	}

	public final TableDefinitionContext tableDefinition() throws RecognitionException {
		TableDefinitionContext _localctx = new TableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__1);
			setState(133);
			columnDefinition();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(134);
				match(T__0);
				setState(135);
				columnDefinition();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnConstraintContext extends ParserRuleContext {
		public TerminalNode PRIMARYKEY() { return getToken(BasicSQLParser.PRIMARYKEY, 0); }
		public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnConstraint(this);
		}
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_columnConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(PRIMARYKEY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSQLParser.ID, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BasicSQLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(BasicSQLParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(BasicSQLParser.BOOLEAN, 0); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitLiteralValue(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 218103808L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameListContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public ColumnNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnNameList(this);
		}
	}

	public final ColumnNameListContext columnNameList() throws RecognitionException {
		ColumnNameListContext _localctx = new ColumnNameListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_columnNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__1);
			setState(150);
			columnName();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(151);
				match(T__0);
				setState(152);
				columnName();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueListContext extends ParserRuleContext {
		public List<LiteralValueContext> literalValue() {
			return getRuleContexts(LiteralValueContext.class);
		}
		public LiteralValueContext literalValue(int i) {
			return getRuleContext(LiteralValueContext.class,i);
		}
		public ValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitValueList(this);
		}
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__1);
			setState(161);
			literalValue();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(162);
				match(T__0);
				setState(163);
				literalValue();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSQLParser.ID, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSQLParser.ID, 0); }
		public TerminalNode OPERATOR() { return getToken(BasicSQLParser.OPERATOR, 0); }
		public TerminalNode STRING() { return getToken(BasicSQLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(BasicSQLParser.NUMBER, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ID);
			setState(174);
			match(OPERATOR);
			setState(175);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateConditionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSQLParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(BasicSQLParser.EQUAL, 0); }
		public TerminalNode STRING() { return getToken(BasicSQLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(BasicSQLParser.NUMBER, 0); }
		public UpdateConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterUpdateCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitUpdateCondition(this);
		}
	}

	public final UpdateConditionContext updateCondition() throws RecognitionException {
		UpdateConditionContext _localctx = new UpdateConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_updateCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ID);
			setState(178);
			match(EQUAL);
			setState(179);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefinitionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ColumnConstraintContext columnConstraint() {
			return getRuleContext(ColumnConstraintContext.class,0);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnDefinition(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			columnName();
			setState(182);
			dataType();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMARYKEY) {
				{
				setState(183);
				columnConstraint();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INTTYPE() { return getToken(BasicSQLParser.INTTYPE, 0); }
		public TerminalNode FLOATTYPE() { return getToken(BasicSQLParser.FLOATTYPE, 0); }
		public TerminalNode VARCHARTYPE() { return getToken(BasicSQLParser.VARCHARTYPE, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitDataType(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSQLParser.ID, 0); }
		public IndexNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterIndexName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitIndexName(this);
		}
	}

	public final IndexNameContext indexName() throws RecognitionException {
		IndexNameContext _localctx = new IndexNameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_indexName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteConditionContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(BasicSQLParser.WHERE, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OPERATOR() { return getTokens(BasicSQLParser.LOGICAL_OPERATOR); }
		public TerminalNode LOGICAL_OPERATOR(int i) {
			return getToken(BasicSQLParser.LOGICAL_OPERATOR, i);
		}
		public DeleteConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterDeleteCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitDeleteCondition(this);
		}
	}

	public final DeleteConditionContext deleteCondition() throws RecognitionException {
		DeleteConditionContext _localctx = new DeleteConditionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_deleteCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(WHERE);
			setState(191);
			condition();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(192);
				match(LOGICAL_OPERATOR);
				setState(193);
				condition();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00c8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00003\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001=\b\u0001"+
		"\n\u0001\f\u0001@\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005b\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007w\b\u0007\n\u0007\f\u0007z\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u0080\b\b\n\b\f\b\u0083\t\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0005\t\u0089\b\t\n\t\f\t\u008c\t\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u009a\b\r\n\r\f\r\u009d\t\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00a5\b\u000e\n\u000e"+
		"\f\u000e\u00a8\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00b9\b\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00c3\b\u0015\n\u0015"+
		"\f\u0015\u00c6\t\u0015\u0001\u0015\u0000\u0000\u0016\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*\u0000\u0003\u0002\u0000\u0018\u0018\u001a\u001b\u0001\u0000\u001a"+
		"\u001b\u0001\u0000\u0014\u0016\u00bf\u00002\u0001\u0000\u0000\u0000\u0002"+
		"4\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006M\u0001"+
		"\u0000\u0000\u0000\bT\u0001\u0000\u0000\u0000\n]\u0001\u0000\u0000\u0000"+
		"\ff\u0001\u0000\u0000\u0000\u000en\u0001\u0000\u0000\u0000\u0010{\u0001"+
		"\u0000\u0000\u0000\u0012\u0084\u0001\u0000\u0000\u0000\u0014\u008f\u0001"+
		"\u0000\u0000\u0000\u0016\u0091\u0001\u0000\u0000\u0000\u0018\u0093\u0001"+
		"\u0000\u0000\u0000\u001a\u0095\u0001\u0000\u0000\u0000\u001c\u00a0\u0001"+
		"\u0000\u0000\u0000\u001e\u00ab\u0001\u0000\u0000\u0000 \u00ad\u0001\u0000"+
		"\u0000\u0000\"\u00b1\u0001\u0000\u0000\u0000$\u00b5\u0001\u0000\u0000"+
		"\u0000&\u00ba\u0001\u0000\u0000\u0000(\u00bc\u0001\u0000\u0000\u0000*"+
		"\u00be\u0001\u0000\u0000\u0000,3\u0003\u0002\u0001\u0000-3\u0003\u0004"+
		"\u0002\u0000.3\u0003\u0006\u0003\u0000/3\u0003\b\u0004\u000003\u0003\n"+
		"\u0005\u000013\u0003\f\u0006\u00002,\u0001\u0000\u0000\u00002-\u0001\u0000"+
		"\u0000\u00002.\u0001\u0000\u0000\u00002/\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000021\u0001\u0000\u0000\u00003\u0001\u0001\u0000\u0000"+
		"\u000045\u0005\u0005\u0000\u000056\u0005\u0006\u0000\u000067\u0005\u0007"+
		"\u0000\u000078\u0003\u001e\u000f\u000089\u0005\b\u0000\u00009>\u0003 "+
		"\u0010\u0000:;\u0005\f\u0000\u0000;=\u0003 \u0010\u0000<:\u0001\u0000"+
		"\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"AB\u0005\u0004\u0000\u0000BC\u0005\u0000\u0000\u0001C\u0003\u0001\u0000"+
		"\u0000\u0000DE\u0005\t\u0000\u0000EF\u0005\n\u0000\u0000FG\u0003\u001e"+
		"\u000f\u0000GH\u0003\u001a\r\u0000HI\u0005\u000b\u0000\u0000IJ\u0003\u001c"+
		"\u000e\u0000JK\u0005\u0004\u0000\u0000KL\u0005\u0000\u0000\u0001L\u0005"+
		"\u0001\u0000\u0000\u0000MN\u0005\r\u0000\u0000NO\u0005\u000e\u0000\u0000"+
		"OP\u0003\u001e\u000f\u0000PQ\u0003\u0012\t\u0000QR\u0005\u0004\u0000\u0000"+
		"RS\u0005\u0000\u0000\u0001S\u0007\u0001\u0000\u0000\u0000TU\u0005\r\u0000"+
		"\u0000UV\u0005\u000f\u0000\u0000VW\u0003(\u0014\u0000WX\u0005\u0010\u0000"+
		"\u0000XY\u0003\u001e\u000f\u0000YZ\u0003\u0016\u000b\u0000Z[\u0005\u0004"+
		"\u0000\u0000[\\\u0005\u0000\u0000\u0001\\\t\u0001\u0000\u0000\u0000]^"+
		"\u0005\u0011\u0000\u0000^_\u0005\u0007\u0000\u0000_a\u0003\u001e\u000f"+
		"\u0000`b\u0003*\u0015\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000cd\u0005\u0004\u0000\u0000de\u0005\u0000"+
		"\u0000\u0001e\u000b\u0001\u0000\u0000\u0000fg\u0005\u0012\u0000\u0000"+
		"gh\u0003\u001e\u000f\u0000hi\u0005\u0013\u0000\u0000ij\u0003\u000e\u0007"+
		"\u0000jk\u0003\u0010\b\u0000kl\u0005\u0004\u0000\u0000lm\u0005\u0000\u0000"+
		"\u0001m\r\u0001\u0000\u0000\u0000no\u0003\u0016\u000b\u0000op\u0005 \u0000"+
		"\u0000px\u0003\u0018\f\u0000qr\u0005\u0001\u0000\u0000rs\u0003\u0016\u000b"+
		"\u0000st\u0005 \u0000\u0000tu\u0003\u0018\f\u0000uw\u0001\u0000\u0000"+
		"\u0000vq\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000y\u000f\u0001\u0000\u0000\u0000"+
		"zx\u0001\u0000\u0000\u0000{|\u0005\b\u0000\u0000|\u0081\u0003\"\u0011"+
		"\u0000}~\u0005\f\u0000\u0000~\u0080\u0003\"\u0011\u0000\u007f}\u0001\u0000"+
		"\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0011\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u0002"+
		"\u0000\u0000\u0085\u008a\u0003$\u0012\u0000\u0086\u0087\u0005\u0001\u0000"+
		"\u0000\u0087\u0089\u0003$\u0012\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0003\u0000\u0000"+
		"\u008e\u0013\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0017\u0000\u0000"+
		"\u0090\u0015\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0019\u0000\u0000"+
		"\u0092\u0017\u0001\u0000\u0000\u0000\u0093\u0094\u0007\u0000\u0000\u0000"+
		"\u0094\u0019\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0002\u0000\u0000"+
		"\u0096\u009b\u0003\u0016\u000b\u0000\u0097\u0098\u0005\u0001\u0000\u0000"+
		"\u0098\u009a\u0003\u0016\u000b\u0000\u0099\u0097\u0001\u0000\u0000\u0000"+
		"\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0003\u0000\u0000"+
		"\u009f\u001b\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0002\u0000\u0000"+
		"\u00a1\u00a6\u0003\u0018\f\u0000\u00a2\u00a3\u0005\u0001\u0000\u0000\u00a3"+
		"\u00a5\u0003\u0018\f\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0003\u0000\u0000\u00aa\u001d"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0019\u0000\u0000\u00ac\u001f"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0019\u0000\u0000\u00ae\u00af"+
		"\u0005\u001f\u0000\u0000\u00af\u00b0\u0007\u0001\u0000\u0000\u00b0!\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0005\u0019\u0000\u0000\u00b2\u00b3\u0005"+
		" \u0000\u0000\u00b3\u00b4\u0007\u0001\u0000\u0000\u00b4#\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0003\u0016\u000b\u0000\u00b6\u00b8\u0003&\u0013\u0000"+
		"\u00b7\u00b9\u0003\u0014\n\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9%\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0007\u0002\u0000\u0000\u00bb\'\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005"+
		"\u0019\u0000\u0000\u00bd)\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\b"+
		"\u0000\u0000\u00bf\u00c4\u0003 \u0010\u0000\u00c0\u00c1\u0005\f\u0000"+
		"\u0000\u00c1\u00c3\u0003 \u0010\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5+\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c4\u0001\u0000\u0000\u0000\n2>ax\u0081\u008a\u009b\u00a6\u00b8\u00c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}