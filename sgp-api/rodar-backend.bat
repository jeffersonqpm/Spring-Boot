@echo off
:: Altera a codificação do terminal para UTF-8 (corrige acentos no terminal)
chcp 65001 > nul

title Rodando Backend - SGP API

echo ====================================================
echo      INICIANDO O BACKEND (SPRING BOOT - MAVEN)
echo ====================================================
echo.

:: Entra no disco F:
F:

:: Navega até a pasta correta do seu projeto (com aspas por causa dos espaços no caminho)
cd "F:\Treina Recife\Spring Boot\TESTES\Primeiro\Spring-Boot\sgp-api"

echo Pasta atual:
cd
echo.
echo Executando mvn spring-boot:run...
echo Para desligar o servidor, feche esta janela ou aperte Ctrl + C.
echo ----------------------------------------------------

:: Executa o comando do Maven
mvn spring-boot:run

pause