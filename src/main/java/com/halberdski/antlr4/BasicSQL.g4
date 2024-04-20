grammar BasicSQL;

sqlStatement: selectStatement | insertStatement | createTableStatement | createIndexStatement | deleteStatement| updateStatement;

selectStatement: SELECT STAR FROM tableName WHERE condition (LOGICAL_OPERATOR condition)* SEMICOLON EOF;
insertStatement: INSERT INTO tableName columnNameList VALUES valueList SEMICOLON EOF;

createTableStatement: CREATE TABLE tableName tableDefinition SEMICOLON EOF;

createIndexStatement: CREATE INDEX indexName ON tableName columnNameList SEMICOLON EOF;

deleteStatement: DELETE FROM tableName deleteCondition? SEMICOLON EOF;

updateStatement: UPDATE tableName SET updateSetClause updateWhereClause SEMICOLON EOF;

updateSetClause: columnName '=' literalValue (',' columnName '=' literalValue)*;

updateWhereClause: WHERE updateCondition (LOGICAL_OPERATOR updateCondition)*;

tableDefinition: '(' columnDefinition (',' columnDefinition)* ')';

columnConstraint: PRIMARYKEY;

columnName: ID;

literalValue: STRING | NUMBER | BOOLEAN;
columnNameList: '(' columnName (',' columnName)* ')';
valueList: '(' literalValue (',' literalValue)* ')';
tableName: ID;
condition: ID OPERATOR (STRING | NUMBER);
updateCondition: ID EQUAL (STRING|NUMBER);


columnDefinition: columnName dataType (columnConstraint)?;

dataType: INTTYPE | FLOATTYPE | VARCHARTYPE;

indexName: ID;

deleteCondition: WHERE condition (LOGICAL_OPERATOR condition)*;



// -------------------------------------------------------------------

SEMICOLON: ';';

SELECT: 'SELECT' | 'select';
STAR: '*';
FROM: 'FROM' | 'from';
WHERE: 'WHERE' | 'where';

INSERT: 'INSERT' | 'insert';
INTO: 'INTO' | 'into';
VALUES: 'VALUES' | 'values';
LOGICAL_OPERATOR: 'AND' | 'and' | 'OR' | 'or' | 'XOR' | 'xor';


CREATE: 'CREATE' | 'create';

TABLE: 'TABLE' | 'table';

INDEX: 'INDEX' | 'index';
ON: 'ON' | 'on';

DELETE: 'DELETE' | 'delete';

UPDATE: 'UPDATE' | 'update';

SET: 'SET' | 'set';

INTTYPE: 'INT' | 'int';
FLOATTYPE: 'FLOAT' | 'float';
VARCHARTYPE: 'VARCHAR' | 'varchar';

PRIMARYKEY: 'PRIMARY KEY' | 'primary key';

BOOLEAN: 'TRUE' | 'FALSE' | 'true' | 'false' ;

ID: [a-zA-Z][a-zA-Z0-9_]*;

STRING: '\''ID'\'';

NUMBER: INT | DECIMAL;

INT: DIGIT+;

DOT: '.';
DECIMAL: DIGIT+ DOT DIGIT+;

OPERATOR: EQUAL | '<' | '>' | '<=' | '>=' | '!=';
EQUAL: '=';

WS : [ \t\r\n]+ -> skip;
DIGIT: [0-9];

