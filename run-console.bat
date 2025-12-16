@echo off
chcp 65001 >nul
echo ==========================================
echo SmartBooking Platform - Mode Console
echo ==========================================
echo.

echo Compilation...
javac -encoding UTF-8 -d bin src/domain/entities/*.java src/domain/factories/*.java src/domain/observers/*.java src/domain/strategies/*.java src/infrastructure/repositories/*.java src/application/services/*.java src/presentation/Demo.java

if %errorlevel% neq 0 (
    echo [ERREUR] La compilation a echoue!
    pause
    exit /b 1
)

echo.
echo Execution...
echo.
java -cp bin presentation.Demo

echo.
pause
