package com.halberdski.antlr4;

// Generated from d:/Semester 6/Databases 2/Projects/Project 1/database-system/src/main/java/com/halberdski/antlr4/BasicSQL.g4 by ANTLR 4.13.1
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
		T__0=1, T__1=2, SELECT=3, STAR=4, FROM=5, WHERE=6, ID=7, OPERATOR=8, WS=9, 
		DIGIT=10, LOGICAL_OPERATOR=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SELECT", "STAR", "FROM", "WHERE", "ID", "OPERATOR", 
			"WS", "DIGIT", "LOGICAL_OPERATOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Hello'", "';'", null, "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SELECT", "STAR", "FROM", "WHERE", "ID", "OPERATOR", 
			"WS", "DIGIT", "LOGICAL_OPERATOR"
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
		"\u0004\u0000\u000bh\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002,\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u00048\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005D\b\u0005\u0001\u0006\u0001\u0006\u0005\u0006"+
		"H\b\u0006\n\u0006\f\u0006K\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007T\b\u0007"+
		"\u0001\b\u0004\bW\b\b\u000b\b\f\bX\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\ng\b"+
		"\n\u0000\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0001\u0000"+
		"\u0004\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0001"+
		"\u000009q\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000"+
		"\u0003\u001d\u0001\u0000\u0000\u0000\u0005+\u0001\u0000\u0000\u0000\u0007"+
		"-\u0001\u0000\u0000\u0000\t7\u0001\u0000\u0000\u0000\u000bC\u0001\u0000"+
		"\u0000\u0000\rE\u0001\u0000\u0000\u0000\u000fS\u0001\u0000\u0000\u0000"+
		"\u0011V\u0001\u0000\u0000\u0000\u0013\\\u0001\u0000\u0000\u0000\u0015"+
		"f\u0001\u0000\u0000\u0000\u0017\u0018\u0005H\u0000\u0000\u0018\u0019\u0005"+
		"e\u0000\u0000\u0019\u001a\u0005l\u0000\u0000\u001a\u001b\u0005l\u0000"+
		"\u0000\u001b\u001c\u0005o\u0000\u0000\u001c\u0002\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005;\u0000\u0000\u001e\u0004\u0001\u0000\u0000\u0000\u001f"+
		" \u0005S\u0000\u0000 !\u0005E\u0000\u0000!\"\u0005L\u0000\u0000\"#\u0005"+
		"E\u0000\u0000#$\u0005C\u0000\u0000$,\u0005T\u0000\u0000%&\u0005s\u0000"+
		"\u0000&\'\u0005e\u0000\u0000\'(\u0005l\u0000\u0000()\u0005e\u0000\u0000"+
		")*\u0005c\u0000\u0000*,\u0005t\u0000\u0000+\u001f\u0001\u0000\u0000\u0000"+
		"+%\u0001\u0000\u0000\u0000,\u0006\u0001\u0000\u0000\u0000-.\u0005*\u0000"+
		"\u0000.\b\u0001\u0000\u0000\u0000/0\u0005F\u0000\u000001\u0005R\u0000"+
		"\u000012\u0005O\u0000\u000028\u0005M\u0000\u000034\u0005f\u0000\u0000"+
		"45\u0005r\u0000\u000056\u0005o\u0000\u000068\u0005m\u0000\u00007/\u0001"+
		"\u0000\u0000\u000073\u0001\u0000\u0000\u00008\n\u0001\u0000\u0000\u0000"+
		"9:\u0005W\u0000\u0000:;\u0005H\u0000\u0000;<\u0005E\u0000\u0000<=\u0005"+
		"R\u0000\u0000=D\u0005E\u0000\u0000>?\u0005w\u0000\u0000?@\u0005h\u0000"+
		"\u0000@A\u0005e\u0000\u0000AB\u0005r\u0000\u0000BD\u0005e\u0000\u0000"+
		"C9\u0001\u0000\u0000\u0000C>\u0001\u0000\u0000\u0000D\f\u0001\u0000\u0000"+
		"\u0000EI\u0007\u0000\u0000\u0000FH\u0007\u0001\u0000\u0000GF\u0001\u0000"+
		"\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000J\u000e\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000LT\u0002<>\u0000MN\u0005<\u0000\u0000NT\u0005=\u0000\u0000OP\u0005"+
		">\u0000\u0000PT\u0005=\u0000\u0000QR\u0005!\u0000\u0000RT\u0005=\u0000"+
		"\u0000SL\u0001\u0000\u0000\u0000SM\u0001\u0000\u0000\u0000SO\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000T\u0010\u0001\u0000\u0000\u0000"+
		"UW\u0007\u0002\u0000\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z[\u0006\b\u0000\u0000[\u0012\u0001\u0000\u0000\u0000\\]\u0007"+
		"\u0003\u0000\u0000]\u0014\u0001\u0000\u0000\u0000^_\u0005A\u0000\u0000"+
		"_`\u0005N\u0000\u0000`g\u0005D\u0000\u0000ab\u0005O\u0000\u0000bg\u0005"+
		"R\u0000\u0000cd\u0005X\u0000\u0000de\u0005O\u0000\u0000eg\u0005R\u0000"+
		"\u0000f^\u0001\u0000\u0000\u0000fa\u0001\u0000\u0000\u0000fc\u0001\u0000"+
		"\u0000\u0000g\u0016\u0001\u0000\u0000\u0000\b\u0000+7CISXf\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}