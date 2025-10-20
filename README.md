# 🐶 API Automation Dogs

Automação de testes de API para listagem de “doguinhos”.  
Este projeto usa Java, Maven, JUnit 5, RestAssured e Allure para geração de relatórios.

---

## 🏷️ Badges

[![CI/CD](https://github.com/franvareira/api-automation-dogs/actions/workflows/ci.yml/badge.svg)](https://github.com/franvareira/api-automation-dogs/actions)  
[![Allure Report](https://img.shields.io/badge/Allure-Report-ED1C24?logo=allure&logoColor=white)](https://franvareira.github.io/api-automation-dogs/)  
![Java 23](https://img.shields.io/badge/Java-23-blue)  
![Maven](https://img.shields.io/badge/Maven-3.x-orange)

---

## 🧱 Tecnologias & versões

- **Java**: 23  
- **Maven**: conforme especificado no `pom.xml`  
- **JUnit 5**  
- **RestAssured**  
- **Allure Report / Allure Maven Plugin**  
- **GitHub Actions** para CI/CD  
- **peaceiris/actions-gh-pages** para publicar relatório no GitHub Pages

---

## 📂 Estrutura de diretórios

```
api-automation-dogs/
├── .github/
│   └── workflows/
│       └── ci.yml              # pipeline de CI/CD (GitHub Actions)
├── src/
│   └── test/
│       ├── java/
│       │   ├── scenarios/      # definições de casos de teste
│       │   ├── services/       # classes que fazem as chamadas via RestAssured
│       │   └── utils/          # classes utilitárias/helper
├── pom.xml                      # arquivo de build do Maven
└── README.md                    # documentação do projeto
```

**O que cada pasta representa:**

- `scenarios/`: localização dos testes “de alto nível” — conjuntos de verificações de API  
- `services/`: classes que encapsulam chamadas HTTP (GET, POST, etc.) usando RestAssured  
- `utils/`: ferramentas auxiliares, helpers, configurações comuns  
- `.github/workflows/ci.yml`: definição de workflow para GitHub Actions (testes, geração e publicação de relatório)

---

## 🧪 Execução local

### Pré-requisitos

- Java 23 instalado e configurado no `PATH`  
- Maven instalado  
- (Opcional) Allure CLI instalado (ver abaixo)

### Passos para rodar os testes localmente

1. Clone o repositório:

   ```bash
   git clone https://github.com/franvareira/api-automation-dogs.git
   cd api-automation-dogs
   git checkout develop
   ```

2. Executar testes com Maven:

   ```bash
   mvn clean
   mvn -Dtest=RunnerAllTest test
   ```

3. Gerar relatório Allure:

   ```bash
   mvn io.qameta.allure:allure-maven:2.15.0:report
   ```

4. (Opcional) Servir o relatório localmente, se você tiver o Allure CLI instalado:

   ```bash
   allure serve target/allure-results
   ```

   Ou:

   ```bash
   mvn io.qameta.allure:allure-maven:2.15.0:serve
   ```

---

## 📦 Instalar o Allure localmente

Para gerar e visualizar relatórios localmente, você pode instalar o **Allure CLI**:

### Via Homebrew (macOS / Linux)

```bash
brew install allure
```

### Via download direto

1. Vá até o repositório oficial do Allure e baixe o pacote binário. [Acesse Aqui](https://allurereport.org/docs/install-for-windows/)  
2. Extraia para uma pasta no seu sistema (ex: `/usr/local/bin` ou algo no PATH).  
3. Adicione o executável `allure` ao seu PATH.

### Verificar instalação

```bash
allure --version
```

(se retornar versão válida, está correto)

### Usar o Allure para gerar/visualizar relatórios

- `allure generate target/allure-results --clean -o target/allure-report`  
- `allure serve target/allure-results` (gera + abre relatório automaticamente)

---


## 🚀 Fluxo CI/CD - Testes Automatizados 

### 🔹 Execução Automática

Disparado automaticamente ao fazer push na branch `develop`.

Executa:

- Build do projeto.
- Execução de testes JUnit5.
- Geração do Allure Report.
- Publicação do relatório no GitHub Pages.

### 🔹 Execução Manual

- Vá para a aba Actions no repositório.
- Selecione CI/CD - Testes Automatizados.
- Clique em Run workflow.
- Escolha a branch (develop ou master) e clique em Run workflow.

### 🔹 Observações

- É possível executar testes quantas vezes forem necessárias em qualquer branch (develop ou master).
- Cada execução manual gera um relatório atualizado.
- Workflow permite validação do código antes do merge manual para master.

Após execução o relatório ficará disponível no link abaixo:

```
https://franvareira.github.io/api-automation-dogs/
```


