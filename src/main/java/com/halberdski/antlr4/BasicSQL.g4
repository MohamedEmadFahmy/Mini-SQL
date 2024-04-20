grammar BasicSQL;

sqlStatement: selectStatement | helloWorld;

helloWorld: 'Hello';

selectStatement: SELECT STAR FROM tableName WHERE condition (LOGICAL_OPERATOR condition)* SEMICOLON EOF;
insertStatement: INSERT INTO tableName '(' columnList ')' VALUES '(' valueList ')' SEMICOLON EOF;


columnName: ID;

literalValue: STRING | NUMBER | BOOLEAN;
columnList: columnName (',' columnName)*;
valueList: literalValue (',' literalValue)*;
tableName: ID;
condition: ID OPERATOR (STRING | NUMBER);

SEMICOLON: ';';

SELECT: 'SELECT' | 'select';
STAR: '*';
FROM: 'FROM' | 'from';
WHERE: 'WHERE' | 'where';

INSERT: 'INSERT' | 'insert';
INTO: 'INTO' | 'into';
VALUES: 'VALUES' | 'values';
LOGICAL_OPERATOR: 'AND' | 'and' | 'OR' | 'or' | 'XOR' | 'xor';

BOOLEAN: 'TRUE' | 'FALSE' | 'true' | 'false' ;

ID: [a-zA-Z][a-zA-Z0-9_]*;

STRING: '\''ID'\'';

NUMBER: INT | FLOAT;

INT: DIGIT+;

DOT: '.';
FLOAT: DIGIT+ DOT DIGIT+;

OPERATOR: '=' | '<' | '>' | '<=' | '>=' | '!=';
WS : [ \t\r\n]+ -> skip;
DIGIT: [0-9];

