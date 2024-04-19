grammar BasicSQL;

sqlStatement: selectStatement | helloWorld;

helloWorld: 'Hello';

selectStatement: SELECT STAR FROM tableName WHERE condition (LOGICAL_OPERATOR condition)* SEMICOLON EOF;

tableName: ID;
condition: ID OPERATOR (STRING | NUM);

SEMICOLON: ';';

SELECT: 'SELECT' | 'select';
STAR: '*';
FROM: 'FROM' | 'from';
WHERE: 'WHERE' | 'where';
LOGICAL_OPERATOR: 'AND' | 'and' | 'OR' | 'or' | 'XOR' | 'xor';

ID: [a-zA-Z][a-zA-Z0-9_]*;

STRING: '\''ID'\'';

NUM: INT | FLOAT;

INT: DIGIT+;

DOT: '.';
FLOAT: DIGIT+ DOT DIGIT+;

OPERATOR: '=' | '<' | '>' | '<=' | '>=' | '!=';
WS : [ \t\r\n]+ -> skip;
DIGIT: [0-9];

