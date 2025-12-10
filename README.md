# SD-SocketJava

Atividade: Comunicação Cliente-Servidor via Socket TCP  
Disciplina: Sistemas Distribuídos - IFPR

## Objetivo
Implementar um chat simples usando Socket em Java:
- Servidor escuta na porta 5050
- Cliente se conecta via localhost
- Troca de mensagens em tempo real
- Encerramento com a palavra "sair"

## Como executar (em Codespace ou terminal local)

1. Abra **dois terminais** (ou duas abas no Codespace)

**Terminal 1 - Iniciar o Servidor:**
```bash
javac Servidor.java
java Servidor

**Terminal 2 - Iniciar o Cliente:**
Bash
javac Cliente.java
java Cliente
