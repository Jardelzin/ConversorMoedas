# 💱 Conversor de Moedas em Java

Um aplicativo simples de console desenvolvido em **Java** que converte valores de **Real (BRL)** para **Dólar (USD)**, **Euro (EUR)** ou **Libra Esterlina (GBP)** utilizando cotações atualizadas em tempo real direto da internet.

Projeto desenvolvido para praticar lógica de programação, manipulação de dados e consumo de APIs externas.

---

## 🚀 Funcionalidades

- Menu interativo no terminal para escolha da moeda de destino.
- Consulta de taxas de câmbio em tempo real via API pública.
- Cálculo automático e exibição do valor convertido formatado em duas casas decimais.
- Tratamento de erros para opções inválidas no menu ou falha de conexão com a internet.

---

## 🛠️ O que foi usado (Tecnologias e Conceitos)

- **Java (JDK 11+):** Linguagem principal do projeto.
- **`java.net.http.HttpClient`:** Recurso nativo do Java utilizado para fazer requisições HTTP na internet sem precisar instalar bibliotecas externas.
- **`java.util.Scanner`:** Classe usada para ler as opções e os valores digitados pelo usuário no teclado.
- **Estrutura `switch-case`:** Utilizada para gerenciar o menu de escolhas de forma limpa.
- **Manipulação de `String` (`indexOf` / `substring`):** Técnica usada para extrair o valor da cotação (`bid`) de dentro da resposta JSON da API.
- **Blocos `try / catch`:** Garante que o programa não trave caso ocorra algum problema de rede.
- **[AwesomeAPI](https://docs.awesomeapi.com.br/api-de-moedas):** API gratuita utilizada para obter as cotações atualizadas.

---

## ▶️ Como executar o projeto

1. Certifique-se de ter o **Java JDK 11** (ou superior) instalado em seu computador.
2. Clone este repositório ou baixe o arquivo `ConversorMoeda.java`.
3. Abra o projeto na sua IDE de preferência (ex: **IntelliJ IDEA**, Eclipse ou VS Code).
4. Execute o método `main` da classe `ConversorMoeda`.
5. Siga as instruções exibidas no console, escolhendo a moeda desejada e digitando o valor em Reais.
