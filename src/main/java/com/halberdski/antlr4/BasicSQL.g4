grammar BasicSQL;

sqlStatement: insertStatement
            | createTableStatement
            | selectStatement
            | updateStatement
            | deleteStatement
            | createIndexStatement
            ;

insertStatement: INSERT INTO tableName '(' columnNameList ')' VALUES '(' valueList ')' ';';
createTableStatement: CREATE TABLE tableName '(' columnDefinitionList ')' ';';
selectStatement: SELECT columnList FROM tableName (WHERE condition)? ';';
updateStatement: UPDATE tableName SET columnValueList (WHERE condition)? ';';
deleteStatement: DELETE FROM tableName (WHERE condition)? ';';
createIndexStatement: CREATE INDEX indexName ON tableName '(' columnNameList ')' ';';

tableName: ID;
indexName: ID;

columnNameList: columnName (',' columnName)*;
columnDefinitionList: columnDefinition (',' columnDefinition)*;
columnDefinition: columnName dataType;

columnValueList: columnValue (',' columnValue)*;
columnValue: columnName '=' value;

columnList: '*' | columnNameList;
valueList: value (',' value)*;

value: STRING | NUMBER | BOOLEAN;
condition: columnName OPERATOR value;

STRING: '\'' (~'\'')* '\'';
NUMBER: ('-' | '+')? DIGIT+ ('.' DIGIT+)?;
BOOLEAN: 'TRUE' | 'FALSE';
ID: [a-zA-Z_][a-zA-Z0-9_]*;

columnName: ID; // Define a rule for column names
dataType: ID; // You might want to define data types as well

INSERT: 'INSERT';
INTO: 'INTO';
CREATE: 'CREATE';
TABLE: 'TABLE';
SELECT: 'SELECT';
UPDATE: 'UPDATE';
DELETE: 'DELETE';
INDEX: 'INDEX';
FROM: 'FROM';
WHERE: 'WHERE';
SET: 'SET';
ON: 'ON';
VALUES: 'VALUES';

OPERATOR: '=' | '<' | '>' | '<=' | '>=' | '<>';
WS: [ \t\r\n]+ -> skip;
DIGIT: [0-9];