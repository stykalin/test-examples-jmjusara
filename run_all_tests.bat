ECHO OFF
chcp 1251
IF [%1] EQU [] SET browser=%1
IF [%1] NEQ [] SET browser=-Dselenide.browser=%1
ECHO ON
mvn test %browser%