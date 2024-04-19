grammar BasicSQL;

sqlStatement: selectStatement | helloWorld;

helloWorld: 'Hello';

selectStatement: SELECT STAR FROM tableName WHERE condition (LOGICAL_OPERATOR condition)* ';';

SELECT: 'SELECT' | 'select';
STAR: '*';
FROM: 'FROM' | 'from';
WHERE: 'WHERE' | 'where';
tableName: ID;
condition: ID OPERATOR (ID | DIGIT)?;

ID: [a-zA-Z][a-zA-Z0-9_]*;

OPERATOR: '=' | '<' | '>' | '<=' | '>=' | '!=';
WS: [ \t\r\n]+ -> skip;
DIGIT: [0-9];

// LOGICAL_OPERATOR: 'AND' | 'and' | 'OR' | 'or' | 'XOR' | 'xor';
LOGICAL_OPERATOR: 'AND' | 'OR' | 'XOR';
