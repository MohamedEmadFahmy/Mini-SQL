package com.halberdski.antlr4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class QueryTester {
    public static void testSelectStarQuery(String sql) {
        // Create a CharStream from the input SQL string
        CharStream input = CharStreams.fromString(sql);

        // Create a lexer that feeds off of the input CharStream
        BasicSQLLexer lexer = new BasicSQLLexer(input);

        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that feeds off the tokens buffer
        BasicSQLParser parser = new BasicSQLParser(tokens);

        // Set custom error listeners to suppress error messages
        lexer.removeErrorListeners();
        parser.removeErrorListeners();

        parser.addErrorListener(new CustomErrorListener(parser));

        try {
            // parser.sqlStatement();
            BasicSQLParser.SqlStatementContext tree = parser.sqlStatement();

            YourCustomListener listener = new YourCustomListener();

            // Traverse the parse tree using the listener
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);
            // System.out.println("Valid SQL: " + sql);

            // System.out.println(tree.toStringTree());
            // System.out.println(tree.getText());
        } catch (ParseCancellationException e) {
            System.out.println("Invalid SQL: " + sql);
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        // String[] selectStatements = {
        // "hi",
        // "SELECT * FROM table",
        // "SELECT * FROM table;",
        // "select * FROM table WHERE id = 5;",
        // "SELECT * FROM table WHERE id = 5;",
        // "SELECT * FROM table WHERE id = 5 AND age = 1;",
        // "SELECT * FROM table WHERE id = 5 OR age = 1;",
        // "SELECT * FROM table WHERE id = 5 OR age = 10;",
        // "SELECT * FROM table WHERE id = 'mo' OR age = 10;",
        // "SELECT * FROM table WHERE id = mo OR age = 1.5.;",
        // "SELECT * FROM table WHERE id = mo OR age = 1. 5.;",
        // "SELECT * FROM table WHERE id = 'mo' OR age = 1. 5.;",
        // "SELECT * FROM table WHERE id = 'mo' OR age = 1.5..;",
        // "select * FROM table WHERE id = 5;;;",
        // };

        // --------------------------------------------------------------------------

        String[] validInsertStatements = {
                "INSERT INTO tableName (column1, column2) VALUES ('value1', 'value2');",
                "INSERT INTO tableName (column1, column2) VALUES (123, 456);",
                "INSERT INTO tableName (column1, column2) VALUES (TRUE, FALSE);",
                "INSERT INTO tableName (column1) VALUES ('value1');",
        };

        String[] invalidInsertStatements = {
                "INSERT INTO tableName (column1) VALUES (value1);",
                "INSERT INTO tableName (column1, column2) VALUES (NULL, NULL);",
                "INSERT INTO tableName VALUES (value1, value2);",
                "INSERT INTO tableName VALUES ('value1', 'value2');",
                "INSERT INTO tableName VALUES (123, 456);",
                "INSERT INTO tableName VALUES (TRUE, FALSE);",
                "INSERT INTO tableName VALUES (NULL, NULL);"
        };

        for (String sql : invalidInsertStatements) {
            testSelectStarQuery(sql);
            System.out.println("\n");
        }

        System.err.println("-----------VALID-----------");
        System.err.println();
        for (String sql : validInsertStatements) {
            testSelectStarQuery(sql);
            System.out.println("\n");
        }
    }
}
