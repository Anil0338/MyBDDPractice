@echo off&setlocal
for %%i in ("%~dp0.") do set "folder=%%~fi"
echo %folder%
cd %folder%
mvn clean test