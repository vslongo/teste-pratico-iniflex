# Executando o Projeto Java no Visual Studio Code

Este guia fornece instruções passo a passo sobre como configurar e executar um projeto Java no Visual Studio Code (VSCode).

## Pré-requisitos

Certifique-se de que o seguinte software esteja instalado:
- Java Development Kit (JDK) - Recomenda-se a versão 11 ou superior.
- Visual Studio Code
- Extensão Java para Visual Studio Code (recomenda-se "Extension Pack for Java" da Microsoft)

## Configuração do Projeto

### Instale as Extensões Necessárias
- Abra o VSCode.
- Vá para a aba de extensões (ícone de blocos no lado esquerdo) ou pressione `Ctrl+Shift+X`.
- Pesquise por "Java Extension Pack" e instale-o.

### Abra o Projeto
- Clique em `File > Open Folder...` e selecione o diretório onde seu projeto Java está localizado.

## Executando o Projeto

### Construa o Projeto
- No VSCode, pressione `Ctrl+Shift+B` para construir o projeto.
- Selecione a tarefa de build adequada se houver múltiplas opções.

### Execute o Programa
- Abra o arquivo que contém o método `main` que você deseja executar.
- Clique com o botão direito e escolha "Run Java".
- Ou, pressione `F5` para iniciar a depuração.

### Verifique a Saída
- A saída do programa pode ser vista no Terminal Integrado do VSCode.

## Problemas Comuns e Solução de Problemas

Se você encontrar problemas durante a execução:
- Verifique se o JDK instalado é compatível e está configurado corretamente.
- Certifique-se de que o projeto foi construído sem erros.
- Reinicie o VSCode se houver problemas persistentes após as configurações.

Para mais informações, consulte a [documentação oficial do VSCode para Java](https://code.visualstudio.com/docs/languages/java).
