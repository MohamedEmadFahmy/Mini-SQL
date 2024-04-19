package com.halberdski.antlr4;

// Generated from c:/Users/Mohamed/Desktop/basic sql/BasicSQL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BasicSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SEMICOLON=2, SELECT=3, STAR=4, FROM=5, WHERE=6, LOGICAL_OPERATOR=7, 
		ID=8, STRING=9, NUM=10, INT=11, DOT=12, FLOAT=13, OPERATOR=14, WS=15, 
		DIGIT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "SEMICOLON", "SELECT", "STAR", "FROM", "WHERE", "LOGICAL_OPERATOR", 
			"ID", "STRING", "NUM", "INT", "DOT", "FLOAT", "OPERATOR", "WS", "DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Hello'", "';'", null, "'*'", null, null, null, null, null, null, 
			null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SEMICOLON", "SELECT", "STAR", "FROM", "WHERE", "LOGICAL_OPERATOR", 
			"ID", "STRING", "NUM", "INT", "DOT", "FLOAT", "OPERATOR", "WS", "DIGIT"
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


	public BasicSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010\u0094\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004B\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005N\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006`\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0005\u0007d\b\u0007\n\u0007\f\u0007g\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\to\b\t\u0001\n"+
		"\u0004\nr\b\n\u000b\n\f\ns\u0001\u000b\u0001\u000b\u0001\f\u0004\fy\b"+
		"\f\u000b\f\f\fz\u0001\f\u0001\f\u0004\f\u007f\b\f\u000b\f\f\f\u0080\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u008a\b\r\u0001"+
		"\u000e\u0004\u000e\u008d\b\u000e\u000b\u000e\f\u000e\u008e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"\u0001\u0000\u0004\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t\n"+
		"\r\r  \u0001\u000009\u00a4\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003\'\u0001\u0000\u0000"+
		"\u0000\u00055\u0001\u0000\u0000\u0000\u00077\u0001\u0000\u0000\u0000\t"+
		"A\u0001\u0000\u0000\u0000\u000bM\u0001\u0000\u0000\u0000\r_\u0001\u0000"+
		"\u0000\u0000\u000fa\u0001\u0000\u0000\u0000\u0011h\u0001\u0000\u0000\u0000"+
		"\u0013n\u0001\u0000\u0000\u0000\u0015q\u0001\u0000\u0000\u0000\u0017u"+
		"\u0001\u0000\u0000\u0000\u0019x\u0001\u0000\u0000\u0000\u001b\u0089\u0001"+
		"\u0000\u0000\u0000\u001d\u008c\u0001\u0000\u0000\u0000\u001f\u0092\u0001"+
		"\u0000\u0000\u0000!\"\u0005H\u0000\u0000\"#\u0005e\u0000\u0000#$\u0005"+
		"l\u0000\u0000$%\u0005l\u0000\u0000%&\u0005o\u0000\u0000&\u0002\u0001\u0000"+
		"\u0000\u0000\'(\u0005;\u0000\u0000(\u0004\u0001\u0000\u0000\u0000)*\u0005"+
		"S\u0000\u0000*+\u0005E\u0000\u0000+,\u0005L\u0000\u0000,-\u0005E\u0000"+
		"\u0000-.\u0005C\u0000\u0000.6\u0005T\u0000\u0000/0\u0005s\u0000\u0000"+
		"01\u0005e\u0000\u000012\u0005l\u0000\u000023\u0005e\u0000\u000034\u0005"+
		"c\u0000\u000046\u0005t\u0000\u00005)\u0001\u0000\u0000\u00005/\u0001\u0000"+
		"\u0000\u00006\u0006\u0001\u0000\u0000\u000078\u0005*\u0000\u00008\b\u0001"+
		"\u0000\u0000\u00009:\u0005F\u0000\u0000:;\u0005R\u0000\u0000;<\u0005O"+
		"\u0000\u0000<B\u0005M\u0000\u0000=>\u0005f\u0000\u0000>?\u0005r\u0000"+
		"\u0000?@\u0005o\u0000\u0000@B\u0005m\u0000\u0000A9\u0001\u0000\u0000\u0000"+
		"A=\u0001\u0000\u0000\u0000B\n\u0001\u0000\u0000\u0000CD\u0005W\u0000\u0000"+
		"DE\u0005H\u0000\u0000EF\u0005E\u0000\u0000FG\u0005R\u0000\u0000GN\u0005"+
		"E\u0000\u0000HI\u0005w\u0000\u0000IJ\u0005h\u0000\u0000JK\u0005e\u0000"+
		"\u0000KL\u0005r\u0000\u0000LN\u0005e\u0000\u0000MC\u0001\u0000\u0000\u0000"+
		"MH\u0001\u0000\u0000\u0000N\f\u0001\u0000\u0000\u0000OP\u0005A\u0000\u0000"+
		"PQ\u0005N\u0000\u0000Q`\u0005D\u0000\u0000RS\u0005a\u0000\u0000ST\u0005"+
		"n\u0000\u0000T`\u0005d\u0000\u0000UV\u0005O\u0000\u0000V`\u0005R\u0000"+
		"\u0000WX\u0005o\u0000\u0000X`\u0005r\u0000\u0000YZ\u0005X\u0000\u0000"+
		"Z[\u0005O\u0000\u0000[`\u0005R\u0000\u0000\\]\u0005x\u0000\u0000]^\u0005"+
		"o\u0000\u0000^`\u0005r\u0000\u0000_O\u0001\u0000\u0000\u0000_R\u0001\u0000"+
		"\u0000\u0000_U\u0001\u0000\u0000\u0000_W\u0001\u0000\u0000\u0000_Y\u0001"+
		"\u0000\u0000\u0000_\\\u0001\u0000\u0000\u0000`\u000e\u0001\u0000\u0000"+
		"\u0000ae\u0007\u0000\u0000\u0000bd\u0007\u0001\u0000\u0000cb\u0001\u0000"+
		"\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000f\u0010\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000hi\u0005\'\u0000\u0000ij\u0003\u000f\u0007\u0000jk\u0005\'\u0000"+
		"\u0000k\u0012\u0001\u0000\u0000\u0000lo\u0003\u0015\n\u0000mo\u0003\u0019"+
		"\f\u0000nl\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000o\u0014\u0001"+
		"\u0000\u0000\u0000pr\u0003\u001f\u000f\u0000qp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t\u0016\u0001\u0000\u0000\u0000uv\u0005.\u0000\u0000v\u0018\u0001"+
		"\u0000\u0000\u0000wy\u0003\u001f\u000f\u0000xw\u0001\u0000\u0000\u0000"+
		"yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|~\u0003\u0017\u000b\u0000}\u007f\u0003"+
		"\u001f\u000f\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u001a\u0001\u0000\u0000\u0000\u0082\u008a\u0002<>\u0000\u0083\u0084"+
		"\u0005<\u0000\u0000\u0084\u008a\u0005=\u0000\u0000\u0085\u0086\u0005>"+
		"\u0000\u0000\u0086\u008a\u0005=\u0000\u0000\u0087\u0088\u0005!\u0000\u0000"+
		"\u0088\u008a\u0005=\u0000\u0000\u0089\u0082\u0001\u0000\u0000\u0000\u0089"+
		"\u0083\u0001\u0000\u0000\u0000\u0089\u0085\u0001\u0000\u0000\u0000\u0089"+
		"\u0087\u0001\u0000\u0000\u0000\u008a\u001c\u0001\u0000\u0000\u0000\u008b"+
		"\u008d\u0007\u0002\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0006\u000e\u0000\u0000\u0091\u001e\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0007\u0003\u0000\u0000\u0093 \u0001\u0000\u0000\u0000\f\u0000"+
		"5AM_ensz\u0080\u0089\u008e\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}