# 💱 Conversor de Moedas em Java

Este é um projeto de **conversor de moedas via console**, desenvolvido como parte de um **desafio da trilha da Alura em parceria com a ONE Oracle**. O objetivo principal é treinar o consumo de APIs externas em Java, utilizando boas práticas de programação orientada a objetos.

---

## 🧩 Explicação do Projeto

O conversor permite que o usuário selecione pares de moedas por meio de um menu numerado, informe um valor a ser convertido, e então realiza a conversão utilizando a **API ExchangeRate-API**. Além disso, o sistema armazena um histórico das conversões realizadas com data, hora, valor convertido e taxa utilizada. A chave da API é protegida por meio de um arquivo `config.properties`.

---

## 📌 Funcionalidades

- ✅ Conversão entre múltiplas moedas internacionais.
- ✅ Menu interativo e numerado para facilitar a escolha das moedas.
- ✅ Histórico completo de conversões com data e hora.
- ✅ Logs de conversão usando a biblioteca `java.time`.
- ✅ Uso seguro da chave da API via `config.properties`.
- ✅ Tratamento de erros e falhas de rede na consulta da API.

---

## ⚙️ Como Funciona

1. O usuário executa o programa no console.
2. Um menu é exibido com pares de moedas numerados.
3. O usuário escolhe uma opção e digita o valor que deseja converter.
4. O sistema consulta a taxa de câmbio atual na API.
5. O valor convertido é exibido ao usuário.
6. A conversão é registrada no histórico com data, hora, moeda de origem, destino, valor e taxa.

---

## 🔢 Menu de Conversão (exemplo)

```
=== Conversor de Moedas ===
1. USD -> BRL
2. BRL -> USD
3. EUR -> BRL
4. BRL -> EUR
5. USD -> EUR
6. EUR -> USD
7. GBP -> BRL
8. BRL -> GBP
9. USD -> ARS
10. ARS -> USD
11. CAD -> JPY
12. JPY -> CAD
13. Ver histórico de conversões
14. Sair
```

---

## 🚀 Como Rodar o Projeto

1. **Clone ou baixe** o repositório.

2. Crie um arquivo `config.properties` na raiz do projeto com o conteúdo:

```properties
api.key=sua_chave_aqui
```

3. Compile os arquivos Java. Exemplo usando terminal:

```bash
javac -cp ".:gson-2.10.1.jar" src/com/danielnatan/conversor/main.java/src
```

4. Execute o programa com:

```bash
java -cp ".:gson-2.10.1.jar:src" com.danielnatan.conversor.Main
```

> 💡 Certifique-se de ter o `gson-2.10.1.jar` na mesma pasta ou corretamente configurado no classpath.

---

## 🧠 Tecnologias Utilizadas

- **Java 17+**
- **API [ExchangeRate-API](https://www.exchangerate-api.com/)** para conversão de moedas
- **GSON** para leitura de JSON
- **java.time** para data/hora
- **Scanner** para entrada via terminal

---

## 📂 Estrutura do Projeto

```
ConversorDeMoedas/
├── config.properties
└── src/
    └── com/danielnatan/conversor/
        ├── api/
        │   └── ExchangeRateService.java
        ├── model/
        │   └── Conversion.java
        ├── util/
        │   └── DateUtil.java
        ├── view/
        │   └── ConsoleUI.java
        └── Main.java
```

---

## 🔐 Segurança da API

A chave da API é armazenada externamente no arquivo `config.properties`, evitando exposição direta no código. Isso torna o projeto mais seguro e modular.

---

## 🧑‍🎓 Projeto Educacional

Este projeto foi desenvolvido como parte do programa **Oracle Next Education (ONE)** da **Alura**, com o objetivo de aplicar na prática os conhecimentos em **Java** e **consumo de APIs REST externas**.

---

## 📜 Licença

Este projeto é livre para fins educacionais e pessoais. Sinta-se à vontade para copiar , modificar e evoluir!

---

## 📩 Contato

Desenvolvido por [Daniel Natan](https://github.com/Danielnatan72)

---

⭐ Se gostou do projeto, não esqueça de deixar uma estrela no GitHub!
