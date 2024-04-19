package com.halberdski.antlr4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class QueryTester {
    public static void test(String sql) {
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

        // try {
        // // SelectStarParser.SelectStarQueryContext tree = parser.selectStarQuery();
        // parser.selectStarQuery();
        // System.out.println("Valid SQL: " + sql);
        // // System.out.println(tree.toStringTree());
        // // System.out.println(tree.toStringTree());
        // // System.out.println(tree.toStringTree());
        // } catch (ParseCancellationException e) {
        // System.out.println("Invalid SQL: " + sql);
        // System.out.println(e.getMessage());
        // }

        // System.out.println(tree.SELECT());
        // System.out.println(tree.FROM());
        // System.out.println(tree.getChildCount());
        // System.out.println(tree.toStringTree());
        // System.out.println(tree.getText());
        // System.out.println(tree.toStringTree());

        try {
            // parser.selectStatement();
            parser.sqlStatement();

            System.out.println("Valid SQL: " + sql);
        } catch (ParseCancellationException e) {
            System.out.println("Invalid SQL: " + sql);
            // System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        // Test the method with sample SQL statements
        // String[] sqlStatements = {
        // "hi",
        // "SELECT * FROM table",
        // "Hello",
        // "SELECT * FROM table_name;",
        // "SELECT * FROM mosker;",
        // "Hello",
        // "SELECT id, name FROM table_name;",
        // "SELECT * FROM table_name WHERE id = 1;",
        // "INSERT INTO table_name (id, name) VALUES (1, 'John');",
        // };
        String[] sqlStatements = {
                "hi",
                "SELECT * FROM table",
                "SELECT * FROM table;",
                "SELECT * FROM table WHERE id = 5;",
                "SELECT * FROM table WHERE id = 5 AND age = 10;",
                "SELECT * FROM table WHERE id = 5 ANDY age = 10;",
        };

        // Iterate through the sample SQL statements and test them
        for (String sql : sqlStatements) {
            test(sql);

            System.out.println("\n");
        }
    }
}
