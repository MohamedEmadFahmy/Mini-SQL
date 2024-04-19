package com.halberdski.antlr4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SQLQueryTester {
    public static void testSQLQuery(String sql) {
        // Create a CharStream from the input SQL string
        CharStream input = CharStreams.fromString(sql);

        // Create a lexer that feeds off of the input CharStream
        BasicSQLLexer lexer = new BasicSQLLexer(input);

        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that feeds off the tokens buffer
        BasicSQLParser parser = new BasicSQLParser(tokens);

        // Set custom error listeners to suppress error messages
        parser.removeErrorListeners();
        parser.addErrorListener(new CustomErrorListener(parser));

        try {
            // Parse the input SQL query using the root rule
            parser.sqlStatement();
            System.out.println(parser.getRuleIndex(sql));

            System.out.println("Valid SQL: " + sql);
        } catch (ParseCancellationException e) {
            System.out.println("Invalid SQL: " + sql);
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test the method with sample SQL statements
        String[] sqlStatements = {
                "hi",
                "SELECT * FROM table",
                "SELECT * FROM table_name;",
                "SELECT id, name FROM table_name;",
                "SELECT * FROM table_name WHERE id = 1;",
                "INSERT INTO table_name (id, name) VALUES (1, 'John');",
                "CREATE TABLE users (id INT, name VARCHAR(255));",
                "CREATE INDEX idx_name ON users (name);",
                "UPDATE users SET name = 'Alice' WHERE id = 1;",
                "DELETE FROM users WHERE id = 1;",
        };

        // Iterate through the sample SQL statements and test them
        for (String sql : sqlStatements) {
            testSQLQuery(sql);
            System.out.println("\n\n");
        }
    }
}
