// Generated from c:/Users/Mohamed/Desktop/basic sql/BasicSQL.g4 by ANTLR 4.13.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, SEMICOLON=5, SELECT=6, STAR=7, FROM=8, 
		WHERE=9, INSERT=10, INTO=11, VALUES=12, LOGICAL_OPERATOR=13, CREATE=14, 
		TABLE=15, INDEX=16, ON=17, DELETE=18, INTTYPE=19, FLOATTYPE=20, VARCHARTYPE=21, 
		PRIMARYKEY=22, BOOLEAN=23, ID=24, STRING=25, NUMBER=26, INT=27, DOT=28, 
		DECIMAL=29, OPERATOR=30, WS=31, DIGIT=32;
	public static final int
		RULE_sqlStatement = 0, RULE_helloWorld = 1, RULE_selectStatement = 2, 
		RULE_insertStatement = 3, RULE_createTableStatement = 4, RULE_createIndexStatement = 5, 
		RULE_deleteStatement = 6, RULE_tableDefinition = 7, RULE_columnConstraint = 8, 
		RULE_columnName = 9, RULE_literalValue = 10, RULE_columnNameList = 11, 
		RULE_valueList = 12, RULE_tableName = 13, RULE_condition = 14, RULE_columnDefinition = 15, 
		RULE_dataType = 16, RULE_indexName = 17, RULE_deleteCondition = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlStatement", "helloWorld", "selectStatement", "insertStatement", "createTableStatement", 
			"createIndexStatement", "deleteStatement", "tableDefinition", "columnConstraint", 
			"columnName", "literalValue", "columnNameList", "valueList", "tableName", 
			"condition", "columnDefinition", "dataType", "indexName", "deleteCondition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Hello'", "'('", "','", "')'", "';'", null, "'*'", null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SEMICOLON", "SELECT", "STAR", "FROM", 
			"WHERE", "INSERT", "INTO", "VALUES", "LOGICAL_OPERATOR", "CREATE", "TABLE", 
			"INDEX", "ON", "DELETE", "INTTYPE", "FLOATTYPE", "VARCHARTYPE", "PRIMARYKEY", 
			"BOOLEAN", "ID", "STRING", "NUMBER", "INT", "DOT", "DECIMAL", "OPERATOR", 
			"WS", "DIGIT"
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
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlStatement);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				selectStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				insertStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				createTableStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
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
	public static class HelloWorldContext extends ParserRuleContext {
		public HelloWorldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_helloWorld; }
	}

	public final HelloWorldContext helloWorld() throws RecognitionException {
		HelloWorldContext _localctx = new HelloWorldContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_helloWorld);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
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
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(SELECT);
			setState(47);
			match(STAR);
			setState(48);
			match(FROM);
			setState(49);
			tableName();
			setState(50);
			match(WHERE);
			setState(51);
			condition();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(52);
				match(LOGICAL_OPERATOR);
				setState(53);
				condition();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(SEMICOLON);
			setState(60);
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
	}

	public final InsertStatementContext insertStatement() throws RecognitionException {
		InsertStatementContext _localctx = new InsertStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_insertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(INSERT);
			setState(63);
			match(INTO);
			setState(64);
			tableName();
			setState(65);
			columnNameList();
			setState(66);
			match(VALUES);
			setState(67);
			valueList();
			setState(68);
			match(SEMICOLON);
			setState(69);
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
	}

	public final CreateTableStatementContext createTableStatement() throws RecognitionException {
		CreateTableStatementContext _localctx = new CreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_createTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(CREATE);
			setState(72);
			match(TABLE);
			setState(73);
			tableName();
			setState(74);
			tableDefinition();
			setState(75);
			match(SEMICOLON);
			setState(76);
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
		public ColumnNameListContext columnNameList() {
			return getRuleContext(ColumnNameListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicSQLParser.SEMICOLON, 0); }
		public TerminalNode EOF() { return getToken(BasicSQLParser.EOF, 0); }
		public CreateIndexStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createIndexStatement; }
	}

	public final CreateIndexStatementContext createIndexStatement() throws RecognitionException {
		CreateIndexStatementContext _localctx = new CreateIndexStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_createIndexStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(CREATE);
			setState(79);
			match(INDEX);
			setState(80);
			indexName();
			setState(81);
			match(ON);
			setState(82);
			tableName();
			setState(83);
			columnNameList();
			setState(84);
			match(SEMICOLON);
			setState(85);
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
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_deleteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(DELETE);
			setState(88);
			match(FROM);
			setState(89);
			tableName();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(90);
				deleteCondition();
				}
			}

			setState(93);
			match(SEMICOLON);
			setState(94);
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
	}

	public final TableDefinitionContext tableDefinition() throws RecognitionException {
		TableDefinitionContext _localctx = new TableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__1);
			setState(97);
			columnDefinition();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(98);
				match(T__2);
				setState(99);
				columnDefinition();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			match(T__3);
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
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_columnConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
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
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_columnName);
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
	public static class LiteralValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BasicSQLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(BasicSQLParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(BasicSQLParser.BOOLEAN, 0); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 109051904L) != 0)) ) {
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
	}

	public final ColumnNameListContext columnNameList() throws RecognitionException {
		ColumnNameListContext _localctx = new ColumnNameListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_columnNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__1);
			setState(114);
			columnName();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(115);
				match(T__2);
				setState(116);
				columnName();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(T__3);
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
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__1);
			setState(125);
			literalValue();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(126);
				match(T__2);
				setState(127);
				literalValue();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__3);
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
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ID);
			setState(138);
			match(OPERATOR);
			setState(139);
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
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			columnName();
			setState(142);
			dataType();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMARYKEY) {
				{
				setState(143);
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
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
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
	}

	public final IndexNameContext indexName() throws RecognitionException {
		IndexNameContext _localctx = new IndexNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_indexName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
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
	}

	public final DeleteConditionContext deleteCondition() throws RecognitionException {
		DeleteConditionContext _localctx = new DeleteConditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_deleteCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(WHERE);
			setState(151);
			condition();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOGICAL_OPERATOR) {
				{
				{
				setState(152);
				match(LOGICAL_OPERATOR);
				setState(153);
				condition();
				}
				}
				setState(158);
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
		"\u0004\u0001 \u00a0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000+\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00027\b\u0002"+
		"\n\u0002\f\u0002:\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\\\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007e\b\u0007\n\u0007\f\u0007h\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bv\b\u000b\n\u000b\f\u000b"+
		"y\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u0081\b\f\n\f\f\f\u0084\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u0091\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u009b\b\u0012"+
		"\n\u0012\f\u0012\u009e\t\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$\u0000\u0003\u0002\u0000\u0017\u0017\u0019\u001a\u0001\u0000\u0019"+
		"\u001a\u0001\u0000\u0013\u0015\u0096\u0000*\u0001\u0000\u0000\u0000\u0002"+
		",\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u0006>\u0001"+
		"\u0000\u0000\u0000\bG\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000"+
		"\fW\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010k\u0001"+
		"\u0000\u0000\u0000\u0012m\u0001\u0000\u0000\u0000\u0014o\u0001\u0000\u0000"+
		"\u0000\u0016q\u0001\u0000\u0000\u0000\u0018|\u0001\u0000\u0000\u0000\u001a"+
		"\u0087\u0001\u0000\u0000\u0000\u001c\u0089\u0001\u0000\u0000\u0000\u001e"+
		"\u008d\u0001\u0000\u0000\u0000 \u0092\u0001\u0000\u0000\u0000\"\u0094"+
		"\u0001\u0000\u0000\u0000$\u0096\u0001\u0000\u0000\u0000&+\u0003\u0004"+
		"\u0002\u0000\'+\u0003\u0006\u0003\u0000(+\u0003\b\u0004\u0000)+\u0003"+
		"\n\u0005\u0000*&\u0001\u0000\u0000\u0000*\'\u0001\u0000\u0000\u0000*("+
		"\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000+\u0001\u0001\u0000"+
		"\u0000\u0000,-\u0005\u0001\u0000\u0000-\u0003\u0001\u0000\u0000\u0000"+
		"./\u0005\u0006\u0000\u0000/0\u0005\u0007\u0000\u000001\u0005\b\u0000\u0000"+
		"12\u0003\u001a\r\u000023\u0005\t\u0000\u000038\u0003\u001c\u000e\u0000"+
		"45\u0005\r\u0000\u000057\u0003\u001c\u000e\u000064\u0001\u0000\u0000\u0000"+
		"7:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;<\u0005\u0005"+
		"\u0000\u0000<=\u0005\u0000\u0000\u0001=\u0005\u0001\u0000\u0000\u0000"+
		">?\u0005\n\u0000\u0000?@\u0005\u000b\u0000\u0000@A\u0003\u001a\r\u0000"+
		"AB\u0003\u0016\u000b\u0000BC\u0005\f\u0000\u0000CD\u0003\u0018\f\u0000"+
		"DE\u0005\u0005\u0000\u0000EF\u0005\u0000\u0000\u0001F\u0007\u0001\u0000"+
		"\u0000\u0000GH\u0005\u000e\u0000\u0000HI\u0005\u000f\u0000\u0000IJ\u0003"+
		"\u001a\r\u0000JK\u0003\u000e\u0007\u0000KL\u0005\u0005\u0000\u0000LM\u0005"+
		"\u0000\u0000\u0001M\t\u0001\u0000\u0000\u0000NO\u0005\u000e\u0000\u0000"+
		"OP\u0005\u0010\u0000\u0000PQ\u0003\"\u0011\u0000QR\u0005\u0011\u0000\u0000"+
		"RS\u0003\u001a\r\u0000ST\u0003\u0016\u000b\u0000TU\u0005\u0005\u0000\u0000"+
		"UV\u0005\u0000\u0000\u0001V\u000b\u0001\u0000\u0000\u0000WX\u0005\u0012"+
		"\u0000\u0000XY\u0005\b\u0000\u0000Y[\u0003\u001a\r\u0000Z\\\u0003$\u0012"+
		"\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]^\u0005\u0005\u0000\u0000^_\u0005\u0000\u0000\u0001_\r\u0001"+
		"\u0000\u0000\u0000`a\u0005\u0002\u0000\u0000af\u0003\u001e\u000f\u0000"+
		"bc\u0005\u0003\u0000\u0000ce\u0003\u001e\u000f\u0000db\u0001\u0000\u0000"+
		"\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ij\u0005"+
		"\u0004\u0000\u0000j\u000f\u0001\u0000\u0000\u0000kl\u0005\u0016\u0000"+
		"\u0000l\u0011\u0001\u0000\u0000\u0000mn\u0005\u0018\u0000\u0000n\u0013"+
		"\u0001\u0000\u0000\u0000op\u0007\u0000\u0000\u0000p\u0015\u0001\u0000"+
		"\u0000\u0000qr\u0005\u0002\u0000\u0000rw\u0003\u0012\t\u0000st\u0005\u0003"+
		"\u0000\u0000tv\u0003\u0012\t\u0000us\u0001\u0000\u0000\u0000vy\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001"+
		"\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005\u0004\u0000\u0000"+
		"{\u0017\u0001\u0000\u0000\u0000|}\u0005\u0002\u0000\u0000}\u0082\u0003"+
		"\u0014\n\u0000~\u007f\u0005\u0003\u0000\u0000\u007f\u0081\u0003\u0014"+
		"\n\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0005\u0004\u0000\u0000\u0086\u0019\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088\u001b\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005\u0018\u0000\u0000\u008a\u008b\u0005\u001e\u0000"+
		"\u0000\u008b\u008c\u0007\u0001\u0000\u0000\u008c\u001d\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0003\u0012\t\u0000\u008e\u0090\u0003 \u0010\u0000"+
		"\u008f\u0091\u0003\u0010\b\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u001f\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0007\u0002\u0000\u0000\u0093!\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005\u0018\u0000\u0000\u0095#\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"\t\u0000\u0000\u0097\u009c\u0003\u001c\u000e\u0000\u0098\u0099\u0005\r"+
		"\u0000\u0000\u0099\u009b\u0003\u001c\u000e\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d%\u0001\u0000\u0000"+
		"\u0000\u009e\u009c\u0001\u0000\u0000\u0000\b*8[fw\u0082\u0090\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}