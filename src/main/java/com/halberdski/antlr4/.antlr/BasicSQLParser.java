// Generated from d:/Semester 6/Databases 2/Projects/Project 1/database-system/src/main/java/com/halberdski/antlr4/BasicSQL.g4 by ANTLR 4.13.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, STRING=7, NUMBER=8, BOOLEAN=9, 
		ID=10, INSERT=11, INTO=12, CREATE=13, TABLE=14, SELECT=15, UPDATE=16, 
		DELETE=17, INDEX=18, FROM=19, WHERE=20, SET=21, ON=22, VALUES=23, OPERATOR=24, 
		WS=25, DIGIT=26;
	public static final int
		RULE_sqlStatement = 0, RULE_insertStatement = 1, RULE_createTableStatement = 2, 
		RULE_selectStatement = 3, RULE_updateStatement = 4, RULE_deleteStatement = 5, 
		RULE_createIndexStatement = 6, RULE_tableName = 7, RULE_indexName = 8, 
		RULE_columnNameList = 9, RULE_columnDefinitionList = 10, RULE_columnDefinition = 11, 
		RULE_columnValueList = 12, RULE_columnValue = 13, RULE_columnList = 14, 
		RULE_valueList = 15, RULE_value = 16, RULE_condition = 17, RULE_columnName = 18, 
		RULE_dataType = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlStatement", "insertStatement", "createTableStatement", "selectStatement", 
			"updateStatement", "deleteStatement", "createIndexStatement", "tableName", 
			"indexName", "columnNameList", "columnDefinitionList", "columnDefinition", 
			"columnValueList", "columnValue", "columnList", "valueList", "value", 
			"condition", "columnName", "dataType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "';'", "','", "'='", "'*'", null, null, null, null, 
			"'INSERT'", "'INTO'", "'CREATE'", "'TABLE'", "'SELECT'", "'UPDATE'", 
			"'DELETE'", "'INDEX'", "'FROM'", "'WHERE'", "'SET'", "'ON'", "'VALUES'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "STRING", "NUMBER", "BOOLEAN", 
			"ID", "INSERT", "INTO", "CREATE", "TABLE", "SELECT", "UPDATE", "DELETE", 
			"INDEX", "FROM", "WHERE", "SET", "ON", "VALUES", "OPERATOR", "WS", "DIGIT"
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
		public InsertStatementContext insertStatement() {
			return getRuleContext(InsertStatementContext.class,0);
		}
		public CreateTableStatementContext createTableStatement() {
			return getRuleContext(CreateTableStatementContext.class,0);
		}
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public UpdateStatementContext updateStatement() {
			return getRuleContext(UpdateStatementContext.class,0);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public CreateIndexStatementContext createIndexStatement() {
			return getRuleContext(CreateIndexStatementContext.class,0);
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
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				insertStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				createTableStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				selectStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				updateStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				deleteStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				createIndexStatement();
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
		enterRule(_localctx, 2, RULE_insertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(INSERT);
			setState(49);
			match(INTO);
			setState(50);
			tableName();
			setState(51);
			match(T__0);
			setState(52);
			columnNameList();
			setState(53);
			match(T__1);
			setState(54);
			match(VALUES);
			setState(55);
			match(T__0);
			setState(56);
			valueList();
			setState(57);
			match(T__1);
			setState(58);
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
	public static class CreateTableStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(BasicSQLParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(BasicSQLParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnDefinitionListContext columnDefinitionList() {
			return getRuleContext(ColumnDefinitionListContext.class,0);
		}
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
		enterRule(_localctx, 4, RULE_createTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(CREATE);
			setState(61);
			match(TABLE);
			setState(62);
			tableName();
			setState(63);
			match(T__0);
			setState(64);
			columnDefinitionList();
			setState(65);
			match(T__1);
			setState(66);
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
	public static class SelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(BasicSQLParser.SELECT, 0); }
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(BasicSQLParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(BasicSQLParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
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
		enterRule(_localctx, 6, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(SELECT);
			setState(69);
			columnList();
			setState(70);
			match(FROM);
			setState(71);
			tableName();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(72);
				match(WHERE);
				setState(73);
				condition();
				}
			}

			setState(76);
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
	public static class UpdateStatementContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(BasicSQLParser.UPDATE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SET() { return getToken(BasicSQLParser.SET, 0); }
		public ColumnValueListContext columnValueList() {
			return getRuleContext(ColumnValueListContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(BasicSQLParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_updateStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(UPDATE);
			setState(79);
			tableName();
			setState(80);
			match(SET);
			setState(81);
			columnValueList();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(82);
				match(WHERE);
				setState(83);
				condition();
				}
			}

			setState(86);
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
	public static class DeleteStatementContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(BasicSQLParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(BasicSQLParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(BasicSQLParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
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
			setState(88);
			match(DELETE);
			setState(89);
			match(FROM);
			setState(90);
			tableName();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(91);
				match(WHERE);
				setState(92);
				condition();
				}
			}

			setState(95);
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
		public ColumnNameListContext columnNameList() {
			return getRuleContext(ColumnNameListContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_createIndexStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(CREATE);
			setState(98);
			match(INDEX);
			setState(99);
			indexName();
			setState(100);
			match(ON);
			setState(101);
			tableName();
			setState(102);
			match(T__0);
			setState(103);
			columnNameList();
			setState(104);
			match(T__1);
			setState(105);
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
		enterRule(_localctx, 14, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
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
		enterRule(_localctx, 16, RULE_indexName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
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
		enterRule(_localctx, 18, RULE_columnNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			columnName();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(112);
				match(T__3);
				setState(113);
				columnName();
				}
				}
				setState(118);
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
	public static class ColumnDefinitionListContext extends ParserRuleContext {
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public ColumnDefinitionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinitionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnDefinitionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnDefinitionList(this);
		}
	}

	public final ColumnDefinitionListContext columnDefinitionList() throws RecognitionException {
		ColumnDefinitionListContext _localctx = new ColumnDefinitionListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_columnDefinitionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			columnDefinition();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(120);
				match(T__3);
				setState(121);
				columnDefinition();
				}
				}
				setState(126);
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
	public static class ColumnDefinitionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
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
		enterRule(_localctx, 22, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			columnName();
			setState(128);
			dataType();
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
	public static class ColumnValueListContext extends ParserRuleContext {
		public List<ColumnValueContext> columnValue() {
			return getRuleContexts(ColumnValueContext.class);
		}
		public ColumnValueContext columnValue(int i) {
			return getRuleContext(ColumnValueContext.class,i);
		}
		public ColumnValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnValueList(this);
		}
	}

	public final ColumnValueListContext columnValueList() throws RecognitionException {
		ColumnValueListContext _localctx = new ColumnValueListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_columnValueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			columnValue();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(131);
				match(T__3);
				setState(132);
				columnValue();
				}
				}
				setState(137);
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
	public static class ColumnValueContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ColumnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnValue(this);
		}
	}

	public final ColumnValueContext columnValue() throws RecognitionException {
		ColumnValueContext _localctx = new ColumnValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_columnValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			columnName();
			setState(139);
			match(T__4);
			setState(140);
			value();
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
	public static class ColumnListContext extends ParserRuleContext {
		public ColumnNameListContext columnNameList() {
			return getRuleContext(ColumnNameListContext.class,0);
		}
		public ColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterColumnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitColumnList(this);
		}
	}

	public final ColumnListContext columnList() throws RecognitionException {
		ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_columnList);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(T__5);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				columnNameList();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
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
		enterRule(_localctx, 30, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			value();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(147);
				match(T__3);
				setState(148);
				value();
				}
				}
				setState(153);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BasicSQLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(BasicSQLParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(BasicSQLParser.BOOLEAN, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicSQLListener ) ((BasicSQLListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) ) {
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
	public static class ConditionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(BasicSQLParser.OPERATOR, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			columnName();
			setState(157);
			match(OPERATOR);
			setState(158);
			value();
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
		enterRule(_localctx, 36, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
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
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicSQLParser.ID, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001a\u00a5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000/\b\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003K\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004U\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005^\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\ts\b\t\n\t\f\tv\t\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\n{\b\n\n\n\f\n~\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0086\b\f\n\f\f\f\u0089\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u0091\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0096\b\u000f\n\u000f\f\u000f"+
		"\u0099\t\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0001\u0001\u0000\u0007\t\u009d"+
		"\u0000.\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u0004<"+
		"\u0001\u0000\u0000\u0000\u0006D\u0001\u0000\u0000\u0000\bN\u0001\u0000"+
		"\u0000\u0000\nX\u0001\u0000\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000e"+
		"k\u0001\u0000\u0000\u0000\u0010m\u0001\u0000\u0000\u0000\u0012o\u0001"+
		"\u0000\u0000\u0000\u0014w\u0001\u0000\u0000\u0000\u0016\u007f\u0001\u0000"+
		"\u0000\u0000\u0018\u0082\u0001\u0000\u0000\u0000\u001a\u008a\u0001\u0000"+
		"\u0000\u0000\u001c\u0090\u0001\u0000\u0000\u0000\u001e\u0092\u0001\u0000"+
		"\u0000\u0000 \u009a\u0001\u0000\u0000\u0000\"\u009c\u0001\u0000\u0000"+
		"\u0000$\u00a0\u0001\u0000\u0000\u0000&\u00a2\u0001\u0000\u0000\u0000("+
		"/\u0003\u0002\u0001\u0000)/\u0003\u0004\u0002\u0000*/\u0003\u0006\u0003"+
		"\u0000+/\u0003\b\u0004\u0000,/\u0003\n\u0005\u0000-/\u0003\f\u0006\u0000"+
		".(\u0001\u0000\u0000\u0000.)\u0001\u0000\u0000\u0000.*\u0001\u0000\u0000"+
		"\u0000.+\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000.-\u0001\u0000"+
		"\u0000\u0000/\u0001\u0001\u0000\u0000\u000001\u0005\u000b\u0000\u0000"+
		"12\u0005\f\u0000\u000023\u0003\u000e\u0007\u000034\u0005\u0001\u0000\u0000"+
		"45\u0003\u0012\t\u000056\u0005\u0002\u0000\u000067\u0005\u0017\u0000\u0000"+
		"78\u0005\u0001\u0000\u000089\u0003\u001e\u000f\u00009:\u0005\u0002\u0000"+
		"\u0000:;\u0005\u0003\u0000\u0000;\u0003\u0001\u0000\u0000\u0000<=\u0005"+
		"\r\u0000\u0000=>\u0005\u000e\u0000\u0000>?\u0003\u000e\u0007\u0000?@\u0005"+
		"\u0001\u0000\u0000@A\u0003\u0014\n\u0000AB\u0005\u0002\u0000\u0000BC\u0005"+
		"\u0003\u0000\u0000C\u0005\u0001\u0000\u0000\u0000DE\u0005\u000f\u0000"+
		"\u0000EF\u0003\u001c\u000e\u0000FG\u0005\u0013\u0000\u0000GJ\u0003\u000e"+
		"\u0007\u0000HI\u0005\u0014\u0000\u0000IK\u0003\"\u0011\u0000JH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0005"+
		"\u0003\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0005\u0010\u0000"+
		"\u0000OP\u0003\u000e\u0007\u0000PQ\u0005\u0015\u0000\u0000QT\u0003\u0018"+
		"\f\u0000RS\u0005\u0014\u0000\u0000SU\u0003\"\u0011\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0005"+
		"\u0003\u0000\u0000W\t\u0001\u0000\u0000\u0000XY\u0005\u0011\u0000\u0000"+
		"YZ\u0005\u0013\u0000\u0000Z]\u0003\u000e\u0007\u0000[\\\u0005\u0014\u0000"+
		"\u0000\\^\u0003\"\u0011\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0003\u0000\u0000`\u000b"+
		"\u0001\u0000\u0000\u0000ab\u0005\r\u0000\u0000bc\u0005\u0012\u0000\u0000"+
		"cd\u0003\u0010\b\u0000de\u0005\u0016\u0000\u0000ef\u0003\u000e\u0007\u0000"+
		"fg\u0005\u0001\u0000\u0000gh\u0003\u0012\t\u0000hi\u0005\u0002\u0000\u0000"+
		"ij\u0005\u0003\u0000\u0000j\r\u0001\u0000\u0000\u0000kl\u0005\n\u0000"+
		"\u0000l\u000f\u0001\u0000\u0000\u0000mn\u0005\n\u0000\u0000n\u0011\u0001"+
		"\u0000\u0000\u0000ot\u0003$\u0012\u0000pq\u0005\u0004\u0000\u0000qs\u0003"+
		"$\u0012\u0000rp\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u\u0013\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000w|\u0003\u0016\u000b\u0000xy\u0005\u0004"+
		"\u0000\u0000y{\u0003\u0016\u000b\u0000zx\u0001\u0000\u0000\u0000{~\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}\u0015\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0003$\u0012\u0000\u0080\u0081\u0003&\u0013\u0000\u0081\u0017\u0001\u0000"+
		"\u0000\u0000\u0082\u0087\u0003\u001a\r\u0000\u0083\u0084\u0005\u0004\u0000"+
		"\u0000\u0084\u0086\u0003\u001a\r\u0000\u0085\u0083\u0001\u0000\u0000\u0000"+
		"\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0019\u0001\u0000\u0000\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b\u0003$\u0012\u0000\u008b"+
		"\u008c\u0005\u0005\u0000\u0000\u008c\u008d\u0003 \u0010\u0000\u008d\u001b"+
		"\u0001\u0000\u0000\u0000\u008e\u0091\u0005\u0006\u0000\u0000\u008f\u0091"+
		"\u0003\u0012\t\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u001d\u0001\u0000\u0000\u0000\u0092\u0097\u0003"+
		" \u0010\u0000\u0093\u0094\u0005\u0004\u0000\u0000\u0094\u0096\u0003 \u0010"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000"+
		"\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u001f\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0007\u0000\u0000\u0000\u009b!\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0003$\u0012\u0000\u009d\u009e\u0005\u0018\u0000\u0000\u009e"+
		"\u009f\u0003 \u0010\u0000\u009f#\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"\n\u0000\u0000\u00a1%\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\n\u0000"+
		"\u0000\u00a3\'\u0001\u0000\u0000\u0000\t.JT]t|\u0087\u0090\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}